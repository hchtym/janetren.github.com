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
    public partial class ModifyUserForm : Form
    {
        acmUserService accessUserService = MainForm.GetAccessUserService();
        public ModifyUserForm(String userName)
        {
            InitializeComponent();
            this.buttonCancel.DialogResult = DialogResult.Cancel;

            // ��ѯ�û���Ϣ
            RetAcmUser result = accessUserService.queryAcmUser(userName);
            if (result.errorCode == 0)
            {
                this.textBoxBoundDomainName.Text = result.acmUser.boundDomainName;
                this.textBoxComputerName.Text = result.acmUser.computerName;

                long value = result.acmUser.idleTimeout.Value;
                this.textBoxIdleTimeout.Text = (value != MainForm.VALUE_NULL ? value.ToString() : "");

                if (result.acmUser.invalidTime != null)
                {
                    this.dateTimePickerInvalidTime.Value = result.acmUser.invalidTime.Value;
                }
                else
                {
                    this.dateTimePickerInvalidTime.Value = System.DateTime.Now.AddYears(10);
                }
                this.textBoxLogonDomainName.Text = result.acmUser.logonDomainName;
                this.textBoxNasIpStr.Text = result.acmUser.nasIpStr;

                value = result.acmUser.nasPort.Value;
                this.textBoxNasPort.Text = (value != MainForm.VALUE_NULL ? value.ToString() : "");

                value = result.acmUser.onlineLimit.Value;
                this.textBoxOnlineLimit.Text = (value != MainForm.VALUE_NULL?value.ToString():"");

                this.textBoxPromptInfo.Text = result.acmUser.promptInfo;
                this.textBoxUserName.Text = result.acmUser.userName;

                value = result.acmUser.vlan.Value;
                this.textBoxVlan.Text = (value != MainForm.VALUE_NULL ? value.ToString() : "");

                value = result.acmUser.vlan2.Value;
                this.textBoxVlan2.Text = (value != MainForm.VALUE_NULL ? value.ToString() : "");

                this.textBoxWlanSsid.Text = result.acmUser.wlanSsid;
            }
            else
            {
                MessageBox.Show("��ȡ�û���Ϣʧ�ܣ�ʧ��ԭ��Ϊ��" +��result.errorMsg);
            }

        }

        // �޸��û���Ϣ
        private void buttonOK_Click(object sender, EventArgs e)
        {
            // �������ʱ��
            long idleTimeout = MainForm.VALUE_NULL;
            try
            {
                if (!"".Equals(this.textBoxIdleTimeout.Text))
                {
                    idleTimeout = int.Parse(this.textBoxIdleTimeout.Text);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("�������ʱ��ֻ��Ϊ������","Web������ʾ�ͻ���");
                return;
            }

            // ������������
            int onlineLimit = MainForm.VALUE_NULL;
            try
            {
                if (!"".Equals(this.textBoxOnlineLimit.Text))
                {
                    onlineLimit = int.Parse(this.textBoxOnlineLimit.Text);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("������������ֻ��Ϊ������", "Web������ʾ�ͻ���");
                return;
            }

            // �˿ں�
            int nasPort = MainForm.VALUE_NULL;
            try
            {
                if (!"".Equals(this.textBoxNasPort.Text))
                {
                    nasPort = int.Parse(this.textBoxNasPort.Text);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("�˿ں�ֻ��Ϊ������", "Web������ʾ�ͻ���");
                return;
            }

            // VLAN ID/�ڲ�VLAN ID
            long vlan = MainForm.VALUE_NULL;
            try
            {
                if (!"".Equals(this.textBoxVlan.Text))
                {
                    vlan = int.Parse(this.textBoxVlan.Text);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("VLAN ID/�ڲ�VLAN IDֻ��Ϊ������", "Web������ʾ�ͻ���");
                return;
            }

            // ���VLAN ID
            long vlan2 = MainForm.VALUE_NULL;
            try
            {
                if (!"".Equals(this.textBoxVlan2.Text))
                {
                    vlan2 = int.Parse(this.textBoxVlan2.Text);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("���VLAN IDֻ��Ϊ������", "Web������ʾ�ͻ���");
                return;
            }

            ModifyAcmUserParam param = new ModifyAcmUserParam();
            param.userName = this.textBoxUserName.Text;
            param.boundDomainName = this.textBoxBoundDomainName.Text;
            param.computerName = this.textBoxComputerName.Text;
            param.idleTimeout = idleTimeout;
            param.idleTimeoutSpecified = true;
            param.invalidTime = this.dateTimePickerInvalidTime.Value;
            param.invalidTimeSpecified = true;
            param.logonDomainName = this.textBoxLogonDomainName.Text;
            param.nasIpStr = this.textBoxNasIpStr.Text;
            param.nasPort = nasPort;
            param.nasPortSpecified = true;
            param.onlineLimit = onlineLimit;
            param.onlineLimitSpecified = true;
            param.promptInfo = this.textBoxPromptInfo.Text;
            param.vlan = vlan;
            param.vlanSpecified = true;
            param.vlan2 = vlan2;
            param.vlan2Specified = true;
            param.wlanSsid = this.textBoxWlanSsid.Text;

            // �����޸��û���Ϣ�ӿ�
            WSCommonResult result = accessUserService.modifyAcmUser(param);
            if (result.errorCode == 0)
            {
                MessageBox.Show("�޸Ľ����û��ɹ�");
            }
            else
            {
                MessageBox.Show("�޸Ľ����û�ʧ�ܣ�ʧ��ԭ��Ϊ��" + result.errorMsg);
            }
            this.Dispose(true);

        }
    }
}