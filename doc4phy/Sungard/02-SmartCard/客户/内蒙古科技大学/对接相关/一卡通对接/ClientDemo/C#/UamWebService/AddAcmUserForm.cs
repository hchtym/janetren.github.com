using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using UamWebService.acmUser;
using UamWebService.imcPlatUser;

namespace UamWebService
{
    public partial class AddAcmUserForm : Form
    {
        imcplatUserService platUserService = MainForm.GetPlatUserService();
        acmUserService accessUserService = MainForm.GetAccessUserService();
        public AddAcmUserForm()
        {
            InitializeComponent();
            this.dateTimePickerInvalidTime.Value = System.DateTime.Now.AddYears(10);
            this.buttonCancel.DialogResult = DialogResult.Cancel;
        }

        private void buttonOK_Click(object sender, EventArgs e)
        {
            if ("".Equals(this.textBoxUserName.Text))
            {
                MessageBox.Show("帐号名不能为空。", "Web服务演示客户端");
                return; 
            }
            if ("".Equals(this.textBoxPassword.Text))
            {
                MessageBox.Show("密码不能为空。", "Web服务演示客户端");
                return;
            }

            // 最大闲置时长
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
                MessageBox.Show("最大闲置时长只能为整数。", "Web服务演示客户端");
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
            User user = new User();
            user.userName = this.textBoxUserName.Text;
            user.certification = "test" + this.textBoxUserName.Text;
            user.status = 0;
            user.statusSpecified = true;
            UserGroup userGroup = new UserGroup();
            userGroup.id = 1;
            userGroup.idSpecified = true;
            user.userGroup = userGroup;
            UserAppendInfo appendInfo = new UserAppendInfo();
            user.userAppend = appendInfo;
            UamWebService.imcPlatUser.WSCommonResult result = platUserService.addUser(user);
            if (result.errorCode != 0)
            {
                MessageBox.Show("增加接入用户失败，失败原因为：增加平台用户失败，" + result.errorMsg, "Web服务演示客户端");
                return;
            }

            
            WSUser wsUser = platUserService.queryUserByNameAndIdentity(user.userName, user.certification);
            if (wsUser.errorCode != 0)
            {
                MessageBox.Show("增加接入用户失败，失败原因为：查询平台用户失败，" + wsUser.errorMsg, "Web服务演示客户端");
                return;
            }

            // 设置接入用户信息
            AddAcmUserParam acmUserParam = new AddAcmUserParam();
            acmUserParam.platUserId = wsUser.user.id;
            acmUserParam.platUserIdSpecified = true;
            acmUserParam.userName = this.textBoxUserName.Text;
            acmUserParam.password = this.textBoxPassword.Text;
            acmUserParam.boundDomainName = this.textBoxBoundDomainName.Text;
            acmUserParam.computerName = this.textBoxComputerName.Text;
            acmUserParam.idleTimeout = idleTimeout;
            acmUserParam.idleTimeoutSpecified = true;
            acmUserParam.invalidTime = this.dateTimePickerInvalidTime.Value;
            acmUserParam.invalidTimeSpecified = true;
            acmUserParam.logonDomainName = this.textBoxLogonDomainName.Text;
            acmUserParam.nasIpStr = this.textBoxNasIpStr.Text;
            acmUserParam.nasPort = nasPort;
            acmUserParam.nasPortSpecified = true;
            acmUserParam.onlineLimit = onlineLimit;
            acmUserParam.onlineLimitSpecified = true;
            acmUserParam.promptInfo = this.textBoxPromptInfo.Text;
            acmUserParam.vlan = vlan;
            acmUserParam.vlanSpecified = true;
            acmUserParam.vlan2 = vlan2;
            acmUserParam.vlan2Specified = true;
            acmUserParam.wlanSsid = this.textBoxWlanSsid.Text;

            UamWebService.acmUser.WSCommonResult addResult = accessUserService.addAcmUser(acmUserParam);
            if (addResult.errorCode != 0)
            {
                MessageBox.Show("增加接入用户失败，失败原因为：" + addResult.errorMsg, "Web服务演示客户端");
                return;
            }
            else
            {
                MessageBox.Show("增加接入用户成功。", "Web服务演示客户端");
            }
            this.Dispose(true);
            MainForm.GetUserListForm().updateList();

        }
    }
}