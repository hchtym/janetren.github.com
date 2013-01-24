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

        
        // ִ�е�¼����
        private void ToolStripMenuItemLogin_Click(object sender, EventArgs e)
        {
            Form logInForm = new LoginForm();
            logInForm.ShowDialog();
            if (logInForm.DialogResult == DialogResult.OK)
            {
                UamWebService.imcPlat.WSCommonResult result = platService.login(LoginForm.loginName, LoginForm.password);
                if (result.errorCode == 0)
                {
                    MessageBox.Show("����Ա��¼�ɹ���");
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
                    MessageBox.Show("����Ա��¼ʧ�ܣ�ʧ��ԭ��Ϊ��" + result.errorMsg);
                }

            }
            
         
        }
          
        // ִ��ע������
        private void ToolStripMenuItemLogout_Click(object sender, EventArgs e)
        {
            UamWebService.imcPlat.logoutResponse result = platService.logout();
            if (result.@return.errorCode == 0)
            {
                MessageBox.Show("����Աע���ɹ���");
            }
            else
            {
                MessageBox.Show("����Աע��ʧ�ܣ�ʧ��ԭ��Ϊ��" + result.@return.errorMsg);
            }
            this.toolStripMenuItemUserMng.Enabled = false;
            this.toolStripMenuItemAccessDetailMng.Enabled = false;
            this.ToolStripMenuItemAssetMng.Enabled = false;
        }

        // ��ѯ�ʲ������б�
        private void ToolStripMenuItemAssetGroupList_Click(object sender, EventArgs e)
        {
            Form queryAssetGroupForm = new AssetGroupListForm(this);
            queryAssetGroupForm.Show();
        }

        
         // ��ѯ�ʲ��б�
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

        // ��ѯ�����û��б�
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

        // ��ѯ�������б�
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

        // ��ѯ������ϸ�б�
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

        // ��ѯ�����б�
        private void ToolStripMenuItemServiceTemplate_Click(object sender, EventArgs e)
        {
            Form serviceTemplateForm = new ServiceTemplateListForm(this);
            serviceTemplateForm.Show();
        }

        // ��ѯLDAPͬ�������б�
        private void ToolStripMenuItemLDAP_Click(object sender, EventArgs e)
        {
            Form ldapConfigListForm = new LdapConfigListForm(this);
            ldapConfigListForm.Show();
        }

        // ��ѯ�����û��б�
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