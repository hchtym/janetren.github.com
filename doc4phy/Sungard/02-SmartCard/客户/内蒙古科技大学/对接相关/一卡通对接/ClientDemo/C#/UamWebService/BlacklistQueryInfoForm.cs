using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using UamWebService.imcPlatUser;
using UamWebService.acmUser;

namespace UamWebService
{
    public partial class BlacklistQueryInfoForm : Form
    {
        imcplatUserService platUserService = null;
        acmUserService accessUserService = null;
        private AcmBlackQueryParam queryParam = null;

        public BlacklistQueryInfoForm()
        {
            InitializeComponent();

            platUserService = MainForm.GetPlatUserService();
            accessUserService = MainForm.GetAccessUserService();

            // 设置用户分组
            CombItem item = new CombItem("不限", -1);
            this.comboBoxUserGroupId.Items.Add(item);
            this.comboBoxUserGroupId.SelectedIndex = 0;

            // 设置加入开始时间
            this.dateTimePickerStartDate.Value = System.DateTime.Now.AddMonths(-1);

            //设置加入原因
            this.comboBoxJoinReason.Items.Add(new CombItem("不限", -1));
            this.comboBoxJoinReason.Items.Add(new CombItem("操作员锁定用户", 1));
            this.comboBoxJoinReason.Items.Add(new CombItem("恶意登录尝试",2));
            this.comboBoxJoinReason.SelectedIndex = 0;

            this.buttonOK.DialogResult = DialogResult.OK;
            this.buttonCancel.DialogResult = DialogResult.Cancel;
        }

        public AcmBlackQueryParam GetQueryParam()
        {
            queryParam = new AcmBlackQueryParam();
            queryParam.accountName = this.textBoxAccountName.Text;
            queryParam.userMacAddress = this.textBoxUserMAC.Text;
            queryParam.userGroupId = ((CombItem)this.comboBoxUserGroupId.SelectedItem).itemValue;
            queryParam.userGroupIdSpecified = true;
            queryParam.joinReason = (int)((CombItem)this.comboBoxJoinReason.SelectedItem).itemValue;
            queryParam.joinReasonSpecified = true;
            queryParam.startDate = this.dateTimePickerStartDate.Value;
            queryParam.startDateSpecified = true;
            queryParam.endDate = this.dateTimePickerEndDate.Value;
            queryParam.endDateSpecified = true;
            queryParam.userStartIpAddress = this.textBoxStartIP.Text;
            queryParam.userEndIpAddress = this.textBoxEndIP.Text;
            return queryParam;
        }
    }
}