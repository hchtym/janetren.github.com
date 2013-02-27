delete from ykt_mon.map_alert_table;
insert into ykt_mon.map_alert_table values(43,'UncheckedRecord','δ������ˮ',0,0,1);
insert into ykt_mon.map_alert_table values(44,'ClockError','�豸ʱ�Ӵ���',0,0,1);
insert into ykt_mon.map_alert_table values(45,'RecordLack','��ˮȱʧ',1,1,1);
insert into ykt_mon.map_alert_table values(46,'RollbackRecord','������ˮ',0,0,1);
insert into ykt_mon.map_alert_table values(47,'SuppressMonitor','ѹ�����',0,0,1);
insert into ykt_mon.map_alert_table values(48,'DeviceAbnormal','�豸�쳣',0,0,1);
insert into ykt_mon.map_alert_table values(49,'LargeAmountRecord','�������',1,1,1);
insert into ykt_mon.map_alert_table values(50,'CAUnbalance','���ⲻƽ',0,0,1);
insert into ykt_mon.map_alert_table values(51,'MidDrawRecord','��;�ο�',0,0,1);
insert into ykt_mon.map_alert_table values(52,'ChangedRecord','��ˮͻ��',0,0,1);
insert into ykt_mon.map_alert_table values(40,'BlackListDiff','�������汾�Ŵ���',1,1,1);
insert into ykt_mon.map_alert_table values(41,'OtheRecordException','�����쳣��ˮ',0,0,1);
insert into ykt_mon.map_alert_table values(42,'BlackCardComsumption','�ڿ�����',1,1,1);

delete from ykt_mon.map_param_table;
insert into ykt_mon.map_param_table values(1,'ShortTimeMCCycle',+0000001.00,'���ڶ������','Сʱ',0);
insert into ykt_mon.map_param_table values(2,'BlackCardCycle',+0000001.00,'�ڿ����Ѽ������','Сʱ',0);
insert into ykt_mon.map_param_table values(3,'SuppressTime',+0000024.00,'ѹ�����ϵͳ����ʱ�䳤��','Сʱ',0);
insert into ykt_mon.map_param_table values(4,'LargeAmountLimit',+0000050.00,'��������ˮ���ѽ�����','Ԫ',0);
insert into ykt_mon.map_param_table values(5,'MeMopercentage',+0000095.00,'�ڴ�Ӧ�ðٷֱȾ���ֵ','%',0);
insert into ykt_mon.map_param_table values(6,'MidDrawCycle',+0000001.00,'��;�ο��������','Сʱ',0);
insert into ykt_mon.map_param_table values(7,'BlackListDistrCycle',+0000001.00,'�������·��������','Сʱ',0);
insert into ykt_mon.map_param_table values(8,'ClockErrorCycle',+0000001.00,'�豸ʱ��У��У��Ƶ��','Сʱ',0);
insert into ykt_mon.map_param_table values(9,'SuppressCycle',+0000001.00,'ѹ����ؼ������','Сʱ',0);
insert into ykt_mon.map_param_table values(10,'BlackListDistrTime',+0000001.00,'�������·�ʱ�侯��','Сʱ',0);
insert into ykt_mon.map_param_table values(11,'CountLimit',+0000003.00,'���ڶ�����Ѳ�����Ĵ���','��',0);
insert into ykt_mon.map_param_table values(12,'TradeLackCycle',+0000000.25,'��ˮȱ�ż������','Сʱ',0);
insert into ykt_mon.map_param_table values(13,'ShortTimeLimit',+0000005.00,'���ڶ�����Ѳ�����ʱ����','����',0);
insert into ykt_mon.map_param_table values(14,'RollbackCycle',+0000001.00,'������ؼ������','Сʱ',0);
insert into ykt_mon.map_param_table values(15,'ClockErrorLimit',+0000010.00,'�豸ʱ��У��ʱ�Ӳ�ƥ������Χ','����',0);
insert into ykt_mon.map_param_table values(16,'LargeAmountCycle',+0000001.00,'��������ˮ�������','Сʱ',0);
insert into ykt_mon.map_param_table values(17,'OtherCycle',+0000001.00,'�����쳣��ˮ�������','Сʱ',0);
insert into ykt_mon.map_param_table values(18,'HeartInterval',+0000010.00,'�豸������������','����',0);
insert into ykt_mon.map_param_table values(19,'CAUnbalanceCycle',+0000012.00,'���ⲻƽ�������','Сʱ',0);
insert into ykt_mon.map_param_table values(20,'DeviceFlushTime',+0000010.00,'�쳣�豸ˢ��ʱ��','����',0);
insert into ykt_mon.map_param_table values(21,'CPUpercentage',+0000090.00,'CPUӦ�ðٷֱȾ���ֵ','%',0);
insert into ykt_mon.map_param_table values(22,'MutationCycle',+0000001.00,'ͻ����ˮ�������','Сʱ',0);
insert into ykt_mon.map_param_table values(23,'UncheckedCycle',+0000001.00,'δ������ˮ�������','Сʱ',0);
insert into ykt_mon.map_param_table values(24,'HWpercentage',+0000090.00,'Ӳ��Ӧ�ðٷֱȾ���ֵ','%',0);
insert into ykt_mon.map_param_table values(25,'SingleAmountLimit',+0000019.00,'���������޶�','Ԫ',0);
insert into ykt_mon.map_param_table values(26,'TradeLackDealCycle',+0000001.00,'��ˮȱ�Ŵ�������','Сʱ',0);
insert into ykt_mon.map_param_table values(27,'AccelateParam',+0000010.00,'��ˮ��������ʱ��','����',0);
insert into ykt_mon.map_param_table values(28,'SerialLostAccelateParam',+0000060.00,'��ˮȱʧ��������ʱ��','����',0);
insert into ykt_mon.map_param_table values(29,'TradeLackCkCycle',+0000010.00,'��ˮȱʧ�ع��������','��',0);
insert into ykt_mon.map_param_table values(30,'ServerExceptionParam',+0000600.00,'�������Ӻ������������ʱ��','��',0);
insert into ykt_mon.map_param_table values(32,'ServiceExceptionCycle',+0000005.00,'����������','����',0);
insert into ykt_mon.map_param_table values(31,'ServerExceptionCycle',+0000005.00,'�������������','����',0);
insert into ykt_mon.map_param_table values(33,'TimeInterval',+0000010.00,'�豸�ѻ��������ʱ����','����',0);
insert into ykt_mon.map_param_table values(34,'HeartLostTime',+0000030.00,'�豸�ѻ�����ʱ��','����',0);


delete from ykt_mon.map_user_table;
insert into ykt_mon.map_user_table values(1,'admin','��������Ա','e10adc3949ba59abbe56e057f20f883e','��','���˴�','admin_mon@kingstargroup.com','','9999','20060712135739',0,'admin','20051109135513');

delete from YKT_MON.MAP_STATE_DIC;
insert into YKT_MON.MAP_STATE_DIC (ID, STATEID, STATENAME, TAGCODE, SHOWCOLOR, ERRORNOT, ERRORCODE)
values (1, '1', '�豸��ͨ', '10112', 0, 1, '12');
insert into YKT_MON.MAP_STATE_DIC (ID, STATEID, STATENAME, TAGCODE, SHOWCOLOR, ERRORNOT, ERRORCODE)
values (2, '12', '�豸��ͨ', '10112', 0, 1, '12');
insert into YKT_MON.MAP_STATE_DIC (ID, STATEID, STATENAME, TAGCODE, SHOWCOLOR, ERRORNOT, ERRORCODE)
values (3, '255', '�豸��ͨ', '10112', 0, 1, '12');
insert into YKT_MON.MAP_STATE_DIC (ID, STATEID, STATENAME, TAGCODE, SHOWCOLOR, ERRORNOT, ERRORCODE)
values (4, '11', 'id�Ŵ�', '10111', 0, 1, '11');
insert into YKT_MON.MAP_STATE_DIC (ID, STATEID, STATENAME, TAGCODE, SHOWCOLOR, ERRORNOT, ERRORCODE)
values (5, '18', 'δǩ��', '10118', 0, 1, '18');
insert into YKT_MON.MAP_STATE_DIC (ID, STATEID, STATENAME, TAGCODE, SHOWCOLOR, ERRORNOT, ERRORCODE)
values (6, '27', '����ǩ��', '10127', 0, 1, '27');
insert into YKT_MON.MAP_STATE_DIC (ID, STATEID, STATENAME, TAGCODE, SHOWCOLOR, ERRORNOT, ERRORCODE)
values (7, '28', 'ȼ������', '10128', 0, 1, '28');
insert into YKT_MON.MAP_STATE_DIC (ID, STATEID, STATENAME, TAGCODE, SHOWCOLOR, ERRORNOT, ERRORCODE)
values (8, '29', '�޷���', '10129', 0, 1, '29');
insert into YKT_MON.MAP_STATE_DIC (ID, STATEID, STATENAME, TAGCODE, SHOWCOLOR, ERRORNOT, ERRORCODE)
values (9, '30', '��¼��', '10130', 0, 1, '30');

delete from YKT_MON.MAP_SYS_DICTIONARY;
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '10', '�쳣��', '������ˮ', 'REVERSE_SERI');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '101', '�쳣��', '�豸�ѻ�', 'DEVICE_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '102', '�쳣��', '������cpu�쳣', 'SERVER_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '103', '�쳣��', '�������ڴ��쳣', 'SERVER_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '104', '�쳣��', '������Ӳ���쳣', 'SERVER_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '105', '�쳣��', '����������ʧ��', 'SERVER_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '108', '�쳣��', 'web����ʧ��', 'SERVICE_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '109', '�쳣��', '���ݿ�����ʧ��', 'SERVICE_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '11', '�쳣��', '�������汾����ȷ', 'BSHEETVER_ERROR');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '110', '�쳣��', 'drtp����ʧ��', 'SERVICE_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '12', '�쳣��', '�豸ʱ�Ӵ���', 'SETTIME_ERROR');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '13', '�쳣��', '���ⲻƽ', 'UNBALANCE_ERROR');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '14', '�쳣��', '���ڶ������', 'SHORTTIME_MUTI_COMSUMPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '15', '�쳣��', '���ʴ���������', 'SINGLE_LARGE_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '201', '�쳣��', '���ڲ�����', 'SERI_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '202', '�쳣��', '��ˮ�Ų�����', 'SERI_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '203', '�쳣��', '���뿨������', 'SERI_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '204', '�쳣��', '�豸id����', 'SERI_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '205', '�쳣��', '��ˮ�ظ�', 'SERI_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '3', '�쳣��', '��������ˮ', 'LARGE_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '4', '�쳣��', '��;�ο���ˮ', 'MID_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '51', '�쳣��', '�ڿ���������', 'BSHEETVER_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '52', '�쳣��', '�׿���������', 'BSHEETVER_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '53', '�쳣��', '�ڿ��������', 'BSHEETVER_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '6', '�쳣��', '�����쳣��ˮ', 'OTHER_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '7', '�쳣��', '��ˮȱ��', 'SERI_LOSS');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '8', '�쳣��', 'ѹ�����', 'SUPRESS_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '9', '�쳣��', 'δ������ˮ', 'UNCHECK_SERI');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '10', '�������', '������ˮ', 'RollbackCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '101', '�������', '�豸�ѻ�', 'HeartInteval');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '102', '�������', 'CPUʹ����Ԥ��', 'ServerExceptionCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '103', '�������', '�ڴ�ʹ����Ԥ��', 'ServerExceptionCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '104', '�������', 'Ӳ��ʹ����Ԥ��', 'ServerExceptionCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '105', '�������', '����������ʧ��', 'ServerExceptionCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '108', '�������', 'web����ʧ��', 'ServiceExceptionCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '109', '�������', '���ݿ�����ʧ��', 'ServiceExceptionCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '11', '�������', '�������汾����ȷ', 'BlackListDistrCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '110', '�������', 'drtp����ʧ��', 'ServiceExceptionCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '12', '�������', '�豸ʱ�Ӵ���', 'ClockErrorCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '13', '�������', '���ⲻƽ', 'CAUnbalanceCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '14', '�������', '���ڶ������', 'ShortTimeMCCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '2', '�������', 'ͻ����ˮ', 'MutationCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '201', '�������', '���ڲ�����', 'MutationCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '202', '�������', '��ˮ�Ų�����', 'MutationCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '203', '�������', '���뿨������', 'MutationCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '204', '�������', '�豸id����', 'MutationCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '205', '�������', '��ˮ�ظ�', 'MutationCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '3', '�������', '��������ˮ', 'LargeAmountCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '4', '�������', '��;�ο���ˮ', 'MidDrawCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '5', '�������', '�ڿ�����', 'BlackCardCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '51', '�������', '�ڿ���������', 'BlackCardCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '52', '�������', '�׿���������', 'BlackCardCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '53', '�������', '�ڿ��������', 'BlackCardCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '6', '�������', '�����쳣��ˮ', 'OtherCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '7', '�������', '��ˮȱ��', 'TradeLackCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '8', '�������', 'ѹ�����', 'SuppressTime');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '9', '�������', 'δ������ˮ', 'UncheckedCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (3, '1', '��������', 'web����', 'web');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (3, '2', '��������', 'db���ݿ�', 'db');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (3, '3', '��������', 'drtp����', 'drtp');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (4, '1', '��������', 'drtp����', 'drtp');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (4, '2', '��������', 'db2���ݿ�', 'db:db2');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (4, '3', '��������', 'oracle���ݿ�', 'db:oracle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (4, '4', '��������', 'web����', 'web');