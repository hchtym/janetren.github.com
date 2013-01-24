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
    public partial class UserListForm : Form
    {
        public static Boolean querySuccess = true;
        acmUserService accessUserService = MainForm.GetAccessUserService();
        public UserListForm(UamWebService.MainForm parent, AcmUserListQueryParam queryParam)
        {
            InitializeComponent();
            this.MdiParent = parent;

            DataGridViewRowCollection rows = this.dataGridView1.Rows;
            this.dataGridViewImageColumn5.Visible = false;

            // 设置查询条件
            if (queryParam == null)
            {
                queryParam = new AcmUserListQueryParam();
            }

            // 调用查询接口
            RetAcmUserList resultList = accessUserService.queryAcmUserList(queryParam);
            if (resultList.errorCode == 0)
            {
                if (resultList.userSimpleInfoArray != null)
                {
                    foreach (AcmUserSimpleInfo userInfo in resultList.userSimpleInfoArray)
                    {
                        String[] row = new String[this.dataGridView1.ColumnCount];
                        row[0] = userInfo.accountId.Value.ToString();
                        row[1] = userInfo.accountName;
                        row[2] = userInfo.fullName;
                        row[3] = userInfo.userGroupId.Value.ToString();
                        if (userInfo.invalidTime != null)
                        {
                            row[4] = userInfo.invalidTime.Value.ToLocalTime().ToString();
                        }

                        //row[4] = userInfo.invalidTime.Value == null ? "" : userInfo.invalidTime.Value.ToString();
                        rows.Add(row);
                    }
                }
                querySuccess = true;
                   
            }
            else
            {
                querySuccess = false;
                MessageBox.Show("查询接入用户列表失败，失败原因为：" + resultList.errorMsg);
            }


        }

        // 增加接入用户
        private void buttonAdd_Click(object sender, EventArgs e)
        {
            Form addAcmUserForm = new AddAcmUserForm();
            addAcmUserForm.ShowDialog();
            this.updateList();
        }


        // 注销接入用户
        private void buttonDelete_Click(object sender, EventArgs e)
        {

            int successNumber = 0, failNumber = 0;
            DataGridViewSelectedRowCollection rows = this.dataGridView1.SelectedRows;
            IEnumerator iter = rows.GetEnumerator();
            if (!iter.MoveNext())
            {
                MessageBox.Show("请至少选择一条记录。");
                return;
            }
            iter.Reset();
            while (iter.MoveNext())
            {
                DataGridViewRow currentRow = (DataGridViewRow)iter.Current;
                String userName = currentRow.Cells[1].Value.ToString();
                WSCommonResult result = accessUserService.cancelAcmUser(userName);
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
                MessageBox.Show("注销接入用户成功，共注销" + successNumber + "条记录");
            }
            else
            {
                MessageBox.Show("成功注销" + successNumber + "条记录，" + failNumber + "条记录注销失败");
            }
            this.updateList();

        }

        // 将用户加入黑名单中
        private void buttonAddBlacklist_Click(object sender, EventArgs e)
        {
            int successNumber = 0, failNumber = 0;
            DataGridViewSelectedRowCollection rows = this.dataGridView1.SelectedRows;
            IEnumerator iter = rows.GetEnumerator();
            if (!iter.MoveNext())
            {
                MessageBox.Show("请至少选择一条记录。");
                return;
            }
            iter.Reset();
            while (iter.MoveNext())
            {
                DataGridViewRow currentRow = (DataGridViewRow)iter.Current;
                String userName = currentRow.Cells[1].Value.ToString();
                WSCommonResult result = accessUserService.addBlackList(userName);
                if (result.errorCode == 0)
                {
                    successNumber++;
                }
                else
                {
                    failNumber++;
                }
            }
            MessageBox.Show(successNumber + "个帐号被成功加入黑名单，" + failNumber + "个帐号未被加入黑名单。");

        }

       
        // 将用户绑定到LDAP同步策略
        private void buttonBindUser_Click(object sender, EventArgs e)
        {
            long[] userId = null;
            DataGridViewSelectedRowCollection rows = this.dataGridView1.SelectedRows;
            userId = new long[rows.Count];
            IEnumerator iter = rows.GetEnumerator();
            if (!iter.MoveNext())
            {
                MessageBox.Show("请至少选择一条记录。");
                return;
            }
            iter.Reset();
            int i = 0;
            while (iter.MoveNext())
            {
                DataGridViewRow currentRow = (DataGridViewRow)iter.Current;
                userId[i] = long.Parse(currentRow.Cells[0].Value.ToString());
                i++;
                
            }
            Form selectLdapPolicyForm = new SelectLdapPolicyForm(userId);
            selectLdapPolicyForm.ShowDialog();

        }

        // 刷新页面
        public void updateList()
        {
            DataGridViewRowCollection rows = this.dataGridView1.Rows;
            rows.Clear();

            // 设置查询条件
            AcmUserListQueryParam queryParam = new AcmUserListQueryParam();
            queryParam.userGroupId = MainForm.VALUE_UNLIMITE;
            queryParam.userGroupIdSpecified = true;
            queryParam.serviceID = MainForm.VALUE_UNLIMITE;
            queryParam.serviceIDSpecified = true;
            queryParam.port = MainForm.VALUE_NULL;
            queryParam.portSpecified = true;
            queryParam.maxConcurrentLimit = MainForm.VALUE_NULL;
            queryParam.maxConcurrentLimitSpecified = true;
            queryParam.maxIdleTime = MainForm.VALUE_NULL;
            queryParam.maxIdleTimeSpecified = true;
            queryParam.innerVlanId = MainForm.VALUE_NULL;
            queryParam.innerVlanIdSpecified = true;
            queryParam.outerVlanId = MainForm.VALUE_NULL;
            queryParam.outerVlanIdSpecified = true;

            // 调用查询接口
            RetAcmUserList resultList = accessUserService.queryAcmUserList(queryParam);
            if (resultList.errorCode == 0)
            {
                if (null != resultList.userSimpleInfoArray)
                {
                    foreach (AcmUserSimpleInfo userInfo in resultList.userSimpleInfoArray)
                    {
                        String[] row = new String[this.dataGridView1.ColumnCount];
                        row[0] = userInfo.accountId.Value.ToString();
                        row[1] = userInfo.accountName;
                        row[2] = userInfo.fullName;
                        row[3] = userInfo.userGroupId.Value.ToString();
                        if (userInfo.invalidTime != null)
                        {
                            row[4] = userInfo.invalidTime.Value.ToLocalTime().ToString();
                        }

                        //row[4] = userInfo.invalidTime.Value == null ? "" : userInfo.invalidTime.Value.ToString();
                        rows.Add(row);
                    }
                }
                
                querySuccess = true;

            }
            else
            {
                querySuccess = false;
                MessageBox.Show("查询接入用户列表失败，失败原因为：" + resultList.errorMsg);
            }
        }

        // 修改用户、修改密码、申请服务、注销服务、详细信息
        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            try
            {
                if (e.RowIndex != -1)
                {
                    String userName = this.dataGridView1.CurrentRow.Cells[1].Value.ToString();
                    switch (e.ColumnIndex)
                    {
                        // 修改用户信息
                        case 5:
                            Form modifyUserForm = new ModifyUserForm(userName);
                            modifyUserForm.ShowDialog();
                            break;
                        // 修改密码
                        case 6:
                            Form modifyPwdForm = new ModifyPwdForm(userName);
                            modifyPwdForm.ShowDialog();
                            break;
                        // 申请服务
                        case 7:
                            Form applyServiceForm = new ApplyServiceForm(userName);
                            applyServiceForm.ShowDialog();
                            break;
                        // 注销服务
                        case 8:
                            Form cancelServiceForm = new CancelServiceForm(userName);
                            cancelServiceForm.ShowDialog();
                            break;
                       
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }
       
    }
}