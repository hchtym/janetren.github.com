using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using UamWebService.acmUser;
using System.Collections;

namespace UamWebService
{
    public partial class BlacklistForm : Form
    {
        public static Boolean querySuccess = true;
        acmUserService accessUserService = MainForm.GetAccessUserService();

        public BlacklistForm(UamWebService.MainForm parent, AcmBlackQueryParam queryParam)
        {
            InitializeComponent();
            this.MdiParent = parent;

            DataGridViewRowCollection rows = this.dataGridView1.Rows;
            // ���ò�ѯ����
            if (queryParam == null)
            {
                queryParam = new AcmBlackQueryParam();
            }

            // ���ò�ѯ�ӿ�
            RetAcmBlackInfoList resultList = accessUserService.queryBlackList(queryParam);
            if (resultList.errorCode == 0)
            {
                if (resultList.retAcmBlackInfoList != null)
                {
                    foreach (RetAcmBlackInfo blackInfo in resultList.retAcmBlackInfoList)
                    {
                        String[] row = new String[this.dataGridView1.ColumnCount];
                        row[0] = blackInfo.blackNameId.Value.ToString();
                        row[1] = blackInfo.accountId.Value.ToString();
                        row[2] = blackInfo.accountName;
                        if (blackInfo.joinDate != null)
                        {
                            row[3] = blackInfo.joinDate.Value.ToLocalTime().ToString();
                        }
                        row[4] = blackInfo.joinReason.Value.ToString();
                        row[5] = blackInfo.userIpAddress;
                        row[6] = blackInfo.userMacAddress;
                        rows.Add(row);
                    }
                }
                querySuccess = true; 

            }
            else
            {
                querySuccess = false;
                MessageBox.Show("��ѯ�������б�ʧ�ܣ�ʧ��ԭ��Ϊ��" + resultList.errorMsg);
            }
        }

        // ���������
        private void buttonDelete_Click(object sender, EventArgs e)
        {
            int successNumber = 0, failNumber = 0;
            DataGridViewSelectedRowCollection rows = this.dataGridView1.SelectedRows;
            IEnumerator iter = rows.GetEnumerator();
            if (!iter.MoveNext())
            {
                MessageBox.Show("������ѡ��һ����¼��");
                return;
            }
            iter.Reset();
            while (iter.MoveNext())
            {
                DataGridViewRow currentRow = (DataGridViewRow)iter.Current;
                if (currentRow.Cells[2].Value == null)
                {
                    MessageBox.Show("�ʺ���Ϊ�գ�");
                    return;
                }
                String userName = currentRow.Cells[2].Value.ToString();
                WSCommonResult result = accessUserService.removeBlackList(userName);
                if (result.errorCode == 0)
                {
                    successNumber++;
                }
                else
                {
                    failNumber++;
                }
            }
            MessageBox.Show( successNumber + "���ʺŽ���������ɹ���"  + failNumber + "���ʺŽ��������ʧ�ܡ�");
            this.updateList();
        }

        // �����б�
        public void updateList()
        {
            DataGridViewRowCollection rows = this.dataGridView1.Rows;
            rows.Clear();
            // ���ò�ѯ����
            AcmBlackQueryParam queryParam = new AcmBlackQueryParam();
            queryParam.joinReason = MainForm.VALUE_UNLIMITE;
            queryParam.joinReasonSpecified = true;
            queryParam.userGroupId = MainForm.VALUE_UNLIMITE;
            queryParam.userGroupIdSpecified = true;

            // ���ò�ѯ�ӿ�
            RetAcmBlackInfoList resultList = accessUserService.queryBlackList(queryParam);
            if (resultList.errorCode == 0)
            {
                if (resultList.retAcmBlackInfoList != null)
                {
                    foreach (RetAcmBlackInfo blackInfo in resultList.retAcmBlackInfoList)
                    {
                        String[] row = new String[this.dataGridView1.ColumnCount];
                        row[0] = blackInfo.blackNameId.Value.ToString();
                        row[1] = blackInfo.accountId.Value.ToString();
                        row[2] = blackInfo.accountName;
                        if (blackInfo.joinDate != null)
                        {
                            row[3] = blackInfo.joinDate.Value.ToLocalTime().ToString();
                        }
                        row[4] = blackInfo.joinReason.Value.ToString();
                        row[5] = blackInfo.userIpAddress;
                        row[6] = blackInfo.userMacAddress;
                        rows.Add(row);
                    }
                    querySuccess = true;
                }


            }
            else
            {
                querySuccess = false;
                MessageBox.Show("��ѯ�������б�ʧ�ܣ�ʧ��ԭ��Ϊ��" + resultList.errorMsg);
            }
        }
    }
}