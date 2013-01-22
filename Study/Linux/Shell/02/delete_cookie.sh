#! /bin/sh
# 演示/dev/null文件的妙用
# 自动删除cookie，并且禁止以后网站再写入cookie

# 自动清空日志文件的内容(特别适用于处理那些由商业站点发送的, 令人厌恶的"cookie")
if [ -f ~/.mozilla/cookies ]  # 如果存在, 就删除. 
then
rm -f ~/.mozilla/cookies
fi

# 以后所有的cookie都被自动扔到黑洞里去, 这样就不会保存在我们的磁盘中了. 
ln -s /dev/null ~/.mozilla/cookies

