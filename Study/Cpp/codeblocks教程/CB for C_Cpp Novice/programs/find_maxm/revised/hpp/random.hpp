// random.hpp
#ifndef RANDOM_HPP_
#define RANDOM_HPP_

#include <ctime>
#include <cstddef>

class random
{
public:
  explicit random(std::size_t s = 0) : seed(s)
  {
    if (0 == seed) seed = std::time(0);
    randomize();
  }
  void reset(std::size_t s)
  {
    seed = s;
    if (0 == seed) seed = std::time(0);
    randomize();
  }
  std::size_t rand32()
  {
    randomize();
    return seed;
  }
  double real()
  {
    randomize();
    return double(seed) / -1UL;
  }
  std::size_t operator()() { return rand32(); }
private:
  std::size_t seed;
  void randomize() { seed = 1103515245UL * seed + 12345UL; }
};

class rand_aux
{
  static random r;
public:
  rand_aux() {}
  void operator()(std::size_t s) { r.reset(s); }
  std::size_t operator()() { return r.rand32(); }
  double operator()(double) { return r.real(); }
};
random rand_aux:: r;

inline void srandom(std::size_t s) { rand_aux()(s); }
inline std::size_t rand32() { return rand_aux()(); }
inline double drand() { return rand_aux()(0.0); }

#include <vector>
// 产生随机数并写入缓冲区中
void gen_rand(std::vector<std::size_t>& v, std::size_t n)
{
  for(std::size_t i = 0; i < n; ++i)
    v.push_back(rand32());
}

#endif
