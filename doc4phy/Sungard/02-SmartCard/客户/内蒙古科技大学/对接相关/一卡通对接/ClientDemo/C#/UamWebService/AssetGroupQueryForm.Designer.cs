namespace UamWebService
{
    partial class AssetGroupQueryForm
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
            this.dataGridView = new System.Windows.Forms.DataGridView();
            this.ColumnGroupId = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.ColumnAssetGroupName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.ColumnAssetGroupDescription = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView
            // 
            this.dataGridView.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.dataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.ColumnGroupId,
            this.ColumnAssetGroupName,
            this.ColumnAssetGroupDescription});
            this.dataGridView.Location = new System.Drawing.Point(0, 0);
            this.dataGridView.Name = "dataGridView";
            this.dataGridView.RowTemplate.Height = 23;
            this.dataGridView.Size = new System.Drawing.Size(678, 315);
            this.dataGridView.TabIndex = 0;
            // 
            // ColumnGroupId
            // 
            this.ColumnGroupId.HeaderText = "分组ID";
            this.ColumnGroupId.Name = "ColumnGroupId";
            this.ColumnGroupId.ReadOnly = true;
            this.ColumnGroupId.Visible = false;
            // 
            // ColumnAssetGroupName
            // 
            this.ColumnAssetGroupName.HeaderText = "分组名称";
            this.ColumnAssetGroupName.Name = "ColumnAssetGroupName";
            this.ColumnAssetGroupName.ReadOnly = true;
            this.ColumnAssetGroupName.Width = 180;
            // 
            // ColumnAssetGroupDescription
            // 
            this.ColumnAssetGroupDescription.HeaderText = "分组描述";
            this.ColumnAssetGroupDescription.Name = "ColumnAssetGroupDescription";
            this.ColumnAssetGroupDescription.ReadOnly = true;
            this.ColumnAssetGroupDescription.Width = 450;
            // 
            // AssetGroupQueryForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(705, 327);
            this.Controls.Add(this.dataGridView);
            this.Name = "AssetGroupQueryForm";
            this.Text = "资产分组列表";
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn ColumnGroupId;
        private System.Windows.Forms.DataGridViewTextBoxColumn ColumnAssetGroupName;
        private System.Windows.Forms.DataGridViewTextBoxColumn ColumnAssetGroupDescription;
    }
}