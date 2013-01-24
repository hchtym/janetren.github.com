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
    public partial class ModifyUserForm : Form
    {
        acmUserService accessUserService = MainForm.GetAccessUserService();
        public ModifyUserForm(String userName)
        {
            InitializeComponent();
            this.buttonCancel.DialogResult = DialogResult.Cancel;

            // 查询用户信息
            RetAcmUser result = accessUserService.queryAcmUser(userName);
            if (result.errorCode == 0)
            {
                this.textBoxBoundDomainName.Text = result.acmUser.boundDomainName;
                this.textBoxComputerName.Text = result.acmUser.computerName;

                long value = result.acmUser.idleTimeout.Value;
                this.textBoxIdleTimeout.Text = (value != MainForm.VALUE_NULL ? value.ToString() : "");

                if (result.acmUser.invalidTime != null)
                {
                    this.dateTimePickerInvalidTime.Value = result.acmUser.invalidTime.Value;
                }
                else
                {
                    this.dateTimePickerInvalidTime.Value = System.DateTime.Now.AddYears(10);
                }
                this.textBoxLogonDomainName.Text = result.acmUser.logonDomainName;
                this.textBoxNasIpStr.Text = result.acmUser.nasIpStr;

                value = result.acmUser.nasPort.Value;
                this.textBoxNasPort.Text = (value != MainForm.VALUE_NULL ? value.ToString() : "");

                value = result.acmUser.onlineLimit.Value;
                this.textBoxOnlineLimit.Text = (value != MainForm.VALUE_NULL?value.ToString():"");

                this.textBoxPromptInfo.Text = result.acmUser.promptInfo;
                this.textBoxUserName.Text = result.acmUser.userName;

                value = result.acmUser.vlan.Value;
                this.textBoxVlan.Text = (value != MainForm.VALUE_NULL ? value.ToString() : "");

                value = result.acmUser.vlan2.Value;
                this.textBoxVlan2.Text = (value != MainForm.VALUE_NULL ? value.ToString() : "");

                this.textBoxWlanSsid.Text = result.acmUser.wlanSsid;
            }
            else
            {
                MessageBox.Show("获取用户信息失败，失败原因为：" +　result.errorMsg);
            }

        }

        // 修改用户信息
        private void buttonOK_Click(object sender, EventArgs e)
        {
            // 最大限制时长
            long idleTimeout = MainForm.VALUE_NULL;
            try
            {
                if (!"".Equals(this.textBoxIdleTimeout.Text))
                {
                    idleTimeout = int.Parse(this.textBoxIdleTimeout.Text);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("最大闲置时长只能为整数。","Web服务演示客户端");
                return;
            }

            // 在线数量限制
            int onlineLimit = MainForm.VALUE_NULL;
            try
            {
                if (!"".Equals(this.textBoxOnlineLimit.Text))
                {
                    onlineLimit = int.Parse(this.textBoxOnlineLimit.Text);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("在线数量限制只能为整数。", "Web服务演示客户端");
                return;
            }

            // 端口号
            int nasPort = MainForm.VALUE_NULL;
            try
            {
                if (!"".Equals(this.textBoxNasPort.Text))
                {
                    nasPort = int.Parse(this.textBoxNasPort.Text);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("端口号只能为整数。", "Web服务演示客户端");
                return;
            }

            // VLAN ID/内层VLAN ID
            long vlan = MainForm.VALUE_NULL;
            try
            {
                if (!"".Equals(this.textBoxVlan.Text))
                {
                    vlan = int.Parse(this.textBoxVlan.Text);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("VLAN ID/内层VLAN ID只能为整数。", "Web服务演示客户端");
                return;
            }

            // 外层VLAN ID
            long vlan2 = MainForm.VALUE_NULL;
            try
            {
                if (!"".Equals(this.textBoxVlan2.Text))
                {
                    vlan2 = int.Parse(this.textBoxVlan2.Text);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("外层VLAN ID只能为整数。", "Web服务演示客户端");
                return;
            }

            ModifyAcmUserParam param = new ModifyAcmUserParam();
            param.userName = this.textBoxUserName.Text;
            param.boundDomainName = this.textBoxBoundDomainName.Text;
            param.computerName = this.textBoxComputerName.Text;
            param.idleTimeout = idleTimeout;
            param.idleTimeoutSpecified = true;
            param.invalidTime = this.dateTimePickerInvalidTime.Value;
            param.invalidTimeSpecified = true;
            param.logonDomainName = this.textBoxLogonDomainName.Text;
            param.nasIpStr = this.textBoxNasIpStr.Text;
            param.nasPort = nasPort;
            param.nasPortSpecified = true;
            param.onlineLimit = onlineLimit;
            param.onlineLimitSpecified = true;
            param.promptInfo = this.textBoxPromptInfo.Text;
            param.vlan = vlan;
            param.vlanSpecified = true;
            param.vlan2 = vlan2;
            param.vlan2Specified = true;
            param.wlanSsid = this.textBoxWlanSsid.Text;

            // 调用修改用户信息接口
            WSCommonResult result = accessUserService.modifyAcmUser(param);
            if (result.errorCode == 0)
            {
                MessageBox.Show("修改接入用户成功");
            }
            else
            {
                MessageBox.Show("修改接入用户失败，失败原因为：" + result.errorMsg);
            }
            this.Dispose(true);

        }
    }
}