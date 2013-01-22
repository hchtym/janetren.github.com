// test_char.cc
#include <cstdlib>
#include <iostream>
#include "stack_clear.hpp"

void test_char()
{
    typedef Stack<char>::size_type size_type;

    std::cout << "test characters:\n";
    //std::srand(std::time(0));
    const size_type M = 11, SZ1 = std::rand() % M, SZ2 = std::rand() % M;
    Stack<char> stc1, stc2;
    // ÓÃËæ»ú×Ö·ûÌî³äStack<char> stc1
    for (size_type i = 0; i < SZ1; ++i)
        stc1.push(static_cast<char>(std::rand()));
    for (size_type i = 0; i < SZ2; ++i)
        stc2.push(static_cast<char>(std::rand()));

    std::cout << "size of Stack: " << stc1.size() << ' ' << stc2.size() << '\n';
    std::cout << "top element: ";
    std::cout << (stc1.empty() ? '\0' : stc1.top()) << ' ';
    std::cout << (stc2.empty() ? '\0' : stc2.top()) << '\n';
    std::cout << "comparing Stack stc1 and stc2:\n";
    std::cout << (stc1 != stc2 ? "stc1 != stc2" : "stc1 == stc2") << '\n';
    std::cout << (stc1 > stc2 ? "stc1 > stc2" : "stc1 <= stc2") << '\n';
    std::cout << (stc1 >= stc2 ? "stc1 >= stc2" : "stc1 < stc2") << '\n';
    stc2.swap(stc1);
    std::cout << (stc1 <= stc2 ? "stc1 <= stc2" : "stc1 > stc2") << '\n';

    stack_clear(stc1);
    stack_clear(stc2);
    std::cout << "characters test ok!\n\n";
}
