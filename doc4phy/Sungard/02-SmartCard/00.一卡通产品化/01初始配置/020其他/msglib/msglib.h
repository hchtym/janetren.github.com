#ifndef __MSGLIB_H__
#define __MSGLIB_H__

#include "mytypes.h"
#include "msgprotocol.h"

#ifdef __cplusplus
extern "C" {
#endif

int MsgConnect(char *ip,int port,int *errcode,char *errmsg);

BOOL MsgCreatePhisical(int handle,char *name,int exprite,int flag,int *errcode,char *errmsg);

BOOL MsgDeletePhisical(int handle,char *name,int *errcode,char *errmsg);

BOOL MsgCreateLogical(int handle,char *name,int timeout,int flag,int *errcode,char *errmsg);

BOOL MsgDeleteLogical(int handle,char *name,int *errcode,char *errmsg);

BOOL MsgJoin(int handle,char* logical,int logicalflag,char* phisical,int phisicalflag,int offset,int *errcode,char* errmsg);

BOOL MsgUnJoin(int handle,char* logical,int logicalflag,char* phisical,int phisicalflag,int *errcode,char* errmsg);

BOOL MsgWritePhisical(int handle,char *name,char* data,int datalength,int *errcode,char *errmsg);

BOOL MsgReadLogical(int handle,char *name,char* buffer,int buffersize,int *datalength,int *errcode,char *errmsg);

BOOL MsgCommitCheckPoint(int handle,char* name,int *errcode,char *errmsg);

BOOL MsgRollbackCheckPoint(int handle,char* name,int *errcode,char *errmsg);

void MsgClose(int handle);

BOOL MsgLogin(int handle,char *user,char *pwd,int *errcode,char *errmsg);

BOOL MsgCreateUser(int handle,char *user,char *pwd,int *errcode,char *errmsg);

BOOL MsgDeleteUser(int handle,char *user,int *errcode,char *errmsg);

BOOL MsgChangePwd(int handle,char *user,char *pwd,int *errcode,char *errmsg);

BOOL MsgCreateServer(int handle,char *server,char *ip,int port,int *errcode,char *errmsg);

BOOL MsgDeleteServer(int handle,char *server,int *errcode,char *errmsg);

BOOL MsgExport(int handlle,char *source,int sourceflag,char *server,char *dest,int destflag,int *errcode,char *errmsg);

BOOL MsgUnExport(int handle,char *source,int sourceflag,char *server,char *dest,int destflag,int *errcode,char *errmsg);

BOOL MsgQuery(int handle,int cmd,char *request,int *errcode,char *errmsg);

int MsgQueryResult(int handle,char *buffer,int buffersize,int *errcode,char *errmsg);

BOOL MsgGetUser(int handle,char *user);

#ifdef __cplusplus
}
#endif

#endif