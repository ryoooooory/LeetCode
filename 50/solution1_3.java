/*
・概要
solution1_2について変数名をリネームしたもの


*/

public class solution1_3 {
  public double myPow(double x, int n) {
    return myPowHelper(x, n, new HashMap<Integer, Double>());
  }

  private double myPowHelper(double x, int n, Map<Integer, Double> calcMemo) {
    if (calcMemo.containsKey(n)) {
      return calcMemo.get(n);
    }
    if (n == 0) {
      return 1;
    } else if (n == 1) {
      return x;
    } else if (n == -1) {
      return 1 / x;
    }
    if (n % 2 == 0) {
      calcMemo.put(n, myPowHelper(x, n / 2, calcMemo) * myPowHelper(x, n / 2, calcMemo));
    } else {
      int delta = 0 < n ? 1 : -1;
      calcMemo.put(n, myPowHelper(x, n / 2, calcMemo) * myPowHelper(x, (n / 2) + delta, calcMemo));
    }
    return calcMemo.get(n);
  }
}
