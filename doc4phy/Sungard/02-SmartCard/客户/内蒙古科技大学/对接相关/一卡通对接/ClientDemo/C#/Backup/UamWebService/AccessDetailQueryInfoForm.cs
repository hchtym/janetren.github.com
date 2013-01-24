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
    public partial class AccessDetailQueryInfoForm : Form
    {
        imcplatUserService platUserService = null;
        acmUserService accessUserService = null;
        private AcmAccessDetailQueryParam queryParam = null;

        public AccessDetailQueryInfoForm()
        {
            InitializeComponent();

            platUserService = MainForm.GetPlatUserService();
            accessUserService = MainForm.GetAccessUserService();

            // 设置用户分组
            this.comboBoxUserGroupId.Items.Add(new CombItem("不限", -1));
            this.comboBoxUserGroupId.SelectedIndex = 0;

            // 设置服务名称
            this.comboBoxServiceID.Items.Add(new CombItem("不限", -1));

            AcmServiceTemplateQueryParam serviceTemplateQueryParam = new AcmServiceTemplateQueryParam();
            RetAcmServiceTemplateInfoList serviceTemplateList = accessUserService.queryServiceTemplateList(serviceTemplateQueryParam);
            if (serviceTemplateList.errorCode == 0)
            {
                if (serviceTemplateList.retAcmServiceTemplateInfoList != null)
                {
                    foreach (RetAcmServiceTemplateInfo serviceTemplate in serviceTemplateList.retAcmServiceTemplateInfoList)
                    {
                        CombItem item = new CombItem(serviceTemplate.serviceName, serviceTemplate.serviceId.Value);
                        this.comboBoxServiceID.Items.Add(item);
                    }
                }
                
            }
            else
            {
                MessageBox.Show("无法获取服务列表信息");
            }
            this.comboBoxServiceID.SelectedIndex = 0;

            // 设置开始时间
            this.dateTimePickerStartTime.Value = System.DateTime.Now.AddMonths(-1);

            // 设置下线原因
            this.comboBoxOfflineCause.Items.Add(new CombItem("不限", -1));
            this.comboBoxOfflineCause.SelectedIndex = 0;
            
            this.buttonOK.DialogResult = DialogResult.OK;
            this.buttonCancel.DialogResult = DialogResult.Cancel;
        }

        // 获取查询条件
        public AcmAccessDetailQueryParam GetQueryParam()
        {
            queryParam = new AcmAccessDetailQueryParam();
            queryParam.accountName = this.textBoxAccountName.Text;
            queryParam.userGroupId = ((CombItem)this.comboBoxUserGroupId.SelectedItem).itemValue;
            queryParam.userGroupIdSpecified = true;
            queryParam.deviceStartIp = this.textBoxDeviceStartIp.Text;
            queryParam.deviceEndIp = this.textBoxDeviceEndIp.Text;
            queryParam.userStartIp = this.textBoxUserStartIp.Text;
            queryParam.userEndIp = this.textBoxUserEndIp.Text;
            queryParam.userMac = this.textBoxUserMAC.Text;
            queryParam.serviceID = ((CombItem)this.comboBoxServiceID.SelectedItem).itemValue;
            queryParam.serviceIDSpecified = true;
            queryParam.startTime = this.dateTimePickerStartTime.Value;
            queryParam.startTimeSpecified = true;
            queryParam.endTime = this.dateTimePickerEndTime.Value;
            queryParam.endTimeSpecified = true;
            queryParam.offlineCause = (int)((CombItem)this.comboBoxOfflineCause.SelectedItem).itemValue;
            queryParam.offlineCauseSpecified = true;

            return queryParam;
        }
    }
}