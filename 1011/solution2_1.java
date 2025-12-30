/*
・概要
他の人のPRなどを参考にしたもの。
https://github.com/garunitule/coding_practice/pull/44/files
変数のつけかたが具体的でいい。自分はsolution1_2で二分探索のところを安易にleft, rightと置いていたが確かに処理フロー的に不自然なのでコンテキストにあった名前にしたい
ex) left = maxInvalidCapacity, right = minValidCapacity とか？　もっと簡単なら minCapacity, maxCapacityとかでもよいかも？
あと、solution1_2でも思った通り、条件にあうかの判定部分を関数化しているのでこれもよさそう

https://github.com/h1rosaka/arai60/pull/46/files
走査の最大値が配列の合計値という違いがある（たしかにこれはそう）。終了条件と定義からleft,rightが隣り合っている時となっている。

https://github.com/hayashi-ay/leetcode/pull/55/files#diff-4e146417f14c744a10f851601f26cd2cb17b420ff966720e568f6f5679aa475eR36-R58
の2ndはきれい
*/

public class solution2_1 {
  public int shipWithinDays(int[] weights, int days) {
    int maxWeight = 0;
    int sumWeight = 0;
    for (int weight : weights) {
      maxWeight = Math.max(maxWeight, weight);
      sumWeight += weight;
    }
    int minCapacity = maxWeight;
    int maxCapacity = sumWeight;
    while (minCapacity < maxCapacity) {
      int midCapacity = minCapacity + (maxCapacity - minCapacity) / 2;
      if (canShipWeight(weights, days, midCapacity)) {
        maxCapacity = midCapacity;
      } else {
        minCapacity = midCapacity + 1;
      }
    }
    return minCapacity;
  }

  private boolean canShipWeight(int[] weights, int days, int capacity) {
    int currentSumWeight = 0;
    int currentDays = 1;
    for (int weight : weights) {
      if (currentSumWeight + weight <= capacity) {
        currentSumWeight += weight;
      } else {
        currentSumWeight = weight;
        currentDays++;
      }
      if (days < currentDays) {
        return false;
      }
    }
    return true;
  }
}
