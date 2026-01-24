/*
https://github.com/potrue/leetcode/pull/46/files
https://github.com/akmhmgc/arai60/pull/41/files
https://github.com/shintaro1993/arai60/pull/50/files
結構bit操作を使って解いてる

https://github.com/shintaro1993/arai60/pull/50/files
で木構造的に解いていたので、木構造として考えたもの。
n = 1    0
n = 2   0  1
n = 3  0 1 0 1
のようになるので、まずkが偶奇かで、kが左右どっちの木なのかわかる。左右どっちかがわかると、親から反転してるかわかる。
これを根までみていけばよい
 */

public class solution2_2 {
  public int kthGrammar(int n, int k) {
    int flippedCount = 0;
    int targetPosition = k;
    while (1 < targetPosition) {
      if (targetPosition % 2 == 0) {
        flippedCount++;
      }
      targetPosition = (targetPosition + 1) / 2;
    }
    return (flippedCount % 2) == 1 ? 1 : 0;
  }
}
