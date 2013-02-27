#ifndef __DESDLL_H__
#define __DESDLL_H__

#ifdef __cplusplus
extern "C" {
#endif
//key 密钥 长度为8字节
//text 明文(卡的物理ID),4字节
//keyB 密文,6字节
int	__stdcall gen_user_card_keyB(unsigned char *key,unsigned char *text,unsigned char *keyB);

#ifdef __cplusplus
}
#endif

#endif