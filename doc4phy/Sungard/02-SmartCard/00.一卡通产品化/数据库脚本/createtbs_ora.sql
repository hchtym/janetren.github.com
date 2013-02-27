/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     2007-5-14 15:14:18                           */
/*==============================================================*/

/*
drop tablespace TS_INDEX including contents cascade constraints;

drop tablespace TS_YKT_CUR including contents cascade constraints;

drop tablespace TS_YKT_HIS01 including contents cascade constraints;

drop tablespace TS_YKT_HIS02 including contents cascade constraints;

drop tablespace TS_YKT_HIS03 including contents cascade constraints;

drop tablespace TS_YKT_HIS04 including contents cascade constraints;

drop tablespace TS_YKT_HIS05 including contents cascade constraints;

drop tablespace TS_YKT_HIS06 including contents cascade constraints;

drop tablespace TS_YKT_HIS07 including contents cascade constraints;

drop tablespace TS_YKT_HIS08 including contents cascade constraints;

drop tablespace TS_YKT_HIS09 including contents cascade constraints;

drop tablespace TS_YKT_HIS10 including contents cascade constraints;

drop tablespace TS_YKT_HIS11 including contents cascade constraints;

drop tablespace TS_YKT_HIS12 including contents cascade constraints;

drop tablespace TS_YKT_MON including contents cascade constraints;

drop tablespace TS_YKT_WEB including contents cascade constraints;
*/

create tablespace TS_YKT_PHOTO
datafile  '/udata/oracle/oradata/ykt/ts_photo.dbf'
size 100M
reuse
  autoextend on
    next 100M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback off;

create tablespace TS_YKT_CUR
datafile  '/udata/oracle/oradata/ykt/ts_ykt_cur.dbf'
size 100M
reuse
  autoextend on
    next 10M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback off;


create tablespace TS_YKT_HIS01
datafile  '/udata/oracle/oradata/ykt/ts_ykt_his01.dbf'
size 100M
reuse
  autoextend on
    next 10M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback off;

create tablespace TS_YKT_HIS02
datafile  '/udata/oracle/oradata/ykt/ts_ykt_his02.dbf'
size 100M
reuse
  autoextend on
    next 10M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback off;

create tablespace TS_YKT_HIS03
datafile  '/udata/oracle/oradata/ykt/ts_ykt_his03.dbf'
size 100M
reuse
  autoextend on
    next 10M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback off;

create tablespace TS_YKT_HIS04
datafile  '/udata/oracle/oradata/ykt/ts_ykt_his04.dbf'
size 100M
reuse
  autoextend on
    next 10M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback off;

create tablespace TS_YKT_HIS05
datafile  '/udata/oracle/oradata/ykt/ts_ykt_his05.dbf'
size 100M
reuse
  autoextend on
    next 10M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback off;

create tablespace TS_YKT_HIS06
datafile  '/udata/oracle/oradata/ykt/ts_ykt_his06.dbf'
size 100M
reuse
  autoextend on
    next 10M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback off;

create tablespace TS_YKT_HIS07
datafile  '/udata/oracle/oradata/ykt/ts_ykt_his07.dbf'
size 100M
reuse
  autoextend on
    next 10M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback off;

create tablespace TS_YKT_HIS08
datafile  '/udata/oracle/oradata/ykt/ts_ykt_his08.dbf'
size 100M
reuse
  autoextend on
    next 10M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback off;

create tablespace TS_YKT_HIS09
datafile  '/udata/oracle/oradata/ykt/ts_ykt_his09.dbf'
size 100M
reuse
  autoextend on
    next 10M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback off;

create tablespace TS_YKT_HIS10
datafile  '/udata/oracle/oradata/ykt/ts_ykt_his10.dbf'
size 100M
reuse
  autoextend on
    next 10M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback off;

create tablespace TS_YKT_HIS11
datafile  '/udata/oracle/oradata/ykt/ts_ykt_his11.dbf'
size 100M
reuse
  autoextend on
    next 10M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback off;

create tablespace TS_YKT_HIS12
datafile  '/udata/oracle/oradata/ykt/ts_ykt_his12.dbf'
size 100M
reuse
  autoextend on
    next 10M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback off;

create tablespace TS_YKT_MON
datafile  '/udata/oracle/oradata/ykt/ts_ykt_mon.dbf'
size 100M
reuse
  autoextend on
    next 10M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback off;

create tablespace TS_YKT_WEB
datafile  '/udata/oracle/oradata/ykt/ts_ykt_web.dbf'
size 100M
reuse
  autoextend on
    next 10M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback off;

create tablespace TS_YKT_HIS
datafile  '/udata/oracle/oradata/ykt/ts_ykt_his.dbf'
size 100M
reuse
  autoextend on
    next 10M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback off;

create tablespace TS_YKT_CONF
datafile  '/udata/oracle/oradata/ykt/ts_ykt_conf.dbf'
size 100M
reuse
  autoextend on
    next 10M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback off;

create tablespace TS_YKT_QUERY
datafile  '/udata/oracle/oradata/ykt/ts_ykt_query.dbf'
size 100M
reuse
  autoextend on
    next 10M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback off;