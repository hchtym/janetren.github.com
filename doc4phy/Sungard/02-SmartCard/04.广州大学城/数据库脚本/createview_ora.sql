/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     2007-6-13 15:35:23                           */
/*==============================================================*/


/*==============================================================*/
/* View: V_BLKLST                                               */
/*==============================================================*/
CREATE OR REPLACE VIEW V_BLKLST
(CARD_ID, IS_AD, VOLUME, PHYSICAL_NO, COSUMER_ID)
AS 
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
	   and a.CARD_ID = c.CARD_ID;

/*==============================================================*/
/* View: V_CARDLST                                              */
/*==============================================================*/
CREATE OR REPLACE VIEW V_CARDLST
(CARD_ID, IS_AD, VOLUME, PHYSICAL_NO, COSUMER_ID, 
 STUEMP_NO)
AS 
select
		    a.CARD_ID,
		    a.IS_AD,
		    a.VOLUME,
		    c.PHYSICAL_NO,
		     c.cosumer_id,
		  d.stuemp_no
		 from
		    YKT_CUR.T_TIF_BLACK_SHEET a,
		    (select card_id,max(volume) as max_volume ,( case is_ad when 9 then 1 else 2 end) as ftype from ykt_cur.T_TIF_BLACK_SHEET group by card_id,( case is_ad when 9 then 1 else 2 end)) b,
		    YKT_CUR.T_PIF_CARD c,
		    ykt_cur.t_cif_customer d
		 where
		    a.CARD_ID = b.card_id
		    and a.VOLUME = b.max_volume
		    and a.CARD_ID = c.CARD_ID
		    and c.cosumer_id=d.cut_id;

/*==============================================================*/
/* View: V_CIF_SHOP                                             */
/*==============================================================*/
CREATE OR REPLACE VIEW V_CIF_SHOP
(NU, SHOP_ID, CUT_ID, DEPT_ID, SHOP_NAME, 
 SHOP_TYPE, IS_INDEP, IS_LEAF, SHOP_STATE, SHOP_MANAGER, 
 MAN, SEX, NATION, MAN_ID, TEL, 
 ADDRESS, IS_GETFEE, RATIO, MANAGER_TYPE, DUTY_TYPE, 
 REG_TIME, COMMENTS, FAT_SHOP_NAME, AREA, CLASSDEPT_NO, 
 RAKEOFF_RATIO, RAKEOFF_TYPE)
AS 
select replace(sys_connect_by_path(dept_id,':'),':','') as nu,shop_id,cut_id,dept_id,shop_name,shop_type,is_indep,is_leaf,
 shop_state,shop_manager,man,sex,nation,man_id,tel,address,is_getfee, ratio
 ,manager_type,duty_type,reg_time,comments,fat_shop_name,area, classdept_no,rakeoff_ratio,rakeoff_type
from YKT_CUR.V_cif_shop_tmp T
CONNECT BY PRIOR  shop_id=dept_id
START WITH shop_id =1;

/*==============================================================*/
/* View: V_CIF_SHOP_TMP                                         */
/*==============================================================*/
CREATE OR REPLACE VIEW V_CIF_SHOP_TMP
(SHOP_ID, CUT_ID, DEPT_ID, SHOP_NAME, SHOP_TYPE, 
 IS_INDEP, IS_LEAF, SHOP_STATE, SHOP_MANAGER, MAN, 
 SEX, NATION, MAN_ID, TEL, ADDRESS, 
 IS_GETFEE, RATIO, MANAGER_TYPE, DUTY_TYPE, REG_TIME, 
 COMMENTS, FAT_SHOP_NAME, RAKEOFF_RATIO, RAKEOFF_TYPE, AREA, 
 CLASSDEPT_NO)
AS 
select a.shop_id, a.cut_id, a.dept_id, a.shop_name, a.shop_type,a.is_indep,
 a.is_leaf, a.shop_state, a.shop_manager, a.man, a.sex,a.nation, a.man_id,
 a.tel, a.address, a.is_getfee, a.ratio, a.manager_type,a.duty_type,
 a.reg_time,a.comments,a.fat_shop_name,a.rakeoff_ratio,a.rakeoff_type,b.area,b.classdept_no
 from (
 select c.shop_id, c.cut_id, c.dept_id, c.shop_name, c.shop_type,c.is_indep
 , c.is_leaf, c.shop_state, c.shop_manager, c.man, c.sex,c.nation,
 c.man_id, c.tel, c.address, c.is_getfee, c.ratio, c.manager_type,
 c.duty_type, c.reg_time,c.comments,d.shop_name as fat_shop_name,c.rakeoff_ratio,c.rakeoff_type
 from ykt_cur.t_cif_shop c
 left outer join ykt_cur.t_cif_shop d
 on c.dept_id=d.shop_id ) a, (
 select e.shop_id,f.area,f.classdept_no
 from ykt_cur.t_cif_shop e
 left outer join ykt_cur.t_cif_customer f
 on e.cut_id=f.cut_id ) b
 where a.shop_id=b.shop_id;

/*==============================================================*/
/* View: V_CIF_SHOP_TREE                                        */
/*==============================================================*/
CREATE OR REPLACE VIEW V_CIF_SHOP_TREE
(SHOP_ID, SHOP_NAME, DEPT_ID, LEAF_ID, LEAF_NAME, 
 IS_INDEP, IS_LEAF, DEPTH)
AS 
SELECT t.shop_id,t.shop_name,t.dept_id,a.shop_id,a.shop_name leaf_name,t.is_indep,t.is_leaf,t.lev
FROM 
	  (
		SELECT FIRST_VALUE (shop_id) OVER (PARTITION BY part ORDER BY lev) leaf_id,shop_id,
               ROW_NUMBER () OVER (PARTITION BY part ORDER BY lev DESC) rn,lev,
               part, dept_id AS dept_id,shop_name,is_indep,is_leaf
        FROM (
			  SELECT shop_id, dept_id, LEVEL lev, (ROWNUM - LEVEL) part,shop_name,is_indep,is_leaf
              FROM ykt_cur.t_cif_shop
              CONNECT BY shop_id = PRIOR dept_id
			  --start with is_leaf='1'
			 )
		) t
left join 
		ykt_cur.t_cif_shop a
on t.leaf_id=a.shop_id
		where a.is_leaf=1
		order by t.shop_id,lev;

/*==============================================================*/
/* View: V_CUT_CARD_INFO                                        */
/*==============================================================*/
CREATE OR REPLACE VIEW V_CUT_CARD_INFO
(CARD_ID, PHYSICAL_NO, STUEMP_NO, CLASSDEPT_NO, S_CODE, 
 SEX, CUT_TYPE, FEE_TYPE, END_TIME, CUT_STATE, 
 VOLUME, FLAG, CUT_NAME)
AS 
select
	   cd.CARD_ID,
	   cd.PHYSICAL_NO,
	   cut.STUEMP_NO,
	   cut.CLASSDEPT_NO,
	   cut.S_CODE,
	   cut.SEX,
	   cut.CUT_TYPE,
	   cut.FEE_TYPE,
	   cd.END_TIME,
	   cut.CUT_STATE,
	   ci.VOLUME,
	   ci.FLAG,
	   cut.CUT_NAME
	from
	   YKT_CUR.T_PIF_CARD cd,
	   YKT_CUR.T_CIF_CUSTOMER cut,
	   YKT_CUR.T_TIF_CUT_INFO_UPDATE ci
	where
	   cd.COSUMER_ID = cut.CUT_ID
	   and cd.CARD_ID = ci.CARD_ID;

/*==============================================================*/
/* View: V_DICTIONARY                                           */
/*==============================================================*/
CREATE OR REPLACE VIEW V_DICTIONARY
(DICT_NO, DICT_VALUE, DICT_CAPTION)
AS 
(SELECT dict_no, dict_value, dict_caption FROM ykt_cur.T_PIF_dictionary)
union all
(select -55 DICT_NO,to_char(txtype) DICT_VALUE,txname DICT_CAPTION from t_tif_cfgsplit);

/*==============================================================*/
/* View: V_PIF_DEVICE                                           */
/*==============================================================*/
CREATE OR REPLACE VIEW V_PIF_DEVICE
(NU, DEVICE_ID, DEVICE_NAME, DEV999_ID, DEVPHY999_ID, 
 DEV999_NO, DEVTYPE, DEVVERSION, CARDSTR, CARDTYPE, 
 PORTCOUNT, FDEV_ID, PORTNO, STATE_ID, JOINMODE, 
 COMADD, PORT, BAUDRATE, COMTYPE, BSHEETVDATE, 
 BSHEETVER, LASTTRASERNO, LASTTRADATE, LASTSHUTSERNO, LASTSHUTDATE, 
 SYSPWD, ADMPWD, PWDONOFF, PUSERNO, CARDSET, 
 FUNONOFF, CARDUSENUM, MAXDEPOSIT, MINDEPOSIT, RATION, 
 MAXTRADE, SHUTTIMES, CARD65PWD, AUTHPWD, FTFLAG, 
 FEETYPE, PHYTYPE, WEB_LEVEL, SUBSYSTEM_ID, AREA, 
 INIT_KEY, MANAGER, TEL, ADDRESS, OPERATE_TIME, 
 COMMENTS)
AS 
select replace(sys_connect_by_path(dev999_id,':'),':','') as nu,device_id,device_name,dev999_id,devphy999_id,dev999_no,devtype, devversion,cardstr,cardtype,portcount,fdev_id,portno,state_id, joinmode ,comadd,port,baudrate,comtype,bsheetvdate,bsheetver, lasttraserno , lasttradate,lastshutserno,lastshutdate,syspwd,admpwd, pwdonoff,puserno, cardset,funonoff,cardusenum,maxdeposit,mindeposit, ration,maxtrade, shuttimes,card65pwd,authpwd,ftflag,feetype,phytype, web_level, subsystem_id ,area,init_key,manager,tel,address,operate_time, comments
from YKT_CUR.T_PIF_Device T
CONNECT BY PRIOR  device_id=fdev_id
START WITH device_id =1;

/*==============================================================*/
/* View: V_TIF_ACTTYPE_TRADE                                    */
/*==============================================================*/
CREATE OR REPLACE VIEW V_TIF_ACTTYPE_TRADE
(SUBNO, SUBNAME, SUBTYPE, DIRECT, KIND, 
 FATHER, "LEVEL", ENDFLAG, SERI_TYPE, FEE_TYPE, 
 OUTORIN, OPCOUNT, FEE_CHANGE, SPARE1)
AS 
select S.subno,S.subname,S.subtype,S.direct,S.kind,S.father,S."LEVEL",S.endflag,
 T.Seri_type,T.Fee_type,T.OutOrIn,T.OpCount,T.Fee_Change,s.spare1
 from YKT_CUR.T_TIF_subject S
 left outer join (
 select T.subno,T.Seri_type,T.Fee_type,T.OutOrIn,count(T.Op_Fee) as
 OpCount,SUM(T.Op_Fee) as Fee_Change
 from YKT_CUR.T_TIF_TradeLog T
 group by T.subno,T.Seri_type,T.Fee_type,T.OutOrIn ) T
 on S.subno = T.subno;

/*==============================================================*/
/* View: V_TIF_ACTTYPE_TRADE_OPER                               */
/*==============================================================*/
CREATE OR REPLACE VIEW V_TIF_ACTTYPE_TRADE_OPER
(RECORD_OPER, SUBNO, SUBNAME, SUBTYPE, DIRECT, 
 KIND, FATHER, "LEVEL", ENDFLAG, SERI_TYPE, 
 FEE_TYPE, OUTORIN, OPCOUNT, FEE_CHANGE, SPARE1)
AS 
select T.record_oper,S.subno,S.subname,S.subtype,S.direct,S.kind,S.father,S."LEVEL",S.endflag,
 T.Seri_type,T.Fee_type,T.OutOrIn,T.OpCount,T.Fee_Change,s.spare1
 from YKT_CUR.T_TIF_subject S,
 (select T.record_oper,T.subno,T.Seri_type,T.Fee_type,T.OutOrIn,count(T.Op_Fee) as
 OpCount,SUM(T.Op_Fee) as Fee_Change
 from YKT_CUR.T_TIF_TradeLog T
 group by T.record_oper,T.subno,T.Seri_type,T.Fee_type,T.OutOrIn ) T
 where S.subno = T.subno(+);

/*==============================================================*/
/* View: V_TIF_DEPTSHOP                                         */
/*==============================================================*/
CREATE OR REPLACE VIEW V_TIF_DEPTSHOP
(DEPT_ID, SHOP_ID, SERI_TYPE, FEE_TYPE, OUTORIN, 
 OPCOUNT, FEE_CHANGE)
AS 
select t.Dept_ID,a.Shop_ID,Seri_type,Fee_type,OutOrIn,OpCount,Fee_Change
from
(
 	SELECT FIRST_VALUE (shop_id) OVER (PARTITION BY part ORDER BY lev) leaf_id,shop_id,dept_id
        FROM (SELECT shop_id, dept_id, LEVEL lev, (ROWNUM - LEVEL) part,shop_name,is_indep,is_leaf
              FROM ykt_cur.t_cif_shop
              CONNECT BY PRIOR dept_id=shop_id 
			 )) t
,YKT_CUR.V_TIF_Shop_Act a
where a.shop_id = t.leaf_id
union all
select Shop_ID,Shop_ID,Seri_type,Fee_type,OutOrIn,OpCount,Fee_Change
from YKT_CUR.V_TIF_Shop_Act;

/*==============================================================*/
/* View: V_TIF_REPORT_ACTIVE                                    */
/*==============================================================*/
CREATE OR REPLACE VIEW V_TIF_REPORT_ACTIVE
(SERIAL_TYPE, TRADE_COUNT, ACC_ADD_NUM, ACC_ADD_AMT, SHP_ADD_NUM, 
 SHP_ADD_AMT, DEP_ADD_AMT, EARN_ADD_AMT, IN_AMT, DEPOSIT_AMT, 
 COST_AMT, BANK_ADD_AMT, CASH_ADD_AMT, CHECK_ADD_AMT, OUTLAY_ADD_AMT, 
 DOWN_SUBSIDY_AMT, UP_SUBSIDY_AMT)
AS 
select SERIAL_TYPE,sum(trade_count) trade_count, sum((
 case
 when serial_type=847101
 or serial_type=847116
 or serial_type=847124
 or serial_type=847125
 or serial_type=847126
 then 1
 when serial_type=847105
 then -1
 else 0
 end)*trade_count) acc_add_num, sum(acc_add_amt) acc_add_amt, sum((
 case
 when serial_type=843335
 then 1
 when serial_type=843336
 then -1
 else 0
 end)*trade_count) shp_add_num, sum(shp_add_amt) shp_add_amt,sum(
 dep_add_amt) dep_add_amt, sum(earn_add_amt) earn_add_amt,sum(in_amt)
 in_amt, sum( deposit_amt) deposit_amt, sum(cost_amt) cost_amt, sum(
 bank_add_amt) bank_add_amt, sum(cash_amt) cash_add_amt,sum(check_amt)
 check_add_amt, sum( outlay_amt) outlay_add_amt,sum(down_subsidy_amt)
 down_subsidy_amt, sum( up_subsidy_amt) up_subsidy_amt
 from YKT_CUR.V_TIF_REPORT_OPER
 group by SERIAL_TYPE;

/*==============================================================*/
/* View: V_TIF_REPORT_CARDDB_NOBALANCE                          */
/*==============================================================*/
create or replace view YKT_CUR.V_TIF_REPORT_CARDDB_NOBALANCE as
select a.ACCOUNT_ID, a.CUSTOMER_ID, a.CARD_ID, a.CUT_NAME, a.STUEMP_NO,
	 a.CARD_TYPE, b.CLASSDEPT_NO, a.CUR_FREEBALA db_bala, a.CARD_BALANCE
	 card_bala, a.NOBALA_NUM, (a.cur_freebala-a.card_balance) diff_bala
	 from YKT_CUR.T_AIF_ACCOUNT a,YKT_CUR.T_CIF_CUSTOMER b
	 where a.CUSTOMER_ID=b.CUT_ID
	 and a.CUR_FREEBALA<>a.CARD_BALANCE
	 and a.CARD_ID<>0;

/*==============================================================*/
/* View: V_TIF_REPORT_DEVICE_MEAL                               */
/*==============================================================*/
CREATE OR REPLACE VIEW V_TIF_REPORT_DEVICE_MEAL
(SHOP_ID, DEVICE_ID, MEAL_ID, OUTORIN, TRADE_COUNT, 
 TRADE_FEE, MNG_FEE, TOTAL_FEE)
AS 
select t1.shop_id,t2.device_id,t1.meal_id,outorin,count(t2.op_fee) trade_count,sum(
    t2.op_fee) trade_fee,sum(t2.mng_fee) mng_fee, sum(t2.op_fee)+sum(
    t2.mng_fee) total_fee
  from (
    select e.account_id,b.shop_id,b.meal_id,
        case
          when c.begin_time is null
            then '000000'
          else c.begin_time
        end as begin_time,
        case
          when c.end_time is null
            then '235959'
          else c.end_time
        end as end_time
      from ykt_cur.t_cif_shop_meal b
        left join ykt_cur.t_pif_meal_type c
        on b.meal_id=c.meal_id
        left join ykt_cur.t_cif_shop d
        on b.shop_id=d.shop_id
        left join ykt_cur.t_aif_account e
        on d.cut_id=e.customer_id
      order by b.shop_id,b.meal_id) t1
    left join (
      select act_id,subno,outorin,
          case
            when fee_type=15
              then op_fee
            else null
          end as op_fee,
          case
            when fee_type=10
              then op_fee
            else 0
          end as mng_fee,operate_date,operate_time,device_id
        from YKT_CUR.T_TIF_TRADELOG
        where subno='202'
        order by ACT_ID,device_id,FEE_TYPE,SERI_TYPE) t2
    on t1.account_ID=t2.act_id
    and t2.operate_time>=t1.begin_time
    and t2.operate_time<=t1.end_time
  group by t1.account_id,t1.shop_id,t2.device_id,t1.meal_id,outorin;

/*==============================================================*/
/* View: V_TIF_REPORT_ERRACC                                    */
/*==============================================================*/
create or replace view YKT_CUR.V_TIF_REPORT_ERRACC as
select a.account_id, a.cut_name, a.stuemp_no, a.card_type, a.last_bala,
	 a.cur_bala, b.sum_trade
	 from ykt_cur.T_AIF_Account a
	 left outer join (
	 select act_id,SUM(sum_trade) sum_trade
	 from (
	 select t1.act_id,((
	 case
	 when t2.direct=1
	 then 1
	 else -1
	 end)*((
	 case
	 when t1.outorin=1
	 then 1
	 else -1
	 end)*t1.op_fee)) sum_trade
	 from ykt_cur.T_TIF_TradeLog t1,ykt_cur.T_TIF_subject t2
	 where t1.subno=t2.subno) t
	 group by act_id) b
	 on a.account_id=b.act_id
	 where a.card_type=1
	 and (a.cur_bala-a.last_bala)<>b.sum_trade;

/*==============================================================*/
/* View: V_TIF_REPORT_OPER                                      */
/*==============================================================*/
create or replace view ykt_cur.v_tif_report_oper as
select a.serial_type as serial_type,a.trade_count as trade_count,
  a.maindevice_id as maindevice_id,a.device_id as device_id, a.oper_code as
  oper_code,b.trade_amt as trade_amt, b.acc_add_amt as acc_add_amt,
  b.shp_add_amt as shp_add_amt,b.dep_add_amt as dep_add_amt, b.earn_add_amt
  as earn_add_amt,b.bank_add_amt as bank_add_amt, b.deposit_amt as
  deposit_amt,b.in_amt as in_amt,b.cost_amt as cost_amt, b.cash_amt as
  cash_amt,b.check_amt as check_amt,b.outlay_amt as outlay_amt,
  b.down_subsidy_amt as down_subsidy_amt,b.up_subsidy_amt as up_subsidy_amt
  from (
  select a.serial_type,count(a.serial_no) trade_count,a.maindevice_id,
  a.device_id,(CASE WHEN A.SERIAL_TYPE=847127 THEN A.RESERVE_1 ELSE a.oper_code END) OPER_CODE
  from ykt_cur.T_TIF_tradeserial a
  group by a.serial_type,a.maindevice_id,a.device_id,a.oper_code,A.RESERVE_1 ) a
  left outer join (
  select t.seri_type,t.maindevice_id,t.device_id,t.record_oper, sum(
  t.op_count) op_count,sum(t.trade_amt) trade_amt, sum(acc_add_amt)
  acc_add_amt,sum(shp_add_amt) shp_add_amt,sum(dep_add_amt)
  dep_add_amt, sum(earn_add_amt) earn_add_amt,sum(bank_add_amt)
  bank_add_amt, sum(t.deposit_amt) deposit_amt,sum(t.in_amt) in_amt,
  sum(t.cost_amt) cost_amt,sum(t.cash_amt) cash_amt,sum(t.check_amt)
  check_amt,sum(t.outlay_amt) outlay_amt,sum(t.down_subsidy_amt)
  down_subsidy_amt,sum(t.up_subsidy_amt) up_subsidy_amt
  from (
  select a.seri_type,a.fee_type,a.maindevice_id,a.device_id,
  a.record_oper, count(a.seri_type) op_count,sum(a.op_fee) op_fee,
  sum((case when (a.fee_type=1 or a.fee_type=7) and a.outorin=1 then 1 else 0 end)*a.op_fee) trade_amt, 
  sum((case when a.subno='201' then 1 else 0 end)* (case when a.outorin=2 then 1 else -1 end)*a.op_fee) acc_add_amt, 
  sum((case when a.subno='202' then 1 else 0 end)* (case when a.outorin=2 then 1 else -1 end)*a.op_fee) shp_add_amt, 
  sum((case when a.subno='503' then 1 else 0 end)* (case when a.outorin=2 then 1 else -1 end)*a.op_fee) dep_add_amt, 
  sum((case when a.subno='504' then 1 else 0 end)* (case when a.outorin=2 then 1 else -1 end)*a.op_fee) earn_add_amt, 
  sum((case when a.subno='102' then 1 else 0 end)* (case when a.outorin=1 then 1 else -1 end)*a.op_fee) bank_add_amt, 
  sum((case when a.act_id='2051' then 1 else 0 end)* (case when a.outorin=2 then 1 else -1 end)*a.op_fee) deposit_amt, 
  sum((case when a.act_id='5011' then 1 else 0 end)* (case when a.outorin=2 then 1 else -1 end)*a.op_fee) in_amt, 
  sum((case when a.act_id='5021' then 1 else 0 end)* (case when a.outorin=2 then 1 else -1 end)*a.op_fee) cost_amt, 
  sum((case when a.act_id='1011' then 1 else 0 end)* (case when a.outorin=1 then 1 else -1 end)*a.op_fee) cash_amt, 
  sum((case when a.act_id='1041' then 1 else 0 end)* (case when a.outorin=1 then 1 else -1 end)*a.op_fee) check_amt, 
  sum((case when a.act_id='1031' then 1 else 0 end)* (case when a.outorin=1 then 1 else -1 end)*a.op_fee) outlay_amt, 
  sum((case when a.act_id='1071' then 1 else 0 end)* (case when a.outorin=1 then 1 else -1 end)*a.op_fee) down_subsidy_amt, 
  sum((case when a.act_id='2071' then 1 else 0 end)* (case when a.outorin=2 then 1 else -1 end)*a.op_fee) up_subsidy_amt
  from ykt_cur.t_tif_tradelog a
  group by a.seri_type,a.fee_type,a.maindevice_id,a.device_id,
  a.record_oper ) t
  group by t.seri_type,t.maindevice_id,t.device_id,t.record_oper ) b
  on a.serial_type=b.seri_type
  and a.maindevice_id=b.maindevice_id
  and a.device_id=b.device_id
  and a.oper_code=b.record_oper;

/*==============================================================*/
/* View: V_TIF_REPORT_OPER_CARD_AMT                             */
/*==============================================================*/
create or replace view YKT_CUR.V_TIF_REPORT_OPER_CARD_AMT(SERIAL_TYPE, TRADE_COUNT, MAINDEVICE_ID, DEVICE_ID, OPER_CODE, BADCARD_STATUS, TRADE_AMT, ACC_ADD_AMT, SHP_ADD_AMT, DEP_ADD_AMT, EARN_ADD_AMT, BANK_ADD_AMT, DEPOSIT_AMT, IN_AMT, COST_AMT, CASH_AMT, CHECK_AMT, OUTLAY_AMT, DOWN_SUBSIDY_AMT, UP_SUBSIDY_AMT) as
select a.serial_type as serial_type,a.trade_count as trade_count,
	 a.maindevice_id as maindevice_id,a.device_id as device_id, a.oper_code as
	 oper_code,a.reserve_3,b.trade_amt as trade_amt, b.acc_add_amt as
	 acc_add_amt, b.shp_add_amt as shp_add_amt,b.dep_add_amt as dep_add_amt,
	 b.earn_add_amt as earn_add_amt,b.bank_add_amt as bank_add_amt,
	 b.deposit_amt as deposit_amt,b.in_amt as in_amt,b.cost_amt as cost_amt,
	 b.cash_amt as cash_amt,b.check_amt as check_amt,b.outlay_amt as outlay_amt
	 , b.down_subsidy_amt as down_subsidy_amt,b.up_subsidy_amt as
	 up_subsidy_amt
	 from (
	 select a.serial_type,count(a.serial_no) trade_count,a.maindevice_id,
	 a.device_id,a.oper_code,a.reserve_3
	 from ykt_cur.T_TIF_tradeserial a
	 group by a.serial_type,a.maindevice_id,a.device_id,a.oper_code,
	 a.reserve_3 ) a
	 left outer join (
	 select t.seri_type,t.maindevice_id,t.device_id,t.record_oper, sum(
	 t.op_count) op_count,sum(t.trade_amt) trade_amt, sum(acc_add_amt)
	 acc_add_amt,sum(shp_add_amt) shp_add_amt,sum(dep_add_amt)
	 dep_add_amt, sum(earn_add_amt) earn_add_amt,sum(bank_add_amt)
	 bank_add_amt, sum(t.deposit_amt) deposit_amt,sum(t.in_amt) in_amt,
	 sum(t.cost_amt) cost_amt,sum(t.cash_amt) cash_amt,sum(t.check_amt)
	 check_amt,sum(t.outlay_amt) outlay_amt,sum(t.down_subsidy_amt)
	 down_subsidy_amt,sum(t.up_subsidy_amt) up_subsidy_amt
	 from (
	 select a.seri_type,a.fee_type,a.maindevice_id,a.device_id,
	 a.record_oper, a.reserve_3,count(a.seri_type) op_count,sum(
	 a.op_fee) op_fee, sum((
	 case
	 when (a.fee_type=1
	 or a.fee_type=7)
	 and a.outorin=1
	 then 1
	 else 0
	 end)*a.op_fee) trade_amt, sum((
	 case
	 when a.subno='201'
	 then 1
	 else 0
	 end)* (
	 case
	 when a.outorin=2
	 then 1
	 else -1
	 end)*a.op_fee) acc_add_amt, sum((
	 case
	 when a.subno='202'
	 then 1
	 else 0
	 end)* (
	 case
	 when a.outorin=2
	 then 1
	 else -1
	 end)*a.op_fee) shp_add_amt, sum((
	 case
	 when a.subno='503'
	 then 1
	 else 0
	 end)* (
	 case
	 when a.outorin=2
	 then 1
	 else -1
	 end)*a.op_fee) dep_add_amt, sum((
	 case
	 when a.subno='504'
	 then 1
	 else 0
	 end)* (
	 case
	 when a.outorin=2
	 then 1
	 else -1
	 end)*a.op_fee) earn_add_amt, sum((
	 case
	 when a.subno='102'
	 then 1
	 else 0
	 end)* (
	 case
	 when a.outorin=1
	 then 1
	 else -1
	 end)*a.op_fee) bank_add_amt, sum((
	 case
	 when a.act_id='2051'
	 then 1
	 else 0
	 end)* (
	 case
	 when a.outorin=2
	 then 1
	 else -1
	 end)*a.op_fee) deposit_amt, sum((
	 case
	 when a.act_id='5011'
	 then 1
	 else 0
	 end)* (
	 case
	 when a.outorin=2
	 then 1
	 else -1
	 end)*a.op_fee) in_amt, sum((
	 case
	 when a.act_id='5021'
	 then 1
	 else 0
	 end)* (
	 case
	 when a.outorin=2
	 then 1
	 else -1
	 end)*a.op_fee) cost_amt, sum((
	 case
	 when a.act_id='1011'
	 then 1
	 else 0
	 end)* (
	 case
	 when a.outorin=1
	 then 1
	 else -1
	 end)*a.op_fee) cash_amt, sum((
	 case
	 when a.act_id='1041'
	 then 1
	 else 0
	 end)* (
	 case
	 when a.outorin=1
	 then 1
	 else -1
	 end)*a.op_fee) check_amt, sum((
	 case
	 when a.act_id='1031'
	 then 1
	 else 0
	 end)* (
	 case
	 when a.outorin=1
	 then 1
	 else -1
	 end)*a.op_fee) outlay_amt, sum((
	 case
	 when a.act_id='1071'
	 then 1
	 else 0
	 end)* (
	 case
	 when a.outorin=1
	 then 1
	 else -1
	 end)*a.op_fee) down_subsidy_amt, sum((
	 case
	 when a.act_id='2071'
	 then 1
	 else 0
	 end)* (
	 case
	 when a.outorin=2
	 then 1
	 else -1
	 end)*a.op_fee) up_subsidy_amt
	 from ykt_cur.t_tif_tradelog a
	 group by a.seri_type,a.fee_type,a.maindevice_id,a.device_id,
	 a.record_oper,a.reserve_3 ) t
	 group by t.seri_type,t.maindevice_id,t.device_id,t.record_oper,
	 t.reserve_3 ) b
	 on a.serial_type=b.seri_type
	 and a.maindevice_id=b.maindevice_id
	 and a.device_id=b.device_id
	 and a.oper_code=b.record_oper;

/*==============================================================*/
/* View: V_TIF_REPORT_TOTALACC                                  */
/*==============================================================*/
create or replace view YKT_CUR.V_TIF_REPORT_TOTALACC as
select sum((
	 case
	 when direct=1
	 then 1
	 else -1
	 end)*cur_bala) as total
	 from (
	 select a.cur_bala,b.direct
	 from ykt_cur.T_AIF_account a,ykt_cur.T_TIF_subject b
	 where a.subno=b.subno) c;

/*==============================================================*/
/* View: V_TIF_SERTYPE_TRADE                                    */
/*==============================================================*/
create or replace view YKT_CUR.V_TIF_SERTYPE_TRADE as
select T.SERI_TYPE,T.FEE_TYPE,T.OUTORIN,count(T.Op_Fee) as OpCount,SUM(
	 T.Op_Fee) as Fee_Change
	 from YKT_CUR.T_TIF_TRADELOG T
	 group by T.SERI_TYPE,T.FEE_TYPE,T.OUTORIN;

/*==============================================================*/
/* View: V_TIF_SHOPDEPTFEE                                      */
/*==============================================================*/
CREATE OR REPLACE VIEW V_TIF_SHOPDEPTFEE
(SHOP_ID, SHOP_NAME, SHOP_TYPE, SHOP_STATE, DEPT_ID, 
 IS_INDEP, SERI_TYPE, FEE_TYPE, OUTORIN, OPCOUNT, 
 FEE_CHANGE)
AS 
select S.Shop_ID,S.Shop_Name,S.Shop_type,S.Shop_state,S.Dept_ID,S.IS_Indep,
 H.Seri_type,H.Fee_type,H.OutOrIn,H.OpCount,H.Fee_Change
 from YKT_CUR.T_CIF_Shop S
 left outer join (
 select G.Dept_ID,G.Seri_type,G.Fee_type,G.OutOrIn,sum(G.OpCount) as
 OpCount,sum(G.Fee_Change) AS Fee_Change
 from YKT_CUR.V_TIF_DeptShop G
 group by G.Dept_ID,G.Seri_type,G.Fee_type,G.OutOrIn ) H
 on H.Dept_ID = S.Shop_ID
 where S.Dept_ID is not null;

/*==============================================================*/
/* View: V_TIF_SHOP_ACT                                         */
/*==============================================================*/
CREATE OR REPLACE VIEW V_TIF_SHOP_ACT
(SHOP_ID, SHOP_NAME, SHOP_TYPE, SHOP_STATE, DEPT_ID, 
 IS_INDEP, ACT_ID, SUBNO, SERI_TYPE, FEE_TYPE, 
 OUTORIN, OPCOUNT, FEE_CHANGE)
AS 
select
	   S.SHOP_ID,
	   S.SHOP_NAME,
	   S.SHOP_TYPE,
	   S.SHOP_STATE,
	   S.DEPT_ID,
	   S.IS_INDEP,
	   T.Act_id,
	   T.subno,
	   T.Seri_type,
	   T.Fee_type,
	   T.OutOrIn,
	   T.OpCount,
	   T.Fee_Change
	from
	   YKT_CUR.T_AIF_ACCOUNT A,
	   YKT_CUR.T_CIF_SHOP S,
	   (select T.Act_id,max(T.subno) subno,T.Seri_type,T.Fee_type,T.OutOrIn,count( T.Op_Fee) as OpCount,SUM(T.Op_Fee) as Fee_Change from YKT_CUR.T_TIF_TradeLog T group by T.Act_id,T.Seri_type,T.Fee_type,T.OutOrIn) T
	where
	   S.CUT_ID > 0
	   and S.CUT_ID = A.CUSTOMER_ID
	   and A.ACCOUNT_ID = T.Act_id;

/*==============================================================*/
/* View: V_TIF_SUBJECT_DEPT                                     */
/*==============================================================*/
CREATE OR REPLACE VIEW V_TIF_SUBJECT_DEPT
(RECORD_OPER, SUBNO, SERI_TYPE, OUTORIN, OP_COUNT, 
 FEE_CHANGE)
AS 
select record_oper,root subno,seri_type,outorin,sum(opcount) OP_COUNT,sum(fee_change) FEE_CHANGE from
(
  select 
    T.record_oper,s.root,S.subno,S.subname,S.subtype,S.direct,S.kind,S.father,S."LEVEL",S.endflag,
     T.Seri_type,T.Fee_type,T.OutOrIn,T.OpCount,T.Fee_Change,s.spare1
  from  
     (
      SELECT FIRST_VALUE (subno) OVER (PARTITION BY part ORDER BY lev) subno,subno root,
   father,f.subname,f.subtype,f.direct,f.kind,f."LEVEL",f.endflag,f.spare1
      from
   (
    select LEVEL lev, (ROWNUM - LEVEL) part,f.*
     from YKT_CUR.t_tif_subject f
     connect by  f.SUBNO=prior f.FATHER
     ) f  
    ) S
   left outer join 
    (
     select T.record_oper,T.subno,T.Seri_type,T.Fee_type,T.OutOrIn,count(T.Op_Fee) 
       OpCount,SUM(T.Op_Fee)  Fee_Change
    from   YKT_CUR.T_TIF_TradeLog T
    group by T.record_oper,T.subno,T.Seri_type,T.Fee_type,T.OutOrIn 
     ) T
   on S.subno = T.subno
)
group by record_oper,root,seri_type,outorin
having seri_type is not null
order by record_oper,subno;
/*==============================================================*/
/* View: v_cust_info_update                                     */
/*==============================================================*/

create or replace view ykt_cur.v_cust_info_update as
select b.cosumer_id cust_id,a.card_id,a.volume,a.physical_no,b.state_id,a.flag
from ykt_cur.t_tif_cut_info_update a,ykt_cur.t_pif_card b
where  a.card_id=b.card_id;
/*==============================================================*/
/* View: v_door_time_grp_detail                                     */
/*==============================================================*/

create or replace view ykt_cur.v_door_time_grp_detail as
select tgid,tgname,time_id ,flag,update_time,idx
from (
select tgid,tgname,time1_id time_id ,flag,update_time,1 idx from ykt_cur.t_door_times_group t1
union all
select tgid,tgname,time2_id time_id,flag,update_time,2 idx from ykt_cur.t_door_times_group t2
union all
select tgid,tgname,time3_id time_id,flag,update_time,3 idx from ykt_cur.t_door_times_group t3
union all
select tgid,tgname,time4_id time_id,flag,update_time,4 idx from ykt_cur.t_door_times_group t4
union all
select tgid,tgname,time5_id time_id,flag,update_time,5 idx from ykt_cur.t_door_times_group t5
union all
select tgid,tgname,time6_id time_id,flag,update_time,6 idx from ykt_cur.t_door_times_group t6
union all
select tgid,tgname,time7_id time_id,flag,update_time,7 idx from ykt_cur.t_door_times_group t7
union all
select tgid,tgname,time8_id time_id,flag,update_time,8 idx from ykt_cur.t_door_times_group t8
) t where time_id > 0 order by tgid,idx;

create or replace view YKT_CUR.V_DOOR_OPER_DEVICE as
  select distinct device_id ,oper_code from
(
select d.device_id,d.oper_code from ykt_cur.t_door_oper_right d 
union all
select m.device_id,r.oper_code from ykt_cur.t_door_group_member m,
ykt_cur.t_door_group_oper_right r where m.group_id=r.gid
) t ;
