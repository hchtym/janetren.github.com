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
    public partial class ModifyPwdForm : Form
    {
        acmUserService accessUserService = MainForm.GetAccessUserService();
        public ModifyPwdForm(String name)
        {
            InitializeComponent();

            this.textBoxUserName.Text = name;
            this.buttonCancel.DialogResult = DialogResult.Cancel;
            //this.buttonOK.DialogResult = DialogResult.OK;

        }

        // 修改用户密码
        private void buttonOK_Click(object sender, EventArgs e)
        {
            ModifyUserPsdParam psdParam = new ModifyUserPsdParam();
            if(this.textBoxPassword.Text == null || this.textBoxPassword.Text == ""){
                MessageBox.Show("请输入密码。");
                return;
            }
            psdParam.name = this.textBoxUserName.Text;
            psdParam.newPsd = this.textBoxPassword.Text;
            WSCommonResult result = accessUserService.modifyUserPassword(psdParam);
            if (result.errorCode == 0)
            {
                MessageBox.Show("修改密码成功。");
            }
            else
            {
                MessageBox.Show("修改密码失败，失败原因为：" + result.errorMsg);
            }
            this.Dispose(true);
        }
    }
}