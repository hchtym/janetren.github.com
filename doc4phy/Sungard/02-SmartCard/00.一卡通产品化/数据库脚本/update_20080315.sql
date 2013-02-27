CREATE TABLESPACE TS_YKT_CK DATAFILE 
  '/opt/oracle/oradata/YKTDB/ts_ykt_ck.dbf' SIZE 100M AUTOEXTEND ON NEXT 8M MAXSIZE UNLIMITED
LOGGING
ONLINE
PERMANENT
EXTENT MANAGEMENT LOCAL AUTOALLOCATE
BLOCKSIZE 8K
SEGMENT SPACE MANAGEMENT AUTO
FLASHBACK OFF;


CREATE USER YKT_CK
  IDENTIFIED BY VALUES '769901546728B440'
  DEFAULT TABLESPACE TS_YKT_CK
  TEMPORARY TABLESPACE TEMP
  PROFILE DEFAULT
  ACCOUNT UNLOCK;
  -- 1 Role for YKT_CK 
  GRANT CONNECT TO YKT_CK;
  ALTER USER YKT_CK DEFAULT ROLE ALL;
  -- 1 Tablespace Quota for YKT_CK 
  ALTER USER YKT_CK QUOTA UNLIMITED ON TS_YKT_CK;

 

CREATE TABLE YKT_CK.T_ATTSERIAL
(
  SERIAL_ID    INTEGER                          NOT NULL,
  DEVICE_ID    INTEGER                          NOT NULL,
  CUST_ID      INTEGER,
  CARD_ID      INTEGER,
  PHY_ID       VARCHAR2(20 BYTE),
  SHOW_CARDNO  VARCHAR2(20 BYTE),
  ATT_DATE     VARCHAR2(8 BYTE),
  ATT_TIME     VARCHAR2(6 BYTE),
  TX_MARK      INTEGER,
  STATUS       CHAR(1 BYTE)
)
TABLESPACE TS_YKT_CK
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;

COMMENT ON TABLE YKT_CK.T_ATTSERIAL IS '考勤流水表';

COMMENT ON COLUMN YKT_CK.T_ATTSERIAL.SERIAL_ID IS '流水号';

COMMENT ON COLUMN YKT_CK.T_ATTSERIAL.DEVICE_ID IS '设备编号';

COMMENT ON COLUMN YKT_CK.T_ATTSERIAL.CUST_ID IS '客户号';

COMMENT ON COLUMN YKT_CK.T_ATTSERIAL.CARD_ID IS '卡号';

COMMENT ON COLUMN YKT_CK.T_ATTSERIAL.PHY_ID IS '物理卡号';

COMMENT ON COLUMN YKT_CK.T_ATTSERIAL.SHOW_CARDNO IS '显示卡号';

COMMENT ON COLUMN YKT_CK.T_ATTSERIAL.ATT_DATE IS '打卡日期';

COMMENT ON COLUMN YKT_CK.T_ATTSERIAL.ATT_TIME IS '打卡时间';

COMMENT ON COLUMN YKT_CK.T_ATTSERIAL.TX_MARK IS '交易标记';

COMMENT ON COLUMN YKT_CK.T_ATTSERIAL.STATUS IS '状态';


CREATE INDEX YKT_CK.IDX_1 ON YKT_CK.T_ATTSERIAL
(CUST_ID, ATT_DATE)
LOGGING
TABLESPACE TS_YKT_CK
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX YKT_CK.P_KEY_1 ON YKT_CK.T_ATTSERIAL
(SERIAL_ID, DEVICE_ID)
LOGGING
TABLESPACE TS_YKT_CK
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


ALTER TABLE YKT_CK.T_ATTSERIAL ADD (
  CONSTRAINT P_KEY_1
 PRIMARY KEY
 (SERIAL_ID, DEVICE_ID)
    USING INDEX 
    TABLESPACE TS_YKT_CK
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));



alter table ykt_cur.t_pif_tradecode add (account_flag integer default 2 not null);

create or replace view YKT_CUR.V_BLKLST as
select
       a.CARD_ID,
       a.IS_AD,
       a.VOLUME,
       c.PHYSICAL_NO,
       c.cosumer_id
    from
       YKT_CUR.T_TIF_BLACK_SHEET a,
       (select card_id,max(volume) as max_volume from ykt_cur.T_TIF_BLACK_SHEET where (is_ad = 0 or is_ad = 1) group by card_id) b,
       YKT_CUR.T_PIF_CARD c
    where
       a.CARD_ID = b.card_id
       and a.VOLUME = b.max_volume
       and a.CARD_ID = c.CARD_ID
union all
select
       a.CARD_ID,
       a.IS_AD,
       a.VOLUME,
       c.CARD_PHYID,
       0
    from
       YKT_CUR.T_TIF_BLACK_SHEET a,
       (select card_id,max(volume) as max_volume from ykt_cur.T_TIF_BLACK_SHEET where (is_ad = 0 or is_ad = 1) group by card_id) b,
       YKT_CUR.T_PIF_OPER_AUTHCARD c
    where
       a.CARD_ID = b.card_id
       and a.VOLUME = b.max_volume
       and a.CARD_ID = c.CARD_ID;

	   
delete from ykt_cur.T_PIF_CUR_SYSPARA where id>=4000 and id<=4005;

ALTER TABLE YKT_CUR.T_AIF_ACCOUNT
ADD (RESERVE_BALA NUMBER(15,6));


drop table YKT_CUR.T_TIF_REPORT_SHOP_BALANCE;

create table YKT_CUR.T_TIF_REPORT_SHOP_BALANCE  (
   BALANCE_DATE         VARCHAR2(10)                    not null,
   SHOP_ID              NUMBER                          not null,
   SHOP_NAME            VARCHAR2(50),
   DEPT_ID              NUMBER,
   TRADE_NUM            NUMBER,
   TRADE_AMT            NUMBER(15,6),
   MNG_AMT              NUMBER(15,6),
   TOTAL_AMT            NUMBER(15,6),
   DATA_SIGN            VARCHAR2(8),
   RESERVE1             VARCHAR2(20),
   RESERVE2             VARCHAR2(20),
   OUTORIN				NUMBER NOT NULL,
   SERI_TYPE			NUMBER NOT NULL,
   constraint SYS_C007211 primary key (BALANCE_DATE, SHOP_ID,OUTORIN,SERI_TYPE)
         
   using index
       pctfree 10
       initrans 2
       maxtrans 255
       tablespace TS_YKT_CUR
       storage
       (
           initial 64K
           minextents 1
           maxextents unlimited
       )
        logging
)
  pctfree 10
initrans 1
maxtrans 255
storage
(
    initial 64K
    minextents 1
    maxextents unlimited
)
tablespace TS_YKT_CUR
logging
monitoring
  noparallel;

  

