using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using UamWebService.imcPlat;
using UamWebService.damAsset;
using System.Net;
using UamWebService.imcPlatUser;
using UamWebService.acmUser;
using UamWebService.fee;

namespace UamWebService
{
    public partial class MainForm : Form
    {
        public const int VALUE_NULL = -9999;
        public const int VALUE_UNLIMITE = -1;
        public static imcplatService platService = null;
        public static imcplatUserService platUserService = null;
        public static acmUserService accessUserService = null;
        public static damAssetService damService = null;
        public static feeService uamFeeService = null;

        static UserListForm userListForm = null;
        public MainForm()
        {
            InitializeComponent();
        }

        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new MainForm());
        }

        private void MainForm_Load(object sender, EventArgs e)
        {
            this.toolStripMenuItemUserMng.Enabled = false;
            this.toolStripMenuItemAccessDetailMng.Enabled = false;
            this.ToolStripMenuItemAssetMng.Enabled = false;
        }

        public static imcplatService GetPlatService()
        {
            return platService;
        }

        public static imcplatUserService GetPlatUserService()
        {
            return platUserService;
        }
        public static damAssetService GetDamService()
        {
            return damService;
        }
        public static acmUserService GetAccessUserService()
        {
            return accessUserService;
        }
        public static feeService GetUamFeeService()
        {
            return uamFeeService;
        }
        public static UserListForm GetUserListForm()
        {
            return userListForm;
        }

        
        // 执行登录操作
        private void ToolStripMenuItemLogin_Click(object sender, EventArgs e)
        {
            Form logInForm = new LoginForm();
            logInForm.ShowDialog();
            if (logInForm.DialogResult == DialogResult.OK)
            {
                UamWebService.imcPlat.WSCommonResult result = platService.login(LoginForm.loginName, LoginForm.password);
                if (result.errorCode == 0)
                {
                    MessageBox.Show("操作员登录成功。");
                    this.toolStripMenuItemUserMng.Enabled = true;
                    this.toolStripMenuItemAccessDetailMng.Enabled = true;
                    try
                    {
                        damService.queryAssetGroup();
                        this.ToolStripMenuItemAssetMng.Enabled = true;
                    }
                    catch (Exception)
                    {
                    }
                }
                else
                {
                    MessageBox.Show("操作员登录失败，失败原因为：" + result.errorMsg);
                }

            }
            
         
        }
          
        // 执行注销操作
        private void ToolStripMenuItemLogout_Click(object sender, EventArgs e)
        {
            UamWebService.imcPlat.logoutResponse result = platService.logout();
            if (result.@return.errorCode == 0)
            {
                MessageBox.Show("操作员注销成功。");
            }
            else
            {
                MessageBox.Show("操作员注销失败，失败原因为：" + result.@return.errorMsg);
            }
            this.toolStripMenuItemUserMng.Enabled = false;
            this.toolStripMenuItemAccessDetailMng.Enabled = false;
            this.ToolStripMenuItemAssetMng.Enabled = false;
        }

        // 查询资产分组列表
        private void ToolStripMenuItemAssetGroupList_Click(object sender, EventArgs e)
        {
            Form queryAssetGroupForm = new AssetGroupListForm(this);
            queryAssetGroupForm.Show();
        }

        
         // 查询资产列表
        private void ToolStripMenuItemAssetList_Click(object sender, EventArgs e)
        {
            AssetListQueryInfoForm assetListQueryInfoForm = new AssetListQueryInfoForm();

            assetListQueryInfoForm.ShowDialog();
            if (assetListQueryInfoForm.DialogResult == DialogResult.OK)
            {
                Form assetListForm = new AssetListForm(this, assetListQueryInfoForm.GetQueryInfo());
                assetListForm.Show();
            }
            else
            {
                assetListQueryInfoForm.Dispose();
            }
        }

        // 查询接入用户列表
        private void ToolStripMenuItemUserList_Click(object sender, EventArgs e)
        {
            UserListQueryInfoForm queryInfoForm = new UserListQueryInfoForm();
            queryInfoForm.ShowDialog();
            if (UserListQueryInfoForm.validate)
            {
                userListForm = new UserListForm(this, queryInfoForm.GetQueryParam());
                if (UserListForm.querySuccess)
                {
                    userListForm.Show();
                }
            }
            else
            {
                queryInfoForm.Dispose();
            }
            

           
        }

        // 查询黑名单列表
        private void ToolStripMenuItemBlacklist_Click(object sender, EventArgs e)
        {
            BlacklistQueryInfoForm queryInfoForm = new BlacklistQueryInfoForm();
            queryInfoForm.ShowDialog();
            if (queryInfoForm.DialogResult == DialogResult.OK)
            {
                Form blacklistForm = new BlacklistForm(this, queryInfoForm.GetQueryParam());
                if (BlacklistForm.querySuccess)
                {
                    blacklistForm.Show();
                }
            }
        }

        // 查询接入明细列表
        private void ToolStripMenuItemAccessDetailList_Click(object sender, EventArgs e)
        {
            AccessDetailQueryInfoForm queryInfoForm = new AccessDetailQueryInfoForm();
            queryInfoForm.ShowDialog();
            if (queryInfoForm.DialogResult == DialogResult.OK)
            {
                Form accessDetailListForm = new AccessDetailListForm(this, queryInfoForm.GetQueryParam());
                if (AccessDetailListForm.querySuccess)
                {
                    accessDetailListForm.Show();
                }
            }
        }

        // 查询服务列表
        private void ToolStripMenuItemServiceTemplate_Click(object sender, EventArgs e)
        {
            Form serviceTemplateForm = new ServiceTemplateListForm(this);
            serviceTemplateForm.Show();
        }

        // 查询LDAP同步策略列表
        private void ToolStripMenuItemLDAP_Click(object sender, EventArgs e)
        {
            Form ldapConfigListForm = new LdapConfigListForm(this);
            ldapConfigListForm.Show();
        }

        // 查询在线用户列表
        private void ToolStripMenuItemOnlineList_Click(object sender, EventArgs e)
        {
            OnlineUserQueryInfoForm queryInfoForm = new OnlineUserQueryInfoForm();
            queryInfoForm.ShowDialog();
            if (OnlineUserQueryInfoForm.validate)
            {
                Form onlineListForm = new OnlineUserListForm(this, queryInfoForm.GetQueryParam());
                if (OnlineUserListForm.querySuccess)
                {
                    onlineListForm.Show();
                }
                else
                {
                    onlineListForm.Dispose();
                }
            }
            queryInfoForm.Dispose();

        }
    }
}