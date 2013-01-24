namespace UamWebService
{
    partial class BlacklistQueryInfoForm
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
            this.comboBoxUserGroupId = new System.Windows.Forms.ComboBox();
            this.textBoxAccountName = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.comboBoxJoinReason = new System.Windows.Forms.ComboBox();
            this.textBoxUserMAC = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.buttonOK = new System.Windows.Forms.Button();
            this.buttonCancel = new System.Windows.Forms.Button();
            this.dateTimePickerStartDate = new System.Windows.Forms.DateTimePicker();
            this.dateTimePickerEndDate = new System.Windows.Forms.DateTimePicker();
            this.textBoxStartIP = new System.Windows.Forms.TextBox();
            this.textBoxEndIP = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // comboBoxUserGroupId
            // 
            this.comboBoxUserGroupId.FormattingEnabled = true;
            this.comboBoxUserGroupId.Location = new System.Drawing.Point(102, 33);
            this.comboBoxUserGroupId.Name = "comboBoxUserGroupId";
            this.comboBoxUserGroupId.Size = new System.Drawing.Size(153, 20);
            this.comboBoxUserGroupId.TabIndex = 36;
            // 
            // textBoxAccountName
            // 
            this.textBoxAccountName.Location = new System.Drawing.Point(102, 6);
            this.textBoxAccountName.Name = "textBoxAccountName";
            this.textBoxAccountName.Size = new System.Drawing.Size(153, 21);
            this.textBoxAccountName.TabIndex = 35;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 36);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(53, 12);
            this.label2.TabIndex = 34;
            this.label2.Text = "用户分组";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(41, 12);
            this.label1.TabIndex = 33;
            this.label1.Text = "帐号名";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 91);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(83, 12);
            this.label3.TabIndex = 38;
            this.label3.Text = "用户IP地址 从";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(12, 64);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(71, 12);
            this.label4.TabIndex = 37;
            this.label4.Text = "加入时间 从";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(302, 91);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(17, 12);
            this.label5.TabIndex = 46;
            this.label5.Text = "到";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(302, 64);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(17, 12);
            this.label6.TabIndex = 45;
            this.label6.Text = "到";
            // 
            // comboBoxJoinReason
            // 
            this.comboBoxJoinReason.FormattingEnabled = true;
            this.comboBoxJoinReason.Location = new System.Drawing.Point(392, 33);
            this.comboBoxJoinReason.Name = "comboBoxJoinReason";
            this.comboBoxJoinReason.Size = new System.Drawing.Size(153, 20);
            this.comboBoxJoinReason.TabIndex = 44;
            // 
            // textBoxUserMAC
            // 
            this.textBoxUserMAC.Location = new System.Drawing.Point(392, 6);
            this.textBoxUserMAC.Name = "textBoxUserMAC";
            this.textBoxUserMAC.Size = new System.Drawing.Size(153, 21);
            this.textBoxUserMAC.TabIndex = 43;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(302, 36);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(53, 12);
            this.label7.TabIndex = 42;
            this.label7.Text = "加入原因";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(302, 9);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(71, 12);
            this.label8.TabIndex = 41;
            this.label8.Text = "用户MAC地址";
            // 
            // buttonOK
            // 
            this.buttonOK.Location = new System.Drawing.Point(217, 130);
            this.buttonOK.Name = "buttonOK";
            this.buttonOK.Size = new System.Drawing.Size(75, 23);
            this.buttonOK.TabIndex = 49;
            this.buttonOK.Text = "查询";
            this.buttonOK.UseVisualStyleBackColor = true;
            // 
            // buttonCancel
            // 
            this.buttonCancel.Location = new System.Drawing.Point(298, 131);
            this.buttonCancel.Name = "buttonCancel";
            this.buttonCancel.Size = new System.Drawing.Size(75, 23);
            this.buttonCancel.TabIndex = 50;
            this.buttonCancel.Text = "取消";
            this.buttonCancel.UseVisualStyleBackColor = true;
            // 
            // dateTimePickerStartDate
            // 
            this.dateTimePickerStartDate.Location = new System.Drawing.Point(101, 61);
            this.dateTimePickerStartDate.Name = "dateTimePickerStartDate";
            this.dateTimePickerStartDate.Size = new System.Drawing.Size(154, 21);
            this.dateTimePickerStartDate.TabIndex = 51;
            // 
            // dateTimePickerEndDate
            // 
            this.dateTimePickerEndDate.Location = new System.Drawing.Point(392, 60);
            this.dateTimePickerEndDate.Name = "dateTimePickerEndDate";
            this.dateTimePickerEndDate.Size = new System.Drawing.Size(154, 21);
            this.dateTimePickerEndDate.TabIndex = 52;
            // 
            // textBoxStartIP
            // 
            this.textBoxStartIP.Location = new System.Drawing.Point(101, 88);
            this.textBoxStartIP.Name = "textBoxStartIP";
            this.textBoxStartIP.Size = new System.Drawing.Size(153, 21);
            this.textBoxStartIP.TabIndex = 53;
            // 
            // textBoxEndIP
            // 
            this.textBoxEndIP.Location = new System.Drawing.Point(392, 87);
            this.textBoxEndIP.Name = "textBoxEndIP";
            this.textBoxEndIP.Size = new System.Drawing.Size(153, 21);
            this.textBoxEndIP.TabIndex = 54;
            // 
            // BlacklistQueryInfoForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(568, 165);
            this.Controls.Add(this.textBoxEndIP);
            this.Controls.Add(this.textBoxStartIP);
            this.Controls.Add(this.dateTimePickerEndDate);
            this.Controls.Add(this.dateTimePickerStartDate);
            this.Controls.Add(this.buttonCancel);
            this.Controls.Add(this.buttonOK);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.comboBoxJoinReason);
            this.Controls.Add(this.textBoxUserMAC);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.comboBoxUserGroupId);
            this.Controls.Add(this.textBoxAccountName);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "BlacklistQueryInfoForm";
            this.Text = "黑名单查询";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ComboBox comboBoxUserGroupId;
        private System.Windows.Forms.TextBox textBoxAccountName;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.ComboBox comboBoxJoinReason;
        private System.Windows.Forms.TextBox textBoxUserMAC;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Button buttonOK;
        private System.Windows.Forms.Button buttonCancel;
        private System.Windows.Forms.DateTimePicker dateTimePickerStartDate;
        private System.Windows.Forms.DateTimePicker dateTimePickerEndDate;
        private System.Windows.Forms.TextBox textBoxStartIP;
        private System.Windows.Forms.TextBox textBoxEndIP;

    }
}