namespace UamWebService
{
    partial class UserListForm
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
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.buttonAdd = new System.Windows.Forms.Button();
            this.buttonDelete = new System.Windows.Forms.Button();
            this.buttonAddBlacklist = new System.Windows.Forms.Button();
            this.buttonBindUser = new System.Windows.Forms.Button();
            this.dataGridViewImageColumn2 = new System.Windows.Forms.DataGridViewImageColumn();
            this.dataGridViewImageColumn1 = new System.Windows.Forms.DataGridViewImageColumn();
            this.dataGridViewImageColumn3 = new System.Windows.Forms.DataGridViewImageColumn();
            this.dataGridViewImageColumn4 = new System.Windows.Forms.DataGridViewImageColumn();
            this.dataGridViewImageColumn5 = new System.Windows.Forms.DataGridViewImageColumn();
            this.dataGridViewImageColumn6 = new System.Windows.Forms.DataGridViewImageColumn();
            this.ColumnUserId = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.ColumnUserName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.ColumnFullName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.ColumnUserGroupID = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.ColumnInvalidTime = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column1 = new System.Windows.Forms.DataGridViewImageColumn();
            this.Column2 = new System.Windows.Forms.DataGridViewImageColumn();
            this.Column4 = new System.Windows.Forms.DataGridViewImageColumn();
            this.Column5 = new System.Windows.Forms.DataGridViewImageColumn();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.AllowUserToAddRows = false;
            this.dataGridView1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.ColumnUserId,
            this.ColumnUserName,
            this.ColumnFullName,
            this.ColumnUserGroupID,
            this.ColumnInvalidTime,
            this.Column1,
            this.Column2,
            this.Column4,
            this.Column5});
            this.dataGridView1.Location = new System.Drawing.Point(8, 37);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.RowTemplate.Height = 23;
            this.dataGridView1.Size = new System.Drawing.Size(900, 489);
            this.dataGridView1.TabIndex = 0;
            this.dataGridView1.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellContentClick);
            // 
            // buttonAdd
            // 
            this.buttonAdd.Location = new System.Drawing.Point(8, 8);
            this.buttonAdd.Name = "buttonAdd";
            this.buttonAdd.Size = new System.Drawing.Size(75, 23);
            this.buttonAdd.TabIndex = 1;
            this.buttonAdd.Text = "增加";
            this.buttonAdd.UseVisualStyleBackColor = true;
            this.buttonAdd.Click += new System.EventHandler(this.buttonAdd_Click);
            // 
            // buttonDelete
            // 
            this.buttonDelete.Location = new System.Drawing.Point(89, 8);
            this.buttonDelete.Name = "buttonDelete";
            this.buttonDelete.Size = new System.Drawing.Size(75, 23);
            this.buttonDelete.TabIndex = 3;
            this.buttonDelete.Text = "注销";
            this.buttonDelete.UseVisualStyleBackColor = true;
            this.buttonDelete.Click += new System.EventHandler(this.buttonDelete_Click);
            // 
            // buttonAddBlacklist
            // 
            this.buttonAddBlacklist.Location = new System.Drawing.Point(170, 8);
            this.buttonAddBlacklist.Name = "buttonAddBlacklist";
            this.buttonAddBlacklist.Size = new System.Drawing.Size(75, 23);
            this.buttonAddBlacklist.TabIndex = 4;
            this.buttonAddBlacklist.Text = "加入黑名单";
            this.buttonAddBlacklist.UseVisualStyleBackColor = true;
            this.buttonAddBlacklist.Click += new System.EventHandler(this.buttonAddBlacklist_Click);
            // 
            // buttonBindUser
            // 
            this.buttonBindUser.Location = new System.Drawing.Point(251, 8);
            this.buttonBindUser.Name = "buttonBindUser";
            this.buttonBindUser.Size = new System.Drawing.Size(127, 23);
            this.buttonBindUser.TabIndex = 5;
            this.buttonBindUser.Text = "绑定到LDAP同步策略";
            this.buttonBindUser.UseVisualStyleBackColor = true;
            this.buttonBindUser.Click += new System.EventHandler(this.buttonBindUser_Click);
            // 
            // dataGridViewImageColumn2
            // 
            this.dataGridViewImageColumn2.HeaderText = "修改密码";
            this.dataGridViewImageColumn2.Name = "dataGridViewImageColumn2";
            this.dataGridViewImageColumn2.ReadOnly = true;
            this.dataGridViewImageColumn2.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            this.dataGridViewImageColumn2.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.Automatic;
            // 
            // dataGridViewImageColumn1
            // 
            this.dataGridViewImageColumn1.HeaderText = "修改";
            this.dataGridViewImageColumn1.Image = global::UamWebService.Properties.Resources.edit;
            this.dataGridViewImageColumn1.Name = "dataGridViewImageColumn1";
            this.dataGridViewImageColumn1.ReadOnly = true;
            this.dataGridViewImageColumn1.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            this.dataGridViewImageColumn1.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.Automatic;
            this.dataGridViewImageColumn1.Width = 80;
            // 
            // dataGridViewImageColumn3
            // 
            this.dataGridViewImageColumn3.HeaderText = "详细信息";
            this.dataGridViewImageColumn3.Image = global::UamWebService.Properties.Resources.detail;
            this.dataGridViewImageColumn3.Name = "dataGridViewImageColumn3";
            this.dataGridViewImageColumn3.ReadOnly = true;
            this.dataGridViewImageColumn3.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            this.dataGridViewImageColumn3.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.Automatic;
            this.dataGridViewImageColumn3.Width = 80;
            // 
            // dataGridViewImageColumn4
            // 
            this.dataGridViewImageColumn4.HeaderText = "详细信息";
            this.dataGridViewImageColumn4.Image = global::UamWebService.Properties.Resources.detail;
            this.dataGridViewImageColumn4.Name = "dataGridViewImageColumn4";
            this.dataGridViewImageColumn4.ReadOnly = true;
            this.dataGridViewImageColumn4.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            this.dataGridViewImageColumn4.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.Automatic;
            this.dataGridViewImageColumn4.Width = 80;
            // 
            // dataGridViewImageColumn5
            // 
            this.dataGridViewImageColumn5.HeaderText = "注销服务";
            this.dataGridViewImageColumn5.Image = global::UamWebService.Properties.Resources.cancel;
            this.dataGridViewImageColumn5.Name = "dataGridViewImageColumn5";
            this.dataGridViewImageColumn5.ReadOnly = true;
            this.dataGridViewImageColumn5.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            this.dataGridViewImageColumn5.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.Automatic;
            this.dataGridViewImageColumn5.Width = 80;
            // 
            // dataGridViewImageColumn6
            // 
            this.dataGridViewImageColumn6.HeaderText = "详细信息";
            this.dataGridViewImageColumn6.Image = global::UamWebService.Properties.Resources.detail;
            this.dataGridViewImageColumn6.Name = "dataGridViewImageColumn6";
            this.dataGridViewImageColumn6.ReadOnly = true;
            this.dataGridViewImageColumn6.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            this.dataGridViewImageColumn6.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.Automatic;
            this.dataGridViewImageColumn6.Width = 80;
            // 
            // ColumnUserId
            // 
            this.ColumnUserId.HeaderText = "帐号ID";
            this.ColumnUserId.Name = "ColumnUserId";
            this.ColumnUserId.ReadOnly = true;
            this.ColumnUserId.Width = 66;
            // 
            // ColumnUserName
            // 
            this.ColumnUserName.HeaderText = "帐号名";
            this.ColumnUserName.Name = "ColumnUserName";
            this.ColumnUserName.ReadOnly = true;
            this.ColumnUserName.Width = 150;
            // 
            // ColumnFullName
            // 
            this.ColumnFullName.HeaderText = "用户姓名";
            this.ColumnFullName.Name = "ColumnFullName";
            this.ColumnFullName.ReadOnly = true;
            // 
            // ColumnUserGroupID
            // 
            this.ColumnUserGroupID.HeaderText = "用户分组ID";
            this.ColumnUserGroupID.Name = "ColumnUserGroupID";
            this.ColumnUserGroupID.ReadOnly = true;
            this.ColumnUserGroupID.Width = 90;
            // 
            // ColumnInvalidTime
            // 
            this.ColumnInvalidTime.HeaderText = "失效日期";
            this.ColumnInvalidTime.Name = "ColumnInvalidTime";
            this.ColumnInvalidTime.ReadOnly = true;
            this.ColumnInvalidTime.Width = 120;
            // 
            // Column1
            // 
            this.Column1.HeaderText = "修改";
            this.Column1.Image = global::UamWebService.Properties.Resources.edit;
            this.Column1.Name = "Column1";
            this.Column1.ReadOnly = true;
            this.Column1.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            this.Column1.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.Automatic;
            this.Column1.Width = 80;
            // 
            // Column2
            // 
            this.Column2.HeaderText = "修改密码";
            this.Column2.Image = global::UamWebService.Properties.Resources.pwd;
            this.Column2.Name = "Column2";
            this.Column2.ReadOnly = true;
            this.Column2.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            this.Column2.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.Automatic;
            this.Column2.Width = 80;
            // 
            // Column4
            // 
            this.Column4.HeaderText = "申请服务";
            this.Column4.Image = global::UamWebService.Properties.Resources.apply;
            this.Column4.Name = "Column4";
            this.Column4.ReadOnly = true;
            this.Column4.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            this.Column4.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.Automatic;
            this.Column4.Width = 80;
            // 
            // Column5
            // 
            this.Column5.HeaderText = "注销服务";
            this.Column5.Image = global::UamWebService.Properties.Resources.cancel;
            this.Column5.Name = "Column5";
            this.Column5.ReadOnly = true;
            this.Column5.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            this.Column5.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.Automatic;
            this.Column5.Width = 80;
            // 
            // UserListForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(905, 538);
            this.Controls.Add(this.buttonBindUser);
            this.Controls.Add(this.buttonAddBlacklist);
            this.Controls.Add(this.buttonDelete);
            this.Controls.Add(this.buttonAdd);
            this.Controls.Add(this.dataGridView1);
            this.Name = "UserListForm";
            this.Text = "接入用户列表";
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.Button buttonAdd;
        private System.Windows.Forms.Button buttonDelete;
        private System.Windows.Forms.Button buttonAddBlacklist;
        private System.Windows.Forms.Button buttonBindUser;
        private System.Windows.Forms.DataGridViewImageColumn dataGridViewImageColumn1;
        private System.Windows.Forms.DataGridViewImageColumn dataGridViewImageColumn2;
        private System.Windows.Forms.DataGridViewImageColumn dataGridViewImageColumn3;
        private System.Windows.Forms.DataGridViewImageColumn dataGridViewImageColumn4;
        private System.Windows.Forms.DataGridViewImageColumn dataGridViewImageColumn5;
        private System.Windows.Forms.DataGridViewImageColumn dataGridViewImageColumn6;
        private System.Windows.Forms.DataGridViewTextBoxColumn ColumnUserId;
        private System.Windows.Forms.DataGridViewTextBoxColumn ColumnUserName;
        private System.Windows.Forms.DataGridViewTextBoxColumn ColumnFullName;
        private System.Windows.Forms.DataGridViewTextBoxColumn ColumnUserGroupID;
        private System.Windows.Forms.DataGridViewTextBoxColumn ColumnInvalidTime;
        private System.Windows.Forms.DataGridViewImageColumn Column1;
        private System.Windows.Forms.DataGridViewImageColumn Column2;
        private System.Windows.Forms.DataGridViewImageColumn Column4;
        private System.Windows.Forms.DataGridViewImageColumn Column5;
    }
}