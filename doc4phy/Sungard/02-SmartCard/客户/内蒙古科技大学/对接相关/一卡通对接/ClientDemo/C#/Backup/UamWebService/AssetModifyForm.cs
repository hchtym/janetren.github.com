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
    public partial class AssetModifyForm : Form
    {
        damAssetService damService =  MainForm.GetDamService();
        public static UamWebService.damAsset.WSCommonResult result;

        RetAssetDetailInfo assetDetail = null;
        long assetId = 0;

        public AssetModifyForm(long assetId)
        {
            InitializeComponent();
            this.buttonCancel.DialogResult = DialogResult.Cancel;
            this.assetId = assetId;

            assetDetail = damService.queryAssetDetail(assetId,true);
            if (assetDetail.errorCode != 0)
            {
                MessageBox.Show("查询资产信息失败，失败原因为：" + assetDetail.errorMsg);
                return;
            }

            // 设置资产信息
            this.textBoxAssetName.Text = assetDetail.assetName;
            this.textBoxAssetNo.Text = assetDetail.assetNumber;
            this.textBoxComputerVendor.Text = assetDetail.computerVariety;
            this.textBoxDescription.Text = assetDetail.remark;
            this.textBoxModel.Text = assetDetail.type;
            this.textBoxPosition.Text = assetDetail.physicalPos;
            this.comboBoxGroupID.Text = assetDetail.groupName;
            this.comboBoxComputerType.Text = assetDetail.computerType;
            this.comboBoxResponser.Text = assetDetail.responserName;

        }

        // 修改资产信息
        private void buttonOK_Click(object sender, EventArgs e)
        {
            if (assetDetail == null)
            {
                MessageBox.Show("获取资产信息失败。");
                return;
            }
            ModifyAssetInfo assetInfo = new ModifyAssetInfo();
            assetInfo.assetId = assetId;
            assetInfo.assetIdSpecified = true;
            assetInfo.assetName = this.textBoxAssetName.Text;
            assetInfo.assetNumber = this.textBoxAssetNo.Text;
            assetInfo.computerType = this.comboBoxComputerType.SelectedItem.ToString();
            assetInfo.computerVariety = this.textBoxComputerVendor.Text;
            assetInfo.physicalPos = this.textBoxPosition.Text;
            assetInfo.remark = this.textBoxDescription.Text;
            assetInfo.type = this.textBoxModel.Text;
            assetInfo.responserId = assetDetail.responserId;
            assetInfo.responserIdSpecified = true;
            WSCommonResult result = damService.modifyAsset(assetInfo);
            if (result.errorCode == 0)
            {
                MessageBox.Show("修改资产信息成功。");
            }
            else
            {
                MessageBox.Show("修改资产信息失败，失败原因为：" + result.errorMsg);
            }
            this.Dispose(true);
        }
    }
}