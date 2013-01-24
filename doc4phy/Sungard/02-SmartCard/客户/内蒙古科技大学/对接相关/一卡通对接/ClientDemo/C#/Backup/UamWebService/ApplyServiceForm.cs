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
    public partial class ApplyServiceForm : Form
    {
        acmUserService accessUserService = MainForm.GetAccessUserService();
        string userName;
        long[] userId;
        public ApplyServiceForm(String userName)
        {
            InitializeComponent();

            this.buttonCancel.DialogResult = DialogResult.Cancel;
            this.userName = userName;

            // 查询用户已申请的服务
            RetAcmUserService userServiceList = accessUserService.queryAcmUserServiceInfo(userName);
            if (userServiceList.errorCode != 0)
            {
                MessageBox.Show("查询用户申请服务信息失败。");
                return;
            }

            // 查询系统中所有服务列表
            AcmServiceTemplateQueryParam param = new AcmServiceTemplateQueryParam();
            RetAcmServiceTemplateInfoList serviceList = accessUserService.queryServiceTemplateList(param);
            if (serviceList.errorCode != 0)
            {
                MessageBox.Show("查询服务列表信息失败。");
                return;
            }

            DataGridViewRowCollection rows1 = this.dataGridView1.Rows;
            DataGridViewRowCollection rows2 = this.dataGridView2.Rows;


            if (userServiceList.acmUserService != null && userServiceList.acmUserService[0] != null)
            {
                userId = new long[userServiceList.acmUserService.Length];
                int i = 0;
                foreach (AcmUserAppliedService appliedService in userServiceList.acmUserService)
                {
                    String[] row = new String[this.dataGridView1.ColumnCount];
                    row[0] = appliedService.serviceTemplateId.Value.ToString();
                    row[1] = appliedService.serviceName;
                    row[2] = appliedService.serviceSuffix;
                    row[3] = appliedService.userIp;
                    rows1.Add(row);
                    userId[i] = appliedService.serviceTemplateId.Value;
                    i++;
                }
            }

            if (serviceList.retAcmServiceTemplateInfoList != null)
            {
                foreach (RetAcmServiceTemplateInfo serviceInfo in serviceList.retAcmServiceTemplateInfoList)
                {
                    if (serviceInfo.serviceStatus != 1)
                    {
                        continue;
                    }
                    Boolean bSkip = false;
                    String[] row = new String[this.dataGridView2.ColumnCount];
                    long serviceId = serviceInfo.serviceId.Value;
                    if (userServiceList.acmUserService != null && userServiceList.acmUserService[0] != null)
                    {
                        foreach (AcmUserAppliedService appliedService in userServiceList.acmUserService)
                        {
                            if (serviceId == appliedService.serviceTemplateId.Value)
                            {
                                bSkip = true;
                                break;
                            }
                        }
                    }
                    
                    if (!bSkip)
                    {
                        row[0] = serviceInfo.serviceId.Value.ToString();
                        row[1] = serviceInfo.serviceName;
                        row[2] = serviceInfo.serviceSuffix;
                        row[3] = "";
                        row[4] = serviceInfo.assignAddress.Value.ToString();
                        rows2.Add(row);

                    }
                }
            }
        }

        // 申请服务
        private void buttonOK_Click(object sender, EventArgs e)
        {
            ApplyServiceInfo[] applyService = null;
            if (userId != null)
            {
                applyService = new ApplyServiceInfo[userId.Length + this.dataGridView2.SelectedRows.Count];
            }
            else
            {
                applyService = new ApplyServiceInfo[this.dataGridView2.SelectedRows.Count];
            }
            if (userId != null)
            {
                for (int i = 0; i < userId.Length; i++)
                {
                    ApplyServiceInfo applyServiceInfo = new ApplyServiceInfo();
                    applyServiceInfo.serviceTemplateId = userId[i];
                    applyServiceInfo.serviceTemplateIdSpecified = true;
                    applyService[i] = applyServiceInfo;

                }
            }
            
            DataGridViewSelectedRowCollection rows = this.dataGridView2.SelectedRows;
            if (rows.Count == 0)
            {
                MessageBox.Show("请至少选择一个服务。");
                return;
            }
            IEnumerator iter = rows.GetEnumerator();
            int j = userId==null?0:userId.Length;
            while (iter.MoveNext())
            {
                DataGridViewRow currentRow = (DataGridViewRow)iter.Current;
                ApplyServiceInfo applyServiceInfo = new ApplyServiceInfo();
                applyServiceInfo.serviceTemplateId = long.Parse(currentRow.Cells[0].Value.ToString());
                applyServiceInfo.serviceTemplateIdSpecified = true;
                
                if(long.Parse(currentRow.Cells[4].Value.ToString()) == 1)
                {
                    applyServiceInfo.userIpAddress = currentRow.Cells[3].Value.ToString();
                }
                applyService[j] = applyServiceInfo;
                j++;
            }
            ApplyServiceParam param = new ApplyServiceParam();
            param.accountName = userName;
            param.serviceInfo = applyService;
            WSCommonResult result = accessUserService.applyService(param);
            if (result.errorCode == 0)
            {
                MessageBox.Show("用户申请服务成功。");
            }
            else
            {
                MessageBox.Show("用户申请服务失败，失败原因为：" + result.errorMsg);
                return;
            }
            this.Dispose(true);
        }
    }
}