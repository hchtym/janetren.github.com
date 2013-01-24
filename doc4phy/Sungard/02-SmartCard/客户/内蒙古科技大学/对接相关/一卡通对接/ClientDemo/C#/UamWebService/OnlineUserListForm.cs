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
    public partial class OnlineUserListForm : Form
    {
        public static Boolean querySuccess = true;
        acmUserService accessUserService = MainForm.GetAccessUserService();
        public OnlineUserListForm(UamWebService.MainForm parent, AcmOnlineUserQueryParam queryParam)
        {
            InitializeComponent();
            this.MdiParent = parent;


            DataGridViewRowCollection rows = this.dataGridView1.Rows;

            // 设置查询条件
            if (queryParam == null)
            {
                queryParam = new AcmOnlineUserQueryParam();
            }

            // 调用查询接口
            RetAcmOnlineUserList resultList = accessUserService.queryAcmOnlineUserList(queryParam);
            if (resultList.errorCode == 0)
            {
                if (resultList.onlineUserInfoArray != null)
                {
                    foreach (AcmOnlineUserSimpleInfo userInfo in resultList.onlineUserInfoArray)
                    {
                        String[] row = new String[this.dataGridView1.ColumnCount];
                        row[0] = userInfo.onlineUserId.Value.ToString();
                        row[1] = userInfo.accountName;
                        row[2] = userInfo.loginName;
                        row[3] = userInfo.fullName;
                        row[4] = (userInfo.serviceId==null)?"":userInfo.serviceId.Value.ToString();
                        row[5] = userInfo.serviceName;
                        row[6] = (userInfo.loginTime ==null)?"": userInfo.loginTime.Value.ToLocalTime().ToString();
                        row[7] = (userInfo.onlineDuration==null)?"":userInfo.onlineDuration.Value.ToString();
                        row[8] = userInfo.deviceIp;
                        row[9] = userInfo.userIp;
                        row[10] = (userInfo.securityStatus==null)?"":userInfo.securityStatus.Value.ToString();
                        row[11] = userInfo.userMac;
                        row[12] = (userInfo.port==null)? "":userInfo.port.Value.ToString();
                        row[13] = userInfo.clientVersion;
                        row[14] = userInfo.clientLanguage;
                        row[15] = (userInfo.outerVlanId==null)?"":userInfo.outerVlanId.Value.ToString();
                        row[16] = (userInfo.innerVlanId==null)?"":userInfo.innerVlanId.Value.ToString();
                        row[17] = userInfo.computerName;
                        rows.Add(row);
                    }
                }
                querySuccess = true;

            }
            else
            {
                querySuccess = false;
                MessageBox.Show("查询在线用户列表失败，失败原因为：" + resultList.errorMsg);
            }
        }

        // 消息下发
        private void button1_Click(object sender, EventArgs e)
        {

            long onlineId = 0;
            DataGridViewSelectedRowCollection rows = this.dataGridView1.SelectedRows;
            if (rows.Count == 0)
            {
                MessageBox.Show("请至少选择一条记录。");
                return;
            }
            else if (rows.Count > 1)
            {
                MessageBox.Show("最多只能选择一条记录");
                return;
            }

            IEnumerator iter = rows.GetEnumerator();
            if(iter.MoveNext())
            {
                DataGridViewRow currentRow = (DataGridViewRow)iter.Current;
                onlineId = long.Parse(currentRow.Cells[0].Value.ToString());
            }
            Form deployMsgForm = new DeployMsgForm(onlineId);
            deployMsgForm.ShowDialog();

        }

        // 强制下线
        private void button2_Click(object sender, EventArgs e)
        {
            DataGridViewSelectedRowCollection rows = this.dataGridView1.SelectedRows;
            if (rows.Count == 0)
            {
                MessageBox.Show("请至少选择一条记录。");
                return;
            }
            else if (rows.Count > 1)
            {
                MessageBox.Show("最多只能选择一条记录");
                return;
            }

            IEnumerator iter = rows.GetEnumerator();
            if (iter.MoveNext())
            {
                DataGridViewRow currentRow = (DataGridViewRow)iter.Current;
                long onlineId = long.Parse(currentRow.Cells[0].Value.ToString());
                WSCommonResult result = accessUserService.kickOut(onlineId, true);
                if (result.errorCode == 0)
                {
                    MessageBox.Show("强制下线成功。");
                }
                else
                {
                    MessageBox.Show("强制下线失败，失败原因为：" + result.errorMsg);
                }
            }
            this.updateList();
        }

        // 清除在线信息
        private void button3_Click(object sender, EventArgs e)
        {
            DataGridViewSelectedRowCollection rows = this.dataGridView1.SelectedRows;
            if (rows.Count == 0)
            {
                MessageBox.Show("请至少选择一条记录。");
                return;
            }
            else if (rows.Count > 1)
            {
                MessageBox.Show("最多只能选择一条记录");
                return;
            }

            IEnumerator iter = rows.GetEnumerator();
            if (iter.MoveNext())
            {
                DataGridViewRow currentRow = (DataGridViewRow)iter.Current;
                long onlineId = long.Parse(currentRow.Cells[0].Value.ToString());
                WSCommonResult result = accessUserService.clearOnlineInfo(onlineId, true);
                if (result.errorCode == 0)
                {
                    MessageBox.Show("清除在线信息成功。");
                }
                else
                {
                    MessageBox.Show("清除在线信息失败，失败原因为：" + result.errorMsg);
                }
            }
            this.updateList();

        }

        // 刷新页面
        public void updateList()
        {
            DataGridViewRowCollection rows = this.dataGridView1.Rows;
            rows.Clear();

            // 设置查询条件
            AcmOnlineUserQueryParam queryParam = new AcmOnlineUserQueryParam();
            queryParam.userGroupId = MainForm.VALUE_UNLIMITE;
            queryParam.userGroupIdSpecified = true;
            queryParam.serviceID = MainForm.VALUE_UNLIMITE;
            queryParam.serviceIDSpecified = true;
            queryParam.port = MainForm.VALUE_NULL;
            queryParam.portSpecified = true;
            queryParam.innerVlanId = MainForm.VALUE_NULL;
            queryParam.innerVlanIdSpecified = true;
            queryParam.outerVlanId = MainForm.VALUE_NULL;
            queryParam.outerVlanIdSpecified = true;
            queryParam.securityStatus = MainForm.VALUE_NULL;
            queryParam.securityStatusSpecified = true;
            queryParam.suspendDuration = MainForm.VALUE_NULL;
            queryParam.suspendDurationSpecified = true;

            // 调用查询接口
            RetAcmOnlineUserList resultList = accessUserService.queryAcmOnlineUserList(queryParam);
            if (resultList.errorCode == 0)
            {
                if (resultList.onlineUserInfoArray != null)
                {
                    foreach (AcmOnlineUserSimpleInfo userInfo in resultList.onlineUserInfoArray)
                    {
                        String[] row = new String[this.dataGridView1.ColumnCount];
                        row[0] = userInfo.onlineUserId.Value.ToString();
                        row[1] = userInfo.accountName;
                        row[2] = userInfo.loginName;
                        row[3] = userInfo.fullName;
                        row[4] = (userInfo.serviceId == null) ? "" : userInfo.serviceId.Value.ToString();
                        row[5] = userInfo.serviceName;
                        row[6] = (userInfo.loginTime == null) ? "" : userInfo.loginTime.Value.ToLocalTime().ToString();
                        row[7] = (userInfo.onlineDuration == null) ? "" : userInfo.onlineDuration.Value.ToString();
                        row[8] = userInfo.deviceIp;
                        row[9] = userInfo.userIp;
                        row[10] = (userInfo.securityStatus == null) ? "" : userInfo.securityStatus.Value.ToString();
                        row[11] = userInfo.userMac;
                        row[12] = (userInfo.port == null) ? "" : userInfo.port.Value.ToString();
                        row[13] = userInfo.clientVersion;
                        row[14] = userInfo.clientLanguage;
                        row[15] = (userInfo.outerVlanId == null) ? "" : userInfo.outerVlanId.Value.ToString();
                        row[16] = (userInfo.innerVlanId == null) ? "" : userInfo.innerVlanId.Value.ToString();
                        row[17] = userInfo.computerName;
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
    }
}