#! /bin/sh
# 测试全局变量和局部变量的适用范围
num=123
func1 ()
{
num=321					#在代码块中声明的变量
echo $num
}
Func2()
{
    local num=456				#声明为局部变量
echo $num
}
echo $num					#显示初始时的num变量
func1						
#调用func1，在函数体中赋值（声明？）变量
echo $num					#测试num变量是否被改变
func2						#调用func2，显式声明局部变量
echo $num					#测试num变量是否被改变
