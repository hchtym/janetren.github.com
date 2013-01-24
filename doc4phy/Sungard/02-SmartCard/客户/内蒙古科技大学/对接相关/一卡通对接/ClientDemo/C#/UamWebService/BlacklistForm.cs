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
    public partial class BlacklistForm : Form
    {
        public static Boolean querySuccess = true;
        acmUserService accessUserService = MainForm.GetAccessUserService();

        public BlacklistForm(UamWebService.MainForm parent, AcmBlackQueryParam queryParam)
        {
            InitializeComponent();
            this.MdiParent = parent;

            DataGridViewRowCollection rows = this.dataGridView1.Rows;
            // 设置查询条件
            if (queryParam == null)
            {
                queryParam = new AcmBlackQueryParam();
            }

            // 调用查询接口
            RetAcmBlackInfoList resultList = accessUserService.queryBlackList(queryParam);
            if (resultList.errorCode == 0)
            {
                if (resultList.retAcmBlackInfoList != null)
                {
                    foreach (RetAcmBlackInfo blackInfo in resultList.retAcmBlackInfoList)
                    {
                        String[] row = new String[this.dataGridView1.ColumnCount];
                        row[0] = blackInfo.blackNameId.Value.ToString();
                        row[1] = blackInfo.accountId.Value.ToString();
                        row[2] = blackInfo.accountName;
                        if (blackInfo.joinDate != null)
                        {
                            row[3] = blackInfo.joinDate.Value.ToLocalTime().ToString();
                        }
                        row[4] = blackInfo.joinReason.Value.ToString();
                        row[5] = blackInfo.userIpAddress;
                        row[6] = blackInfo.userMacAddress;
                        rows.Add(row);
                    }
                }
                querySuccess = true; 

            }
            else
            {
                querySuccess = false;
                MessageBox.Show("查询黑名单列表失败，失败原因为：" + resultList.errorMsg);
            }
        }

        // 解除黑名单
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
                if (currentRow.Cells[2].Value == null)
                {
                    MessageBox.Show("帐号名为空！");
                    return;
                }
                String userName = currentRow.Cells[2].Value.ToString();
                WSCommonResult result = accessUserService.removeBlackList(userName);
                if (result.errorCode == 0)
                {
                    successNumber++;
                }
                else
                {
                    failNumber++;
                }
            }
            MessageBox.Show( successNumber + "个帐号解除黑名单成功，"  + failNumber + "个帐号解除黑名单失败。");
            this.updateList();
        }

        // 更新列表
        public void updateList()
        {
            DataGridViewRowCollection rows = this.dataGridView1.Rows;
            rows.Clear();
            // 设置查询条件
            AcmBlackQueryParam queryParam = new AcmBlackQueryParam();
            queryParam.joinReason = MainForm.VALUE_UNLIMITE;
            queryParam.joinReasonSpecified = true;
            queryParam.userGroupId = MainForm.VALUE_UNLIMITE;
            queryParam.userGroupIdSpecified = true;

            // 调用查询接口
            RetAcmBlackInfoList resultList = accessUserService.queryBlackList(queryParam);
            if (resultList.errorCode == 0)
            {
                if (resultList.retAcmBlackInfoList != null)
                {
                    foreach (RetAcmBlackInfo blackInfo in resultList.retAcmBlackInfoList)
                    {
                        String[] row = new String[this.dataGridView1.ColumnCount];
                        row[0] = blackInfo.blackNameId.Value.ToString();
                        row[1] = blackInfo.accountId.Value.ToString();
                        row[2] = blackInfo.accountName;
                        if (blackInfo.joinDate != null)
                        {
                            row[3] = blackInfo.joinDate.Value.ToLocalTime().ToString();
                        }
                        row[4] = blackInfo.joinReason.Value.ToString();
                        row[5] = blackInfo.userIpAddress;
                        row[6] = blackInfo.userMacAddress;
                        rows.Add(row);
                    }
                    querySuccess = true;
                }


            }
            else
            {
                querySuccess = false;
                MessageBox.Show("查询黑名单列表失败，失败原因为：" + resultList.errorMsg);
            }
        }
    }
}