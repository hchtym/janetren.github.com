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
    public partial class UserListQueryInfoForm : Form
    {
        imcplatUserService platUserService = null;
        acmUserService accessUserService = null;
        private AcmUserListQueryParam queryParam = new AcmUserListQueryParam();

        private int nasPort;
        private int vlan;
        private int vlan2;
        private int onlineLimit;
        private int idleLimit;
        public static bool validate = false;

        public UserListQueryInfoForm()
        {
            InitializeComponent();
            validate = false;

            // ��ȡWeb�������
            platUserService = MainForm.GetPlatUserService();
            accessUserService = MainForm.GetAccessUserService();

            // ���ÿ�ʼ���ڲ�ѯ����
            this.dateTimePickerCreationStartDate.Value = System.DateTime.Now.AddMonths(-1);
            //this.dateTimePickerLastLogOffStartTime.Value = System.DateTime.Now.AddMonths(-1);

            // ���÷�������
            CombItem item = new CombItem("����", -1);
            this.comboBoxServiceID.Items.Add(item);

            AcmServiceTemplateQueryParam serviceTemplateQueryParam = new AcmServiceTemplateQueryParam();
            RetAcmServiceTemplateInfoList serviceTemplateList = accessUserService.queryServiceTemplateList(serviceTemplateQueryParam);
            if (serviceTemplateList.errorCode == 0 )
            {
                if (serviceTemplateList.retAcmServiceTemplateInfoList != null)
                {
                    foreach (RetAcmServiceTemplateInfo serviceTemplate in serviceTemplateList.retAcmServiceTemplateInfoList)
                    {
                        item = new CombItem(serviceTemplate.serviceName, serviceTemplate.serviceId.Value);
                        this.comboBoxServiceID.Items.Add(item);
                    }
                }
            }
            else
            {
                MessageBox.Show("�޷���ȡ�����б���Ϣ");
            }
            this.comboBoxServiceID.SelectedIndex = 0;

            // �����û�����
            item = new CombItem("����", -1);
            this.comboBoxUserGroupId.Items.Add(item);
            this.comboBoxUserGroupId.SelectedIndex = 0;

            this.buttonOK.DialogResult = DialogResult.OK;
            this.buttonCancel.DialogResult = DialogResult.Cancel;
        }

        public AcmUserListQueryParam GetQueryParam()
        {
            queryParam.accountName = this.textBoxAccountName.Text;
            queryParam.fullName = this.textBoxFullName.Text;
            queryParam.userGroupId = ((CombItem)this.comboBoxUserGroupId.SelectedItem).itemValue;
            queryParam.userGroupIdSpecified = true;
            queryParam.serviceID = ((CombItem)this.comboBoxServiceID.SelectedItem).itemValue;
            queryParam.serviceIDSpecified = true;
            queryParam.identityNumber = this.textBoxIdentityNumber.Text;
            queryParam.contactAddress = this.textBoxContactAddress.Text;
            queryParam.creationStartDate = this.dateTimePickerCreationStartDate.Value;
            queryParam.creationStartDateSpecified = true;
            queryParam.creationEndDate = this.dateTimePickerCreationEndDate.Value;
            queryParam.creationEndDateSpecified = true;
            //queryParam.lastLogOffStartTime = this.dateTimePickerLastLogOffStartTime.Value;
            //queryParam.lastLogOffStartTimeSpecified = true;
            //queryParam.lastLogOffEndTime = this.dateTimePickerLastLogOffEndTime.Value;
            //queryParam.lastLogOffEndTimeSpecified = true;
            queryParam.email = this.textBoxEmai.Text;
            queryParam.port = nasPort;
            queryParam.portSpecified = true;
            queryParam.maxConcurrentLimit = onlineLimit;
            queryParam.maxConcurrentLimitSpecified = true;
            queryParam.maxIdleTime = idleLimit;
            queryParam.maxIdleTimeSpecified = true;
            queryParam.deviceStartIp = this.textBoxDeviceStartIp.Text;
            queryParam.deviceEndIp = this.textBoxDeviceEndIp.Text;
            queryParam.userStartIp = this.textBoxUserStartIp.Text;
            queryParam.userEndIp = this.textBoxUserEndIp.Text;
            queryParam.userMac = this.textBoxUserMac.Text;
            queryParam.userSsid = this.textBoxUserSsid.Text;
            queryParam.innerVlanId = vlan;
            queryParam.innerVlanIdSpecified = true;
            queryParam.outerVlanId = vlan2;
            queryParam.outerVlanIdSpecified = true;
            queryParam.boundDomain = this.textBoxBoundDomain.Text;
            queryParam.logonDomain = this.textBoxLogonDomain.Text;
            queryParam.computerName = this.textBoxComputerName.Text;
            
            return queryParam;
        }


        class CombItem : System.Object
        {
            public String caption;
            public long itemValue;
            public CombItem(String caption, long itemValue)
            {
                this.caption = caption;
                this.itemValue = itemValue;
            }
            public override string ToString()
            {
                return caption;
            }
        }

        private void buttonOK_Click(object sender, EventArgs e)
        {
            //������������
            onlineLimit = MainForm.VALUE_NULL;
            try
            {
                if (!"".Equals(this.textBoxMaxConcurrentLimit.Text))
                {
                    nasPort = int.Parse(this.textBoxMaxConcurrentLimit.Text);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("������������ֻ��Ϊ������");
                return;
            }
            
            // �������ʱ��
            idleLimit = MainForm.VALUE_NULL;
            try
            {
                if (!"".Equals(this.textBoxMaxIdleTime.Text))
                {
                    nasPort = int.Parse(this.textBoxMaxIdleTime.Text);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("�������ʱ��ֻ��Ϊ������");
                return;
            }
            
            // �˿ں�
            nasPort = MainForm.VALUE_NULL;
            try
            {
                if (!"".Equals(this.textBoxPort.Text))
                {
                    nasPort = int.Parse(this.textBoxPort.Text);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("�豸�˿�ֻ��Ϊ������");
                return;
            }
            // VLAN ID/�ڲ�VLAN ID
            vlan = MainForm.VALUE_NULL;
            try
            {
                if (!"".Equals(this.textBoxInnerVlanId.Text))
                {
                    vlan = int.Parse(this.textBoxInnerVlanId.Text);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("VLAN ID/�ڲ�VLAN IDֻ��Ϊ������");
                return;
            }

            // ���VLAN ID
            vlan2 = MainForm.VALUE_NULL;
            try
            {
                if (!"".Equals(this.textBoxOuterVlanId.Text))
                {
                    vlan2 = int.Parse(this.textBoxOuterVlanId.Text);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("���VLAN IDֻ��Ϊ������");
                return;
            }
            validate = true;
            //this.Dispose(true);
        }
    }
}