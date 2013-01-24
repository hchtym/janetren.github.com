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
    public partial class OnlineUserQueryInfoForm : Form
    {
        acmUserService accessUserService = null;
        private AcmOnlineUserQueryParam queryParam = new AcmOnlineUserQueryParam();
        public static bool validate = false;

        private int nasPort;
        private int vlan;
        private int vlan2;
        private int suspendTime;

        public OnlineUserQueryInfoForm()
        {
            InitializeComponent();
            accessUserService = MainForm.GetAccessUserService();
            validate = false;

            this.dateTimePickerStartDate.Value = System.DateTime.Now.AddMonths(-1);

            // 设置服务名称
            CombItem item = new CombItem("不限", -1);
            this.comboBoxServiceID.Items.Add(item);

            AcmServiceTemplateQueryParam serviceTemplateQueryParam = new AcmServiceTemplateQueryParam();
            RetAcmServiceTemplateInfoList serviceTemplateList = accessUserService.queryServiceTemplateList(serviceTemplateQueryParam);
            if (serviceTemplateList.errorCode == 0)
            {
                if (serviceTemplateList.retAcmServiceTemplateInfoList != null)
                {
                    foreach (RetAcmServiceTemplateInfo serviceTemplate in serviceTemplateList.retAcmServiceTemplateInfoList)
                    {
                        item = new CombItem(serviceTemplate.serviceName, serviceTemplate.serviceId.Value);
                        this.comboBoxServiceID.Items.Add(item);
                    }
                }
               
            }
            else
            {
                MessageBox.Show("无法获取服务列表信息");
            }
            this.comboBoxServiceID.SelectedIndex = 0;

            // 设置用户分组
            this.comboBoxUserGroupId.Items.Add(new CombItem("不限", -1));
            this.comboBoxUserGroupId.SelectedIndex = 0;

            // 设置安全状态
            this.comboBoxSafeState.Items.Add(new CombItem("不限", -1));
            this.comboBoxSafeState.SelectedIndex = 0;

            //设置客户端版本
            this.comboBoxClientVersion.Items.Add("不限");
            this.comboBoxClientVersion.SelectedIndex = 0;

            // 设置客户端语言
            this.comboBoxClientLang.Items.Add("不限");
            this.comboBoxClientLang.SelectedIndex = 0;

            this.buttonOK.DialogResult = DialogResult.OK;
            this.buttonCancel.DialogResult = DialogResult.Cancel;
        }

        public AcmOnlineUserQueryParam GetQueryParam()
        {
            queryParam.accountName = this.textBoxAccountName.Text;
            queryParam.boundDomain = this.textBoxBoundDomain.Text;
            queryParam.clientLanguage = "";
            queryParam.clientVersion = "";
            queryParam.computerName = this.textBoxComputerName.Text;
            queryParam.deviceStartIp = this.textBoxDeviceStartIp.Text;
            queryParam.deviceEndIp = this.textBoxDeviceEndIp.Text;
            queryParam.fullName = this.textBoxFullName.Text;
            queryParam.innerVlanId = this.vlan;
            queryParam.innerVlanIdSpecified = true;
            queryParam.loginEndTime = this.dateTimePickerEndDate.Value;
            queryParam.loginEndTimeSpecified = true;
            queryParam.loginStartTime = this.dateTimePickerStartDate.Value;
            queryParam.loginStartTimeSpecified = true;
            queryParam.logonDomain = this.textBoxLogonDomain.Text;
            queryParam.outerVlanId = this.vlan2;
            queryParam.outerVlanIdSpecified = true;
            queryParam.port = this.nasPort;
            queryParam.portSpecified = true;
            queryParam.securityStatus = (int)((CombItem)this.comboBoxSafeState.SelectedItem).itemValue;
            queryParam.securityStatusSpecified = true;
            queryParam.serviceID = ((CombItem)this.comboBoxServiceID.SelectedItem).itemValue;
            queryParam.serviceIDSpecified = true;
            queryParam.suspendDuration = this.suspendTime;
            queryParam.suspendDurationSpecified = true;
            queryParam.userEndIp = this.textBoxUserEndIp.Text;
            queryParam.userStartIp = this.textBoxUserStartIp.Text;
            queryParam.userGroupId = ((CombItem)this.comboBoxUserGroupId.SelectedItem).itemValue;
            queryParam.userGroupIdSpecified = true;
            queryParam.userMac = this.textBoxUserMac.Text;
            queryParam.userSsid = this.textBoxUserSsid.Text;
            return queryParam;
        }

        private void buttonOK_Click(object sender, EventArgs e)
        {
            // 端口号
            nasPort = MainForm.VALUE_NULL;
            try
            {
                if (!"".Equals(this.textBoxPort.Text))
                {
                    nasPort = int.Parse(this.textBoxPort.Text);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("设备端口只能为整数。");
                return;
            }
            // VLAN ID/内层VLAN ID
            vlan = MainForm.VALUE_NULL;
            try
            {
                if (!"".Equals(this.textBoxInnerVlanId.Text))
                {
                    vlan = int.Parse(this.textBoxInnerVlanId.Text);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("VLAN ID/内层VLAN ID只能为整数。");
                return;
            }

            // 外层VLAN ID
            vlan2 = MainForm.VALUE_NULL;
            try
            {
                if (!"".Equals(this.textBoxOuterVlanId.Text))
                {
                    vlan2 = int.Parse(this.textBoxOuterVlanId.Text);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("外层VLAN ID只能为整数。");
                return;
            }
            // 挂起时长
            suspendTime = MainForm.VALUE_NULL;
            try
            {
                if (!"".Equals(this.textBoxSuspendTime.Text))
                {
                    suspendTime = int.Parse(this.textBoxSuspendTime.Text);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("挂起时长只能为整数。");
                return;
            }
            validate = true;
           // this.Dispose(false);
        }
    }
}