using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using UamWebService.acmUser;
using System.Collections;

namespace UamWebService
{
    public partial class LdapUserListForm : Form
    {
        acmUserService accessUserService = MainForm.GetAccessUserService();
        public long policyId = -1;
        public LdapUserListForm(long id)
        {
            InitializeComponent();
            this.policyId = id;

            AcmSyncPolicyUserQueryParam queryParam = new AcmSyncPolicyUserQueryParam();
            queryParam.policyId = id;
            queryParam.policyIdSpecified = true;
            DataGridViewRowCollection rows = this.dataGridView1.Rows;

            // ���ò�ѯ����
            if (queryParam == null)
            {
                MessageBox.Show("��ѯ��������Ϊ�գ�");
            }

            // ���ò�ѯ�ӿ�
            RetAcmSyncPolicyUserInfoList resultList = accessUserService.querySyncPolicyUserInfoList(queryParam); ;
            if (resultList.errorCode == 0)
            {
                if (resultList.retAcmSyncPolicyUserInfoList != null)
                {
                    foreach (RetAcmSyncPolicyUserInfo userInfo in resultList.retAcmSyncPolicyUserInfoList)
                    {
                        String[] row = new String[this.dataGridView1.ColumnCount];
                        row[0] = userInfo.userId.Value.ToString();
                        row[1] = userInfo.accountName;
                        row[2] = userInfo.userName;
                        row[3] = userInfo.userGroupId.Value.ToString();
                        row[4] = userInfo.status.Value.ToString(); ;
                        rows.Add(row);
                    }
                }
            }
            else
            {
                MessageBox.Show("��ѯLDAP���û��б�ʧ�ܣ�ʧ��ԭ��Ϊ��" + resultList.errorMsg);
            }
        }

        // ������û�
        private void button1_Click(object sender, EventArgs e)
        {
            int successNumber = 0, failNumber = 0;
            DataGridViewSelectedRowCollection rows = this.dataGridView1.SelectedRows;
            IEnumerator iter = rows.GetEnumerator();
            if (!iter.MoveNext())
            {
                MessageBox.Show("����������ѡ��һ����¼��");
                return;
            }
            iter.Reset();
            while (iter.MoveNext())
            {
                DataGridViewRow currentRow = (DataGridViewRow)iter.Current;
                long userId = long.Parse(currentRow.Cells[0].Value.ToString());
                WSCommonResult result = accessUserService.cancelBindingUser(userId, true);
                if (result.errorCode == 0)
                {
                    successNumber++;
                }
                else
                {
                    failNumber++;
                }
            }
            if (failNumber == 0)
            {
                MessageBox.Show("������û��ɹ��������" + successNumber + "����¼");
            }
            else
            {
                MessageBox.Show("�ɹ����" + successNumber + "����¼��" + failNumber + "����¼���ʧ��");
            }
            this.updateList();
        }

        public void updateList()
        {
            AcmSyncPolicyUserQueryParam queryParam = new AcmSyncPolicyUserQueryParam();
            queryParam.policyId = policyId;
            queryParam.policyIdSpecified = true;
            DataGridViewRowCollection rows = this.dataGridView1.Rows;
            rows.Clear();

            // ���ò�ѯ����
            if (queryParam == null)
            {
                MessageBox.Show("��ѯ��������Ϊ�գ�");
            }

            // ���ò�ѯ�ӿ�
            RetAcmSyncPolicyUserInfoList resultList = accessUserService.querySyncPolicyUserInfoList(queryParam); ;
            if (resultList.errorCode == 0)
            {
                if (resultList.retAcmSyncPolicyUserInfoList != null)
                {
                    foreach (RetAcmSyncPolicyUserInfo userInfo in resultList.retAcmSyncPolicyUserInfoList)
                    {
                        String[] row = new String[this.dataGridView1.ColumnCount];
                        row[0] = userInfo.userId.Value.ToString();
                        row[1] = userInfo.accountName;
                        row[2] = userInfo.userName;
                        row[3] = userInfo.userGroupId.Value.ToString();
                        row[4] = userInfo.status.Value.ToString(); ;
                        rows.Add(row);
                    }
                }
            }
            else
            {
                MessageBox.Show("��ѯLDAP���û��б�ʧ�ܣ�ʧ��ԭ��Ϊ��" + resultList.errorMsg);
            }
        }

    }
}