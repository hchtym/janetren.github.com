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

create tablespace TS_YKT_CUR
datafile 
'/storage/oracle/oradata/yktdb/ts_yktcur1.dbf' size 2048M reuse autoextend on next 1024M  maxsize UNLIMITED,
'/storage/oracle/oradata/yktdb/ts_yktcur2.dbf' size 2048M reuse autoextend on next 1024M  maxsize UNLIMITED,
'/storage/oracle/oradata/yktdb/ts_yktcur3.dbf' size 2048M reuse autoextend on next 1024M  maxsize UNLIMITED,
'/storage/oracle/oradata/yktdb/ts_yktcur4.dbf' size 2048M reuse autoextend on next 1024M  maxsize UNLIMITED,
'/storage/oracle/oradata/yktdb/ts_yktcur5.dbf' size 2048M reuse autoextend on next 1024M  maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback on;


create tablespace TS_YKT_HIS01
datafile  '/storage/oracle/oradata/yktdb/ts_ykt_his01.dbf'
size 1024M
reuse
  autoextend on
    next 1024M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback on;

create tablespace TS_YKT_HIS02
datafile  '/storage/oracle/oradata/yktdb/ts_ykt_his02.dbf'
size 1024M
reuse
  autoextend on
    next 1024M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback on;

create tablespace TS_YKT_HIS03
datafile  '/storage/oracle/oradata/yktdb/ts_ykt_his03.dbf'
size 1024M
reuse
  autoextend on
    next 1024M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback on;

create tablespace TS_YKT_HIS04
datafile  '/storage/oracle/oradata/yktdb/ts_ykt_his04.dbf'
size 1024M
reuse
  autoextend on
    next 1024M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback on;

create tablespace TS_YKT_HIS05
datafile  '/storage/oracle/oradata/yktdb/ts_ykt_his05.dbf'
size 1024M
reuse
  autoextend on
    next 1024M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback on;

create tablespace TS_YKT_HIS06
datafile  '/storage/oracle/oradata/yktdb/ts_ykt_his06.dbf'
size 1024M
reuse
  autoextend on
    next 1024M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback on;

create tablespace TS_YKT_HIS07
datafile  '/storage/oracle/oradata/yktdb/ts_ykt_his07.dbf'
size 1024M
reuse
  autoextend on
    next 1024M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback on;

create tablespace TS_YKT_HIS08
datafile  '/storage/oracle/oradata/yktdb/ts_ykt_his08.dbf'
size 1024M
reuse
  autoextend on
    next 1024M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback on;

create tablespace TS_YKT_HIS09
datafile  '/storage/oracle/oradata/yktdb/ts_ykt_his09.dbf'
size 1024M
reuse
  autoextend on
    next 1024M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback on;

create tablespace TS_YKT_HIS10
datafile  '/storage/oracle/oradata/yktdb/ts_ykt_his10.dbf'
size 1024M
reuse
  autoextend on
    next 1024M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback on;

create tablespace TS_YKT_HIS11
datafile  '/storage/oracle/oradata/yktdb/ts_ykt_his11.dbf'
size 1024M
reuse
  autoextend on
    next 1024M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback on;

create tablespace TS_YKT_HIS12
datafile  '/storage/oracle/oradata/yktdb/ts_ykt_his12.dbf'
size 1024M
reuse
  autoextend on
    next 1024M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback on;

create tablespace TS_YKT_MON
datafile  '/storage/oracle/oradata/yktdb/ts_ykt_mon.dbf'
size 1024M
reuse
  autoextend on
    next 1024M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback on;

create tablespace TS_YKT_WEB
datafile  '/storage/oracle/oradata/yktdb/ts_ykt_web.dbf'
size 512M
reuse
  autoextend on
    next 512M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback on;

create tablespace TS_YKT_HIS
datafile  '/storage/oracle/oradata/yktdb/ts_ykt_his.dbf'
size 2048M
reuse
  autoextend on
    next 2048M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback on;

create tablespace TS_YKT_CONF
datafile  '/storage/oracle/oradata/yktdb/ts_ykt_conf.dbf'
size 64M
reuse
  autoextend on
    next 64M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback on;

create tablespace TS_YKT_QUERY
datafile  '/storage/oracle/oradata/yktdb/ts_ykt_query.dbf'
size 64M
reuse
  autoextend on
    next 64M
    maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback on;
create tablespace TS_YKT_PHOTO
datafile  
'/storage/oracle/oradata/yktdb/ts_photo1.dbf' size 2048M reuse  autoextend on  next 1024M  maxsize UNLIMITED,
'/storage/oracle/oradata/yktdb/ts_photo2.dbf' size 2048M reuse  autoextend on  next 1024M  maxsize UNLIMITED
logging
extent management  local  autoallocate
segment space management auto
flashback on;