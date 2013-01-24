/********************************************************************
	created:	2006/12/30
	author:		CHENYH
	
	purpose:	 ���ڲ��� KBDC �ӿڿ��������
*********************************************************************/

#include "stdafx.h"
//#include "KBDClt.h"
#include "kbclt.h"

void Test567890(KBDCHandle ch)
{
	char eMsg[1024]; // ע�⾡����������Ϊ >=1024�ֽ�
	char fvalue[1024]; // ע������������Ϊ >=1024�ֽ�
	int rtn;
	printf("set request to 567890\n");

	//���������ļ�KSSICLT.lkc req�������ù��ܺ�
	rtn = KBDCBeginRequest(ch,567890,eMsg);					//��������ĺ�̨���ܺ� 567890
	if (rtn<0)
	{
		printf("KBDCBeginRequest Error %d:%s",rtn,eMsg);
		return;
	}
	printf("Set request fields\n");
	KBDCSetFieldValue(ch,"sholder_ac_no","wang");		   // ������������������ֵ
	KBDCSetFieldValue(ch,"scust_no","yan");

	if (KBDCCallSvr(ch,5000,eMsg)<0)					   // �����̨��Ӧ
	{
		printf("KBDCCallSvr Error:%s\n",eMsg);
		return;
	}
	printf("Return Code:%d at Time:%u\n",KBDCGetRetCode(ch),GetTickCount());
	
	if (KBDCGetRetCode(ch)==0)							   // ��ȡ��̨�ķ���ֵ���ɹ�
	{
		KBDCGetFieldValue(ch,"lvol0",fvalue,eMsg);			// ��ȡ��̨����Ӧ����
		printf("Return 'lvol0' of Record %d='%s'\n",fvalue);

		KBDCGetFieldValue(ch,"lvol1",fvalue,eMsg);
		printf("Return 'lvol1' of Record %d='%s'\n",fvalue);
	}
	else												 // ��̨����ʧ��
	{
		KBDCGetFieldValue(ch,"vsmess",fvalue,eMsg);		 // ��ȡ��̨���صĴ�����Ϣ
		printf("Return error from background'%s'\n",fvalue);
	}
	
}

int main()
{
   char eMsg[1024];  // ע�⾡����������Ϊ >=1024�ֽ�
   ///////////////////////////////// Begin1 //////////////////////////////////////
   // ��������������������߳��ڣ�������������֮ǰ���ã����ұ���Ϊ�ɹ�����
#ifdef _DEBUG
   if (KBDCInit(1,"",eMsg)<0)						// ��ʼ��
#else
   if (KBDCInit(0,"",eMsg)<0)
#endif
   {
      printf("KBDCInit Error:%s\n",eMsg);
      return(-1);
   }
  
   KBDCHandle ch;
   ch = KBDCNewHandle(eMsg);						// ������
   if (ch==NULL)
   {
      printf("KBDCNewHandle Error:%s\n",eMsg);
   }
   else
   {
	  Test567890(ch);
      KBDCDeleteHandle(ch);						  // ɾ�����
   }
 
   KBDCExit();									  // �˳�
   return(0);
}