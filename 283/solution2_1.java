/*
・概要
LeetCodeの解法をみた。

・解き方。
2ポインタを使う。
まず0でないindexをみつけたら、どんどん左に詰めていく。最後に左に詰めた要素の数のindexより右側を全部0にすれば完了。

*/

public class solution2_1 {
  // [0,1,2] [2,1,0]
  // [0,0,1,2] [1,0,1,2]
  public void moveZeroes(int[] nums) {
    int nonZeroIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[nonZeroIndex++] = nums[i];
      }
    }
    for (int i = nonZeroIndex; i < nums.length; i++) {
      nums[i] = 0;
    }
  }
}
