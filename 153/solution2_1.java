/*
https://discord.com/channels/1084280443945353267/1230079550923341835/1233971372946882600
https://github.com/nanae772/leetcode-arai60/pull/41/files
この辺りにもある通り、solution1の解法について、ループ処理の中でrightをみなくても配列の最後の要素と比較することで同じことができるので、そちらで実装してみる。

https://github.com/yas-2023/leetcode_arai60/pull/22/files#r2606084983
いいコメント

*/
public class solution2 {
  public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    int numsLastValue = nums[nums.length - 1];
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (numsLastValue < nums[mid]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return nums[left];
  }
}
