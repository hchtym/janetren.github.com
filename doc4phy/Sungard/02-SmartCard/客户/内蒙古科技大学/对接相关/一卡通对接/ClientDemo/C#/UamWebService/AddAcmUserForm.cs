using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using UamWebService.acmUser;
using UamWebService.imcPlatUser;

namespace UamWebService
{
    public partial class AddAcmUserForm : Form
    {
        imcplatUserService platUserService = MainForm.GetPlatUserService();
        acmUserService accessUserService = MainForm.GetAccessUserService();
        public AddAcmUserForm()
        {
            InitializeComponent();
            this.dateTimePickerInvalidTime.Value = System.DateTime.Now.AddYears(10);
            this.buttonCancel.DialogResult = DialogResult.Cancel;
        }

        private void buttonOK_Click(object sender, EventArgs e)
        {
            if ("".Equals(this.textBoxUserName.Text))
            {
                MessageBox.Show("�ʺ�������Ϊ�ա�", "Web������ʾ�ͻ���");
                return; 
            }
            if ("".Equals(this.textBoxPassword.Text))
            {
                MessageBox.Show("���벻��Ϊ�ա�", "Web������ʾ�ͻ���");
                return;
            }

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
                MessageBox.Show("�������ʱ��ֻ��Ϊ������", "Web������ʾ�ͻ���");
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
            User user = new User();
            user.userName = this.textBoxUserName.Text;
            user.certification = "test" + this.textBoxUserName.Text;
            user.status = 0;
            user.statusSpecified = true;
            UserGroup userGroup = new UserGroup();
            userGroup.id = 1;
            userGroup.idSpecified = true;
            user.userGroup = userGroup;
            UserAppendInfo appendInfo = new UserAppendInfo();
            user.userAppend = appendInfo;
            UamWebService.imcPlatUser.WSCommonResult result = platUserService.addUser(user);
            if (result.errorCode != 0)
            {
                MessageBox.Show("���ӽ����û�ʧ�ܣ�ʧ��ԭ��Ϊ������ƽ̨�û�ʧ�ܣ�" + result.errorMsg, "Web������ʾ�ͻ���");
                return;
            }

            
            WSUser wsUser = platUserService.queryUserByNameAndIdentity(user.userName, user.certification);
            if (wsUser.errorCode != 0)
            {
                MessageBox.Show("���ӽ����û�ʧ�ܣ�ʧ��ԭ��Ϊ����ѯƽ̨�û�ʧ�ܣ�" + wsUser.errorMsg, "Web������ʾ�ͻ���");
                return;
            }

            // ���ý����û���Ϣ
            AddAcmUserParam acmUserParam = new AddAcmUserParam();
            acmUserParam.platUserId = wsUser.user.id;
            acmUserParam.platUserIdSpecified = true;
            acmUserParam.userName = this.textBoxUserName.Text;
            acmUserParam.password = this.textBoxPassword.Text;
            acmUserParam.boundDomainName = this.textBoxBoundDomainName.Text;
            acmUserParam.computerName = this.textBoxComputerName.Text;
            acmUserParam.idleTimeout = idleTimeout;
            acmUserParam.idleTimeoutSpecified = true;
            acmUserParam.invalidTime = this.dateTimePickerInvalidTime.Value;
            acmUserParam.invalidTimeSpecified = true;
            acmUserParam.logonDomainName = this.textBoxLogonDomainName.Text;
            acmUserParam.nasIpStr = this.textBoxNasIpStr.Text;
            acmUserParam.nasPort = nasPort;
            acmUserParam.nasPortSpecified = true;
            acmUserParam.onlineLimit = onlineLimit;
            acmUserParam.onlineLimitSpecified = true;
            acmUserParam.promptInfo = this.textBoxPromptInfo.Text;
            acmUserParam.vlan = vlan;
            acmUserParam.vlanSpecified = true;
            acmUserParam.vlan2 = vlan2;
            acmUserParam.vlan2Specified = true;
            acmUserParam.wlanSsid = this.textBoxWlanSsid.Text;

            UamWebService.acmUser.WSCommonResult addResult = accessUserService.addAcmUser(acmUserParam);
            if (addResult.errorCode != 0)
            {
                MessageBox.Show("���ӽ����û�ʧ�ܣ�ʧ��ԭ��Ϊ��" + addResult.errorMsg, "Web������ʾ�ͻ���");
                return;
            }
            else
            {
                MessageBox.Show("���ӽ����û��ɹ���", "Web������ʾ�ͻ���");
            }
            this.Dispose(true);
            MainForm.GetUserListForm().updateList();

        }
    }
}