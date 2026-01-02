/*
・概要
他の人のを参考にしたもの
https://github.com/h1rosaka/arai60/pull/47/files
確かに、実行時間的にもsolution1_1のものは間に合わなさそう
再帰じゃないループで解いてみようかなと思った。
https://github.com/hayashi-ay/leetcode/pull/41/files#r1514489206
たしかにn < 0のときは、-を反転させてその後は共通にする方がスマートですね。
あとそういえば塁上はpowerか、
https://github.com/h1rosaka/arai60/pull/47/files#r2657093869
styleガイドをみなおすいい機会になった（リンク先はpythonだが）
https://github.com/Satorien/LeetCode/pull/45/files
これはかなりきれい
bit操作での実装もあるが、そちらのコメントにもある遠り、直感的ではない印象,まあ/２とかだけならまあ代用もできるかあという印象

ということでこちらではまず、再帰処理で、-処理をきれいにしたもので実装する
-の処理と、nの偶奇はある程度きれいになったが、intの最小値が来た時に反転でint最大値を超えるので、longにしたところが少し微妙かも
ということで、-が来た時は+1してから反転させるときれいになりlongをつかわなくてもいいことにきづいたのでそちらも実装した

*/
public class solution2_1 {
  public double myPow(double x, int n) {
    return myPowHelper(x, n, new HashMap<Long, Double>());
  }

  private double myPowHelper(double x, long n, Map<Long, Double> memo) {
    if (memo.containsKey(n)) {
      return memo.get(n);
    }
    if (n < 0) {
      return 1 / myPowHelper(x, -n, memo);
    } else if (n == 0) {
      return 1;
    } else if (n == 1) {
      return x;
    }
    if (n % 2 == 0) {
      memo.put(n, myPowHelper(x, n / 2, memo) * myPowHelper(x, n / 2, memo));
    } else {
      memo.put(n, myPowHelper(x, n / 2, memo) * myPowHelper(x, n / 2, memo) * x);
    }
    Math.pow(1, 1);
    return memo.get(n);
  }

  // すこし改善
  public double myPow(double x, int n) {
    return myPowHelper(x, n, new HashMap<Integer, Double>());
  }

  private double myPowHelper(double x, int n, Map<Integer, Double> memo) {
    if (memo.containsKey(n)) {
      return memo.get(n);
    }
    if (n < 0) {
      return 1 / (x * myPowHelper(x, -(n + 1), memo));
    } else if (n == 0) {
      return 1;
    } else if (n == 1) {
      return x;
    }
    if (n % 2 == 0) {
      memo.put(n, myPowHelper(x, n / 2, memo) * myPowHelper(x, n / 2, memo));
    } else {
      memo.put(n, myPowHelper(x, n / 2, memo) * myPowHelper(x, n / 2, memo) * x);
    }
    return memo.get(n);
  }
}
