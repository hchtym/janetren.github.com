-- Create table
--drop table YKT_CUR.YKT_CUR.T_CUSTOMERTMP;
create table YKT_CUR.T_CUSTOMERTMP
(
  STUEMP_NO       VARCHAR(30) not null,
  CUT_NAME     	  VARCHAR(60),
  CUT_TYPE        INTEGER,
  SEX             CHAR(1),
  ID_TYPE         INTEGER,
  ID_NO           VARCHAR(60),
  COUNTRY         VARCHAR(30),
  PEOPLE          INTEGER,
  ADDR            VARCHAR(240),
  TEL             VARCHAR(30),
  EMAIL           VARCHAR(60),
  AREA_NO         INTEGER,
  DEPT_NO         VARCHAR(30),
  SPECIALTY_NO    VARCHAR(30),
  CLASS_NO        VARCHAR(30),
  AT_SCHOOL_STATUS  CHAR(1),
  IN_SCHOOL_DATE  CHAR(8),
  OUT_SCHOOL_DATE CHAR(8),
  IMP_DATE        CHAR(8),
  IMP_OPER        VARCHAR(10),
  IMP_SEQNO       INTEGER,
  IMP_BATCHNO     VARCHAR(30),
  IMP_STATUS      CHAR(1),
  primary key(stuemp_no)
);
-- Add comments to the columns 
comment on column YKT_CUR.T_CUSTOMERTMP.STUEMP_NO
  is '学号/工号';
comment on column YKT_CUR.T_CUSTOMERTMP.CUT_NAME
  is '姓名';
comment on column YKT_CUR.T_CUSTOMERTMP.CUT_TYPE
  is '客户类别';
comment on column YKT_CUR.T_CUSTOMERTMP.SEX
  is '性别';
comment on column YKT_CUR.T_CUSTOMERTMP.ID_TYPE
  is '证件类型';
comment on column YKT_CUR.T_CUSTOMERTMP.ID_NO
  is '证件号码';
comment on column YKT_CUR.T_CUSTOMERTMP.COUNTRY
  is '国籍';
comment on column YKT_CUR.T_CUSTOMERTMP.PEOPLE
  is '民族';
comment on column YKT_CUR.T_CUSTOMERTMP.ADDR
  is '地址';
comment on column YKT_CUR.T_CUSTOMERTMP.TEL
  is '电话';
comment on column YKT_CUR.T_CUSTOMERTMP.EMAIL
  is '电子信箱';
comment on column YKT_CUR.T_CUSTOMERTMP.AREA_NO
  is '校区';
comment on column YKT_CUR.T_CUSTOMERTMP.DEPT_NO
  is '部门编号';
comment on column YKT_CUR.T_CUSTOMERTMP.SPECIALTY_NO
  is '专业编号';
comment on column YKT_CUR.T_CUSTOMERTMP.CLASS_NO
  is '班级编号';
comment on column YKT_CUR.T_CUSTOMERTMP.AT_SCHOOL_STATUS
  is '在校状态';
comment on column YKT_CUR.T_CUSTOMERTMP.IN_SCHOOL_DATE
  is '入校日期';
comment on column YKT_CUR.T_CUSTOMERTMP.OUT_SCHOOL_DATE
  is '离校日期';
comment on column YKT_CUR.T_CUSTOMERTMP.IMP_DATE
  is '导入日期';
comment on column YKT_CUR.T_CUSTOMERTMP.IMP_OPER
  is '导入操作员';
comment on column YKT_CUR.T_CUSTOMERTMP.IMP_SEQNO
  is '导入流水号';
comment on column YKT_CUR.T_CUSTOMERTMP.IMP_BATCHNO
  is '导入批次号';
comment on column YKT_CUR.T_CUSTOMERTMP.IMP_STATUS
  is '导入状态';
-- Create/Recreate indexes 
create index YKT_CUR.IDX_IMP on YKT_CUR.T_CUSTOMERTMP (IMP_DATE, IMP_OPER, IMP_SEQNO);