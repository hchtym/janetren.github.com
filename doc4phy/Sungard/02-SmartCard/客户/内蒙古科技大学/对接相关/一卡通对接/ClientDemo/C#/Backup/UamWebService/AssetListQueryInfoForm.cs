using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using UamWebService.damAsset;

namespace UamWebService
{
    public partial class AssetListQueryInfoForm : Form
    {
        private AssetQueryInfo queryInfo = new AssetQueryInfo();
        public AssetListQueryInfoForm()
        {
            InitializeComponent();
            this.buttonQuery.DialogResult = DialogResult.OK;
            this.buttonCancel.DialogResult = DialogResult.Cancel;
        }

        public AssetQueryInfo GetQueryInfo()
        {
            queryInfo.assetNumber = this.textBoxAssetNo.Text;
            queryInfo.assetName = this.textBoxAssetName.Text;
            queryInfo.responser = this.textBoxAssetResponsor.Text;
            queryInfo.groupId = ((CombItem)this.comboBoxGroupName.SelectedItem).itemValue;
            queryInfo.groupIdSpecified = true;
            queryInfo.startDate = this.dateTimePickerStartDate.Value;
            queryInfo.startDateSpecified = true;
            queryInfo.endDate = this.dateTimePickerEndDate.Value;
            queryInfo.endDateSpecified = true;
            String computerType = this.comboBoxComputerType.SelectedItem.ToString();
            queryInfo.computerType = computerType == "²»ÏÞ" ? null : computerType;
            queryInfo.computerVariety = this.textBoxComputerVendor.Text;
            queryInfo.type = this.textBoxModel.Text;
            queryInfo.status = ((CombItem)this.comboBoxStatus.SelectedItem).itemValue;
            queryInfo.statusSpecified = true;
            queryInfo.operSystem = this.textBoxOperateSys.Text;
            queryInfo.operSystemId = ((CombItem)this.comboBoxOSLan.SelectedItem).itemValue;
            queryInfo.operSystemIdSpecified = true;
            queryInfo.operSystemMend = this.textBoxOSPatch.Text;
            return queryInfo;
        }

        class CombItem : System.Object
        {
            public String caption;
            public int itemValue;
            public CombItem(String caption, int itemValue)
            {
                this.caption = caption;
                this.itemValue = itemValue;
            }
            public override string ToString()
            {
                return caption;
            }
        }
        
    }
}