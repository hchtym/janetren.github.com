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
    public partial class ServiceTemplateListForm : Form
    {
        acmUserService accessUserService = MainForm.GetAccessUserService();
        public ServiceTemplateListForm(UamWebService.MainForm parent)
        {
            InitializeComponent();
            this.MdiParent = parent;

            DataGridViewRowCollection rows = this.dataGridView1.Rows;

            // ����ȱʡ��ѯ����
            AcmServiceTemplateQueryParam param = new AcmServiceTemplateQueryParam();
            RetAcmServiceTemplateInfoList resultList = accessUserService.queryServiceTemplateList(param);
            if (resultList.errorCode == 0)
            {
                if (resultList.retAcmServiceTemplateInfoList != null)
                {
                    foreach (RetAcmServiceTemplateInfo templateInfo in resultList.retAcmServiceTemplateInfoList)
                    {
                        String[] row = new String[this.dataGridView1.ColumnCount];
                        row[0] = templateInfo.serviceId.Value.ToString();
                        row[1] = templateInfo.serviceName;
                        if (templateInfo.serviceStatus.Value == 1)
                        {
                            row[2] = "������";
                        }
                        else
                        {
                            row[2] = "��������";
                        }
                        row[3] = templateInfo.serviceDesc;
                        row[4] = templateInfo.serviceSuffix;
                        row[5] = templateInfo.groupId.Value.ToString();
                        row[6] = templateInfo.safePolicy.Value.ToString();
                        row[7] = templateInfo.ldapPriority.Value.ToString();
                        if (templateInfo.assignAddress.Value == 1)
                        {
                            row[8] = "��";
                        }
                        else
                        {
                            row[8] = "��";
                        }
                        rows.Add(row);

                    }
                }

            }
            else
            {
                MessageBox.Show("��ѯ�������б�ʧ�ܣ�ʧ��ԭ��Ϊ��" + resultList.errorMsg);
            }
        }
    }
}