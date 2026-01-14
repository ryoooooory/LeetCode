/*
・概要
solution1_1を改良して、時間計算量を改善したもの

・解き方
再帰処理を考察すると、nについて半分ずつ減らしていってもなりたつことがわかったので、そちらで実装。

・計算量
O(logn)


*/

public class solution1_2 {
  public double myPow(double x, int n) {
    return myPowHelper(x, n, new HashMap<Integer, Double>());
  }

  private double myPowHelper(double x, int n, Map<Integer, Double> memo) {
    if (memo.containsKey(n)) {
      return memo.get(n);
    }
    if (n == 0) {
      return 1;
    } else if (n == 1) {
      return x;
    } else if (n == -1) {
      return 1 / x;
    }
    if (n % 2 == 0) {
      memo.put(n, myPowHelper(x, n / 2, memo) * myPowHelper(x, n / 2, memo));
    } else {
      int diff = 0 < n ? 1 : -1;
      memo.put(n, myPowHelper(x, n / 2, memo) * myPowHelper(x, (n / 2) + diff, memo));
    }
    return memo.get(n);
  }
}
