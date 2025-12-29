/*
・概要
自力解法
5分くらいでAC
時間計算量O(log n), 空間計算量O(1), nは配列の要素数

・解き方
問題分を見た瞬間に二分探索を思い浮かべた。（もっというとupper_bound,lowerboundを思い浮かべたがJavaにはないので自力実装することにした)

期待値としては、targetをinsertする位置を見つけることなので、targetが見つかった場合はそのindexを返し、見つからなかった場合はleftがtargetをinsertする位置になるのでleftを返す。

*/

public class solution1 {
  public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = (right - left) / 2 + left; // オーバーフロー対策
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }
}
