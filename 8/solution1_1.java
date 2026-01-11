/*
・概要
自力解法。25分くらいでAC.途中で条件分岐によって５回くらいWAになった。

・解き方
問題文の通りの要件を満たすようにアルゴリズムをつくる。indexを条件にあわせて進めていき、数字ゾーンになったらStackにいれていき最終的な数字を計算していく。
数字については、Intの最大・最小値と比べてそれを超えたら丸める必要がある。

・計算量
時間：O(n)  今回はn = 200なので、2msくらいで終わりそう
空間：O(n)

*/

public class solution1_1 {
  // から文字無視、-,+確認、数字が出てきたら数字モード
  // 0は無視,0じゃ無いのをみつけるまでつづける
  // 文字がでてくるまでつづける（Stackにいれる。）。数字がなかったら0
  // Stackから計算。
  // O(n) n
  // 48
  // s48
  // -46
  // +46a
  public int myAtoi(String s) {
    boolean isPlus = true;
    int index = 0;
    char[] cs = s.toCharArray();
    while (index < cs.length) {
      if (cs[index] == '+') {
        index++;
        break;
      } else if (cs[index] == '-') {
        isPlus = false;
        index++;
        break;
      } else if (Character.isDigit(cs[index])) {
        break;
      } else if (cs[index] == ' ') {
        index++;
      } else {
        return 0;
      }
    }
    if (index == cs.length) {
      return 0;
    }
    while (index < cs.length) {
      if (!Character.isDigit(cs[index])) {
        return 0;
      }
      if (cs[index] != '0') {
        break;
      }
      index++;
    }
    if (cs.length <= index || !Character.isDigit(cs[index])) {
      return 0;
    }
    Deque<Character> stack = new ArrayDeque<>();
    while (index < cs.length && Character.isDigit(cs[index])) {
      stack.push(cs[index]);
      index++;
    }
    long val = 0;
    long pow = 1;
    while (!stack.isEmpty()) {
      int num = Character.getNumericValue(stack.pop());
      val += pow * num;
      if (isPlus && (Integer.MAX_VALUE < val || Integer.MAX_VALUE < pow)) {
        return Integer.MAX_VALUE;
      } else if (!isPlus && (-val < Integer.MIN_VALUE || Integer.MAX_VALUE < pow)) {
        return Integer.MIN_VALUE;
      }
      pow *= 10;
    }
    return isPlus ? (int) val : (int) -val;
  }
}
