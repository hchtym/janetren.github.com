/*==============================================================*/
/* Table: T_DOOR_EVENTS_HIS                                     */
/*==============================================================*/
create table YKT_HIS.T_DOOR_EVENTS_HIS  (
   DEVICE_ID            NUMBER                          not null,
   EVENT_CODE           NUMBER                          not null,
   TX_DATE              CHAR(8)                         not null,
   TX_TIME              CHAR(6)                         not null,
   SYSID                NUMBER,
   EVENT_MSG            VARCHAR2(255),
   COL_DATE             CHAR(8),
   COL_TIME             CHAR(6),
   TRANS_YEAR           CHAR(4)                         not null,
   TRANS_MON_DAY        CHAR(4)                         not null,
   constraint PK_T_DOOR_EVENTS_HIS primary key (DEVICE_ID, EVENT_CODE, TX_DATE, TX_TIME, TRANS_YEAR, TRANS_MON_DAY)
         
   using index
       pctfree 10
       initrans 2
       maxtrans 255
       tablespace TS_YKT_HIS
       storage
       (
           initial 64K
           minextents 1
           maxextents unlimited
       )
        logging
)
  partition by range
 ( TRANS_MON_DAY )
    (
  partition
             PART_01
            values less than ( '0201' )
            tablespace TS_YKT_HIS01
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_02
            values less than ( '0301' )
            tablespace TS_YKT_HIS02
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_03
            values less than ( '0401' )
            tablespace TS_YKT_HIS03
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_04
            values less than ( '0501' )
            tablespace TS_YKT_HIS04
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_05
            values less than ( '0601' )
            tablespace TS_YKT_HIS05
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_06
            values less than ( '0701' )
            tablespace TS_YKT_HIS06
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_07
            values less than ( '0801' )
            tablespace TS_YKT_HIS07
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_08
            values less than ( '0901' )
            tablespace TS_YKT_HIS08
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_09
            values less than ( '1001' )
            tablespace TS_YKT_HIS09
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_10
            values less than ( '1101' )
            tablespace TS_YKT_HIS10
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_11
            values less than ( '1201' )
            tablespace TS_YKT_HIS11
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_12
            values less than ( MAXVALUE )
            tablespace TS_YKT_HIS12
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            )
    )
monitoring
  noparallel;

  /*==============================================================*/
/* Table: T_DOOR_TXDTL_HIS                                      */
/*==============================================================*/
create table YKT_HIS.T_DOOR_TXDTL_HIS  (
   DEVICE_ID            NUMBER                          not null,
   TX_DATE              CHAR(8)                         not null,
   TX_TIME              CHAR(6)                         not null,
   PHYCARD_NO           CHAR(8)                         not null,
   SERIAL_NO            NUMBER,
   CUST_ID				INTEGER,
   CARD_NO              NUMBER,
   TX_MARK              NUMBER,
   CRC                  CHAR(5),
   SYS_ID               NUMBER,
   COL_DATE             CHAR(8),
   COL_TIME             CHAR(6),
   COMMENTS             VARCHAR2(255),
   TRANS_YEAR           CHAR(4)                         not null,
   TRANS_MON_DAY        CHAR(4)                         not null,
   constraint P_KEYDOOR_TXDTL_Q1 primary key (DEVICE_ID, TX_DATE, TX_TIME, PHYCARD_NO, TRANS_YEAR, TRANS_MON_DAY)
         using index
       pctfree 10
       initrans 2
       maxtrans 255
       tablespace TS_YKT_HIS
       storage
       (
           initial 64K
           minextents 1
           maxextents unlimited
       )
        logging
)
  partition by range
 ( TRANS_MON_DAY )
    (
  partition
             PART_01
            values less than ( '0201' )
            tablespace TS_YKT_HIS01
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_02
            values less than ( '0301' )
            tablespace TS_YKT_HIS02
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_03
            values less than ( '0401' )
            tablespace TS_YKT_HIS03
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_04
            values less than ( '0501' )
            tablespace TS_YKT_HIS04
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_05
            values less than ( '0601' )
            tablespace TS_YKT_HIS05
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_06
            values less than ( '0701' )
            tablespace TS_YKT_HIS06
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_07
            values less than ( '0801' )
            tablespace TS_YKT_HIS07
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_08
            values less than ( '0901' )
            tablespace TS_YKT_HIS08
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_09
            values less than ( '1001' )
            tablespace TS_YKT_HIS09
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_10
            values less than ( '1101' )
            tablespace TS_YKT_HIS10
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_11
            values less than ( '1201' )
            tablespace TS_YKT_HIS11
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_12
            values less than ( MAXVALUE )
            tablespace TS_YKT_HIS12
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            )
    )
monitoring
  noparallel;


/*==============================================================*/
/* Table: T_TIF_RCVDTL_HIS                                      */
/*==============================================================*/
create table YKT_HIS.T_TIF_RCVDTL_HIS  (
   TX_DATE              CHAR(8)                         not null,
   TX_TIME              CHAR(6)                         not null,
   CARD_NO              NUMBER                          not null,
   DEVICE_ID            CHAR(8)                         not null,
   SERIAL_NO            NUMBER                          not null,
   PURSE_NO             NUMBER,
   IN_BALA              NUMBER,
   OUT_BALA             NUMBER,
   AMOUNT               NUMBER,
   TOTAL_CNT            NUMBER,
   TX_CODE              NUMBER,
   TX_MARK              NUMBER,
   COMU_VER             NUMBER,
   RUN_REASON           NUMBER,
   CRC                  CHAR(4),
   INPOWER_NO           CHAR(8),
   SYS_ID               NUMBER,
   OPER_NO              CHAR(8),
   STATUS               CHAR,
   COL_TIMESTAMP        CHAR(20),
   DEAL_DATE            CHAR(8),
   DEAL_TIME            CHAR(6),
   FEE_CODE             NUMBER,
   ERR_CODE             NUMBER,
   TRANS_YEAR           CHAR(16 char),
   TRANS_MON_DAY        CHAR(16 char),
   constraint P_KEY_2 primary key (SERIAL_NO, TX_DATE, DEVICE_ID, CARD_NO)
         using index
       pctfree 10
       initrans 2
       maxtrans 255
       tablespace TS_YKT_HIS
       storage
       (
           initial 64K
           minextents 1
           maxextents unlimited
       )
        logging
)
  partition by range
 ( TRANS_MON_DAY )
    (
  partition
             PART_01
            values less than ( '0401' )
            tablespace TS_YKT_HIS01
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_02
            values less than ( '0701' )
            tablespace TS_YKT_HIS02
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_03
            values less than ( '1001' )
            tablespace TS_YKT_HIS03
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_04
            values less than ( MAXVALUE )
            tablespace TS_YKT_HIS04
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            )
    )
monitoring
  noparallel;

/*==============================================================*/
/* Table: T_TIF_TRADELOG_HIS                                    */
/*==============================================================*/
create table YKT_HIS.T_TIF_TRADELOG_HIS  (
   BAK_DATE             VARCHAR2(10)                    not null,
   BAK_TIME             VARCHAR2(8)                     not null,
   SERINO               NUMBER                          not null,
   SERI_TYPE            NUMBER                          not null,
   FEE_TYPE             NUMBER                          not null,
   ACT_ID               CHAR(16)                        not null,
   SUBNO                VARCHAR2(20),
   OTHER_ACTID          CHAR(16),
   OTHER_SUBNO          VARCHAR2(20),
   OUTORIN              NUMBER,
   OP_FEE               NUMBER(15,6),
   NEW_FEE              NUMBER(15,6),
   WARRANT_TYPE         NUMBER,
   WARRANT_NO           VARCHAR2(20),
   OPERATE_DATE         VARCHAR2(10),
   OPERATE_TIME         VARCHAR2(8),
   COLLECT_DATE         VARCHAR2(10),
   COLLECT_TIME         VARCHAR2(8),
   ENTERACT_DATE        VARCHAR2(10),
   ENTERACT_TIME        VARCHAR2(8),
   MAINDEVICE_ID        NUMBER,
   DEVICE_ID            NUMBER,
   ANNEX                NUMBER                          not null,
   RECORD_OPER          VARCHAR2(10),
   CHECK_OPER           VARCHAR2(10),
   WRITE_OPER           VARCHAR2(10),
   RESERVE_1            VARCHAR2(20),
   RESERVE_2            VARCHAR2(20),
   RESERVE_3            VARCHAR2(20),
   COMMENTS             VARCHAR2(100),
   CUR_FROZEBALA        NUMBER(20,6),
   TRANS_YEAR           CHAR(4),
   TRANS_MON_DAY        CHAR(4),
   constraint PK_T_TIF_TRADELOG_HIS primary key (BAK_DATE, BAK_TIME, SERINO, SERI_TYPE, FEE_TYPE, ACT_ID, ANNEX)
         
   using index
       pctfree 10
       initrans 2
       maxtrans 255
       tablespace TS_YKT_HIS
       storage
       (
           initial 64K
           minextents 1
           maxextents unlimited
       )
        logging
)
  partition by range
 ( TRANS_MON_DAY )
    (
  partition
             PART_01
            values less than ( '0201' )
            tablespace TS_YKT_HIS01
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_02
            values less than ( '0301' )
            tablespace TS_YKT_HIS02
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_03
            values less than ( '0401' )
            tablespace TS_YKT_HIS03
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_04
            values less than ( '0501' )
            tablespace TS_YKT_HIS04
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_05
            values less than ( '0601' )
            tablespace TS_YKT_HIS05
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_06
            values less than ( '0701' )
            tablespace TS_YKT_HIS06
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_07
            values less than ( '0801' )
            tablespace TS_YKT_HIS07
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_08
            values less than ( '0901' )
            tablespace TS_YKT_HIS08
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_09
            values less than ( '1001' )
            tablespace TS_YKT_HIS09
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_10
            values less than ( '1101' )
            tablespace TS_YKT_HIS10
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_11
            values less than ( '1201' )
            tablespace TS_YKT_HIS11
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_12
            values less than ( MAXVALUE )
            tablespace TS_YKT_HIS12
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            )
    )
monitoring
  noparallel;

 /*==============================================================*/
/* Table: T_TIF_TRADESERIAL_HIS                                 */
/*==============================================================*/
create table YKT_HIS.T_TIF_TRADESERIAL_HIS  (
   BAK_DATE             VARCHAR2(10)                    not null,
   BAK_TIME             VARCHAR2(8)                     not null,
   SERIAL_NO            NUMBER                          not null,
   OTHER_SERI_NO        NUMBER,
   SERIAL_TYPE          NUMBER,
   SERIAL_STATE         NUMBER,
   OPERATE_DATE         VARCHAR2(10),
   OPERATE_TIME         VARCHAR2(8),
   COLLECT_DATE         VARCHAR2(10),
   COLLECT_TIME         VARCHAR2(8),
   ENTERACT_DATE        VARCHAR2(10),
   ENTERACT_TIME        VARCHAR2(8),
   MAINDEVICE_ID        NUMBER,
   DEVICE_ID            NUMBER,
   DEVPHY999_ID         VARCHAR2(8),
   SHOWID               CHAR(10),
   CARD_ID              NUMBER,
   PURSE_ID             NUMBER,
   TRADE_COUNT          NUMBER,
   TRADE_FEE            NUMBER(15,6),
   IN_BALANCE           NUMBER(9,2),
   OUT_BALANCE          NUMBER(9,2),
   DEPOSIT_FEE          NUMBER(9,2),
   IN_FEE               NUMBER(9,2),
   COST_FEE             NUMBER(9,2),
   BOARDFEE             NUMBER(9,2),
   OLDPWD               VARCHAR2(32),
   NEWPWD               VARCHAR2(32),
   CUSTOMER_ID          NUMBER,
   OPER_CODE            VARCHAR2(10),
   OUT_ACCOUNT_ID       CHAR(16),
   IN_ACCOUNT_ID        CHAR(16),
   B_ACT_ID             VARCHAR2(40),
   SYS_ID               NUMBER,
   CONDITION_ID         NUMBER,
   IS_ONLINE            CHAR,
   TMARK                NUMBER,
   DEV_AUTH             CHAR(8),
   COMU_VER             NUMBER,
   RUN_REASON           NUMBER,
   CRC                  CHAR(5),
   ECODE                NUMBER,
   REVISESERIAL_NO      NUMBER,
   RESERVE_1            VARCHAR2(40),
   RESERVE_2            VARCHAR2(40),
   RESERVE_3            VARCHAR2(40),
   TRANS_YEAR           CHAR(4),
   TRANS_MON_DAY        CHAR(4),
   constraint PK_T_TIF_TRADESERIAL_HIS primary key (BAK_DATE, BAK_TIME, SERIAL_NO)
         
   using index
       pctfree 10
       initrans 2
       maxtrans 255
       tablespace TS_YKT_HIS
       storage
       (
           initial 64K
           minextents 1
           maxextents unlimited
       )
        logging
)
  partition by range
 ( TRANS_MON_DAY )
    (
  partition
             PART_01
            values less than ( '0201' )
            tablespace TS_YKT_HIS01
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_02
            values less than ( '0301' )
            tablespace TS_YKT_HIS02
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_03
            values less than ( '0401' )
            tablespace TS_YKT_HIS03
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_04
            values less than ( '0501' )
            tablespace TS_YKT_HIS04
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_05
            values less than ( '0601' )
            tablespace TS_YKT_HIS05
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_06
            values less than ( '0701' )
            tablespace TS_YKT_HIS06
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_07
            values less than ( '0801' )
            tablespace TS_YKT_HIS07
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_08
            values less than ( '0901' )
            tablespace TS_YKT_HIS08
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_09
            values less than ( '1001' )
            tablespace TS_YKT_HIS09
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_10
            values less than ( '1101' )
            tablespace TS_YKT_HIS10
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_11
            values less than ( '1201' )
            tablespace TS_YKT_HIS11
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            ),
  partition
             PART_12
            values less than ( MAXVALUE )
            tablespace TS_YKT_HIS12
             logging
            storage
            (
                initial 64K
                minextents 1
                maxextents unlimited
            )
    )
monitoring
  noparallel;


-- ÀúÊ·¿âË÷Òý

CREATE INDEX YKT_HIS.INDEX_T1
  ON YKT_HIS.T_TIF_TRADESERIAL_HIS
 ("SERIAL_STATE" ASC,
  "SERIAL_TYPE"  ASC,
  "BAK_DATE"     ASC,
  "CUSTOMER_ID"  ASC,
  "TRADE_FEE"    ASC
 );

CREATE INDEX YKT_HIS.IDX_ACC1
  ON YKT_HIS.T_TIF_TRADELOG_HIS
 ("ACT_ID"       ASC,
  "OPERATE_DATE" ASC,
  "OPERATE_TIME" ASC
 );

CREATE INDEX YKT_HIS.IDX_CARD1
  ON YKT_HIS.T_TIF_TRADESERIAL_HIS
 ("CARD_ID" ASC
 );

CREATE INDEX YKT_HIS.IDX_CUTID1
  ON YKT_HIS.T_TIF_TRADESERIAL_HIS
 ("CUSTOMER_ID" ASC
 );

CREATE INDEX YKT_HIS.IDX_DATE1
  ON YKT_HIS.T_TIF_TRADESERIAL_HIS
 ("OPERATE_DATE" ASC
 );

CREATE INDEX YKT_HIS.IDX_DEVICE1
  ON YKT_HIS.T_TIF_TRADESERIAL_HIS
 ("DEVPHY999_ID" ASC
 );


CREATE INDEX YKT_HIS.IDX_RTL_STATUS
  ON YKT_HIS.T_TIF_RCVDTL_HIS
 ("STATUS" ASC
 );


CREATE INDEX YKT_HIS.IDX_TS_EC
  ON YKT_HIS.T_TIF_RCVDTL_HIS
 ("COL_TIMESTAMP" ASC,
  "ERR_CODE"      ASC
 ) REVERSE ;


CREATE INDEX YKT_HIS.INDEX_TX_DATE
  ON YKT_HIS.T_TIF_RCVDTL_HIS
 ("TX_DATE" ASC,
  "CARD_NO" ASC
 );

CREATE INDEX YKT_HIS.INX_DT_Q1_CARD
  ON YKT_HIS.T_DOOR_TXDTL_HIS
 ("CARD_NO" ASC
 )REVERSE;


CREATE UNIQUE INDEX YKT_HIS.P_KEY_DT
  ON YKT_HIS.T_DOOR_TXDTL_HIS
 ("DEVICE_ID" ASC,
  "TX_DATE"   ASC
 );




CREATE INDEX YKT_HIS.SERIAL_STAT1
  ON YKT_HIS.T_TIF_TRADESERIAL_HIS
 ("SERIAL_TYPE" ASC,
  "OPERATE_DATE" ASC,
  "OPERATE_TIME" ASC,
  "DEVPHY999_ID" ASC,
  "SYS_ID"      ASC
 );

create index YKT_HIS.IDX_DR_CUST_ID on YKT_HIS.T_DOOR_TXDTL_HIS (
   CUST_ID ASC
);


grant select, insert, update, delete, references, alter, index on YKT_HIS.T_TIF_TRADELOG_HIS to YKT_CUR;
grant select, insert, update, delete on YKT_HIS.T_TIF_TRADESERIAL_HIS to YKT_CUR;