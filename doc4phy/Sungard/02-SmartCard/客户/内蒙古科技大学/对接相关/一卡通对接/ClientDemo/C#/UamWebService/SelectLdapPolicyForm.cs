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

            // 设置缺省查询条件
            AcmSyncPolicyQueryParam queryParam = new AcmSyncPolicyQueryParam();
            // 调用查询接口
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
                MessageBox.Show("查询同步策略列表失败，失败原因为：" + resultList.errorMsg);
            }

            //this.buttonOK.DialogResult = DialogResult.OK;
            this.buttonCancel.DialogResult = DialogResult.Cancel;
        }

        // 将用户绑定到指定的LDAP同步策略上
        private void buttonOK_Click(object sender, EventArgs e)
        {
            int successNumber = 0, failNumber = 0;
            if (this.listBox1.SelectedItem == null)
            {
                MessageBox.Show(this,"请选择LDAP同步策略");
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
            MessageBox.Show(successNumber + "条记录绑定成功， " + failNumber + "条记录绑定失败。");
            this.Dispose(true) ;
           

        }

    }
}