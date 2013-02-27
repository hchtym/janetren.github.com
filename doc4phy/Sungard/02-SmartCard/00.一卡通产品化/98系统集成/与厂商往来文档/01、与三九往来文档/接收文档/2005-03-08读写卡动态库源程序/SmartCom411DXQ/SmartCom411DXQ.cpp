#include "stdafx.h"
#include "stdlib.h"
#include "Comm.h"

//��Ȩ��־
int nAutoFlag = 0;
unsigned char UCWORKINGKEY[256];

//*************��ȡ������뺯��*********************
int __stdcall GetMFLastErr()
{
	return ErrorCode;
}

//*******************************************
int Init_SetParam(char *ComStr,int MachineNo,int BaudRate)
{
    Dll_bps=BaudRate;                                    //������
    Dll_MacNo =MachineNo;                                 //����
	ErrorCode = 0;

// ��ʼ������
	if(CommIntilialize(ComStr,Dll_bps) != 0)
		return(-1);
	
	return 0;
}

//***********************************************
int CloseComHandle()
{
	if(hCommDev)
	{
		CloseHandle(hCommDev);
	}
	return 0;
}
//**public command*****************************************
int ReadTermID(unsigned char *IDBuf,BOOL bLinked,char *ComStr,int BaudRate)
{
	int retCode,Len;

	Dll_MacNo = 0xff;
	Dll_CommByte = 0xe1;

	if(!bLinked)
	{
		if(Init_SetParam(ComStr,Dll_MacNo,BaudRate) < 0)
			return(-1);
	}

	Dll_MacNo = 0xff;
	Dll_CommByte = 0xe1;
	retCode = ExeCommand(IDBuf,0);
	if(retCode<0)
	{
		if(!bLinked)
			CloseComHandle();
		return retCode;
	}

	if(!bLinked)
		CloseComHandle();
	Len = Dll_RetData[3];
	memcpy(IDBuf,Dll_RetData+4,Len);
	Dll_MacNo = Dll_RetData[Len+3];
	return Dll_MacNo;
}
//**public command*****************************************
int QueryTermID(unsigned char LowIDNo,unsigned char *Buffer,BOOL bLinked,char *ComStr,int BaudRate)
{
	int retCode,Len;

	Dll_MacNo = 0xff;
	Dll_CommByte = 0xe2;

	if(!bLinked)
	{
		if(Init_SetParam(ComStr,Dll_MacNo,BaudRate) < 0)
			return(-1);
	}

	Dll_MacNo = 0xff;
	Dll_CommByte = 0xe2;
	Buffer[0] = LowIDNo;
	retCode = ExeCommand(Buffer,1);
	if(retCode<0)
	{
		if(!bLinked)
			CloseComHandle();
		return retCode;
	}

	if(!bLinked)
		CloseComHandle();
	Len = Dll_RetData[3];

	memcpy(Buffer,Dll_RetData+4,Len);

	Dll_MacNo = Dll_RetData[8];
	return Dll_MacNo;
}
//**public command*****************************************
int SetTermMacNo(unsigned char *IDBuf,int MacNo,BOOL bLinked,char *ComStr,int BaudRate)
{
	int retCode,Len;
	BYTE Buffer[8];

	Dll_MacNo = 0xff;
	Dll_CommByte = 0xe3;

	if((MacNo>255)||(MacNo<1))
	{
		ErrorCode = 31;
		return (-1);
	}
	if(!bLinked)
	{
		if(Init_SetParam(ComStr,Dll_MacNo,BaudRate) < 0)
			return(-1);
	}

	Dll_MacNo = 0xff;
	Dll_CommByte = 0xe3;

	Len = 4;
	memcpy(Buffer,IDBuf,4);
	Buffer[4] = MacNo;

	retCode = ExeCommand(Buffer,5);
	if(retCode<0)
	{
		if(!bLinked)
			CloseComHandle();
		return retCode;
	}

	if(!bLinked)
		CloseComHandle();
	Dll_MacNo = MacNo;
	return Dll_MacNo;
}
//**public command*****************************************
int ReadTermMacType(unsigned char *Buffer,BOOL bLinked,char *ComStr,int BaudRate)
{
	int retCode,Len;

	Dll_CommByte = 0xe4;

	if(!bLinked)
	{
	// ��ʼ������
		Dll_MacNo = 0xff;
		if(Init_SetParam(ComStr,Dll_MacNo,BaudRate) < 0)
			return(-1);
	}

	Dll_CommByte = 0xe4;
	retCode = ExeCommand(Buffer,0);
	if(retCode<0)
	{
		if(!bLinked)
			CloseComHandle();
		return retCode;
	}

	if(!bLinked)
		CloseComHandle();
	Len = Dll_RetData[3];

	memcpy(Buffer,Dll_RetData+4,Len);

	return Len;
}
//**public command*****************************************
int ReadTermDate(unsigned char *Buffer,BOOL bLinked,char *ComStr,int BaudRate)
{
	int retCode,Len;

	if(!bLinked)
	{
	// ��ʼ������
		Dll_MacNo = 0xff;
		if(Init_SetParam(ComStr,Dll_MacNo,BaudRate) < 0)
			return(-1);
	}

	Dll_CommByte = 0xe5;
	retCode = ExeCommand(Buffer,0);
	if(retCode<0)
	{
		if(!bLinked)
			CloseComHandle();
		return retCode;
	}

	if(!bLinked)
		CloseComHandle();
	Len = Dll_RetData[3];
	memcpy(Buffer,Dll_RetData+4,Len);
	return Len;
}

//��д������
int _stdcall SMT_ConnectMF280(int nPortNo, int nBaudRate)
{
	char tmp[20];
	unsigned char IDBuf[16];
	int ret;
	int macno=1;
	sprintf(tmp,"\\\\?\\COM%d",nPortNo);
	if(ReadTermMacType(IDBuf,false,tmp,nBaudRate)<0)
	{
		return -1;
	}
	if(IDBuf[0]!=4||IDBuf[1]!=20)
	{
		return -1;
	}
	Sleep(10);
	memset(IDBuf,0,16);
	ret = ReadTermID(IDBuf,false,tmp,nBaudRate);
	if(ret<0)
		return -1;
	macno=ret;
	if(Init_SetParam(tmp,macno,nBaudRate)<0)
	{
		return -1;
	}
	nAutoFlag=0;
	return 0;
}

//2���ض϶�д��
int _stdcall SMT_CloseMF280()
{
	int ret;
	ret = CloseComHandle();
	return ret;
}

//3����д������������
int _stdcall SMT_ControlBuzzer()
{
	int retCode;
	BYTE Buffer[1];

	Dll_CommByte = 59;

	Buffer[0]=NULL;
	retCode = ExeCommand(Buffer,0);
	if(retCode<0)
		return retCode;
	return 0;
}

//*******************************************
int MF_ReadSeriesNo(unsigned char *Buffer)
{
	int retCode,Len;

	Dll_CommByte = 1;
	Len = 0;
	retCode = ExeCommand(Buffer,Len);
	if(retCode<0)
		return retCode;

	Len = Dll_RetData[3];
	memcpy(Buffer,Dll_RetData+4,Len);
//	Buffer[Len] = NULL;
	return Len;
}


//1������û����Ƿ��ڸ�Ӧ��
int _stdcall SMT_RequestCardExist(unsigned char ucSerialNo[4],unsigned char ucType[1])
{
	unsigned char Buf[5];
	int ret;
	ret = MF_ReadSeriesNo(Buf);
	if(ret > 0)
	{
		memcpy(ucSerialNo,Buf,4);
		memcpy(ucType,Buf+4,1);
		return 0;
	}
	return -1;
}

//2����½��Ƭ 
int _stdcall SMT_Login_With_UserKey(int Sector,unsigned char *Buffer,int PaDSelect)
// Sector ������
// PaDSelect == 0 KEYA ��½
// PaDSelect == 1 KEYB ��½
// Buffer -----KEYA��KEYB

{
	int retCode,Len;
	
	unsigned char Buffer_temp[20];
	memset(Buffer_temp,0,20);

	Dll_CommByte = 16;  
	
	Buffer_temp[0] = Sector;
	if(PaDSelect == 0)
	{
		Buffer_temp[1] = 0x02;//AKEY��¼
		memcpy(Buffer_temp+2,Buffer,6);
	}
	else
	{
		Buffer_temp[1] = 0x42;//BKEY��¼
		memcpy(Buffer_temp+2+6,Buffer,6);
	}
	Len = 14;
	retCode = ExeCommand(Buffer_temp,Len);
	return retCode;
}

//3������Ƭ
int _stdcall SMT_ReadBlock(int Sector,int BlockNo, unsigned char *BlockBuf)
{
	int retCode,i,Len;
	BlockBuf[0] = Sector;
	BlockBuf[1] = BlockNo;
	Len = 2;
	Dll_CommByte = 0x2C;  
	retCode = ExeCommand(BlockBuf,Len);
	if(retCode<0)
		return retCode;

	Len = Dll_RetData[3];
	for(i = 0;i<Len;i++)
		BlockBuf[i] = Dll_RetData[i+4];
	return retCode;
}

//4��д��Ƭ
int _stdcall SMT_WriteBlock(int Sector,int BlockNo,unsigned char *BlockBuf)
{
	unsigned char Buf[20];
	int retCode,i,Len;

	
	Dll_CommByte = 0x2D; 
	Len = 16;
	memset(Buf,0,20);
	Buf[0] = Sector;
	Buf[1] = BlockNo;

	for(i = 0;i < Len;i++)
		Buf[2+i] = BlockBuf[i];

	retCode = ExeCommand(Buf,Len+2);
	if(retCode<0)
		return retCode;

	Len = Dll_RetData[3];
	
	for(i = 0;i<Len;i++)
		BlockBuf[i] = Dll_RetData[i+4];
	return retCode;

}

//5����Ǯ
int _stdcall SMT_Philips_Packet_Proc(int flag,int Sector,int BlockNo,int Money,unsigned char *BlockBuf)
//flag���Ӽ�Ǯ��־ 0---�� 1---��
{
	unsigned char Buf[20];
	int retCode,Len;

	if(flag == 0)
		Dll_CommByte = 0x2e; 
	else
		Dll_CommByte = 0x2f;
	Len = 6;
	memset(Buf,0,20);
	Buf[0] = Sector;
	Buf[1] = BlockNo;
	Buf[2] = Money%256;
	Buf[3] = Money/256;
	Buf[4] = Money/256/256;
	Buf[5] = Money/256/256/256;
	
	retCode = ExeCommand(Buf,Len);
	if(retCode<0)
		return retCode;

	Len = Dll_RetData[3];
	for(int i = 0;i<Len;i++)
		BlockBuf[i] = Dll_RetData[i+4];
	return retCode;
}

//6 ���ݿ�COPY
int _stdcall SMT_Copy_DataBlock(int Sector,int souBlock,int desBlock,unsigned char *BlockBuf)
{
	unsigned char Buf[20];
	int i,retCode,Len;

	Dll_CommByte = 0x30; 
	Len = 3;
	memset(Buf,0,20);
	Buf[0] = Sector;
	Buf[1] = souBlock;
	Buf[2] = desBlock;
	
	retCode = ExeCommand(Buf,Len);
	if(retCode<0)
		return retCode;

	Len = Dll_RetData[3];
	for(i = 0;i<Len;i++)
		BlockBuf[i] = Dll_RetData[i+4];
	return retCode;
}

//7 ���߿�Ƭ
int _stdcall SMT_SleepCard()
{
	unsigned char Buf[20];
	int retCode,Len;

	Dll_CommByte = 0x08; 
	Len = 0;
	memset(Buf,0,20);
	
	retCode = ExeCommand(Buf,Len);
	return retCode;
}


//��鶯̬���Ƿ���Ȩ
int _stdcall SMT_JudgeAutoFlag()
//����ֵ��     0��δ��Ȩ     1����Ȩ
{
	return nAutoFlag;
}

//2����̬����Ȩ
int _stdcall SMT_AutoDll(unsigned char *ucWorkingKey)
{
	int i;
	memcpy(UCWORKINGKEY,ucWorkingKey,8);
	for(i=0;i<8;i++)
		UCWORKINGKEY[i+8] = ~ucWorkingKey[i];
	nAutoFlag = 1;
	return 0;
}

//3����Ƭ����
int _stdcall SMT_CreateGreyCard(BOOL bPersonalFlag,BOOL bStateFlag, BOOL bBankInfo,BOOL bPacketFlag[8])
{
	unsigned char ucSerialNo[5];
	unsigned char ucKeyA[6],ucKeyB[6];
	unsigned char ucRawData[256],ucDesData[256];
	
	int i,j,startSector=4;
	int ret;
	ret = MF_ReadSeriesNo(ucSerialNo);
	if(ret != 0)
		return -1;//��Ƭ���ڸ�Ӧ��
	//1��ʹ�ó��������½��Ƭ  ǰ32������
	memset(ucKeyA,0xFF,6);
	memset(ucKeyB,0xFF,6);
	memset(ucRawData,0x00,16);
	for(i=0;i<15;i++)
		ucRawData[15] += ucRawData[i];
	for(i=0;i<32;i++)
	{
		ret = SMT_Login_With_UserKey(i,ucKeyA,0);
		if(ret != 0)
			return -2; //�ǳ�����
		ret = SMT_Login_With_UserKey(i,ucKeyB,1);
		if(ret != 0)
			return -2; //�ǳ�����
		for(j=0;j<3;j++)
			SMT_WriteBlock(i,j,ucRawData);
	}
	
	//2������KEYA��KEYB����Ǯ������
	
	//1 --- ����KEYA
	memcpy(ucRawData,ucSerialNo,4);
	for(i=0;i<4;i++)
		ucRawData[i+4] = ~ucRawData[i];
	des_code(UCWORKINGKEY,ucRawData,ucDesData,'0');
	Cal_Key(ucDesData,ucKeyA);
	//����KEYB
	TriDes(UCWORKINGKEY,ucRawData,ucDesData,'0');
	Cal_Key(ucDesData,ucKeyB);
	memcpy(ucRawData,ucKeyA,6);
	ucRawData[6] = 0x7F;
	ucRawData[7] = 0x07;
	ucRawData[8] = 0x88;
	ucRawData[9] = 0x00;
	memcpy(ucRawData+10,ucKeyB,6);
	memset(ucDesData,0xFF,6);
	for(i=0;i<32;i++)
	{
		ret = SMT_Login_With_UserKey(i,ucDesData,1);
		if(ret != 0)
			return -2; //�ǳ�����
		ret = SMT_WriteBlock(i,3,ucRawData);
		if(ret != 0)
			return -3; //��Ƭ����ʧ��
	}
	//����Ǯ���� ��0��
	j = 0;
	for(i=0;i<8;i++)
	{
		if(bPacketFlag[i] == TRUE)
			ucRawData[j] = 0x00;
		else
			ucRawData[j] = 0xFF;
		j = j + 1;
		if(bPacketFlag[i] == TRUE)
		{
			ucRawData[j] = startSector;
			startSector+=1;
		}
		else
			ucRawData[j] = 0xFF;
		j=j+1;
	}
	//1 ʹ���û������½
	ret = SMT_Login_With_UserKey(3,ucKeyA,0);
	if(ret != 0)
		return -4;//ʹ���û�����KEYA���ܵ�½
	ret = SMT_WriteBlock(3,0,ucRawData);
	if(ret != 0)
		return -5;//�޷�д��
	memset(ucRawData,0xFF,16);
	for(i=0;i<8;i++)
	{
		if(bPacketFlag[i] == TRUE)
		{
			ucRawData[i] = startSector;
			startSector += 1;
		}
		else
			ucRawData[i] = 0xFF;
	}
	ret = SMT_WriteBlock(3,1,ucRawData);
	if(ret != 0)
		return -5;//�޷�д��
	memset(ucRawData,0xFF,16);  //20050305����
	ret = SMT_WriteBlock(3,2,ucRawData);
	if(ret != 0)
		return -5;//�޷�д��
	return 0;
}


//ʹ�ø�����Կ��ϵ��½��Ƭ
int Login_Card(int sector)
{
	unsigned char ucSerialNo[5],ucRawData[256],ucDesData[256],ucKeyA[6];
	int i,ret;
	ret = MF_ReadSeriesNo(ucSerialNo);
	if(ret != 0)
		return -1;//��Ƭ���ڸ�Ӧ��
	//1 --- ����KEYA
	memcpy(ucRawData,ucSerialNo,4);
	for(i=0;i<4;i++)
		ucRawData[i+4] = ~ucRawData[i];
	des_code(UCWORKINGKEY,ucRawData,ucDesData,'0');
	Cal_Key(ucDesData,ucKeyA);
	ret = SMT_Login_With_UserKey(sector,ucKeyA,0);
	if(ret != 0)
		return -2;//��Ƭ��½ʧ��
	return 0;
}


//д�뿨Ƭ״̬��Ϣ
int _stdcall SMT_WriteCardStateInfo(unsigned char ucShowCardNo[5],
									int nDealCardNo[1],
									unsigned char ucDeadLineDate[3],
									unsigned char ucCardRightType[1])
{
	unsigned char ucSerialNo[5],ucRawData[256],ucDesData[256],ucKeyA[6];
	int i,ret;
	ret = MF_ReadSeriesNo(ucSerialNo);
	if(ret != 0)
		return -1;//��Ƭ���ڸ�Ӧ��
	//1 --- ����KEYA
	memcpy(ucRawData,ucSerialNo,4);
	for(i=0;i<4;i++)
		ucRawData[i+4] = ~ucRawData[i];
	des_code(UCWORKINGKEY,ucRawData,ucDesData,'0');
	Cal_Key(ucDesData,ucKeyA);
	ret = SMT_Login_With_UserKey(1,ucKeyA,0);
	if(ret != 0)
		return -2;//��Ƭ��½ʧ��
	//��0��������֯
	if(nDealCardNo[0] > 0x0FFFFF)
		return -3;//���׿��Ź���
	memset(ucRawData,0xFF,16);
	ucRawData[0] = nDealCardNo[0]/256/256;
	ucRawData[1] = nDealCardNo[0]/256;
	ucRawData[2] = nDealCardNo[0]%256;
	ucRawData[3] = ucCardRightType[0];
	memcpy(ucRawData+4,ucDeadLineDate,3);
	memcpy(ucRawData+7,ucShowCardNo,5);
	ret = SMT_WriteBlock(1,0,ucRawData);
	if(ret != 0)
		return -5; //д��ʧ��
	return 0;
}

int _stdcall SMT_ReadCardStateInfo(unsigned char ucShowCardNo[5],
								   int nDealCardNo[1],
								   unsigned char ucDeadLineDate[3],
								   unsigned char ucCardRightType[1])
{
	int ret;
	unsigned char ucBuffer[16];
	ret = Login_Card(1);
	if(ret != 0)	return ret;
	ret = SMT_ReadBlock(1,0,ucBuffer);
	if(ret != 0)
		return -6; //����ʧ��
	nDealCardNo[0] = ucBuffer[0]*256*256+ucBuffer[1]*256+ucBuffer[2];
	ucCardRightType[0] = ucBuffer[3];
	memcpy(ucDeadLineDate,ucBuffer+4,3);
	memcpy(ucShowCardNo,ucBuffer+7,5);
	return 0;
}

//(3)�޸���ʾ����
int _stdcall SMT_ChangeShowCardNo(unsigned char ucShowCardNo[5])
{
	int ret;
	unsigned char ucBuffer[16];
	ret = Login_Card(1);
	if(ret != 0)	return ret;
	ret = SMT_ReadBlock(1,0,ucBuffer);
	if(ret != 0)
		return -6; //����ʧ��
	memcpy(ucBuffer+7,ucShowCardNo,5);
	ret = SMT_WriteBlock(1,0,ucBuffer);
	if(ret != 0)
		return -5; //д��ʧ��
	return 0;
}

//(4)�޸��ڲ����׿���
int _stdcall SMT_ChangeDealCardNo(int nDealCardNo[1])
{
	int ret;
	unsigned char ucBuffer[16];
	ret = Login_Card(1);
	if(ret != 0)	return ret;
	ret = SMT_ReadBlock(1,0,ucBuffer);
	if(ret != 0)
		return -6; //����ʧ��
	ucBuffer[0] = nDealCardNo[0]/256/256;
	ucBuffer[1] = nDealCardNo[0]/256;
	ucBuffer[2] = nDealCardNo[0]%256;
	ret = SMT_WriteBlock(1,0,ucBuffer);
	if(ret != 0)
		return -5; //д��ʧ��
	return 0;
}

//(5)�޸Ŀ�Ƭʹ�ý�������
int _stdcall SMT_ChangeDeadLineDate (unsigned char ucDeadLineDate[3])
{
	int ret;
	unsigned char ucBuffer[16];
	ret = Login_Card(1);
	if(ret != 0)	return ret;
	ret = SMT_ReadBlock(1,0,ucBuffer);
	if(ret != 0)
		return -6; //����ʧ��
	memcpy(ucBuffer+4,ucDeadLineDate,3);
	ret = SMT_WriteBlock(1,0,ucBuffer);
	if(ret != 0)
		return -5; //д��ʧ��
	return 0;
}

//(6)�޸Ŀ�ƬȨ������
int _stdcall SMT_ChangeCardRightType (unsigned char ucCardRightType[1])
{
	int ret;
	unsigned char ucBuffer[16];
	ret = Login_Card(1);
	if(ret != 0)	return ret;
	ret = SMT_ReadBlock(1,0,ucBuffer);
	if(ret != 0)
		return -6; //����ʧ��
	memcpy(ucBuffer+3,ucCardRightType,1);
	ret = SMT_WriteBlock(1,0,ucBuffer);
	if(ret != 0)
		return -5; //д��ʧ��
	return 0;
}

//2��������Ϣ��ز���
//(1)д�뿨Ƭ������Ϣ
int _stdcall SMT_WritePersonalInfo(unsigned char ucName[8],
								   unsigned char ucDutyNo[4],
								   unsigned char ucCertificateNo[20],
								   unsigned char ucDepartmentNo[10],
								   unsigned char ucIdentifyNo[4],
								   unsigned char ucSexNo[1],
								   unsigned char ucCardNo[20])
{
	int ret;
	unsigned char ucBuffer[16];
	//����ѧ�Ų���
	ret = Login_Card(0);
	if(ret != 0)	return ret;
	memcpy(ucBuffer,ucCardNo,16);
	ret = SMT_WriteBlock(0,1,ucBuffer);
	if(ret != 0)	return -5;
	memset(ucBuffer,0xFF,16);
	memcpy(ucBuffer,ucCardNo+16,4);
	ret = SMT_WriteBlock(0,2,ucBuffer);
	if(ret != 0)	return -5;
	
	//��2����0�����
	ret = Login_Card(2);
	if(ret != 0)	return ret;
	memcpy(ucBuffer,ucName,8);
	memcpy(ucBuffer+8,ucDutyNo,4);
	memcpy(ucBuffer+12,ucCertificateNo,4);
	ret = SMT_WriteBlock(2,0,ucBuffer);
	if(ret != 0)	return -5;
	memcpy(ucBuffer,ucCertificateNo+4,16);
	ret = SMT_WriteBlock(2,1,ucBuffer);
	if(ret != 0)	return -5;
	memcpy(ucBuffer,ucDepartmentNo,10);
	memcpy(ucBuffer+10,ucIdentifyNo,4);
	memcpy(ucBuffer+14,ucSexNo,1);
	ret = SMT_WriteBlock(2,2,ucBuffer);
	if(ret != 0)	return -5;
	return 0;
}


int _stdcall SMT_ReadPersonalInfo(unsigned char ucName[8],
								  unsigned char ucDutyNo[4],
								  unsigned char ucCertificateNo[20],
								  unsigned char ucDepartmentNo[10],
								  unsigned char ucIdentifyNo[4],
								  unsigned char ucSexNo[1],
								  unsigned char ucCardNo[20])
{
	int ret;
	unsigned char ucBuffer[16];
	//����ѧ�Ų���
	ret = Login_Card(0);
	if(ret != 0)	return ret;
	ret = SMT_ReadBlock(0,1,ucBuffer);
	if(ret != 0)	return -6;
	memcpy(ucCardNo,ucBuffer,16);
	ret = SMT_ReadBlock(0,2,ucBuffer);
	if(ret != 0)	return -6;
	memcpy(ucCardNo+16,ucBuffer,4);

	ret = Login_Card(2);
	if(ret != 0)	return ret;
	ret = SMT_ReadBlock(2,0,ucBuffer);
	if(ret != 0 )	return -6;
	memcpy(ucName,ucBuffer,8);
	memcpy(ucDutyNo,ucBuffer+8,4);
	memcpy(ucCertificateNo,ucBuffer+12,4);
	ret = SMT_ReadBlock(2,1,ucBuffer);
	if(ret != 0)	return -6;
	memcpy(ucCertificateNo+4,ucBuffer,16);
	ret = SMT_ReadBlock(2,2,ucBuffer);
	if(ret != 0)	return -6;
	memcpy(ucDepartmentNo,ucBuffer,10);
	memcpy(ucIdentifyNo,ucBuffer+10,4);
	memcpy(ucSexNo,ucBuffer+14,1);
	return 0;
}

//(3)�޸�����
int _stdcall SMT_ChangeName(unsigned char ucName[8])
{
	int ret;
	unsigned char ucBuffer[16];
	//����ѧ�Ų���
	ret = Login_Card(2);
	if(ret != 0)	return ret;
	ret = SMT_ReadBlock(2,0,ucBuffer);
	if(ret != 0)	return -6;
	memcpy(ucBuffer,ucName,8);
	ret = SMT_WriteBlock(2,0,ucBuffer);
	if(ret != 0)	return -5;
	return 0;
}

//(4)�޸�ְ�����
int _stdcall SMT_ChangeDutyNo(unsigned char ucDutyNo[4])
{
	int ret;
	unsigned char ucBuffer[16];
	//����ѧ�Ų���
	ret = Login_Card(2);
	if(ret != 0)	return ret;
	ret = SMT_ReadBlock(2,0,ucBuffer);
	if(ret != 0)	return -6;
	memcpy(ucBuffer+8,ucDutyNo,4);
	ret = SMT_WriteBlock(2,0,ucBuffer);
	if(ret != 0)	return -5;
	return 0;
}

//(5)�޸�֤������
int _stdcall SMT_ChangeCerificateNo (unsigned char ucCertificateNo[20])
{
	int ret;
	unsigned char ucBuffer[16];
	//����ѧ�Ų���
	ret = Login_Card(2);
	if(ret != 0)	return ret;
	ret = SMT_ReadBlock(2,0,ucBuffer);
	if(ret != 0)	return -6;
	memcpy(ucBuffer+12,ucCertificateNo,4);
	ret = SMT_WriteBlock(2,0,ucBuffer);
	if(ret != 0)	return -5;
	memcpy(ucBuffer,ucCertificateNo+4,16);
	ret = SMT_WriteBlock(2,1,ucBuffer);
	if(ret != 0)	return -5;
	return 0;

}

//(6)�޸Ĳ��ű��
int _stdcall SMT_ChangeDepartmentNo (unsigned char ucDepartmentNo[10])
{
	int ret;
	unsigned char ucBuffer[16];
	//����ѧ�Ų���
	ret = Login_Card(2);
	if(ret != 0)	return ret;
	ret = SMT_ReadBlock(2,2,ucBuffer);
	if(ret != 0)	return -6;
	memcpy(ucBuffer,ucDepartmentNo,10);
	ret = SMT_WriteBlock(2,2,ucBuffer);
	if(ret != 0)	return -5;
	return 0;
}

//(7)�޸���ݴ���
int _stdcall SMT_ChangeIdentifyNo (unsigned char ucIdentifyNo[4])
{
	int ret;
	unsigned char ucBuffer[16];
	//����ѧ�Ų���
	ret = Login_Card(2);
	if(ret != 0)	return ret;
	ret = SMT_ReadBlock(2,2,ucBuffer);
	if(ret != 0)	return -6;
	memcpy(ucBuffer+10,ucIdentifyNo,4);
	ret = SMT_WriteBlock(2,2,ucBuffer);
	if(ret != 0)	return -5;
	return 0;
}

//(8)�޸��Ա����
int _stdcall SMT_ChangeSexNo (unsigned char ucSexNo[1])
{
	int ret;
	unsigned char ucBuffer[16];
	//����ѧ�Ų���
	ret = Login_Card(2);
	if(ret != 0)	return ret;
	ret = SMT_ReadBlock(2,2,ucBuffer);
	if(ret != 0)	return -6;
	memcpy(ucBuffer+14,ucSexNo,1);
	ret = SMT_WriteBlock(2,2,ucBuffer);
	if(ret != 0)	return -5;
	return 0;
}

//(9)�޸Ŀ���
int _stdcall SMT_ChangeCardNo (unsigned char ucCardNo[20])
{
	int ret;
	unsigned char ucBuffer[16];
	//����ѧ�Ų���
	ret = Login_Card(0);
	if(ret != 0)	return ret;
	memcpy(ucBuffer,ucCardNo,16);
	ret = SMT_WriteBlock(0,1,ucBuffer);
	if(ret != 0)	return -6;
	memset(ucCardNo,0xFF,16);
	memcpy(ucBuffer,ucCardNo,16);
	ret = SMT_WriteBlock(0,2,ucBuffer);
	if(ret != 0)	return -5;
	return 0;
}

//(1)д��������
int _stdcall SMT_WritePersonalPassword(unsigned char PersonalPsd[3])
{
	int ret;
	unsigned char ucBuffer[16];
	
	ret = Login_Card(1);
	if(ret != 0)	return ret;
	memset(ucBuffer,0xFF,16);
	memcpy(ucBuffer,PersonalPsd,3);
	ret = SMT_WriteBlock(1,1,ucBuffer);
	if(ret != 0)	return -6;
	return 0;
}

//(2)����������
int _stdcall SMT_ReadPersonalPassword(unsigned char PersonalPsd[3])
{
	int ret;
	unsigned char ucBuffer[16];
	
	ret = Login_Card(1);
	if(ret != 0)	return ret;
	memset(ucBuffer,0xFF,16);
	ret = SMT_ReadBlock(1,1,ucBuffer);
	if(ret != 0)	return -5;
	memcpy(PersonalPsd,ucBuffer,3);
	return 0;
}

//(1)д���п���
int _stdcall SMT_WriteBankCardNo(unsigned char ucBankCardNo[10])
{
	int ret;
	unsigned char ucBuffer[16];
	
	ret = Login_Card(1);
	if(ret != 0)	return ret;
	memset(ucBuffer,0xFF,16);
	memcpy(ucBuffer,ucBankCardNo,10);
	ret = SMT_WriteBlock(1,2,ucBuffer);
	if(ret != 0)	return -5;
	return 0;
}

//(2)�����п���
int _stdcall SMT_ReadBankCardNo(unsigned char  ucBankCardNo[10])
{
	int ret;
	unsigned char ucBuffer[16];
	
	ret = Login_Card(1);
	if(ret != 0)	return ret;
	memset(ucBuffer,0xFF,16);
	ret = SMT_ReadBlock(1,2,ucBuffer);
	if(ret != 0)	return -5;
	memcpy(ucBankCardNo,ucBuffer,10);
	return 0;
}

typedef struct _LOOPPURSEINFO
{
		DWORD RemainMoney;// ����Ǯ�����
		WORD DealTimes;// ��Ƭ������ˮ��
		BYTE DealYear; //��������
		BYTE DealMonth; 
		BYTE DealDay;
		BYTE DealHour;
		BYTE DealMin;
		BYTE DealTimes_CurTime; // �ۼƽ��״���(��ǰʱ�����)
		BYTE DealTimes_CurDay;// �ۼƽ��״���(������)
} LOOPPURSEINFO,*LPLOOPPURSEINFO;



int _stdcall SMT_ReadPacketInfo(int nPacketNo,LOOPPURSEINFO *LoopPurseInfo)
{
	int ret,sector;
	unsigned char ucBuffer[16];
	ret = Login_Card(3);
	if(ret != 0)	return ret;
	ret = SMT_ReadBlock(3,0,ucBuffer);
	if(ret != 0)	return -5;
	
	if(ucBuffer[(nPacketNo-1)*2] != 0x00)
		return 1; //Ǯ��������ʹ��
	sector = ucBuffer[(nPacketNo-1)*2+1]; //Ǯ����������
	
	ret = Login_Card(sector);
	if(ret != 0)	return ret;

	unsigned char ucBuf1[16],ucBuf2[16];
	unsigned char ucCheck;
	ret = SMT_ReadBlock(sector,0,ucBuf1);
	if(ret != 0)	return -5;
	ret = SMT_ReadBlock(sector,2,ucBuf2);
	int i;
	ucCheck = 0;
	for(i=0;i<15;i++)
		ucCheck+=ucBuf1[i];
	if(ucCheck == ucBuf1[15])
	{
		LoopPurseInfo->RemainMoney = ucBuf1[0]+ucBuf1[1]*256+ucBuf1[2]*256*256;
		LoopPurseInfo->DealTimes   = ucBuf1[3]*256+ucBuf1[4];
		LoopPurseInfo->DealYear    = ucBuf1[5];
		LoopPurseInfo->DealMonth   = ucBuf1[6];
		LoopPurseInfo->DealDay     = ucBuf1[7];
		LoopPurseInfo->DealHour    = ucBuf1[8];
		LoopPurseInfo->DealMin     = ucBuf1[9];
		LoopPurseInfo->DealTimes_CurTime = ucBuf1[0x0D];
		LoopPurseInfo->DealTimes_CurDay  = ucBuf1[0X0E];
		return 0;
	}
	else
	{
		ucCheck = 0;
		for(i=0;i<15;i++)
			ucCheck+=ucBuf2[i];
		if(ucCheck == ucBuf2[15])
		{
			LoopPurseInfo->RemainMoney = ucBuf2[0]+ucBuf2[1]*256+ucBuf2[2]*256*256;
			LoopPurseInfo->DealTimes   = ucBuf2[3]*256+ucBuf2[4];
			LoopPurseInfo->DealYear    = ucBuf2[5];
			LoopPurseInfo->DealMonth   = ucBuf2[6];
			LoopPurseInfo->DealDay     = ucBuf2[7];
			LoopPurseInfo->DealHour    = ucBuf2[8];
			LoopPurseInfo->DealMin     = ucBuf2[9];
			LoopPurseInfo->DealTimes_CurTime = ucBuf2[0x0D];
			LoopPurseInfo->DealTimes_CurDay  = ucBuf2[0X0E];
			return 0;
		}
		else
			return 2;
	}
	return 2;
}

int _stdcall SMT_PacketAddMomey(int nPacketNo,int nMoney)
{
	int ret,sector;
	unsigned char ucBuffer[16];
	ret = Login_Card(3);
	if(ret != 0)	return ret;
	ret = SMT_ReadBlock(3,0,ucBuffer);
	if(ret != 0)	return -5;
	
	if(ucBuffer[(nPacketNo-1)*2] != 0x00)
		return 1; //Ǯ��������ʹ��
	sector = ucBuffer[(nPacketNo-1)*2+1]; //Ǯ����������
	
	ret = Login_Card(sector);
	if(ret != 0)	return ret;
	unsigned char ucBuf1[16],ucBuf2[16];
	unsigned char ucCheck;
	ret = SMT_ReadBlock(sector,0,ucBuf1);
	if(ret != 0)	return -5;
	int i;
	
	ucCheck = 0;
	for(i=0;i<15;i++)
		ucCheck+=ucBuf1[i];
	if(ucCheck == ucBuf1[15])
	{
		ret = SMT_Copy_DataBlock(sector,0,2,ucBuf2);
		if(ret != 0)	return -5;
		i = ucBuf1[0]+ucBuf1[1]*256+ucBuf1[2]*256*256;
		i = i + nMoney;
		ucBuf1[0] = i%256;
		ucBuf1[1] = i/256;
		ucBuf1[2] = i/256/256;
		i = ucBuf1[3]*256+ucBuf1[4];
		i = i + 1;
		ucBuf1[3] = i/256;
		ucBuf1[4] = i%256;
		CTime tm = CTime::GetCurrentTime();
		ucBuf1[5] = tm.GetYear();
		ucBuf1[6] = tm.GetMonth();
		ucBuf1[7] = tm.GetDay();
		ucBuf1[8] = tm.GetHour();
		ucBuf1[9] = tm.GetMinute();
		ucBuf1[15]=0;	
		for(i=0;i<15;i++)	ucBuf1[15] += ucBuf1[i];
		ret = SMT_WriteBlock(sector,0,ucBuf1);
		if(ret != 0)	return -6;
		else	return 0;
	}
	else
	{
		ret = SMT_ReadBlock(sector,2,ucBuf2);
		if(ret != 0)	return -5;
		ucCheck = 0;
		for(i=0;i<15;i++)	ucCheck+=ucBuf2[i];
		if(ucCheck != ucBuf2[15])	return 2;
		ret = SMT_Copy_DataBlock(sector,2,0,ucBuf1);
		if(ret != 0)	return -5;
		if(memcmp(ucBuf1,ucBuf2,16) != 0)	return -5;
		i = ucBuf1[0]+ucBuf1[1]*256+ucBuf1[2]*256*256;
		i = i + nMoney;
		ucBuf1[0] = i%256;
		ucBuf1[1] = i/256;
		ucBuf1[2] = i/256/256;
		i = ucBuf1[3]*256+ucBuf1[4];
		i = i + 1;
		ucBuf1[3] = i/256;
		ucBuf1[4] = i%256;
		CTime tm = CTime::GetCurrentTime();
		ucBuf1[5] = tm.GetYear();
		ucBuf1[6] = tm.GetMonth();
		ucBuf1[7] = tm.GetDay();
		ucBuf1[8] = tm.GetHour();
		ucBuf1[9] = tm.GetMinute();
		ucBuf1[15]=0;	
		for(i=0;i<15;i++)	ucBuf1[15] += ucBuf1[i];
		ret = SMT_WriteBlock(sector,0,ucBuf1);
		if(ret != 0)	return -6;
		else	return 0;
	}
	return 0;

}

//(3)Ǯ����Ǯ
int _stdcall SMT_PacketDelMomey(int nPacketNo,int nMoney)
{
	int ret,sector;
	unsigned char ucBuffer[16];
	ret = Login_Card(3);
	if(ret != 0)	return ret;
	ret = SMT_ReadBlock(3,0,ucBuffer);
	if(ret != 0)	return -5;
	
	if(ucBuffer[(nPacketNo-1)*2] != 0x00)
		return 1; //Ǯ��������ʹ��
	sector = ucBuffer[(nPacketNo-1)*2+1]; //Ǯ����������
	
	ret = Login_Card(sector);
	if(ret != 0)	return ret;
	unsigned char ucBuf1[16],ucBuf2[16];
	unsigned char ucCheck;
	ret = SMT_ReadBlock(sector,0,ucBuf1);
	if(ret != 0)	return -5;
	int i;
	
	ucCheck = 0;
	for(i=0;i<15;i++)
		ucCheck+=ucBuf1[i];
	if(ucCheck == ucBuf1[15])
	{
		ret = SMT_Copy_DataBlock(sector,0,2,ucBuf2);
		if(ret != 0)	return -5;
		i = ucBuf1[0]+ucBuf1[1]*256+ucBuf1[2]*256*256;
		if(i<nMoney)	return 3;
		i = i - nMoney;
		ucBuf1[0] = i%256;
		ucBuf1[1] = i/256;
		ucBuf1[2] = i/256/256;
		i = ucBuf1[3]*256+ucBuf1[4];
		i = i + 1;
		ucBuf1[3] = i/256;
		ucBuf1[4] = i%256;
		CTime tm = CTime::GetCurrentTime();
		ucBuf1[5] = tm.GetYear();
		ucBuf1[6] = tm.GetMonth();
		ucBuf1[7] = tm.GetDay();
		ucBuf1[8] = tm.GetHour();
		ucBuf1[9] = tm.GetMinute();
		ucBuf1[15]=0;	
		for(i=0;i<15;i++)	ucBuf1[15] += ucBuf1[i];
		ret = SMT_WriteBlock(sector,0,ucBuf1);
		if(ret != 0)	return -6;
		else	return 0;
	}
	else
	{
		ret = SMT_ReadBlock(sector,2,ucBuf2);
		if(ret != 0)	return -5;
		ucCheck = 0;
		for(i=0;i<15;i++)	ucCheck+=ucBuf2[i];
		if(ucCheck != ucBuf2[15])	return 2;
		ret = SMT_Copy_DataBlock(sector,2,0,ucBuf1);
		if(ret != 0)	return -5;
		if(memcmp(ucBuf1,ucBuf2,16) != 0)	return -5;
		i = ucBuf1[0]+ucBuf1[1]*256+ucBuf1[2]*256*256;
		if(i<nMoney)	return 3;
		i = i - nMoney;
		ucBuf1[0] = i%256;
		ucBuf1[1] = i/256;
		ucBuf1[2] = i/256/256;
		i = ucBuf1[3]*256+ucBuf1[4];
		i = i + 1;
		ucBuf1[3] = i/256;
		ucBuf1[4] = i%256;
		CTime tm = CTime::GetCurrentTime();
		ucBuf1[5] = tm.GetYear();
		ucBuf1[6] = tm.GetMonth();
		ucBuf1[7] = tm.GetDay();
		ucBuf1[8] = tm.GetHour();
		ucBuf1[9] = tm.GetMinute();
		ucBuf1[15]=0;	
		for(i=0;i<15;i++)	ucBuf1[15] += ucBuf1[i];
		ret = SMT_WriteBlock(sector,0,ucBuf1);
		if(ret != 0)	return -6;
		else	return 0;
	}
	return 0;
}

int _stdcall SMT_WriteAssistInfo (int nBatchNo[1],int nMoney[1])
{
	return 0;
}

int _stdcall SMT_ReadAssisInfo(int nBatchNo[1],int nMoney[1],unsigned char ucBatchTime[5],unsigned char ucMacNo[4])
{
	return 0;
}

int _stdcall SMT_SetBlackCardFlag()
{
	int ret;
	unsigned char ucBuffer[16];
	ret = Login_Card(3);
	if(ret != 0)	return ret;
	memset(ucBuffer,0xFF,16);
	ucBuffer[0] = 0x00;
	ret = SMT_WriteBlock(3,2,ucBuffer);
	if(ret != 0)	return -6;
	return 0;
}

int _stdcall SMT_SetNormalFlag()
{
	int ret;
	unsigned char ucBuffer[16];
	ret = Login_Card(3);
	if(ret != 0)	return ret;
	memset(ucBuffer,0xFF,16);
	ret = SMT_WriteBlock(3,2,ucBuffer);
	if(ret != 0)	return -6;
	return 0;

}
