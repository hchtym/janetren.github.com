using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using UamWebService.imcPlat;
using System.Net;
using UamWebService.imcPlatUser;
using UamWebService.damAsset;
using UamWebService.acmUser;
using UamWebService.fee;

namespace UamWebService
{
    public partial class LoginForm : Form
    {
        public string url;
        public static string loginName;
        public static string password;
        public LoginForm()
        {
            InitializeComponent();
            this.buttonOK.DialogResult = DialogResult.OK;
            this.buttonCancel.DialogResult = DialogResult.Cancel;
        }

        private void buttonOK_Click(object sender, EventArgs e)
        {
            url = "http://" + this.textBoxIP.Text + ":" + this.textBoxPort.Text +"/imcws/services/";
            loginName = this.textBoxOperator.Text;
            password = this.textBoxPassword.Text;

            CookieContainer cc = new CookieContainer();
            MainForm.platService = new imcplatService(url + "imcplatService");
            MainForm.platUserService = new imcplatUserService(url +"imcplatUserService");
            MainForm.damService = new damAssetService(url + "damAssetService");
            MainForm.accessUserService = new acmUserService(url +"acmUserService");
            MainForm.uamFeeService = new feeService(url + "feeService");
            MainForm.platService.CookieContainer = cc;
            MainForm.platUserService.CookieContainer = cc;
            MainForm.damService.CookieContainer = cc;
            MainForm.accessUserService.CookieContainer = cc;
            MainForm.uamFeeService.CookieContainer = cc;
        }

    }
}