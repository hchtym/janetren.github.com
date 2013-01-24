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
    public partial class AssetGroupQueryForm : Form
    {
        damAssetService damService = null;
        public AssetGroupQueryForm(UamWebService.MainForm parent)
        {
            InitializeComponent();
            this.MdiParent = parent;
             DataGridViewRowCollection rows = this.dataGridView.Rows;
            damService = MainForm.GetDamService();
            queryAssetGroupResponse response = damService.queryAssetGroup();
            foreach(RetAssetGroupInfo groupInfo in response.@return.retAssetGroupInfoList){
                String[] row = new string[3];
                row[0] = groupInfo.groupId.ToString();
                row[1] = groupInfo.groupName;
                row[2] = groupInfo.groupDescription;
                rows.Add(row);
            }

            //string[] row0 = { "123", "29"};
            //string[] row1 = { "456", "30" };
            //DataGridViewRowCollection rows = this.dataGridView.Rows;
            //rows.Add(row0);
            //rows.Add(row1); 
        }
    }
}