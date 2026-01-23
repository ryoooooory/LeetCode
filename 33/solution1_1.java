/*
・概要
自力解法。12分くらいでAC
後半の二分探索とleft == rightの時の考慮がたりずに数回WAした。

・解き方
前の153. Find Minimum in Rotated Sorted Arrayと同じく、回転している配列を二分探索で解く問題だと思ったので、
まず最小値（回転部分）を見つけて、そこから回転した部分の左右で二分探索を行うことを考えた。

・計算量
時間計算量O(log n), 空間計算量O(1), nは配列の要素数

・所感
最大３回二分探索を行うので、このあたりを最適化できそうだなと思ったが思いつかなかった。

https://github.com/garunitule/coding_practice/pull/43/files
これをみると、後半の値を求める時は、numsの右端の値と比較して片方の範囲でのみ２分探索すれば良いことがわかる。

*/

public class solution1_1 {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[nums.length - 1] < nums[mid]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    int rightSearch = binaySerach(nums, target, left, nums.length - 1);
    if (rightSearch != -1) {
      return rightSearch;
    }
    int leftSearch = binaySerach(nums, target, 0, left - 1);
    return leftSearch;
  }

  int binaySerach(int[] nums, int target, int left, int right) {
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    if (left == right) {
      return nums[left] == target ? left : -1;
    } else {
      return -1;
    }
  }
}
