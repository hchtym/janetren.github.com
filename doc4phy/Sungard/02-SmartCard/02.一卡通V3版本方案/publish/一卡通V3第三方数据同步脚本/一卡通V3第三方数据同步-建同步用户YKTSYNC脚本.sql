create user YKTSYNC
  identified by "yktsync"
  default tablespace USERS
  temporary tablespace TEMP
  profile DEFAULT;

GRANT CONNECT TO YKTSYNC;
grant select,update,delete,insert on ykt_cur.T_CUSTOMERTMP to YKTSYNC;
grant select,update,delete,insert on ykt_cur.T_DEPTTMP to YKTSYNC;

grant select on ykt_cur.V_CARDBAL to YKTSYNC;
grant select on ykt_cur.V_CARDVER to YKTSYNC;
grant select on ykt_cur.V_CUSTCARDINFO to YKTSYNC;
grant select on ykt_cur.V_MINPHOTO to YKTSYNC;

