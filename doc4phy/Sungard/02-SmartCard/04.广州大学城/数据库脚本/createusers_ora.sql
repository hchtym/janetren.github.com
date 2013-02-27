create user YKT_CUR
  identified by "kingstar"
  default tablespace TS_YKT_CUR
  temporary tablespace TEMP
  profile DEFAULT
  quota unlimited on ts_ykt_cur;
  
  

-- Grant/Revoke role privileges 
grant connect to YKT_CUR with admin option;
grant dba to YKT_CUR;
grant resource to YKT_CUR with admin option;
-- Grant/Revoke system privileges 
grant create any synonym to YKT_CUR with admin option;
grant create procedure to YKT_CUR with admin option;
grant create public synonym to YKT_CUR with admin option;
grant create table to YKT_CUR with admin option;
grant create view to YKT_CUR with admin option;
grant drop any procedure to YKT_CUR with admin option;
grant drop any synonym to YKT_CUR with admin option;
grant drop any table to YKT_CUR with admin option;
grant drop any view to YKT_CUR with admin option;
grant drop public synonym to YKT_CUR with admin option;
grant select any dictionary to YKT_CUR with admin option;
grant unlimited tablespace to YKT_CUR with admin option;


create user ykt_his identified by kingstar  
default tablespace ts_ykt_his 
TEMPORARY TABLESPACE TEMP 
profile DEFAULT
QUOTA UNLIMITED ON ts_ykt_his
QUOTA UNLIMITED ON ts_ykt_his01
QUOTA UNLIMITED ON ts_ykt_his02
QUOTA UNLIMITED ON ts_ykt_his03
QUOTA UNLIMITED ON ts_ykt_his04
QUOTA UNLIMITED ON ts_ykt_his05
QUOTA UNLIMITED ON ts_ykt_his06
QUOTA UNLIMITED ON ts_ykt_his07
QUOTA UNLIMITED ON ts_ykt_his08
QUOTA UNLIMITED ON ts_ykt_his09
QUOTA UNLIMITED ON ts_ykt_his10
QUOTA UNLIMITED ON ts_ykt_his11
QUOTA UNLIMITED ON ts_ykt_his12;
--QUOTA UNLIMITED ON TEMP 


grant create any index to YKT_HIS;
grant create any table to YKT_HIS;
grant create any view to YKT_HIS;
grant drop any table to YKT_HIS;
grant drop any trigger to YKT_HIS;
grant drop any view to YKT_HIS;

GRANT CONNECT TO ykt_his;

create user YKT_QUERY
  identified by "kingstar"
  default tablespace TS_YKT_QUERY
  temporary tablespace TEMP
  profile DEFAULT
  quota unlimited on TS_YKT_QUERY;

grant create any index to YKT_QUERY;
grant create any table to YKT_QUERY;
grant create any view to YKT_QUERY;
grant drop any table to YKT_QUERY;
grant drop any trigger to YKT_QUERY;
grant drop any view to YKT_QUERY;

GRANT CONNECT TO YKT_QUERY;


create user YKT_WEB
  identified by "kingstar"
  default tablespace TS_YKT_WEB
  temporary tablespace TEMP
  profile DEFAULT
  quota unlimited on TS_YKT_WEB;

grant create any index to YKT_WEB;
grant create any table to YKT_WEB;
grant create any view to YKT_WEB;
grant drop any table to YKT_WEB;
grant drop any trigger to YKT_WEB;
grant drop any view to YKT_WEB;

GRANT CONNECT TO YKT_WEB;


create user YKT_MON
  identified by "kingstar"
  default tablespace TS_YKT_MON
  temporary tablespace TEMP
  profile DEFAULT
  quota unlimited on TS_YKT_MON;

grant create any index to YKT_MON;
grant create any table to YKT_MON;
grant create any view to YKT_MON;
grant drop any table to YKT_MON;
grant drop any trigger to YKT_MON;
grant drop any view to YKT_MON;

GRANT CONNECT TO YKT_MON;
