// 注意编译运行时需要动态连接两个库文件libboost_system-mgw44-mt-1_42.lib
// 和libboost_filesystem-mgw44-mt-1_42.lib, 运行结果test3.cpp
// test3.cpp

#include <iostream>
#include <boost/filesystem/operations.hpp>

int main()
{
	namespace bfs = boost::filesystem;
	bfs::path p("test3.cpp");
	if(bfs::exists(p))
	  std::cout << p.leaf() << std::endl;
	return 0;
}
