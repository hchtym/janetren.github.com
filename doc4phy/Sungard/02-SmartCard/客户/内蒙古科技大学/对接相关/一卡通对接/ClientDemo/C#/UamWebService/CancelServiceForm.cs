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
    public partial class CancelServiceForm : Form
    {
        acmUserService accessUserService = MainForm.GetAccessUserService();
        String userName = null;
        public CancelServiceForm(String name)
        {
            InitializeComponent();
            userName = name;
            this.buttonCancel.DialogResult = DialogResult.Cancel;

            RetAcmUserService resultList = accessUserService.queryAcmUserServiceInfo(name);
            if (resultList.errorCode == 0)
            {
                if (resultList.acmUserService != null && resultList.acmUserService.Length!=0)
                {
                    foreach (AcmUserAppliedService service in resultList.acmUserService)
                    {
                        if (service != null)
                        {
                            this.checkedListBox1.Items.Add(new CombItem(service.serviceName, service.serviceTemplateId.Value));
                        }           
                    }
                }
            }
            else
            {
                MessageBox.Show("查询用户服务信息失败，失败原因为：" + resultList.errorMsg);
            }
        }

        private void buttonOK_Click(object sender, EventArgs e)
        {
            if (this.checkedListBox1.CheckedItems.Count == 0)
            {
                MessageBox.Show("请至少选择一个服务。");
                return;
            }
            long[] id = new long[this.checkedListBox1.CheckedItems.Count];
            CancelServiceParam param = new CancelServiceParam();
            int i=0;
            IEnumerator iter = this.checkedListBox1.CheckedItems.GetEnumerator();
            while (iter.MoveNext())
            {
                id[i] = ((CombItem)iter.Current).itemValue;
                i++;
            }
            param.serviceList = new long?[id.Length];
            for (int j = 0; j < id.Length; j++)
           {
                param.serviceList[j] = id[j];
            }
            param.accountName =userName;
            WSCommonResult result = accessUserService.cancelService(param);
            if (result.errorCode == 0)
            {
                MessageBox.Show("用户注销服务成功。");
            }
            else
            {
                MessageBox.Show("用户注销服务失败，失败原因为：" + result.errorMsg);
            }
            this.Dispose(true);
        }
    }
}