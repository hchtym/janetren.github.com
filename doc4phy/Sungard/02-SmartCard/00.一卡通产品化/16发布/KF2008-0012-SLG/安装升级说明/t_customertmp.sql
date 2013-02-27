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
  is 'ѧ��/����';
comment on column YKT_CUR.T_CUSTOMERTMP.CUT_NAME
  is '����';
comment on column YKT_CUR.T_CUSTOMERTMP.CUT_TYPE
  is '�ͻ����';
comment on column YKT_CUR.T_CUSTOMERTMP.SEX
  is '�Ա�';
comment on column YKT_CUR.T_CUSTOMERTMP.ID_TYPE
  is '֤������';
comment on column YKT_CUR.T_CUSTOMERTMP.ID_NO
  is '֤������';
comment on column YKT_CUR.T_CUSTOMERTMP.COUNTRY
  is '����';
comment on column YKT_CUR.T_CUSTOMERTMP.PEOPLE
  is '����';
comment on column YKT_CUR.T_CUSTOMERTMP.ADDR
  is '��ַ';
comment on column YKT_CUR.T_CUSTOMERTMP.TEL
  is '�绰';
comment on column YKT_CUR.T_CUSTOMERTMP.EMAIL
  is '��������';
comment on column YKT_CUR.T_CUSTOMERTMP.AREA_NO
  is 'У��';
comment on column YKT_CUR.T_CUSTOMERTMP.DEPT_NO
  is '���ű��';
comment on column YKT_CUR.T_CUSTOMERTMP.SPECIALTY_NO
  is 'רҵ���';
comment on column YKT_CUR.T_CUSTOMERTMP.CLASS_NO
  is '�༶���';
comment on column YKT_CUR.T_CUSTOMERTMP.AT_SCHOOL_STATUS
  is '��У״̬';
comment on column YKT_CUR.T_CUSTOMERTMP.IN_SCHOOL_DATE
  is '��У����';
comment on column YKT_CUR.T_CUSTOMERTMP.OUT_SCHOOL_DATE
  is '��У����';
comment on column YKT_CUR.T_CUSTOMERTMP.IMP_DATE
  is '��������';
comment on column YKT_CUR.T_CUSTOMERTMP.IMP_OPER
  is '�������Ա';
comment on column YKT_CUR.T_CUSTOMERTMP.IMP_SEQNO
  is '������ˮ��';
comment on column YKT_CUR.T_CUSTOMERTMP.IMP_BATCHNO
  is '�������κ�';
comment on column YKT_CUR.T_CUSTOMERTMP.IMP_STATUS
  is '����״̬';
-- Create/Recreate indexes 
create index YKT_CUR.IDX_IMP on YKT_CUR.T_CUSTOMERTMP (IMP_DATE, IMP_OPER, IMP_SEQNO);