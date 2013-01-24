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
    public partial class UserListForm : Form
    {
        public static Boolean querySuccess = true;
        acmUserService accessUserService = MainForm.GetAccessUserService();
        public UserListForm(UamWebService.MainForm parent, AcmUserListQueryParam queryParam)
        {
            InitializeComponent();
            this.MdiParent = parent;

            DataGridViewRowCollection rows = this.dataGridView1.Rows;
            this.dataGridViewImageColumn5.Visible = false;

            // ���ò�ѯ����
            if (queryParam == null)
            {
                queryParam = new AcmUserListQueryParam();
            }

            // ���ò�ѯ�ӿ�
            RetAcmUserList resultList = accessUserService.queryAcmUserList(queryParam);
            if (resultList.errorCode == 0)
            {
                if (resultList.userSimpleInfoArray != null)
                {
                    foreach (AcmUserSimpleInfo userInfo in resultList.userSimpleInfoArray)
                    {
                        String[] row = new String[this.dataGridView1.ColumnCount];
                        row[0] = userInfo.accountId.Value.ToString();
                        row[1] = userInfo.accountName;
                        row[2] = userInfo.fullName;
                        row[3] = userInfo.userGroupId.Value.ToString();
                        if (userInfo.invalidTime != null)
                        {
                            row[4] = userInfo.invalidTime.Value.ToLocalTime().ToString();
                        }

                        //row[4] = userInfo.invalidTime.Value == null ? "" : userInfo.invalidTime.Value.ToString();
                        rows.Add(row);
                    }
                }
                querySuccess = true;
                   
            }
            else
            {
                querySuccess = false;
                MessageBox.Show("��ѯ�����û��б�ʧ�ܣ�ʧ��ԭ��Ϊ��" + resultList.errorMsg);
            }


        }

        // ���ӽ����û�
        private void buttonAdd_Click(object sender, EventArgs e)
        {
            Form addAcmUserForm = new AddAcmUserForm();
            addAcmUserForm.ShowDialog();
            this.updateList();
        }


        // ע�������û�
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
                String userName = currentRow.Cells[1].Value.ToString();
                WSCommonResult result = accessUserService.cancelAcmUser(userName);
                if (result.errorCode == 0)
                {
                    successNumber++;
                }
                else
                {
                    failNumber++;
                }
            }
            if (failNumber == 0)
            {
                MessageBox.Show("ע�������û��ɹ�����ע��" + successNumber + "����¼");
            }
            else
            {
                MessageBox.Show("�ɹ�ע��" + successNumber + "����¼��" + failNumber + "����¼ע��ʧ��");
            }
            this.updateList();

        }

        // ���û������������
        private void buttonAddBlacklist_Click(object sender, EventArgs e)
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
                String userName = currentRow.Cells[1].Value.ToString();
                WSCommonResult result = accessUserService.addBlackList(userName);
                if (result.errorCode == 0)
                {
                    successNumber++;
                }
                else
                {
                    failNumber++;
                }
            }
            MessageBox.Show(successNumber + "���ʺű��ɹ������������" + failNumber + "���ʺ�δ�������������");

        }

       
        // ���û��󶨵�LDAPͬ������
        private void buttonBindUser_Click(object sender, EventArgs e)
        {
            long[] userId = null;
            DataGridViewSelectedRowCollection rows = this.dataGridView1.SelectedRows;
            userId = new long[rows.Count];
            IEnumerator iter = rows.GetEnumerator();
            if (!iter.MoveNext())
            {
                MessageBox.Show("������ѡ��һ����¼��");
                return;
            }
            iter.Reset();
            int i = 0;
            while (iter.MoveNext())
            {
                DataGridViewRow currentRow = (DataGridViewRow)iter.Current;
                userId[i] = long.Parse(currentRow.Cells[0].Value.ToString());
                i++;
                
            }
            Form selectLdapPolicyForm = new SelectLdapPolicyForm(userId);
            selectLdapPolicyForm.ShowDialog();

        }

        // ˢ��ҳ��
        public void updateList()
        {
            DataGridViewRowCollection rows = this.dataGridView1.Rows;
            rows.Clear();

            // ���ò�ѯ����
            AcmUserListQueryParam queryParam = new AcmUserListQueryParam();
            queryParam.userGroupId = MainForm.VALUE_UNLIMITE;
            queryParam.userGroupIdSpecified = true;
            queryParam.serviceID = MainForm.VALUE_UNLIMITE;
            queryParam.serviceIDSpecified = true;
            queryParam.port = MainForm.VALUE_NULL;
            queryParam.portSpecified = true;
            queryParam.maxConcurrentLimit = MainForm.VALUE_NULL;
            queryParam.maxConcurrentLimitSpecified = true;
            queryParam.maxIdleTime = MainForm.VALUE_NULL;
            queryParam.maxIdleTimeSpecified = true;
            queryParam.innerVlanId = MainForm.VALUE_NULL;
            queryParam.innerVlanIdSpecified = true;
            queryParam.outerVlanId = MainForm.VALUE_NULL;
            queryParam.outerVlanIdSpecified = true;

            // ���ò�ѯ�ӿ�
            RetAcmUserList resultList = accessUserService.queryAcmUserList(queryParam);
            if (resultList.errorCode == 0)
            {
                if (null != resultList.userSimpleInfoArray)
                {
                    foreach (AcmUserSimpleInfo userInfo in resultList.userSimpleInfoArray)
                    {
                        String[] row = new String[this.dataGridView1.ColumnCount];
                        row[0] = userInfo.accountId.Value.ToString();
                        row[1] = userInfo.accountName;
                        row[2] = userInfo.fullName;
                        row[3] = userInfo.userGroupId.Value.ToString();
                        if (userInfo.invalidTime != null)
                        {
                            row[4] = userInfo.invalidTime.Value.ToLocalTime().ToString();
                        }

                        //row[4] = userInfo.invalidTime.Value == null ? "" : userInfo.invalidTime.Value.ToString();
                        rows.Add(row);
                    }
                }
                
                querySuccess = true;

            }
            else
            {
                querySuccess = false;
                MessageBox.Show("��ѯ�����û��б�ʧ�ܣ�ʧ��ԭ��Ϊ��" + resultList.errorMsg);
            }
        }

        // �޸��û����޸����롢�������ע��������ϸ��Ϣ
        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            try
            {
                if (e.RowIndex != -1)
                {
                    String userName = this.dataGridView1.CurrentRow.Cells[1].Value.ToString();
                    switch (e.ColumnIndex)
                    {
                        // �޸��û���Ϣ
                        case 5:
                            Form modifyUserForm = new ModifyUserForm(userName);
                            modifyUserForm.ShowDialog();
                            break;
                        // �޸�����
                        case 6:
                            Form modifyPwdForm = new ModifyPwdForm(userName);
                            modifyPwdForm.ShowDialog();
                            break;
                        // �������
                        case 7:
                            Form applyServiceForm = new ApplyServiceForm(userName);
                            applyServiceForm.ShowDialog();
                            break;
                        // ע������
                        case 8:
                            Form cancelServiceForm = new CancelServiceForm(userName);
                            cancelServiceForm.ShowDialog();
                            break;
                       
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }
       
    }
}