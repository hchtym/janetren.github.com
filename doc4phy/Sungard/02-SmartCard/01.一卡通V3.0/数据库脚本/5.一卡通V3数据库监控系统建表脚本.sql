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
  is '���ⲻƽ��';
-- Add comments to the columns 
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.ACCNO
  is '�˺�';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.ANALYSISTIME
  is '����ʱ��';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.ACCNAME
  is '�ʻ���';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.SUBJNO
  is '��Ŀ��';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.ACCPWD
  is '�ʻ�����';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.CUSTID
  is '�ͻ���';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.CARDNO
  is '���׿���';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.PURSENO
  is 'Ǯ����';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.DAYCOSTMAXAMT
  is '�������޶�';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.CARDMAXBAL
  is '�������';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.STOPPAYFLAG
  is 'ֹ����־';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.STATUS
  is '״̬';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.YDAYBAL
  is '�������';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.YDAYAVAILBAL
  is '���տ������';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.YDAYFROZEBAL
  is '���ն������';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.BALANCE
  is '�ʻ����';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.AVAILBAL
  is '�������';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.FROZEBAL
  is '�������';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.SUBSIDYBAL
  is '���첹�����';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.FOREGIFT
  is 'Ѻ��';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.LASTCARDCNT
  is '���¿����״���';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.LASTCARDBAL
  is '���¿����';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.DAYCOSTAMT
  is '���ۼ����ѽ��';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.LASTTRANSDATE
  is '�ϴν�������';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.LASTACCDATE
  is '�ϴ���������';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.SUBSIDYNO
  is '�������κ�';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.OPENDATE
  is '��������';
comment on column YKT_MON.MAP_CAUNBALANCE_TABLE.CLOSEDATE
  is '��������';
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
  is 'YKT_MON.MAP_DEVICE_TABLE-�豸��';
-- Add comments to the columns 
comment on column YKT_MON.MAP_DEVICE_TABLE.ANALYSISTIME
  is '����ʱ��';
comment on column YKT_MON.MAP_DEVICE_TABLE.DEVICEID
  is '�ն˱��Ҳ���豸���';
comment on column YKT_MON.MAP_DEVICE_TABLE.DEVICENAME
  is '�豸����';
comment on column YKT_MON.MAP_DEVICE_TABLE.DEVPHYID
  is '�豸����ID��';
comment on column YKT_MON.MAP_DEVICE_TABLE.DEVTYPECODE
  is '�豸���͡�';
comment on column YKT_MON.MAP_DEVICE_TABLE.FDEVPHYID
  is '�ϼ��豸';
comment on column YKT_MON.MAP_DEVICE_TABLE.RUNSTATUS
  is '����״̬';
comment on column YKT_MON.MAP_DEVICE_TABLE.STATUS
  is '״̬:1-����2-ע��';
comment on column YKT_MON.MAP_DEVICE_TABLE.IP
  is 'IP��ַ';
comment on column YKT_MON.MAP_DEVICE_TABLE.DEVICENO
  is '�豸����';
comment on column YKT_MON.MAP_DEVICE_TABLE.CARDVERNO
  is '���������汾��';
comment on column YKT_MON.MAP_DEVICE_TABLE.SYSID
  is 'ǰ�û�ϵͳID';
comment on column YKT_MON.MAP_DEVICE_TABLE.AREACODE
  is '�������';
comment on column YKT_MON.MAP_DEVICE_TABLE.DEVUSAGE
  is '�豸��;';
comment on column YKT_MON.MAP_DEVICE_TABLE.DEVICETIME
  is '�豸ʱ��';
comment on column YKT_MON.MAP_DEVICE_TABLE.SERVERTIME
  is '������ʱ��';
comment on column YKT_MON.MAP_DEVICE_TABLE.CONTACT_NAME
  is '��ϵ��';
comment on column YKT_MON.MAP_DEVICE_TABLE.CPU
  is 'cpuʹ����';
comment on column YKT_MON.MAP_DEVICE_TABLE.MEMORY
  is '�ڴ�ʹ����';
comment on column YKT_MON.MAP_DEVICE_TABLE.HARDDISK
  is 'Ӳ��ʹ����';
comment on column YKT_MON.MAP_DEVICE_TABLE.ERROR_REASON
  is '�������';
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
  is '�쳣��ˮ��';
-- Add comments to the columns 
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.ANALYSISTIME
  is '����ʱ��';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.TRANSDATE
  is '��������';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.TRANSTIME
  is '����ʱ��';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.DEVPHYID
  is '�豸����ID';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.DEVSEQNO
  is '�豸��ˮ��';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.CARDNO
  is '���׿���';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.PURSENO
  is 'Ǯ����';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.CARDCNT
  is '�����״���';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.CARDBEFBAL
  is '����ǰ�����';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.AMOUNT
  is '������-���������';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.CARDAFTBAL
  is '���׺����';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.MANAGEFEE
  is '�����';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.TRANSMARK
  is '���ױ��';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.TRANSCODE
  is '������';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.SUBSIDYNO
  is '�������κ�';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.BATCHNO
  is '�������κ�';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.SYSID
  is '��ϵͳID';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.COLDATE
  is '�ɼ�����';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.COLTIME
  is '�ɼ�ʱ��';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.ACCDATE
  is '��������';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.ACCTIME
  is '����ʱ��';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.STATUS
  is '״̬-1��ʼ״̬2-����ʧ��3-�ɹ�4-�쳣��ˮ';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.ERRCODE
  is '������';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.ERRMSG
  is '������Ϣ';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.DELFLAG
  is 'ɾ����־';
 comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.CONTACTNAME
  is '��ϵ��';
comment on column YKT_MON.MAP_SERIALEXCEPT_TABLE.ABNORMALTYPE
  is '�������';
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
  is '״̬����';
comment on column YKT_MON.MAP_STATE_DIC.STATENAME
  is '״̬����';
comment on column YKT_MON.MAP_STATE_DIC.TAGCODE
  is 'tag����';
comment on column YKT_MON.MAP_STATE_DIC.SHOWCOLOR
  is '��ɫ';
comment on column YKT_MON.MAP_STATE_DIC.ERRORNOT
  is '�Ƿ���Ϊ����';
comment on column YKT_MON.MAP_STATE_DIC.ERRORCODE
  is '�������';
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