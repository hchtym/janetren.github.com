using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using UamWebService.damAsset;
using UamWebService.imcPlat;
using UamWebService.imcPlatUser;

namespace UamWebService
{
    public partial class AssetAddForm : Form
    {
        damAssetService damService = null;
        imcplatService platService = null;
        imcplatUserService platUserService = null;
        public static UamWebService.damAsset.WSCommonResult result;
        public AssetAddForm()
        {
            InitializeComponent();
            damService = MainForm.GetDamService();
            platService = MainForm.GetPlatService();
            platUserService = MainForm.GetPlatUserService();

            // 设置责任人
            WSUserArray userList = platUserService.queryAllUser(new long[] { 1 });
            if (userList.errorCode == 0)
            {
                if (userList.userArray == null || userList.userArray.Length == 0)
                {
                    MessageBox.Show("系统中必须至少存在一个平台用户");
                }
                else
                {
                    foreach (User user in userList.userArray)
                    {
                        CombItem item = new CombItem(user.userName, user.id.Value);
                        this.comboBoxResponser.Items.Add(item);
                    }
                }

            }
            else
            {
                MessageBox.Show("查询平台用户失败");
            }
            this.comboBoxResponser.SelectedIndex = 0;

            // 设置计算机类型
            this.comboBoxComputerType.Items.AddRange(new object[] {
            "pc",
            "laptop",
            "workstation",
            "server",
            "other"});
            this.comboBoxComputerType.SelectedIndex = 0;

            // 设置资产分组
            queryAssetGroupResponse response = damService.queryAssetGroup();
            if (response.@return.errorCode == 0)
            {
                foreach (RetAssetGroupInfo groupInfo in response.@return.retAssetGroupInfoList)
                {
                    CombItem item = new CombItem(groupInfo.groupName, groupInfo.groupId.Value);
                    this.comboBoxGroupID.Items.Add(item);
                }
                this.comboBoxGroupID.SelectedIndex = 0;
            }
            else
            {
                MessageBox.Show("无法获取资产分组信息");
            }
                                
            this.buttonOK.DialogResult = DialogResult.OK;
            this.buttonCancel.DialogResult = DialogResult.Cancel;

        }

        private void buttonOK_Click(object sender, EventArgs e)
        {
            AddAssetInfo assetInfo = new AddAssetInfo();
            assetInfo.assetNumber = this.textBoxAssetNo.Text;
            assetInfo.responserId = ((CombItem)this.comboBoxResponser.SelectedItem).itemValue;
            assetInfo.responserIdSpecified = true;
            assetInfo.groupId = ((CombItem)this.comboBoxGroupID.SelectedItem).itemValue;
            assetInfo.groupIdSpecified = true;
            assetInfo.physicalPos = this.textBoxPosition.Text;
            assetInfo.assetName = this.textBoxAssetName.Text;
            assetInfo.computerType = this.comboBoxComputerType.SelectedItem.ToString();
            assetInfo.computerVariety = this.textBoxComputerVendor.Text;
            assetInfo.type = this.textBoxModel.Text;
            assetInfo.remark = this.textBoxDescription.Text;
            result = damService.addAsset(assetInfo);
        }

        class CombItem : System.Object
        {
            public String caption;
            public long itemValue;
            public CombItem(String caption, long itemValue)
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