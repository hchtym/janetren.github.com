namespace UamWebService
{
    partial class MainForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.toolStripMenuItemOperatorMng = new System.Windows.Forms.ToolStripMenuItem();
            this.ToolStripMenuItemLogin = new System.Windows.Forms.ToolStripMenuItem();
            this.ToolStripMenuItemLogout = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItemUserMng = new System.Windows.Forms.ToolStripMenuItem();
            this.ToolStripMenuItemUserList = new System.Windows.Forms.ToolStripMenuItem();
            this.ToolStripMenuItemBlacklist = new System.Windows.Forms.ToolStripMenuItem();
            this.ToolStripMenuItemOnlineList = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItemAccessDetailMng = new System.Windows.Forms.ToolStripMenuItem();
            this.ToolStripMenuItemAccessDetailList = new System.Windows.Forms.ToolStripMenuItem();
            this.ToolStripMenuItemServiceTemplate = new System.Windows.Forms.ToolStripMenuItem();
            this.ToolStripMenuItemLDAP = new System.Windows.Forms.ToolStripMenuItem();
            this.ToolStripMenuItemAssetMng = new System.Windows.Forms.ToolStripMenuItem();
            this.ToolStripMenuItemAssetList = new System.Windows.Forms.ToolStripMenuItem();
            this.ToolStripMenuItemAssetGroupList = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripMenuItemOperatorMng,
            this.toolStripMenuItemUserMng,
            this.toolStripMenuItemAccessDetailMng,
            this.ToolStripMenuItemAssetMng});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(615, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // toolStripMenuItemOperatorMng
            // 
            this.toolStripMenuItemOperatorMng.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.ToolStripMenuItemLogin,
            this.ToolStripMenuItemLogout});
            this.toolStripMenuItemOperatorMng.Name = "toolStripMenuItemOperatorMng";
            this.toolStripMenuItemOperatorMng.Size = new System.Drawing.Size(53, 20);
            this.toolStripMenuItemOperatorMng.Text = "操作员";
            // 
            // ToolStripMenuItemLogin
            // 
            this.ToolStripMenuItemLogin.Name = "ToolStripMenuItemLogin";
            this.ToolStripMenuItemLogin.Size = new System.Drawing.Size(152, 22);
            this.ToolStripMenuItemLogin.Text = "登录";
            this.ToolStripMenuItemLogin.Click += new System.EventHandler(this.ToolStripMenuItemLogin_Click);
            // 
            // ToolStripMenuItemLogout
            // 
            this.ToolStripMenuItemLogout.Name = "ToolStripMenuItemLogout";
            this.ToolStripMenuItemLogout.Size = new System.Drawing.Size(152, 22);
            this.ToolStripMenuItemLogout.Text = "注销";
            this.ToolStripMenuItemLogout.Click += new System.EventHandler(this.ToolStripMenuItemLogout_Click);
            // 
            // toolStripMenuItemUserMng
            // 
            this.toolStripMenuItemUserMng.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.ToolStripMenuItemUserList,
            this.ToolStripMenuItemBlacklist,
            this.ToolStripMenuItemOnlineList});
            this.toolStripMenuItemUserMng.Name = "toolStripMenuItemUserMng";
            this.toolStripMenuItemUserMng.Size = new System.Drawing.Size(89, 20);
            this.toolStripMenuItemUserMng.Text = "接入用户管理";
            // 
            // ToolStripMenuItemUserList
            // 
            this.ToolStripMenuItemUserList.Name = "ToolStripMenuItemUserList";
            this.ToolStripMenuItemUserList.Size = new System.Drawing.Size(142, 22);
            this.ToolStripMenuItemUserList.Text = "接入用户列表";
            this.ToolStripMenuItemUserList.Click += new System.EventHandler(this.ToolStripMenuItemUserList_Click);
            // 
            // ToolStripMenuItemBlacklist
            // 
            this.ToolStripMenuItemBlacklist.Name = "ToolStripMenuItemBlacklist";
            this.ToolStripMenuItemBlacklist.Size = new System.Drawing.Size(142, 22);
            this.ToolStripMenuItemBlacklist.Text = "黑名单列表";
            this.ToolStripMenuItemBlacklist.Click += new System.EventHandler(this.ToolStripMenuItemBlacklist_Click);
            // 
            // ToolStripMenuItemOnlineList
            // 
            this.ToolStripMenuItemOnlineList.Name = "ToolStripMenuItemOnlineList";
            this.ToolStripMenuItemOnlineList.Size = new System.Drawing.Size(142, 22);
            this.ToolStripMenuItemOnlineList.Text = "在线用户列表";
            this.ToolStripMenuItemOnlineList.Click += new System.EventHandler(this.ToolStripMenuItemOnlineList_Click);
            // 
            // toolStripMenuItemAccessDetailMng
            // 
            this.toolStripMenuItemAccessDetailMng.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.ToolStripMenuItemAccessDetailList,
            this.ToolStripMenuItemServiceTemplate,
            this.ToolStripMenuItemLDAP});
            this.toolStripMenuItemAccessDetailMng.Name = "toolStripMenuItemAccessDetailMng";
            this.toolStripMenuItemAccessDetailMng.Size = new System.Drawing.Size(89, 20);
            this.toolStripMenuItemAccessDetailMng.Text = "接入业务管理";
            // 
            // ToolStripMenuItemAccessDetailList
            // 
            this.ToolStripMenuItemAccessDetailList.Name = "ToolStripMenuItemAccessDetailList";
            this.ToolStripMenuItemAccessDetailList.Size = new System.Drawing.Size(166, 22);
            this.ToolStripMenuItemAccessDetailList.Text = "接入明细列表";
            this.ToolStripMenuItemAccessDetailList.Click += new System.EventHandler(this.ToolStripMenuItemAccessDetailList_Click);
            // 
            // ToolStripMenuItemServiceTemplate
            // 
            this.ToolStripMenuItemServiceTemplate.Name = "ToolStripMenuItemServiceTemplate";
            this.ToolStripMenuItemServiceTemplate.Size = new System.Drawing.Size(166, 22);
            this.ToolStripMenuItemServiceTemplate.Text = "服务列表";
            this.ToolStripMenuItemServiceTemplate.Click += new System.EventHandler(this.ToolStripMenuItemServiceTemplate_Click);
            // 
            // ToolStripMenuItemLDAP
            // 
            this.ToolStripMenuItemLDAP.Name = "ToolStripMenuItemLDAP";
            this.ToolStripMenuItemLDAP.Size = new System.Drawing.Size(166, 22);
            this.ToolStripMenuItemLDAP.Text = "LDAP同步策略列表";
            this.ToolStripMenuItemLDAP.Click += new System.EventHandler(this.ToolStripMenuItemLDAP_Click);
            // 
            // ToolStripMenuItemAssetMng
            // 
            this.ToolStripMenuItemAssetMng.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.ToolStripMenuItemAssetList,
            this.ToolStripMenuItemAssetGroupList});
            this.ToolStripMenuItemAssetMng.Name = "ToolStripMenuItemAssetMng";
            this.ToolStripMenuItemAssetMng.Size = new System.Drawing.Size(65, 20);
            this.ToolStripMenuItemAssetMng.Text = "资产管理";
            // 
            // ToolStripMenuItemAssetList
            // 
            this.ToolStripMenuItemAssetList.Name = "ToolStripMenuItemAssetList";
            this.ToolStripMenuItemAssetList.Size = new System.Drawing.Size(142, 22);
            this.ToolStripMenuItemAssetList.Text = "资产列表";
            this.ToolStripMenuItemAssetList.Click += new System.EventHandler(this.ToolStripMenuItemAssetList_Click);
            // 
            // ToolStripMenuItemAssetGroupList
            // 
            this.ToolStripMenuItemAssetGroupList.Name = "ToolStripMenuItemAssetGroupList";
            this.ToolStripMenuItemAssetGroupList.Size = new System.Drawing.Size(142, 22);
            this.ToolStripMenuItemAssetGroupList.Text = "资产分组列表";
            this.ToolStripMenuItemAssetGroupList.Click += new System.EventHandler(this.ToolStripMenuItemAssetGroupList_Click);
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(615, 307);
            this.Controls.Add(this.menuStrip1);
            this.IsMdiContainer = true;
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "MainForm";
            this.Text = "Web服务演示客户端";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.Load += new System.EventHandler(this.MainForm_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItemUserMng;
        private System.Windows.Forms.ToolStripMenuItem ToolStripMenuItemUserList;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItemAccessDetailMng;
        private System.Windows.Forms.ToolStripMenuItem ToolStripMenuItemAccessDetailList;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItemOperatorMng;
        private System.Windows.Forms.ToolStripMenuItem ToolStripMenuItemLogin;
        private System.Windows.Forms.ToolStripMenuItem ToolStripMenuItemLogout;
        private System.Windows.Forms.ToolStripMenuItem ToolStripMenuItemAssetMng;
        private System.Windows.Forms.ToolStripMenuItem ToolStripMenuItemAssetList;
        private System.Windows.Forms.ToolStripMenuItem ToolStripMenuItemAssetGroupList;
        private System.Windows.Forms.ToolStripMenuItem ToolStripMenuItemBlacklist;
        private System.Windows.Forms.ToolStripMenuItem ToolStripMenuItemOnlineList;
        private System.Windows.Forms.ToolStripMenuItem ToolStripMenuItemServiceTemplate;
        private System.Windows.Forms.ToolStripMenuItem ToolStripMenuItemLDAP;
    }
}