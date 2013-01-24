namespace UamWebService
{
    partial class ModifyUserForm
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
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.textBoxIdleTimeout = new System.Windows.Forms.TextBox();
            this.textBoxUserName = new System.Windows.Forms.TextBox();
            this.textBoxNasPort = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.label11 = new System.Windows.Forms.Label();
            this.label12 = new System.Windows.Forms.Label();
            this.label13 = new System.Windows.Forms.Label();
            this.textBoxVlan2 = new System.Windows.Forms.TextBox();
            this.textBoxComputerName = new System.Windows.Forms.TextBox();
            this.textBoxLogonDomainName = new System.Windows.Forms.TextBox();
            this.textBoxWlanSsid = new System.Windows.Forms.TextBox();
            this.textBoxBoundDomainName = new System.Windows.Forms.TextBox();
            this.textBoxVlan = new System.Windows.Forms.TextBox();
            this.textBoxPromptInfo = new System.Windows.Forms.TextBox();
            this.textBoxOnlineLimit = new System.Windows.Forms.TextBox();
            this.textBoxNasIpStr = new System.Windows.Forms.TextBox();
            this.buttonOK = new System.Windows.Forms.Button();
            this.buttonCancel = new System.Windows.Forms.Button();
            this.dateTimePickerInvalidTime = new System.Windows.Forms.DateTimePicker();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 12);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(41, 12);
            this.label1.TabIndex = 0;
            this.label1.Text = "帐号名";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(269, 9);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(53, 12);
            this.label2.TabIndex = 1;
            this.label2.Text = "失效日期";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 46);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(77, 12);
            this.label3.TabIndex = 2;
            this.label3.Text = "最大闲置时长";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(269, 46);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(77, 12);
            this.label4.TabIndex = 3;
            this.label4.Text = "在线数量限制";
            // 
            // textBoxIdleTimeout
            // 
            this.textBoxIdleTimeout.Location = new System.Drawing.Point(95, 43);
            this.textBoxIdleTimeout.Name = "textBoxIdleTimeout";
            this.textBoxIdleTimeout.Size = new System.Drawing.Size(140, 21);
            this.textBoxIdleTimeout.TabIndex = 5;
            // 
            // textBoxUserName
            // 
            this.textBoxUserName.Location = new System.Drawing.Point(95, 9);
            this.textBoxUserName.Name = "textBoxUserName";
            this.textBoxUserName.ReadOnly = true;
            this.textBoxUserName.Size = new System.Drawing.Size(140, 21);
            this.textBoxUserName.TabIndex = 6;
            // 
            // textBoxNasPort
            // 
            this.textBoxNasPort.Location = new System.Drawing.Point(95, 118);
            this.textBoxNasPort.Name = "textBoxNasPort";
            this.textBoxNasPort.Size = new System.Drawing.Size(140, 21);
            this.textBoxNasPort.TabIndex = 7;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(269, 80);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(65, 12);
            this.label5.TabIndex = 9;
            this.label5.Text = "设备IP地址";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(12, 80);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(77, 12);
            this.label6.TabIndex = 8;
            this.label6.Text = "登录提示信息";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(12, 186);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(65, 12);
            this.label7.TabIndex = 11;
            this.label7.Text = "计算机名称";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(12, 154);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(71, 12);
            this.label8.TabIndex = 10;
            this.label8.Text = "外层VLAN ID";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(269, 194);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(47, 12);
            this.label9.TabIndex = 13;
            this.label9.Text = " 绑定域";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(269, 154);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(77, 12);
            this.label10.TabIndex = 12;
            this.label10.Text = "无线用户SSID";
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(269, 118);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(119, 12);
            this.label11.TabIndex = 15;
            this.label11.Text = "VLAN ID/内层VLAN ID";
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(12, 118);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(41, 12);
            this.label12.TabIndex = 14;
            this.label12.Text = "端口号";
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.Location = new System.Drawing.Point(12, 222);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(47, 12);
            this.label13.TabIndex = 16;
            this.label13.Text = " 登录域";
            // 
            // textBoxVlan2
            // 
            this.textBoxVlan2.Location = new System.Drawing.Point(95, 151);
            this.textBoxVlan2.Name = "textBoxVlan2";
            this.textBoxVlan2.Size = new System.Drawing.Size(140, 21);
            this.textBoxVlan2.TabIndex = 19;
            // 
            // textBoxComputerName
            // 
            this.textBoxComputerName.Location = new System.Drawing.Point(95, 185);
            this.textBoxComputerName.Name = "textBoxComputerName";
            this.textBoxComputerName.Size = new System.Drawing.Size(140, 21);
            this.textBoxComputerName.TabIndex = 18;
            // 
            // textBoxLogonDomainName
            // 
            this.textBoxLogonDomainName.Location = new System.Drawing.Point(95, 219);
            this.textBoxLogonDomainName.Name = "textBoxLogonDomainName";
            this.textBoxLogonDomainName.Size = new System.Drawing.Size(140, 21);
            this.textBoxLogonDomainName.TabIndex = 17;
            // 
            // textBoxWlanSsid
            // 
            this.textBoxWlanSsid.Location = new System.Drawing.Point(397, 151);
            this.textBoxWlanSsid.Name = "textBoxWlanSsid";
            this.textBoxWlanSsid.Size = new System.Drawing.Size(140, 21);
            this.textBoxWlanSsid.TabIndex = 25;
            // 
            // textBoxBoundDomainName
            // 
            this.textBoxBoundDomainName.Location = new System.Drawing.Point(397, 185);
            this.textBoxBoundDomainName.Name = "textBoxBoundDomainName";
            this.textBoxBoundDomainName.Size = new System.Drawing.Size(140, 21);
            this.textBoxBoundDomainName.TabIndex = 24;
            // 
            // textBoxVlan
            // 
            this.textBoxVlan.Location = new System.Drawing.Point(397, 118);
            this.textBoxVlan.Name = "textBoxVlan";
            this.textBoxVlan.Size = new System.Drawing.Size(140, 21);
            this.textBoxVlan.TabIndex = 23;
            // 
            // textBoxPromptInfo
            // 
            this.textBoxPromptInfo.Location = new System.Drawing.Point(95, 80);
            this.textBoxPromptInfo.Name = "textBoxPromptInfo";
            this.textBoxPromptInfo.Size = new System.Drawing.Size(140, 21);
            this.textBoxPromptInfo.TabIndex = 22;
            // 
            // textBoxOnlineLimit
            // 
            this.textBoxOnlineLimit.Location = new System.Drawing.Point(397, 43);
            this.textBoxOnlineLimit.Name = "textBoxOnlineLimit";
            this.textBoxOnlineLimit.Size = new System.Drawing.Size(140, 21);
            this.textBoxOnlineLimit.TabIndex = 21;
            // 
            // textBoxNasIpStr
            // 
            this.textBoxNasIpStr.Location = new System.Drawing.Point(397, 77);
            this.textBoxNasIpStr.Name = "textBoxNasIpStr";
            this.textBoxNasIpStr.Size = new System.Drawing.Size(140, 21);
            this.textBoxNasIpStr.TabIndex = 20;
            // 
            // buttonOK
            // 
            this.buttonOK.Location = new System.Drawing.Point(271, 256);
            this.buttonOK.Name = "buttonOK";
            this.buttonOK.Size = new System.Drawing.Size(75, 23);
            this.buttonOK.TabIndex = 26;
            this.buttonOK.Text = "确定";
            this.buttonOK.UseVisualStyleBackColor = true;
            this.buttonOK.Click += new System.EventHandler(this.buttonOK_Click);
            // 
            // buttonCancel
            // 
            this.buttonCancel.Location = new System.Drawing.Point(352, 256);
            this.buttonCancel.Name = "buttonCancel";
            this.buttonCancel.Size = new System.Drawing.Size(75, 23);
            this.buttonCancel.TabIndex = 27;
            this.buttonCancel.Text = "取消";
            this.buttonCancel.UseVisualStyleBackColor = true;
            // 
            // dateTimePickerInvalidTime
            // 
            this.dateTimePickerInvalidTime.Location = new System.Drawing.Point(397, 8);
            this.dateTimePickerInvalidTime.Name = "dateTimePickerInvalidTime";
            this.dateTimePickerInvalidTime.Size = new System.Drawing.Size(140, 21);
            this.dateTimePickerInvalidTime.TabIndex = 28;
            // 
            // ModifyUserForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(571, 303);
            this.Controls.Add(this.dateTimePickerInvalidTime);
            this.Controls.Add(this.buttonCancel);
            this.Controls.Add(this.buttonOK);
            this.Controls.Add(this.textBoxWlanSsid);
            this.Controls.Add(this.textBoxBoundDomainName);
            this.Controls.Add(this.textBoxVlan);
            this.Controls.Add(this.textBoxPromptInfo);
            this.Controls.Add(this.textBoxOnlineLimit);
            this.Controls.Add(this.textBoxNasIpStr);
            this.Controls.Add(this.textBoxVlan2);
            this.Controls.Add(this.textBoxComputerName);
            this.Controls.Add(this.textBoxLogonDomainName);
            this.Controls.Add(this.label13);
            this.Controls.Add(this.label11);
            this.Controls.Add(this.label12);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.label10);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.textBoxNasPort);
            this.Controls.Add(this.textBoxUserName);
            this.Controls.Add(this.textBoxIdleTimeout);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "ModifyUserForm";
            this.Text = "修改接入用户";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox textBoxIdleTimeout;
        private System.Windows.Forms.TextBox textBoxUserName;
        private System.Windows.Forms.TextBox textBoxNasPort;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.Label label13;
        private System.Windows.Forms.TextBox textBoxVlan2;
        private System.Windows.Forms.TextBox textBoxComputerName;
        private System.Windows.Forms.TextBox textBoxLogonDomainName;
        private System.Windows.Forms.TextBox textBoxWlanSsid;
        private System.Windows.Forms.TextBox textBoxBoundDomainName;
        private System.Windows.Forms.TextBox textBoxVlan;
        private System.Windows.Forms.TextBox textBoxPromptInfo;
        private System.Windows.Forms.TextBox textBoxOnlineLimit;
        private System.Windows.Forms.TextBox textBoxNasIpStr;
        private System.Windows.Forms.Button buttonOK;
        private System.Windows.Forms.Button buttonCancel;
        private System.Windows.Forms.DateTimePicker dateTimePickerInvalidTime;
    }
}