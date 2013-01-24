using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using UamWebService.acmUser;

namespace UamWebService
{
    public partial class SelectLdapPolicyForm : Form
    {
        acmUserService accessUserService = MainForm.GetAccessUserService();
        long[] userId;
        public SelectLdapPolicyForm(long[] id)
        {
            InitializeComponent();
            userId = id;

            // ����ȱʡ��ѯ����
            AcmSyncPolicyQueryParam queryParam = new AcmSyncPolicyQueryParam();
            // ���ò�ѯ�ӿ�
            RetAcmSyncPolicyInfoList resultList = accessUserService.querySyncPolicyInfoList(queryParam);
            if (resultList.errorCode == 0)
            {
                if (resultList.retAcmSyncPolicyInfoList != null)
                {
                    foreach (RetAcmSyncPolicyInfo policyInfo in resultList.retAcmSyncPolicyInfoList)
                    {
                        this.listBox1.Items.Add(new CombItem(policyInfo.policyName, policyInfo.policyId.Value));

                    }
                }

            }
            else
            {
                MessageBox.Show("��ѯͬ�������б�ʧ�ܣ�ʧ��ԭ��Ϊ��" + resultList.errorMsg);
            }

            //this.buttonOK.DialogResult = DialogResult.OK;
            this.buttonCancel.DialogResult = DialogResult.Cancel;
        }

        // ���û��󶨵�ָ����LDAPͬ��������
        private void buttonOK_Click(object sender, EventArgs e)
        {
            int successNumber = 0, failNumber = 0;
            if (this.listBox1.SelectedItem == null)
            {
                MessageBox.Show(this,"��ѡ��LDAPͬ������");
                return;
            }
            long policyId = ((CombItem)this.listBox1.SelectedItem).itemValue;
            foreach (long id in userId)
            {
                WSCommonResult result = accessUserService.addBindingUser(policyId, true, id, true);
                if (result.errorCode == 0)
                {
                    successNumber++;
                }
                else
                {
                    failNumber++;
                }
            }
            MessageBox.Show(successNumber + "����¼�󶨳ɹ��� " + failNumber + "����¼��ʧ�ܡ�");
            this.Dispose(true) ;
           

        }

    }
}