create user YKTPUB
  identified by "yktpub"
  default tablespace USERS
  temporary tablespace TEMP
  profile DEFAULT;

GRANT CONNECT TO YKTPUB;
grant select on ykt_cur.T_CUSTOMERTMP to YKTPUB;
grant select on ykt_cur.T_DEPTTMP to YKTPUB;

grant select on ykt_cur.V_CARDBAL to YKTPUB;
grant select on ykt_cur.V_CARDVER to YKTPUB;
grant select on ykt_cur.V_CUSTCARDINFO to YKTPUB;
grant select on ykt_cur.V_MINPHOTO to YKTPUB;

