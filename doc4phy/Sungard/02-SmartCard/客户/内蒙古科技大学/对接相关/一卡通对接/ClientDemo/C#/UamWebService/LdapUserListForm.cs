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

            // 设置查询条件
            if (queryParam == null)
            {
                MessageBox.Show("查询条件不能为空！");
            }

            // 调用查询接口
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
                MessageBox.Show("查询LDAP绑定用户列表失败，失败原因为：" + resultList.errorMsg);
            }
        }

        // 解除绑定用户
        private void button1_Click(object sender, EventArgs e)
        {
            int successNumber = 0, failNumber = 0;
            DataGridViewSelectedRowCollection rows = this.dataGridView1.SelectedRows;
            IEnumerator iter = rows.GetEnumerator();
            if (!iter.MoveNext())
            {
                MessageBox.Show("请至少至少选择一条记录。");
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
                MessageBox.Show("解除绑定用户成功，共解除" + successNumber + "条记录");
            }
            else
            {
                MessageBox.Show("成功解除" + successNumber + "条记录，" + failNumber + "条记录解除失败");
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

            // 设置查询条件
            if (queryParam == null)
            {
                MessageBox.Show("查询条件不能为空！");
            }

            // 调用查询接口
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
                MessageBox.Show("查询LDAP绑定用户列表失败，失败原因为：" + resultList.errorMsg);
            }
        }

    }
}