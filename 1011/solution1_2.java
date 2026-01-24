/*
・概要
solution1_1について走査部分を二分探索にして計算量を改善したもの。
15分くらいでAC

・解法
走査部分について
1, 不変条件
見つけたいもの：条件を満たす最小のcapacity
left: これを以下のCapacityでは条件をみたさない。
right:これ以上のCapacityで条件をみたす。
2, 更新処理
leftとrightの間の値candidateをみていく。条件（かかる日数がdays以下）を満たすの時は、
定義より、right = candidate
逆に条件を満たさない時は、left = candidate + 1;
3, 終了条件
定義より、leftとrightが一致したところが見つけたいものと同じになるのでleft == right

・計算量
// O(log(m) * n), m: 最大値*n, n: weightsの要素数
// m = 500n = 500 * 5 * 10 ^ 4 = 25 * 10 ^ 6 → 2 * 10 ^ 7
// nlog(m) = 500 * log(2 * 10 ^ 7) = 500 * 7 * log(20) = 3500 * log (20) = 3500 * (2log(2) + log(5)) = 3500 * (2 + 2.3) = 3500 * 5 = 175000 = 2 * 10 ^ 5
// 大体Javaが1sで10^7くらい処理ができるとすると、2 * 10 ^ 5 / 10 ^ 7 = 2 / 10 ^ 2 = 20msくらいで完了しそう

*/

public class solution1_2 {
  public int shipWithinDays(int[] weights, int days) {
    int maxWeight = 0;
    for (int weight : weights) {
      maxWeight = Math.max(maxWeight, weight);
    }
    int left = maxWeight;
    int right = maxWeight * weights.length;
    while (left < right) {
      int candidateCapacity = left + (right - left) / 2;
      int currentSumWeights = 0;
      int currentDays = 1;

      // この辺りは関数にしてもいいかも
      for (int weight : weights) {
        if (currentSumWeights + weight <= candidateCapacity) {
          currentSumWeights += weight;
        } else {
          currentSumWeights = weight;
          currentDays++;
          if (days < currentDays) {
            break;
          }
        }
      }
      if (currentDays <= days) {
        right = candidateCapacity;
      } else {
        left = candidateCapacity + 1;
      }
    }
    return left;
  }
}
