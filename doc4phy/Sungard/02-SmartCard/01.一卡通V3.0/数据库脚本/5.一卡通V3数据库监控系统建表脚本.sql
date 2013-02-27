-- Create table
create table YKT_MON.MAP_CONTACT_TABLE
(
  ID             INTEGER not null,
  CONTACTNAME    VARCHAR2(50),
  CONTACTGENDER  VARCHAR2(3),
  CONTACTCOMPANY VARCHAR2(30),
  WEEKDAYS       VARCHAR2(7),
  STARTTIME      VARCHAR2(26),
  ENDTIME        VARCHAR2(26),
  EMAIL          VARCHAR2(30),
  CELLPHONE      VARCHAR2(13)
)
tablespace TS_YKT_MON
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table YKT_MON.MAP_CONTACT_TABLE
  add primary key (ID)
  using index 
  tablespace TS_YKT_MON
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
 -- Create table
create table YKT_MON.MAP_CONTACT_MONITOR_TABLE
(
  ID          INTEGER not null,
  CONTACTNAME VARCHAR2(50),
  MONITORNO   VARCHAR2(50),
  MONITORNAME VARCHAR2(50)
)
tablespace TS_YKT_MON
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table YKT_MON.MAP_CONTACT_MONITOR_TABLE
  add primary key (ID)
  using index 
  tablespace TS_YKT_MON
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  -- Create table
create table YKT_MON.MAP_ANALYSIS_POINT
(
  ANALYSISNAME  VARCHAR2(50) not null,
  ANALYSISPOINT VARCHAR2(14) not null
)
tablespace TS_YKT_MON
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table YKT_MON.MAP_ANALYSIS_POINT
  add primary key (ANALYSISNAME)
  using index 
  tablespace TS_YKT_MON
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  -- Create table
create table YKT_MON.MAP_ALERT_TABLE
(
  ID         INTEGER not null,
  PARAMETER  VARCHAR2(50),
  NAME       VARCHAR2(50),
  PHONEALERT INTEGER,
  MAILALERT  INTEGER,
  NOTE       INTEGER
)
tablespace TS_YKT_MON
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table YKT_MON.MAP_ALERT_TABLE
  add primary key (ID)
  using index 
  tablespace TS_YKT_MON
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );


-- Create table
create table ykt_mon.map_caunbalance_table
(
  ACCNO         VARCHAR2(20) not null,
  ANALYSISTIME  CHAR(14) not null,
  ACCNAME       VARCHAR2(240),
  SUBJNO        VARCHAR2(20),
  ACCPWD        VARCHAR2(64),
  CUSTID        INTEGER,
  CARDNO        INTEGER,
  PURSENO       INTEGER,
  DAYCOSTMAXAMT NUMBER(15,2),
  CARDMAXBAL    NUMBER(15,2),
  STOPPAYFLAG   CHAR(1),
  STATUS        CHAR(1),
  YDAYBAL       NUMBER(15,2),
  YDAYAVAILBAL  NUMBER(15,2),
  YDAYFROZEBAL  NUMBER(15,2),
  BALANCE       NUMBER(15,2),
  AVAILBAL      NUMBER(15,2),
  FROZEBAL      NUMBER(15,2),
  SUBSIDYBAL    NUMBER(15,2),
  FOREGIFT      NUMBER(15,2),
  LASTCARDCNT   INTEGER,
  LASTCARDBAL   NUMBER(15,2),
  DAYCOSTAMT    NUMBER(15,2),
  LASTTRANSDATE CHAR(8),
  LASTACCDATE   CHAR(8),
  SUBSIDYNO     INTEGER,
  LASTSUBSIDYNO INTEGER,
  OPENDATE      CHAR(8),
  CLOSEDATE     CHAR(8)
)
tablespace TS_YKT_MON
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table YKT_MON.MAP_CAUNBALANCE_TABLE
  is '卡库不平表';
-- Add comments to the columns 
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.ACCNO
  is '账号';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.ANALYSISTIME
  is '分析时间';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.ACCNAME
  is '帐户名';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.SUBJNO
  is '科目号';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.ACCPWD
  is '帐户密码';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.CUSTID
  is '客户号';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.CARDNO
  is '交易卡号';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.PURSENO
  is '钱包号';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.DAYCOSTMAXAMT
  is '日消费限额';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.CARDMAXBAL
  is '卡最大金额';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.STOPPAYFLAG
  is '止付标志';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.STATUS
  is '状态';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.YDAYBAL
  is '昨日余额';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.YDAYAVAILBAL
  is '昨日可用余额';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.YDAYFROZEBAL
  is '昨日冻结余额';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.BALANCE
  is '帐户余额';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.AVAILBAL
  is '可用余额';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.FROZEBAL
  is '冻结余额';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.SUBSIDYBAL
  is '代领补助金额';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.FOREGIFT
  is '押金';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.LASTCARDCNT
  is '最新卡交易次数';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.LASTCARDBAL
  is '最新卡余额';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.DAYCOSTAMT
  is '日累计消费金额';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.LASTTRANSDATE
  is '上次交易日期';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.LASTACCDATE
  is '上次清算日期';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.SUBSIDYNO
  is '补助批次号';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.OPENDATE
  is '开户日期';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.CLOSEDATE
  is '销户日期';
-- Create/Recreate primary, unique and foreign key constraints 

  alter table YKT_MON.MAP_CAUNBALANCE_TABLE
  add primary key (ACCNO, ANALYSISTIME)
  using index 
  tablespace TS_YKT_MON
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );


-- Create table
create table YKT_MON.MAP_DEVICE_TABLE
(
  ANALYSISTIME CHAR(14) not null,
  DEVICEID     INTEGER not null,
  DEVICENAME   VARCHAR2(60),
  DEVPHYID     VARCHAR2(30),
  DEVTYPECODE  VARCHAR2(30),
  FDEVPHYID    VARCHAR2(30),
  RUNSTATUS    CHAR(1),
  STATUS       CHAR(1),
  IP           VARCHAR2(30),
  DEVICENO     INTEGER,
  CARDVERNO    VARCHAR2(30),
  SYSID        INTEGER,
  AREACODE     VARCHAR2(3),
  DEVUSAGE     INTEGER,
  DEVICETIME   VARCHAR2(14),
  SERVERTIME   VARCHAR2(14),
  CONTACT_NAME VARCHAR2(150),
  CPU          NUMBER(5,2),
  MEMORY       NUMBER(5,2),
  HARDDISK     NUMBER(5,2),
  ERROR_REASON NUMBER
)
tablespace TS_YKT_MON
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table YKT_MON.MAP_DEVICE_TABLE
  is 'YKT_MON.MAP_DEVICE_TABLE-设备表';
-- Add comments to the columns 
comment on column YKT_MON.MAP_DEVICE_TABLE.ANALYSISTIME
  is '分析时间';
comment on column YKT_MON.MAP_DEVICE_TABLE.DEVICEID
  is '终端编号也是设备编号';
comment on column YKT_MON.MAP_DEVICE_TABLE.DEVICENAME
  is '设备名称';
comment on column YKT_MON.MAP_DEVICE_TABLE.DEVPHYID
  is '设备物理ID★';
comment on column YKT_MON.MAP_DEVICE_TABLE.DEVTYPECODE
  is '设备类型★';
comment on column YKT_MON.MAP_DEVICE_TABLE.FDEVPHYID
  is '上级设备';
comment on column YKT_MON.MAP_DEVICE_TABLE.RUNSTATUS
  is '运行状态';
comment on column YKT_MON.MAP_DEVICE_TABLE.STATUS
  is '状态:1-正常2-注销';
comment on column YKT_MON.MAP_DEVICE_TABLE.IP
  is 'IP地址';
comment on column YKT_MON.MAP_DEVICE_TABLE.DEVICENO
  is '设备机号';
comment on column YKT_MON.MAP_DEVICE_TABLE.CARDVERNO
  is '卡黑名单版本号';
comment on column YKT_MON.MAP_DEVICE_TABLE.SYSID
  is '前置机系统ID';
comment on column YKT_MON.MAP_DEVICE_TABLE.AREACODE
  is '区域代码';
comment on column YKT_MON.MAP_DEVICE_TABLE.DEVUSAGE
  is '设备用途';
comment on column YKT_MON.MAP_DEVICE_TABLE.DEVICETIME
  is '设备时间';
comment on column YKT_MON.MAP_DEVICE_TABLE.SERVERTIME
  is '服务器时间';
comment on column YKT_MON.MAP_DEVICE_TABLE.CONTACT_NAME
  is '联系人';
comment on column YKT_MON.MAP_DEVICE_TABLE.CPU
  is 'cpu使用率';
comment on column YKT_MON.MAP_DEVICE_TABLE.MEMORY
  is '内存使用率';
comment on column YKT_MON.MAP_DEVICE_TABLE.HARDDISK
  is '硬盘使用率';
comment on column YKT_MON.MAP_DEVICE_TABLE.ERROR_REASON
  is '错误代码';
-- Create/Recreate primary, unique and foreign key constraints 
alter table YKT_MON.MAP_DEVICE_TABLE
  add primary key (ANALYSISTIME, DEVICEID)
  using index 
  tablespace TS_YKT_MON
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 12M
    minextents 1
    maxextents unlimited
  );


-- Create table
create table YKT_MON.MAP_SERIALEXCEPT_TABLE
(
	ANALYSISTIME CHAR(14) not null,
  TRANSDATE  CHAR(8) not null,
  TRANSTIME  CHAR(6),
  DEVPHYID   VARCHAR2(30) not null,
  DEVSEQNO   INTEGER not null,
  CARDNO     INTEGER,
  PURSENO    INTEGER,
  CARDCNT    INTEGER,
  CARDBEFBAL NUMBER,
  AMOUNT     NUMBER,
  CARDAFTBAL NUMBER,
  MANAGEFEE  NUMBER,
  TRANSMARK  INTEGER,
  TRANSCODE  INTEGER,
  SHOPID		 INTEGER,
  SUBSIDYNO  INTEGER,
  BATCHNO    VARCHAR2(30),
  SYSID      INTEGER,
  COLDATE    CHAR(8),
  COLTIME    CHAR(6),
  ACCDATE    CHAR(8),
  ACCTIME    CHAR(6),
  STATUS     CHAR(1) not null,
  ERRCODE    INTEGER,
  ERRMSG     VARCHAR2(240),
  DELFLAG    CHAR(1),
  CONTACTNAME   VARCHAR2(30),
  ABNORMALTYPE  INTEGER
)
tablespace TS_YKT_MON
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table YKT_MON.MAP_SERIALEXCEPT_TABLE
  is '异常流水表';
-- Add comments to the columns 
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.ANALYSISTIME
  is '分析时间';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.TRANSDATE
  is '交易日期';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.TRANSTIME
  is '交易时间';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.DEVPHYID
  is '设备物理ID';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.DEVSEQNO
  is '设备流水号';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.CARDNO
  is '交易卡号';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.PURSENO
  is '钱包号';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.CARDCNT
  is '卡交易次数';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.CARDBEFBAL
  is '交易前卡余额';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.AMOUNT
  is '发生额-包含管理费';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.CARDAFTBAL
  is '交易后卡余额';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.MANAGEFEE
  is '管理费';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.TRANSMARK
  is '交易标记';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.TRANSCODE
  is '交易码';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.SUBSIDYNO
  is '补助批次号';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.BATCHNO
  is '导入批次号';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.SYSID
  is '子系统ID';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.COLDATE
  is '采集日期';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.COLTIME
  is '采集时间';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.ACCDATE
  is '记账日期';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.ACCTIME
  is '记账时间';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.STATUS
  is '状态-1初始状态2-入账失败3-成功4-异常流水';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.ERRCODE
  is '错误码';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.ERRMSG
  is '错误信息';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.DELFLAG
  is '删除标志';
 comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.CONTACTNAME
  is '联系人';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.ABNORMALTYPE
  is '错误代码';
-- Create/Recreate primary, unique and foreign key constraints 
alter table YKT_MON.MAP_SERIALEXCEPT_TABLE
  add primary key (ANALYSISTIME,TRANSDATE, DEVPHYID, DEVSEQNO)
  using index 
  tablespace TS_YKT_MON
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

-- Create table
create table YKT_MON.MAP_PARAM_TABLE
(
  ID        INTEGER not null,
  PARAMETER VARCHAR2(50),
  VALUE     NUMBER(9,2),
  NAME      VARCHAR2(50),
  UNIT      VARCHAR2(10),
  FLAG      INTEGER
)
tablespace TS_YKT_MON
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table YKT_MON.MAP_PARAM_TABLE
  add primary key (ID)
  using index 
  tablespace TS_YKT_MON
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  -- Create table
create table YKT_MON.MAP_LINES_TABLE
(
  ID         INTEGER not null,
  POINT1     VARCHAR2(16),
  POINT2     VARCHAR2(16),
  LINETYPE   INTEGER,
  LINECOLOR  INTEGER,
  LINESTYLE  INTEGER,
  LINESTATUS INTEGER
)
tablespace TS_YKT_MON
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table YKT_MON.MAP_LINES_TABLE
  add primary key (ID)
  using index 
  tablespace TS_YKT_MON
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  -- Create table
create table YKT_MON.MAP_FATHER_LINE
(
  ID         INTEGER not null,
  SPOINT     VARCHAR2(16),
  EPOINT     VARCHAR2(16),
  SPLAYER    INTEGER,
  EPLAYER    INTEGER,
  LINETYPE   INTEGER,
  LINECOLOR  INTEGER,
  LINESTYLE  INTEGER,
  LINESTATUS INTEGER
)
tablespace TS_YKT_MON
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table YKT_MON.MAP_FATHER_LINE
  add primary key (ID)
  using index 
  tablespace TS_YKT_MON
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  -- Create table
create table YKT_MON.MAP_FATHERSETS_TABLE
(
  ID              INTEGER not null,
  SYSTEMID        VARCHAR2(10),
  OPERATIONSYSTEM VARCHAR2(50),
  SYSTEMNAME      VARCHAR2(50),
  STATUS          INTEGER,
  IP              VARCHAR2(30),
  HOSTNAME        VARCHAR2(60),
  AREA            VARCHAR2(3),
  MACADDRESS      VARCHAR2(25),
  COORDX          NUMBER,
  COORDY          NUMBER,
  FEATURE         VARCHAR2(8)
)
tablespace TS_YKT_MON
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table YKT_MON.MAP_FATHERSETS_TABLE
  add primary key (ID)
  using index 
  tablespace TS_YKT_MON
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  -- Create table
create table YKT_MON.MONITORS
(
  HOST     VARCHAR2(60) not null,
  CATEGORY VARCHAR2(30) not null,
  ENTRY    VARCHAR2(60) not null,
  VALUESTR VARCHAR2(60),
  MODIFIED TIMESTAMP(6) not null
)
tablespace TS_YKT_MON
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table YKT_MON.MONITORS
  add constraint SQL061225110344120 primary key (HOST, CATEGORY, ENTRY)
  using index 
  tablespace TS_YKT_MON
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  -- Create table
create table YKT_MON.MAP_USER_TABLE
(
  ID         INTEGER not null,
  USERNAME   VARCHAR2(30),
  NAME       VARCHAR2(30),
  PASSWORD   VARCHAR2(32),
  GENDER     VARCHAR2(4),
  COMPANY    VARCHAR2(100),
  EMAIL      VARCHAR2(40),
  PHONE      VARCHAR2(30),
  USERROLE   VARCHAR2(4),
  LOGINTIME  VARCHAR2(14),
  USERSTATUS INTEGER,
  ADDUSER    VARCHAR2(30),
  CREATETIME VARCHAR2(14)
)
tablespace TS_YKT_MON
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table YKT_MON.MAP_USER_TABLE
  add primary key (ID)
  using index 
  tablespace TS_YKT_MON
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  -- Create table
create table YKT_MON.MAP_SYS_DICTIONARY
(
  DICT_NO      INTEGER not null,
  DICT_VALUE   VARCHAR2(10) not null,
  DICT_NAME    VARCHAR2(40),
  DICT_CAPTION VARCHAR2(40),
  DICT_CODE    VARCHAR2(50)
)
tablespace TS_YKT_MON
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table YKT_MON.MAP_SYS_DICTIONARY
  add primary key (DICT_NO, DICT_VALUE)
  using index 
  tablespace TS_YKT_MON
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  -- Create table
create table YKT_MON.MAP_STATE_DIC
(
  ID        INTEGER not null,
  STATEID   VARCHAR2(20),
  STATENAME VARCHAR2(60),
  TAGCODE   VARCHAR2(30),
  SHOWCOLOR NUMBER,
  ERRORNOT  NUMBER,
  ERRORCODE VARCHAR2(25)
)
tablespace TS_YKT_MON
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column YKT_MON.MAP_STATE_DIC.ID
  is 'id';
comment on column YKT_MON.MAP_STATE_DIC.STATEID
  is '状态代码';
comment on column YKT_MON.MAP_STATE_DIC.STATENAME
  is '状态名称';
comment on column YKT_MON.MAP_STATE_DIC.TAGCODE
  is 'tag代码';
comment on column YKT_MON.MAP_STATE_DIC.SHOWCOLOR
  is '颜色';
comment on column YKT_MON.MAP_STATE_DIC.ERRORNOT
  is '是否标记为错误';
comment on column YKT_MON.MAP_STATE_DIC.ERRORCODE
  is '错误代码';
-- Create/Recreate primary, unique and foreign key constraints 
alter table YKT_MON.MAP_STATE_DIC
  add constraint MAPSTATEID primary key (ID)
  using index 
  tablespace TS_YKT_MON
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  -- Create table
create table YKT_MON.MAP_SETS_TABLE
(
  ID        INTEGER not null,
  DEVID     INTEGER,
  SETSID    VARCHAR2(16),
  SETNAME   VARCHAR2(50),
  FATHERID  VARCHAR2(16),
  SETTYPE   VARCHAR2(8),
  SETSTATUS INTEGER,
  XCOOR     NUMBER,
  YCOOR     NUMBER,
  FEATURE   VARCHAR2(30)
)
tablespace TS_YKT_MON
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table YKT_MON.MAP_SETS_TABLE
  add primary key (ID)
  using index 
  tablespace TS_YKT_MON
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  -- Create table
create table YKT_MON.MAP_SERVICE_TABLE
(
  SERVICE_ID   INTEGER not null,
  SERVICE_NAME VARCHAR2(50),
  SERVER_ID    INTEGER,
  SERVER_NAME  VARCHAR2(50),
  SERVICE_TYPE VARCHAR2(30),
  URL          VARCHAR2(60),
  IP           VARCHAR2(60),
  PORT         INTEGER,
  DBNAME       VARCHAR2(60),
  USERNAME     VARCHAR2(30),
  PASSWORD     VARCHAR2(30)
)
tablespace TS_YKT_MON
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table YKT_MON.MAP_SERVICE_TABLE
  add constraint SQL061225110658390 primary key (SERVICE_ID)
  using index 
  tablespace TS_YKT_MON
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  -- Create table
create table YKT_MON.MAP_SERVICE_EXCEPTION
(
  ANALYSISTIME CHAR(14) not null,
  SERVICE_ID   INTEGER not null,
  SERVER_ID    INTEGER,
  SERVER_NAME  VARCHAR2(60),
  SERVICE_TYPE VARCHAR2(20),
  STATUS       VARCHAR2(8),
  CONTACTNAME  VARCHAR2(50),
  ERRORCODE    INTEGER
)
tablespace TS_YKT_MON
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table YKT_MON.MAP_SERVICE_EXCEPTION
  add primary key (ANALYSISTIME, SERVICE_ID)
  using index 
  tablespace TS_YKT_MON
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  -- Create table
create table YKT_MON.MAP_SERIALOST_TABLE
(
  ANALYSISTIME  VARCHAR2(14) not null,
  SERIAL_NO     INTEGER not null,
  DEVICE_ID     CHAR(8) not null,
  TX_DATE       VARCHAR2(8) not null,
  TX_TIME       VARCHAR2(6) not null,
  CONTACTNAME   VARCHAR2(50),
  SERIAL_REASON INTEGER not null,
  SERIAL_STATUS INTEGER not null
)
tablespace TS_YKT_MON
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table YKT_MON.MAP_SERIALOST_TABLE
  add primary key (ANALYSISTIME, SERIAL_NO, DEVICE_ID)
  using index 
  tablespace TS_YKT_MON
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );