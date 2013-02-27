delete from ykt_mon.map_alert_table;
insert into ykt_mon.map_alert_table values(43,'UncheckedRecord','未入账流水',0,0,1);
insert into ykt_mon.map_alert_table values(44,'ClockError','设备时钟错误',0,0,1);
insert into ykt_mon.map_alert_table values(45,'RecordLack','流水缺失',1,1,1);
insert into ykt_mon.map_alert_table values(46,'RollbackRecord','冲正流水',0,0,1);
insert into ykt_mon.map_alert_table values(47,'SuppressMonitor','压数监控',0,0,1);
insert into ykt_mon.map_alert_table values(48,'DeviceAbnormal','设备异常',0,0,1);
insert into ykt_mon.map_alert_table values(49,'LargeAmountRecord','大额消费',1,1,1);
insert into ykt_mon.map_alert_table values(50,'CAUnbalance','卡库不平',0,0,1);
insert into ykt_mon.map_alert_table values(51,'MidDrawRecord','中途拔卡',0,0,1);
insert into ykt_mon.map_alert_table values(52,'ChangedRecord','流水突变',0,0,1);
insert into ykt_mon.map_alert_table values(40,'BlackListDiff','黑名单版本号错误',1,1,1);
insert into ykt_mon.map_alert_table values(41,'OtheRecordException','其他异常流水',0,0,1);
insert into ykt_mon.map_alert_table values(42,'BlackCardComsumption','黑卡消费',1,1,1);

delete from ykt_mon.map_param_table;
insert into ykt_mon.map_param_table values(1,'ShortTimeMCCycle',+0000001.00,'短期多笔消费','小时',0);
insert into ykt_mon.map_param_table values(2,'BlackCardCycle',+0000001.00,'黑卡消费监控周期','小时',0);
insert into ykt_mon.map_param_table values(3,'SuppressTime',+0000024.00,'压数监控系统警戒时间长度','小时',0);
insert into ykt_mon.map_param_table values(4,'LargeAmountLimit',+0000050.00,'大额不正常流水消费金额警戒线','元',0);
insert into ykt_mon.map_param_table values(5,'MeMopercentage',+0000095.00,'内存应用百分比警戒值','%',0);
insert into ykt_mon.map_param_table values(6,'MidDrawCycle',+0000001.00,'中途拔卡监控周期','小时',0);
insert into ykt_mon.map_param_table values(7,'BlackListDistrCycle',+0000001.00,'黑名单下发监控周期','小时',0);
insert into ykt_mon.map_param_table values(8,'ClockErrorCycle',+0000001.00,'设备时钟校验校验频率','小时',0);
insert into ykt_mon.map_param_table values(9,'SuppressCycle',+0000001.00,'压数监控监控周期','小时',0);
insert into ykt_mon.map_param_table values(10,'BlackListDistrTime',+0000001.00,'黑名单下发时间警戒','小时',0);
insert into ykt_mon.map_param_table values(11,'CountLimit',+0000003.00,'短期多笔消费不允许的次数','次',0);
insert into ykt_mon.map_param_table values(12,'TradeLackCycle',+0000000.25,'流水缺号监控周期','小时',0);
insert into ykt_mon.map_param_table values(13,'ShortTimeLimit',+0000005.00,'短期多笔消费不允许时间间隔','分钟',0);
insert into ykt_mon.map_param_table values(14,'RollbackCycle',+0000001.00,'冲正监控监控周期','小时',0);
insert into ykt_mon.map_param_table values(15,'ClockErrorLimit',+0000010.00,'设备时钟校验时钟不匹配允许范围','分钟',0);
insert into ykt_mon.map_param_table values(16,'LargeAmountCycle',+0000001.00,'大额不正常流水监控周期','小时',0);
insert into ykt_mon.map_param_table values(17,'OtherCycle',+0000001.00,'其他异常流水监控周期','小时',0);
insert into ykt_mon.map_param_table values(18,'HeartInterval',+0000010.00,'设备心跳分析周期','分钟',0);
insert into ykt_mon.map_param_table values(19,'CAUnbalanceCycle',+0000012.00,'卡库不平监控周期','小时',0);
insert into ykt_mon.map_param_table values(20,'DeviceFlushTime',+0000010.00,'异常设备刷新时间','分钟',0);
insert into ykt_mon.map_param_table values(21,'CPUpercentage',+0000090.00,'CPU应用百分比警戒值','%',0);
insert into ykt_mon.map_param_table values(22,'MutationCycle',+0000001.00,'突变流水监控周期','小时',0);
insert into ykt_mon.map_param_table values(23,'UncheckedCycle',+0000001.00,'未入账流水监控周期','小时',0);
insert into ykt_mon.map_param_table values(24,'HWpercentage',+0000090.00,'硬盘应用百分比警戒值','%',0);
insert into ykt_mon.map_param_table values(25,'SingleAmountLimit',+0000019.00,'大额单笔消费限额','元',0);
insert into ykt_mon.map_param_table values(26,'TradeLackDealCycle',+0000001.00,'流水缺号处理周期','小时',0);
insert into ykt_mon.map_param_table values(27,'AccelateParam',+0000010.00,'流水分析加速时间','分钟',0);
insert into ykt_mon.map_param_table values(28,'SerialLostAccelateParam',+0000060.00,'流水缺失分析加速时间','分钟',0);
insert into ykt_mon.map_param_table values(29,'TradeLackCkCycle',+0000010.00,'流水缺失回归分析周期','天',0);
insert into ykt_mon.map_param_table values(30,'ServerExceptionParam',+0000600.00,'服务器延后心跳最大允许时间','秒',0);
insert into ykt_mon.map_param_table values(32,'ServiceExceptionCycle',+0000005.00,'服务监控周期','分钟',0);
insert into ykt_mon.map_param_table values(31,'ServerExceptionCycle',+0000005.00,'服务器监控周期','分钟',0);
insert into ykt_mon.map_param_table values(33,'TimeInterval',+0000010.00,'设备脱机最大允许时间间隔','分钟',0);
insert into ykt_mon.map_param_table values(34,'HeartLostTime',+0000030.00,'设备脱机警戒时间','分钟',0);


delete from ykt_mon.map_user_table;
insert into ykt_mon.map_user_table values(1,'admin','超级管理员','e10adc3949ba59abbe56e057f20f883e','男','金仕达','admin_mon@kingstargroup.com','','9999','20060712135739',0,'admin','20051109135513');

delete from YKT_MON.MAP_STATE_DIC;
insert into YKT_MON.MAP_STATE_DIC (ID, STATEID, STATENAME, TAGCODE, SHOWCOLOR, ERRORNOT, ERRORCODE)
values (1, '1', '设备不通', '10112', 0, 1, '12');
insert into YKT_MON.MAP_STATE_DIC (ID, STATEID, STATENAME, TAGCODE, SHOWCOLOR, ERRORNOT, ERRORCODE)
values (2, '12', '设备不通', '10112', 0, 1, '12');
insert into YKT_MON.MAP_STATE_DIC (ID, STATEID, STATENAME, TAGCODE, SHOWCOLOR, ERRORNOT, ERRORCODE)
values (3, '255', '设备不通', '10112', 0, 1, '12');
insert into YKT_MON.MAP_STATE_DIC (ID, STATEID, STATENAME, TAGCODE, SHOWCOLOR, ERRORNOT, ERRORCODE)
values (4, '11', 'id号错', '10111', 0, 1, '11');
insert into YKT_MON.MAP_STATE_DIC (ID, STATEID, STATENAME, TAGCODE, SHOWCOLOR, ERRORNOT, ERRORCODE)
values (5, '18', '未签到', '10118', 0, 1, '18');
insert into YKT_MON.MAP_STATE_DIC (ID, STATEID, STATENAME, TAGCODE, SHOWCOLOR, ERRORNOT, ERRORCODE)
values (6, '27', '申请签到', '10127', 0, 1, '27');
insert into YKT_MON.MAP_STATE_DIC (ID, STATEID, STATENAME, TAGCODE, SHOWCOLOR, ERRORNOT, ERRORCODE)
values (7, '28', '燃气报警', '10128', 0, 1, '28');
insert into YKT_MON.MAP_STATE_DIC (ID, STATEID, STATENAME, TAGCODE, SHOWCOLOR, ERRORNOT, ERRORCODE)
values (8, '29', '无费率', '10129', 0, 1, '29');
insert into YKT_MON.MAP_STATE_DIC (ID, STATEID, STATENAME, TAGCODE, SHOWCOLOR, ERRORNOT, ERRORCODE)
values (9, '30', '记录满', '10130', 0, 1, '30');

delete from YKT_MON.MAP_SYS_DICTIONARY;
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '10', '异常码', '充正流水', 'REVERSE_SERI');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '101', '异常码', '设备脱机', 'DEVICE_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '102', '异常码', '服务器cpu异常', 'SERVER_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '103', '异常码', '服务器内存异常', 'SERVER_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '104', '异常码', '服务器硬盘异常', 'SERVER_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '105', '异常码', '服务器连接失败', 'SERVER_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '108', '异常码', 'web连接失败', 'SERVICE_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '109', '异常码', '数据库连接失败', 'SERVICE_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '11', '异常码', '黑名单版本不正确', 'BSHEETVER_ERROR');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '110', '异常码', 'drtp连接失败', 'SERVICE_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '12', '异常码', '设备时钟错误', 'SETTIME_ERROR');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '13', '异常码', '卡库不平', 'UNBALANCE_ERROR');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '14', '异常码', '短期多次消费', 'SHORTTIME_MUTI_COMSUMPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '15', '异常码', '单笔大额不正常消费', 'SINGLE_LARGE_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '201', '异常码', '日期不合理', 'SERI_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '202', '异常码', '流水号不合理', 'SERI_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '203', '异常码', '出入卡金额错误', 'SERI_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '204', '异常码', '设备id错误', 'SERI_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '205', '异常码', '流水重复', 'SERI_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '3', '异常码', '大额不正常流水', 'LARGE_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '4', '异常码', '中途拔卡流水', 'MID_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '51', '异常码', '黑卡正常消费', 'BSHEETVER_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '52', '异常码', '白卡不能消费', 'BSHEETVER_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '53', '异常码', '黑卡标记消费', 'BSHEETVER_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '6', '异常码', '其他异常流水', 'OTHER_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '7', '异常码', '流水缺号', 'SERI_LOSS');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '8', '异常码', '压数监控', 'SUPRESS_EXCEPTION');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (1, '9', '异常码', '未入帐流水', 'UNCHECK_SERI');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '10', '周期码表', '充正流水', 'RollbackCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '101', '周期码表', '设备脱机', 'HeartInteval');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '102', '周期码表', 'CPU使用率预警', 'ServerExceptionCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '103', '周期码表', '内存使用率预警', 'ServerExceptionCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '104', '周期码表', '硬盘使用率预警', 'ServerExceptionCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '105', '周期码表', '服务器连接失败', 'ServerExceptionCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '108', '周期码表', 'web连接失败', 'ServiceExceptionCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '109', '周期码表', '数据库连接失败', 'ServiceExceptionCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '11', '周期码表', '黑名单版本不正确', 'BlackListDistrCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '110', '周期码表', 'drtp连接失败', 'ServiceExceptionCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '12', '周期码表', '设备时钟错误', 'ClockErrorCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '13', '周期码表', '卡库不平', 'CAUnbalanceCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '14', '周期码表', '短期多次消费', 'ShortTimeMCCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '2', '周期码表', '突变流水', 'MutationCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '201', '周期码表', '日期不合理', 'MutationCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '202', '周期码表', '流水号不合理', 'MutationCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '203', '周期码表', '出入卡金额错误', 'MutationCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '204', '周期码表', '设备id错误', 'MutationCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '205', '周期码表', '流水重复', 'MutationCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '3', '周期码表', '大额不正常流水', 'LargeAmountCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '4', '周期码表', '中途拔卡流水', 'MidDrawCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '5', '周期码表', '黑卡消费', 'BlackCardCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '51', '周期码表', '黑卡正常消费', 'BlackCardCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '52', '周期码表', '白卡不能消费', 'BlackCardCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '53', '周期码表', '黑卡标记消费', 'BlackCardCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '6', '周期码表', '其他异常流水', 'OtherCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '7', '周期码表', '流水缺号', 'TradeLackCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '8', '周期码表', '压数监控', 'SuppressTime');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (2, '9', '周期码表', '未入帐流水', 'UncheckedCycle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (3, '1', '服务类型', 'web服务', 'web');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (3, '2', '服务类型', 'db数据库', 'db');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (3, '3', '服务类型', 'drtp服务', 'drtp');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (4, '1', '服务类型', 'drtp服务', 'drtp');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (4, '2', '服务类型', 'db2数据库', 'db:db2');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (4, '3', '服务类型', 'oracle数据库', 'db:oracle');
insert into YKT_MON.MAP_SYS_DICTIONARY (DICT_NO, DICT_VALUE, DICT_NAME, DICT_CAPTION, DICT_CODE)
values (4, '4', '服务类型', 'web服务', 'web');