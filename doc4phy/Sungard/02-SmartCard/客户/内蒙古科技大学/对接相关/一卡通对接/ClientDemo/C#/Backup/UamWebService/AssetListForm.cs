using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using UamWebService.damAsset;
using System.Collections;

namespace UamWebService
{
    public partial class AssetListForm : Form
    {
        damAssetService damService = MainForm.GetDamService();
        public AssetListForm(UamWebService.MainForm parent, AssetQueryInfo queryInfo)
        {
            InitializeComponent();
            this.MdiParent = parent;
            DataGridViewRowCollection rows = this.dataGridView.Rows;

            // ���ò�ѯ����
            if (queryInfo == null)
            {
                queryInfo = new AssetQueryInfo();
            }
            //AssetQueryInfo queryInfo = new AssetQueryInfo();
            //queryInfo.status = -1;
            //queryInfo.operSystemId = -1;

            // ���ò�ѯ�ӿ�
            RetAssetInfoList resultList = damService.queryAsset(queryInfo);
            if (resultList.errorCode == 0)
            {
                if (resultList.retAssetList != null)
                {
                    for (int i = 0; i < resultList.retAssetList.Length; i++)
                    {
                        if (resultList.retAssetList[i] == null)
                            continue;
                        String[] row = new String[this.dataGridView.ColumnCount];
                        row[0] = resultList.retAssetList[i].assetId.ToString();
                        row[1] = resultList.retAssetList[i].status.ToString();
                        row[2] = resultList.retAssetList[i].assetNumber;
                        row[3] = resultList.retAssetList[i].assetName;
                        row[4] = resultList.retAssetList[i].groupId.ToString();
                        row[5] = resultList.retAssetList[i].type;
                        row[6] = resultList.retAssetList[i].responser;
                        row[7] = resultList.retAssetList[i].joinDate.ToString();
                        rows.Add(row);
                    }
                }
                
            }
            else
            {
                MessageBox.Show("��ѯ�ʲ��б�ʧ�ܣ�ʧ��ԭ��Ϊ��" + resultList.errorMsg);
            }
        }

        //ɾ���ʲ�
        private void buttonDelete_Click(object sender, EventArgs e)
        {
            int successNumber = 0, failNumber = 0;
          DataGridViewSelectedRowCollection rows = this.dataGridView.SelectedRows;
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
              long assetID = long.Parse(currentRow.Cells[0].Value.ToString());
              WSCommonResult result = damService.deleteAsset(assetID, true);
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
              MessageBox.Show("ɾ���ʲ��ɹ�����ɾ��" + successNumber + "���ʲ�");
          }
          else
          {
              MessageBox.Show("�ɹ�ɾ��" + successNumber + "���ʲ���" + failNumber + "���ʲ�ɾ��ʧ�ܡ�");
          }
          this.updateList();

        }

        // �����ʲ�
        private void buttonAdd_Click(object sender, EventArgs e)
        {
            Form addAssetForm = new AssetAddForm();
            addAssetForm.ShowDialog();
            if (addAssetForm.DialogResult == DialogResult.OK)
            {
                // Display a message box indicating that the OK button was clicked.
                //MessageBox.Show("The OK button on the form was clicked.");
                // Optional: Call the Dispose method when you are finished with the dialog box.
                if (AssetAddForm.result.errorCode == 0)
                {
                    MessageBox.Show("�����ʲ��ɹ�");
                    this.updateList();
                }
                else
                {
                    MessageBox.Show("�����ʲ�ʧ�ܣ�ʧ��ԭ��Ϊ��" + AssetAddForm.result.errorMsg);
                }
                //addAssetForm.Dispose();
            }

        }

        public void updateList()
        {
            DataGridViewRowCollection rows = this.dataGridView.Rows;
            rows.Clear();
            AssetQueryInfo queryInfo = new AssetQueryInfo();

            // ���ò�ѯ�ӿ�
            RetAssetInfoList resultList = damService.queryAsset(queryInfo);
            if (resultList.errorCode == 0)
            {
                if (resultList.retAssetList != null)
                {
                    for (int i = 0; i < resultList.retAssetList.Length; i++)
                    {
                        if (resultList.retAssetList[i] == null)
                            continue;
                        String[] row = new String[this.dataGridView.ColumnCount];
                        row[0] = resultList.retAssetList[i].assetId.ToString();
                        row[1] = resultList.retAssetList[i].status.ToString();
                        row[2] = resultList.retAssetList[i].assetNumber;
                        row[3] = resultList.retAssetList[i].assetName;
                        row[4] = resultList.retAssetList[i].groupId.ToString();
                        row[5] = resultList.retAssetList[i].type;
                        row[6] = resultList.retAssetList[i].responser;
                        row[7] = resultList.retAssetList[i].joinDate.ToString();
                        rows.Add(row);
                    }
                }

            }
        }

        // �޸��ʲ�
        private void dataGridView_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            try
            {
                if (e.RowIndex != -1)
                {
                    long assetId = long.Parse(this.dataGridView.CurrentRow.Cells[0].Value.ToString());
                    if (e.ColumnIndex == 8)
                    {
                        Form assetModifyForm = new AssetModifyForm(assetId);
                        assetModifyForm.ShowDialog();
                        this.updateList();

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