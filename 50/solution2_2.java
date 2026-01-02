/*
・概要
https://github.com/Satorien/LeetCode/pull/45/files
を参考にbit操作で実装したもの


・解法
根本的な考えは指数について、２進数で考えて下位bitから見ていき、奇数の場合(ビットが立っている場合)はresultにその時点でのbaseをかけていく。
具体的には、2の5乗についてみていくと
指数: 5 → 0101
1, 0101 最下位bitが奇数なので、resultにこの時点でのbase = 2(base1つ分) をかける。ビットを１つ右にずらす。
2, 010 最下位bitが偶数なので、resultにはなにもしない。ビットを１つ右にずらす。
3, 01 最下位bitが奇数なので、resultにこの時点でのbase = 8(base4つ分) をかける。ビットを１つ右にずらす。

*/

public class solution2_2 {
  public double myPow(double x, int n) {
    return myPowHelper(x, n);
  }

  private double myPowHelper(double x, long n) {
    if (n < 0) {
      x = 1 / x;
      n = -n;
    } else if (n == 0) {
      return 1;
    } else if (n == 1) {
      return x;
    }
    double result = 1.0;
    double base = x;
    long exp = n;
    while (0 < exp) {
      if ((exp & 1) == 1) {
        result *= base;
      }
      base *= base;
      exp = exp >> 1;
    }
    return result;
  }
}
