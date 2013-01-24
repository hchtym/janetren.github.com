/********************************************************************
	created:	2006/12/30
	author:		CHENYH
	
	purpose:	 用于测试 KBDC 接口库的主程序
*********************************************************************/

#include "stdafx.h"
//#include "KBDClt.h"
#include "kbclt.h"

void Test567890(KBDCHandle ch)
{
	char eMsg[1024]; // 注意尽量给出缓存为 >=1024字节
	char fvalue[1024]; // 注意必须给出缓存为 >=1024字节
	int rtn;
	printf("set request to 567890\n");

	//需在配置文件KSSICLT.lkc req项中配置功能号
	rtn = KBDCBeginRequest(ch,567890,eMsg);					//设置请求的后台功能号 567890
	if (rtn<0)
	{
		printf("KBDCBeginRequest Error %d:%s",rtn,eMsg);
		return;
	}
	printf("Set request fields\n");
	KBDCSetFieldValue(ch,"sholder_ac_no","wang");		   // 设置请求包的数据域的值
	KBDCSetFieldValue(ch,"scust_no","yan");

	if (KBDCCallSvr(ch,5000,eMsg)<0)					   // 请求后台响应
	{
		printf("KBDCCallSvr Error:%s\n",eMsg);
		return;
	}
	printf("Return Code:%d at Time:%u\n",KBDCGetRetCode(ch),GetTickCount());
	
	if (KBDCGetRetCode(ch)==0)							   // 获取后台的返回值，成功
	{
		KBDCGetFieldValue(ch,"lvol0",fvalue,eMsg);			// 获取后台的响应数据
		printf("Return 'lvol0' of Record %d='%s'\n",fvalue);

		KBDCGetFieldValue(ch,"lvol1",fvalue,eMsg);
		printf("Return 'lvol1' of Record %d='%s'\n",fvalue);
	}
	else												 // 后台返回失败
	{
		KBDCGetFieldValue(ch,"vsmess",fvalue,eMsg);		 // 获取后台返回的错误信息
		printf("Return error from background'%s'\n",fvalue);
	}
	
}

int main()
{
   char eMsg[1024];  // 注意尽量给出缓存为 >=1024字节
   ///////////////////////////////// Begin1 //////////////////////////////////////
   // 以下这个函数必须在主线程内，启用其他函数之前调用，并且必须为成功才行
#ifdef _DEBUG
   if (KBDCInit(1,"",eMsg)<0)						// 初始化
#else
   if (KBDCInit(0,"",eMsg)<0)
#endif
   {
      printf("KBDCInit Error:%s\n",eMsg);
      return(-1);
   }
  
   KBDCHandle ch;
   ch = KBDCNewHandle(eMsg);						// 申请句柄
   if (ch==NULL)
   {
      printf("KBDCNewHandle Error:%s\n",eMsg);
   }
   else
   {
	  Test567890(ch);
      KBDCDeleteHandle(ch);						  // 删除句柄
   }
 
   KBDCExit();									  // 退出
   return(0);
}