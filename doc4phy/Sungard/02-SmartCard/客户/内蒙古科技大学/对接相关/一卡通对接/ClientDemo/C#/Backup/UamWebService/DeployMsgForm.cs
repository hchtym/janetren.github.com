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

        // ��Ϣ�·�
        private void buttonOK_Click(object sender, EventArgs e)
        {
           WSCommonResult result = accessUserService.sendMessage(onlineId, true, this.textBox1.Text);
           if (result.errorCode == 0)
           {
               MessageBox.Show("�·���Ϣ�ɹ���");
           }
           else
           {
               MessageBox.Show("�·���Ϣʧ�ܣ�ʧ��ԭ��Ϊ��" + result.errorMsg);
           }
           this.Dispose(true);
        }
    }
}