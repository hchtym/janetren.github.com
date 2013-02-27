--交易流水视图
create or replace view ykt_cur.v_transdtl as
select "ACCDATE","ACCTIME","TERMID","TERMSEQNO","TRANSDATE","TRANSTIME","COLDATE","COLTIME","TRANSCODE","PAYTYPE","VOUCHERNO","CUSTID","CUSTNAME","CARDNO","PURSENO","CARDCNT","CARDBEFBAL","CARDAFTBAL","AMOUNT","MANAGEFEE","OPERCODE","SYSID","DEVPHYID","DEVSEQNO","EXTTYPE","EXTDATA","REVFLAG","STATUS","ERRCODE","REMARK" from ykt_cur.t_transdtl;
--账务交易明细视图
create or replace view ykt_cur.v_accdtl as
select "ACCDATE","ACCTIME","TERMID","TERMSEQNO","SUBSEQNO","TRANSDATE","TRANSTIME","PAYTYPE","VOUCHERNO","TRANSCODE","TRANSTYPE","SUMMARY","SUBJNO","ACCNO","ACCNAME","DCFLAG","AMOUNT","BALANCE","OPPSUBJNO","OPPACCNO","OPPACCNAME","OPERCODE","REMARK"
    from ykt_cur.t_accdtl;
--终端视图
CREATE OR REPLACE VIEW ykt_cur.V_TERM AS
select siteno termid,sitename termname from ykt_cur.t_site
UNION ALL
SELECT deviceid termid,devicename FROM ykt_cur.t_device where deviceid>1;
--收费pos机型代码视图
create or replace view ykt_cur.v_consumepostype as
select '0226' postype from dual
union all
select '0236' postype from dual
union all
select '0244' postype from dual
union all
select '0245' postype from dual
union all
select '0115' postype from dual
union all
select '1055' postype from dual
union all
select '0228' postype from dual
union all
select '5301' postype from dual
union all
select '5302' postype from dual;

--设备递归视图
create or replace view ykt_cur.v_device as
select replace(sys_connect_by_path(devphyid,':'),':','') as nu,deviceid,
devicename,
devphyid,
devtypecode,
devverno,
cardphytype,
svrportcnt,
fdeviceid,
runstatus,
status,
commtype,
ip,
portno,
svrportno,
deviceno,
baudrate,
cardset,
cardverno,
lastseqno,
lasttranstime,
purseno,
maxamt,
devphytype,
sysid,
areacode,
doorlstver,
devusage
from YKT_CUR.t_device T
CONNECT BY PRIOR  deviceid=fdeviceid
START WITH deviceid =1;

--数据字典视图
CREATE OR REPLACE VIEW ykt_cur.V_DICTIONARY AS
(SELECT dicttype, dictval, dictcaption
      FROM ykt_cur.t_dictionary)
    UNION ALL
   (SELECT -2 dicttype, to_char(branchno) dictval,to_char(branchname) dictcaption
    FROM YKT_CUR.T_branch where status='1')
    UNION ALL
   (SELECT -3 dicttype, to_char (siteno) dictval, sitename dictcaption
      FROM ykt_cur.t_site )
    UNION ALL
   (SELECT -5 dicttype, to_char(cardtype) dictval,cardtypename dictcaption
    FROM YKT_CUR.t_cardtype where anonymflag='0' or anonymflag is null)
    UNION ALL
   (SELECT -6 dicttype, TO_CHAR (transcode) dicttype, transname dictcaption
      FROM ykt_cur.t_transcode where feeflag=1 or transcode in(3000,3020,3100,3170))
    UNION ALL
    SELECT -7 dicttype, TO_CHAR (transtype) dictval, transname dictcaption
      FROM ykt_cur.t_transtype where  displayflag='1'
    UNION ALL
   (SELECT -8 dicttype, TO_CHAR (transcode) dictval, transname dictcaption
      FROM ykt_cur.t_transcode)
    UNION ALL
   (SELECT -9 dicttype, TO_CHAR (siteno) dictval, sitename dictcaption
      FROM ykt_cur.t_site
    union all
    select -9 dicttype,to_char(deviceid) dictval,devicename dictcaption
      from ykt_cur.t_device where status='1'
    )
    UNION ALL
    (SELECT -10 dicttype, TO_CHAR (purseno) dictval, pursename dictcaption
      FROM ykt_cur.t_purse )
    UNION ALL
   (
    select -11 dicttype,to_char(groupid) dictval, groupname dictcaption
    from ykt_cur.t_doorgroup
   )
   UNION ALL
  (SELECT -12 dicttype, TO_CHAR (weekid) dictval, weekname dictcaption
      FROM ykt_cur.t_doorweektime)
   UNION ALL
   (
    select -13 dicttype,to_char(holidayid) dictval, holidayname dictcaption
    from ykt_cur.t_doorholiday
   )
   union all
   SELECT -15 dicttype, TO_CHAR (transcode) dictval, transname dictcaption
      FROM ykt_cur.t_transcode where feeflag='1' or transflag='1'
   UNION ALL
   SELECT -16 dicttype, TO_CHAR (transcode) dictval, transname dictcaption
   FROM ykt_cur.t_transcode where feeflag=1 or transflag=1
   union all
  (SELECT -20 dicttype,opercode dictval,to_char(opername) dictcaption
   FROM YKT_CUR.t_operator where opertype='1' and status<>'2' )
   UNION ALL
   (SELECT -22 dicttype,deptcode dictval,to_char(deptname) dictcaption
    FROM YKT_CUR.t_dept)
   UNION ALL
   (SELECT -23 dicttype,SPECIALTYCODE dictval,SPECIALTYname dictcaption
    FROM YKT_CUR.t_specialty)
   UNION ALL
   (SELECT -24 dicttype,to_char(errcode) dictval,errmsg dictcaption
    FROM YKT_CUR.t_errcode)
    UNION ALL
   (SELECT -25 dicttype,subjno dictval,subjname dictcaption
    FROM YKT_CUR.t_subject)
    UNION ALL
    (SELECT -27 dicttype,areacode dictval,areaname dictcaption
    FROM YKT_CUR.t_area where arealevel=2)
    UNION ALL
    (SELECT -28 dicttype,areacode dictval,areaname dictcaption
    FROM YKT_CUR.t_area)
    UNION ALL
    (SELECT -29 dicttype,to_char(modulecode) dictval,modulename dictcaption
    FROM YKT_CUR.T_moduleauth)
    UNION ALL
    (SELECT -30 dicttype,opercode dictval,to_char(opername) dictcaption
    FROM YKT_CUR.t_operator where opertype<>'0' and status<>'2' )
    UNION ALL
    (SELECT -31 dicttype,to_char(deviceid) dictval,DEVICENAME dictcaption
    FROM YKT_CUR.t_device where status='1')
    UNION ALL
    (SELECT -32 dicttype,to_char(sysid) dictval,sysname dictcaption
    FROM YKT_CUR.t_subsystem where status='1')
    UNION ALL
    (SELECT -33 dicttype,to_char(siteno) dictval,sitename dictcaption
    FROM YKT_CUR.t_site)
    UNION ALL
    (SELECT -34 dicttype,to_char(custtype) dictval,custtypename dictcaption
    FROM YKT_CUR.t_custtype)
    UNION ALL
   (SELECT -35 dicttype ,to_char(phytype) dictval,dname dictcaption
    FROM ykt_cur.t_phydevice)
    UNION ALL
  (SELECT -38 dicttype, TO_CHAR (transcode) dictval, transname dictcaption
      FROM ykt_cur.t_transcode )
    UNION ALL
   (SELECT -40 dicttype,to_char(shopid) dictval,to_char(shopname) dictcaption
    FROM YKT_CUR.t_shop where status='1')
    UNION ALL
   (SELECT -42 dicttype,to_char(deviceid) dictval,devicename dictcaption
    FROM YKT_CUR.t_device where status='1' and devtypecode in ('5301','0226'))
    UNION ALL
   (SELECT -43 dicttype,to_char(feetype) dictval,feename dictcaption
    FROM YKT_CUR.t_feetype where feetype>0)
    UNION ALL
    (SELECT -44 dicttype,to_char(feetype) dictval,feename dictcaption
    FROM YKT_CUR.t_feetype
    union all
    SELECT -44 dicttype,'99' dictval,'通用类别' dictcaption
    FROM dual
    )
     UNION ALL
    select -46 dicttype,to_char(groupid) dictval, groupname dictcaption
    from ykt_cur.t_doorgroup
   UNION ALL
   (SELECT -47 dicttype,to_char(sysid) dictval,sysname dictcaption
    FROM YKT_CUR.t_subsystem where status='1')
    UNION ALL
   (SELECT -49 dicttype,to_char(shopid) dictval,to_char(shopname) dictcaption
    FROM YKT_CUR.t_shop where status='1')
    UNION ALL
   (select -50 dicttype,to_char(shopid) dictval,to_char(shopname) dictcaption
    from ykt_cur.t_shop t where status='1' and shoptype='2')
     UNION ALL
    (
    select -51 dicttype,a.opercode dictval,to_char(b.opername) dictcaption from ykt_cur.t_depositoper a,ykt_cur.t_operator b where a.opercode=b.opercode  and b.status='1')
    UNION ALL
   (SELECT -55 dicttype, TO_CHAR (transtype) dictval, transname dictcaption
      FROM ykt_cur.t_transtype)
    union all
     (SELECT -56 dicttype, TO_CHAR(cardtype) dictval,cardtypename dictcaption
    FROM YKT_CUR.t_cardtype);

create or replace view ykt_cur.v_doortimegrpdetail as
select timegrpid,timegrpname,timeid ,adddelflag,downstatus,updatetime,idx
from (
select timegrpid,timegrpname,timeid1 timeid ,adddelflag,downstatus,updatetime,1 idx from ykt_cur.t_doortimegrp t1
union all
select timegrpid,timegrpname,timeid2 timeid,adddelflag,downstatus,updatetime,2 idx from ykt_cur.t_doortimegrp t2
union all
select timegrpid,timegrpname,timeid3 timeid,adddelflag,downstatus,updatetime,3 idx from ykt_cur.t_doortimegrp t3
union all
select timegrpid,timegrpname,timeid4 timeid,adddelflag,downstatus,updatetime,4 idx from ykt_cur.t_doortimegrp t4
union all
select timegrpid,timegrpname,timeid5 timeid,adddelflag,downstatus,updatetime,5 idx from ykt_cur.t_doortimegrp t5
union all
select timegrpid,timegrpname,timeid6 timeid,adddelflag,downstatus,updatetime,6 idx from ykt_cur.t_doortimegrp t6
union all
select timegrpid,timegrpname,timeid7 timeid,adddelflag,downstatus,updatetime,7 idx from ykt_cur.t_doortimegrp t7
union all
select timegrpid,timegrpname,timeid8 timeid,adddelflag,downstatus,updatetime,8 idx from ykt_cur.t_doortimegrp t8
) t where timeid > 0 order by timegrpid,idx;

create or replace view ykt_cur.v_sysstat as
select 1 itemid,'客户总数' itemname,count(1) itemval from ykt_cur.t_customer where status='1'
union all
select 2,'商户账户总数',count(1) from ykt_cur.t_shopacc where  status='1'
union all
select 3,'网络账户总数',count(1) from ykt_cur.t_netacc where status='1'
union all
select 4,'卡户总数',count(1) from ykt_cur.t_account where  status='1'
union all
select 5,'日卡开户数',count(1) from ykt_cur.t_account where status='1'  and opendate= (select paraval from ykt_cur.t_syspara where paraid=2)
union all
select 6,'日卡销户数',count(1) from ykt_cur.t_account where status='2'  and closedate= (select paraval from ykt_cur.t_syspara where paraid=2)
union all
select 7,'挂失卡总数',count(1) from ykt_cur.t_card where status='1' and lossflag='1'
union all
select 8,'日卡挂失数',count(1) from ykt_cur.t_card where lossflag='1' and lossdate=(select paraval from ykt_cur.t_syspara where paraid=2)
union all
select 9,'冻结卡总数',count(1) from ykt_cur.t_card where status='1' and frozeflag='1'
union all
select 10,'日冻结卡数',count(1) from ykt_cur.t_card t where frozeflag='1' and frozedate=(select paraval from ykt_cur.t_syspara where paraid=2)
union all
select 11,'坏卡登记总数',count(1) from ykt_cur.t_card where status='1' and badflag='1'
union all
select 12,'日坏卡登记数',count(1) from ykt_cur.t_card where status='1' and badflag='1' and baddate=(select paraval from ykt_cur.t_syspara where paraid=2)
