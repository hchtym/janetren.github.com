#ifndef __DESDLL_H__
#define __DESDLL_H__

#ifdef __cplusplus
extern "C" {
#endif
//key ��Կ ����Ϊ8�ֽ�
//text ����(��������ID),4�ֽ�
//keyB ����,6�ֽ�
int	__stdcall gen_user_card_keyB(unsigned char *key,unsigned char *text,unsigned char *keyB);

#ifdef __cplusplus
}
#endif

#endif