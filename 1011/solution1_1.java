/*
・概要
自力解放。10分ほどで実装して、10分くらいでTLE

・解法
重さを固定して、毎回weightsを操作して条件にあうか確かめる。
重さの候補としては、weightsの最大値をmaxWとすると、maxW <= 候補 <= maxW * weightsの要素数
となるので、この範囲で探していき、条件通り指定日以下になるかみていく。

・計算量
// O(m * n), m: 最大値*weights, n: weightsの要素数
// 今回の条件的には mが最大で5 * 10 ^ 4 * 500 なので大きく見積もっても10 ^ 8

・所感
ギリギリまにあうかなとおもったけど、TLEになってしまい、改善できそうなところを考えると線形走査しているmaxW <= 候補 <= maxW * weightsの要素数の部分を二分探索すればlognに計算量を減らせるのでそちらは次の解法でためす。

*/

public class solution1_1 {
  class Solution {
    // weightsの最大値を見つける。
    // 最大値から最大値*weightsの数の値だけ繰り返し処理をする
    // 繰り返し処理：capを固定してweightsを走査して、指定日数以下で返せるかをみていく。
    // O(m * n), m: 最大値*weights, n: weightsの要素数
    // mは制約から最大で5 * 10 ^ 4 * 500 = 10 ^ 8

    public int shipWithinDays(int[] weights, int days) {
      int maxWeight = 0;
      for (int weight : weights) {
        maxWeight = Math.max(maxWeight, weight);
      }

      for (int capacity = maxWeight; capacity <= maxWeight * weights.length; capacity++) {
        int currentSumWeights = 0;
        int currentDays = 1;
        for (int weight : weights) {
          if (currentSumWeights + weight <= capacity) {
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
          return capacity;
        }
      }
      return -1; // ここは想定外なのでエラーハンドリングなどは相談
    }
  }
}
