// test_types.hpp
#include <cstdlib>
#include <ctime>

#include "tests/test_int.cc"
#include "tests/test_double.cc"
#include "tests/test_char.cc"
#include "tests/test_bool.cc"
#include "tests/test_string.cc"

static void init_rand() { std::srand(std::time(0)); }
void test_types()
{
	init_rand();
  test_int();
  test_double();
  test_char();
  test_bool();
  test_string();

}
