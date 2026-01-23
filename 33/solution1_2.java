/*
・概要
solution1.javaのコードを参考に、後半の２分探索で条件分岐したもの。
*/
public class solution1_2 {
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
    if (target <= nums[nums.length - 1]) {
      return binaySerach(nums, target, left, nums.length - 1);
    } else {
      return binaySerach(nums, target, 0, left - 1);
    }
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
    return nums[left] == target ? left : -1;
  }
}
