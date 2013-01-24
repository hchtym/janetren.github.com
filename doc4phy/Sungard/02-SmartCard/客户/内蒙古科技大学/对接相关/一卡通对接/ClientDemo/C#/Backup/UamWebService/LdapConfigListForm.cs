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
    public partial class LdapConfigListForm : Form
    {
        acmUserService accessUserService = MainForm.GetAccessUserService();
        public LdapConfigListForm(UamWebService.MainForm parent)
        {
            InitializeComponent();
            this.MdiParent = parent;

            DataGridViewRowCollection rows = this.dataGridView1.Rows;

            // ����ȱʡ��ѯ����
            AcmSyncPolicyQueryParam queryParam = new AcmSyncPolicyQueryParam();
            // ���ò�ѯ�ӿ�
            RetAcmSyncPolicyInfoList resultList = accessUserService.querySyncPolicyInfoList(queryParam);
            if (resultList.errorCode == 0)
            {
                if (resultList.retAcmSyncPolicyInfoList != null)
                {
                    foreach (RetAcmSyncPolicyInfo policyInfo in resultList.retAcmSyncPolicyInfoList)
                    {
                        String[] row = new String[this.dataGridView1.ColumnCount];
                        row[0] = policyInfo.policyId.Value.ToString();
                        row[1] = policyInfo.policyName;
                        row[2] = policyInfo.serverId.Value.ToString();
                        row[3] = policyInfo.serverName;
                        row[4] = policyInfo.syncPolicyId.Value.ToString();
                        row[5] = policyInfo.userGroupId.Value.ToString();
                        if (policyInfo.configStatus.Value == 1)
                        {
                            row[6] = "��Ч";
                        }
                        else
                        {
                            row[6] = "��Ч";
                        }
                        if (policyInfo.autoSync.Value)
                        {
                            row[7] = "��";
                        }
                        else
                        {
                            row[7] = "��";
                        }
                        rows.Add(row);

                    }
                }

            }
            else
            {
                MessageBox.Show("��ѯͬ�������б�ʧ�ܣ�ʧ��ԭ��Ϊ��" + resultList.errorMsg);
            }

        }

       // private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        //{
            
            
        //}

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            try
            {
                if (e.ColumnIndex == 8 && e.RowIndex != -1)
                {
                    long policyId = long.Parse(this.dataGridView1.CurrentRow.Cells[0].Value.ToString());
                    Form ldapUserListForm = new LdapUserListForm(policyId);
                    ldapUserListForm.ShowDialog();
                    //MessageBox.Show(policyId.ToString());

                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            
            
        }
    }
}