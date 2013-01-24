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
    public partial class DeployMsgForm : Form
    {
        acmUserService accessUserService = MainForm.GetAccessUserService();
        private long onlineId;
        public DeployMsgForm(long onlineId)
        {
            InitializeComponent();

            this.onlineId = onlineId;
            this.buttonCancel.DialogResult = DialogResult.Cancel;
        }

        // 消息下发
        private void buttonOK_Click(object sender, EventArgs e)
        {
           WSCommonResult result = accessUserService.sendMessage(onlineId, true, this.textBox1.Text);
           if (result.errorCode == 0)
           {
               MessageBox.Show("下发消息成功。");
           }
           else
           {
               MessageBox.Show("下发消息失败，失败原因为：" + result.errorMsg);
           }
           this.Dispose(true);
        }
    }
}