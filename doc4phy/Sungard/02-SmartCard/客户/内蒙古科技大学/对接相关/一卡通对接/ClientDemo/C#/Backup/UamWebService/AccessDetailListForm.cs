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
    public partial class AccessDetailListForm : Form
    {
        public static Boolean querySuccess = true;
        acmUserService accessUserService = MainForm.GetAccessUserService();

        public AccessDetailListForm(UamWebService.MainForm parent, AcmAccessDetailQueryParam queryParam)
        {
            InitializeComponent();
            this.MdiParent = parent;

            DataGridViewRowCollection rows = this.dataGridView1.Rows;
            // 设置查询条件
            if (queryParam == null)
            {
                queryParam = new AcmAccessDetailQueryParam();
            }

            // 调用查询接口
            RetAcmAccessDetailList resultList = accessUserService.queryAcmAccessDetailList(queryParam);
            if (resultList.errorCode == 0)
            {
                if (resultList.acmAccessDetailSimpleInfo != null)
                {
                    foreach (AcmAccessDetailSimpleInfo accessDetaiInfo in resultList.acmAccessDetailSimpleInfo)
                    {
                        String[] row = new String[this.dataGridView1.ColumnCount];
                        row[0] = accessDetaiInfo.accessDetailId.Value.ToString();
                        row[1] = accessDetaiInfo.accountName;
                        row[2] = accessDetaiInfo.fullName;
                        row[3] = accessDetaiInfo.loginName;
                        row[4] = accessDetaiInfo.serviceId.Value.ToString();
                        if (accessDetaiInfo.accessStartTime != null)
                        {
                            row[5] = accessDetaiInfo.accessStartTime.Value.ToLocalTime().ToString();
                        }
                        if (accessDetaiInfo.accessEndTime != null)
                        {
                            row[6] = accessDetaiInfo.accessEndTime.Value.ToLocalTime().ToString();
                        }
                        row[7] = accessDetaiInfo.accessDuration.Value.ToString();
                        row[8] = accessDetaiInfo.deviceIp;
                        row[9] = accessDetaiInfo.userIp;
                        row[10] = accessDetaiInfo.influxByte.Value.ToString();
                        row[11] = accessDetaiInfo.outfluxByte.Value.ToString();
                        row[12] = accessDetaiInfo.userGroupId.Value.ToString();
                        row[13] = accessDetaiInfo.innerVlanId.Value.ToString();
                        row[14] = accessDetaiInfo.outerVlanId.Value.ToString();
                        row[15] = accessDetaiInfo.port.Value.ToString();
                        row[16] = accessDetaiInfo.solt.Value.ToString();
                        row[17] = accessDetaiInfo.subSolt.Value.ToString();
                        row[18] = accessDetaiInfo.userMac;
                        row[19] = accessDetaiInfo.offlineCause.Value.ToString();
                        rows.Add(row);
                    }
                }
                querySuccess = true;

            }
            else
            {
                querySuccess = false;
                MessageBox.Show("查询接入明细列表失败，失败原因为：" + resultList.errorMsg);
            }
        }
    }
}