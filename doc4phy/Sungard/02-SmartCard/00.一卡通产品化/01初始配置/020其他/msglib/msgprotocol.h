#ifndef __MSGPROTOCOL_H
#define __MSGPROTOCOL_H
#include "drtpprotocol.h"
#include "drtplib.h"
#ifndef WIN32
#	ifndef __GNUC__
#		define __PACKED__
#		pragma options align=packed
#	else
#		define __PACKED__	__attribute__ ((packed))
#		pragma pack(push,1)
#	endif
#else
#	define __PACKED__
#	pragma pack(push,1)
#endif

#define MSG_CREATE_PHISICAL              1
#define MSG_DEL_PHISICAL                 2
#define MSG_CREATE_LOGICAL               3
#define MSG_DEL_LOGICAL                  4
#define MSG_JOIN                         5
#define MSG_UNJOIN				         6
#define MSG_WRITE_PHISICAL		         7
#define MSG_READ_LOGICAL		         8
#define MSG_READ_LOGICAL_RESULT          9
#define MSG_CREATE_SERVER	            10
#define MSG_DEL_SERVER	                11
#define MSG_EXPORT				        12
#define MSG_UNEXPORT		            13
#define MSG_GET_SYN_POINT               14
#define MSG_GET_SYN_POINT_RESULT        15
#define MSG_SEND_SYN_DATA               16
#define MSG_CREATE_USER                 17
#define MSG_CHANGE_PWD                  18
#define MSG_DEL_USER                    19
#define MSG_CHECK_PWD                   20
#define MSG_COMMIT                      21
#define MSG_ROLLBACK                    22
#define MSG_SYN_OK                      23
#define MSG_SYN_ERROR                   24

#define MSG_GET_SYN_GID                 25
#define MSG_GET_SYN_GID_RESULT          26
#define MSG_SYN_REQUEST                 27
#define MSG_TRUNCATE                    28

#define MSG_QUERY				        29
#define MSG_QUERY_RESULT	            30
#define MSG_QUERY_END                   31

#define MSG_RESULT_OK                   100
#define MSG_RESULT_ERROR                101

#define MSG_ERROR_NO_DATA               100
#define MSG_ERROR_NO_PHISICAL_OBJECT    -1
#define MSG_ERROR_NO_LOGICAL_OBJECT     -2
#define MSG_ERROR_NO_DISK               -3
#define MSG_ERROR_NO_MEMORY             -4
#define MSG_ERROR_NO_SERVER             -5
#define MSG_ERROR_NOT_LOGIN             -6
#define MSG_ERROR_NO_USER               -7
#define MSG_ERROR_INVALID_PWD           -8

#define QUEUE_FLAG     1
#define MESSAGE_FLAG   2
#define COPY_FLAG      3
#define GROUP_FLAG     4
#define SHADOW_FLAG    5

typedef struct tag_msg_head
{
	int cmd;
}__PACKED__ TAG_MSG_HEAD;

typedef struct tag_msg_error
{
	int errcode;
	char errmsg[300];
}__PACKED__ TAG_MSG_ERROR;

typedef struct tag_msg_create_phisical
{
	char name[80];
	int exprit;
	int flag;
}__PACKED__ TAG_MSG_CREATE_PHISICAL;

typedef struct tag_msg_del_phisical
{
	char name[80];
}__PACKED__ TAG_MSG_DEL_PHISICAL;

typedef struct tag_msg_write_phisical
{
	char name[80];
	int len;
	char data;
}__PACKED__ TAG_MSG_WRITE_PHISICAL;

typedef struct tag_msg_create_logical
{
	char name[80];
	int timeout;
	int flag;
}__PACKED__ TAG_MSG_CREATE_LOGICAL;

typedef struct tag_msg_del_logical
{
	char name[80];
}__PACKED__ TAG_MSG_DEL_LOGICAL;

typedef struct tag_msg_read_logical
{
	char name[80];
}__PACKED__ TAG_MSG_READ_LOGICAL;

typedef struct tag_msg_read_logical_result
{
	int len;
	char data;
}__PACKED__ TAG_MSG_READ_LOGICAL_RESULT;

typedef struct tag_msg_join
{
	char logicalname[80];
	int logicalflag;
	char phisicalname[80];
	int phisicalflag;
	int offset;
}__PACKED__ TAG_MSG_JOIN;

typedef struct tag_msg_unjoin
{
	char logicalname[80];
	int logicalflag;
	char phisicalname[80];
	int phisicalflag;
}__PACKED__ TAG_MSG_UNJOIN;

typedef struct tag_msg_create_server
{
	char servername[80];
	char ip[80];
	int port;
}__PACKED__ TAG_MSG_CREATE_SERVER;

typedef struct tsg_msg_del_server
{
	char servername[80];
}__PACKED__ TAG_MSG_DEL_SERVER;

typedef struct tag_msg_export
{
	char source_phisicalname[80];
	int source_flag;
	char dest_phisicalname[80];
	int dest_flag;
	char servername[80];
}__PACKED__ TAG_MSG_EXPORT;

typedef struct tag_msg_unexport
{
	char source_phisicalname[80];
	int source_flag;
	char dest_phisicalname[80];
	int dest_flag;
	char servername[80];
}__PACKED__ TAG_MSG_UNEXPORT;

typedef struct tag_msg_get_syn_gid_result
{
	char msg_id[80];
}__PACKED__ TAG_MSG_GET_SYN_GID_RESULT;

typedef struct tag_msg_get_syn_point
{
	char msg_id[80];
	int shadowid;
	int source_seg;
	int source_seg_serial;
	int source_offset;
}__PACKED__ TAG_MSG_GET_SYN_POINT;

typedef struct tag_msg_get_syn_point_result
{
	int shadowid;
	int source_seg;
	int source_seg_serial;
	int source_offset;
}__PACKED__ TAG_MSG_GET_SYN_POINT_RESULT;

typedef struct tag_msg_syn_write
{
	int shadowid;
	int flag;
	char sgid[80];
	char dest_phisicalname[80];
	int dest_flag;
	int source_seg;
	int source_offset;
	int source_seg_serial;
	int datalength;
	int idslength;
	char data;
}__PACKED__ TAG_MSG_SYN_WRITE;

typedef struct tag_msg_syn_request
{
	int sid;
	int count;
}__PACKED__ TAG_MSG_SYN_REQUEST;

typedef struct tag_msg_create_user
{
	char user[80];
	char pwd[80];
}__PACKED__ TAG_MSG_CREATE_USER;

typedef struct tag_msg_change_pwd
{
	char user[80];
	char pwd[80];
}__PACKED__ TAG_MSG_CHANGE_PWD;

typedef struct tag_msg_del_user
{
	char user[80];
}__PACKED__ TAG_MSG_DEL_USER;

typedef struct tag_msg_check_pwd
{
	char user[80];
	char pwd[80];
}__PACKED__ TAG_MSG_CHECK_PWD;

typedef struct tag_msg_commit
{
	char name[80];
}__PACKED__ TAG_MSG_COMMIT;

typedef struct tag_msg_rollback
{
	char name[80];
}__PACKED__ TAG_MSG_ROLLBACK;

#define QUERY_USER_ALL              1
#define QUERY_PHISICAL_ALL          2
#define QUERY_LOGICAL_ALL           3
#define QUERY_PHISICAL              4
#define QUERY_LOGICAL               5
#define QUERY_SERVER_ALL            6
#define QUERY_SERVER                7
#define QUERY_SHADOW_ALL            8
#define QUERY_SHADOW                9
#define QUERY_INFO                  10

typedef struct tag_msg_query
{
	int cmd;
	char request;
}__PACKED__ TAG_MSG_QUERY;

typedef struct tag_msg_query_result
{
	char result;
}__PACKED__ TAG_MSG_QUERY_RESULT;

typedef struct tag_msg_message
{
	TAG_MSG_HEAD head;
	union
	{
		char buffer[32764];
		TAG_MSG_ERROR msg_error;
		TAG_MSG_CREATE_PHISICAL msg_create_phisical;
		TAG_MSG_DEL_PHISICAL msg_del_phisical;
		TAG_MSG_WRITE_PHISICAL msg_write_phisical;
		TAG_MSG_CREATE_LOGICAL msg_create_logical;
		TAG_MSG_DEL_LOGICAL msg_del_logical;
		TAG_MSG_READ_LOGICAL msg_read_logical;
		TAG_MSG_READ_LOGICAL_RESULT msg_read_logical_result;
		TAG_MSG_JOIN msg_join;
		TAG_MSG_UNJOIN msg_unjoin;
		TAG_MSG_CREATE_SERVER msg_create_server;
		TAG_MSG_DEL_SERVER msg_del_server;
		TAG_MSG_EXPORT msg_export;
		TAG_MSG_UNEXPORT msg_unexport;
		TAG_MSG_GET_SYN_GID_RESULT msg_get_syn_gid_result;
		TAG_MSG_GET_SYN_POINT msg_get_syn_point;
		TAG_MSG_GET_SYN_POINT_RESULT msg_get_syn_point_result;
		TAG_MSG_SYN_WRITE msg_syn_write;
		TAG_MSG_CREATE_USER msg_create_user;
		TAG_MSG_CHANGE_PWD  msg_change_pwd;
		TAG_MSG_DEL_USER    msg_del_user;
		TAG_MSG_CHECK_PWD msg_check_pwd;
		TAG_MSG_COMMIT msg_commit;
		TAG_MSG_ROLLBACK msg_rollback;
		TAG_MSG_SYN_REQUEST msg_syn_request;
		TAG_MSG_QUERY msg_query;
		TAG_MSG_QUERY_RESULT msg_query_result;
	} body;
}__PACKED__ TAG_MSG_MESSAGE;

typedef struct _tag_inter_message
{
	int handle;
	int len;
	int id;
	TAG_DRTPHANDLE drtphandle;
	TAG_MSG_MESSAGE *message;
}TAG_INTER_MESSAGE;

#ifndef WIN32
#	ifndef __GNUC__
#		pragma options align=reset
#	else
#		pragma pack(pop)
#	endif
#else
#	pragma pack(pop)
#endif

#endif