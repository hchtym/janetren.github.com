// ע���������ʱ��Ҫ��̬�����������ļ�libboost_system-mgw44-mt-1_42.lib
// ��libboost_filesystem-mgw44-mt-1_42.lib, ���н��test3.cpp
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
