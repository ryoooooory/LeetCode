/*
・概要
LeetCodeの解法や他の人の解放を見た。

LeetCodeの解放をみると、基本solution1_1と同じだが、swapした後はreverseするだけでいいねというもの。確かに。
*/

public class solution2_1 {
  public void nextPermutation(int[] nums) {
    // 全部降順かチェック。
    boolean isDesending = true;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] < nums[i + 1]) {
        isDesending = false;
      }
    }
    if (isDesending) {
      Arrays.sort(nums);
      return;
    }
    for (int i = nums.length - 2; 0 <= i; i--) {
      if (nums[i] < nums[i + 1]) {
        int swapIndex = i + 1;
        for (int j = i + 2; j < nums.length; j++) {
          if (nums[i] < nums[j] && nums[j] <= nums[swapIndex]) {
            swapIndex = j;
          }
        }
        swap(i, swapIndex, nums);
        reverse(i + 1, nums.length - 1, nums);
        return;
      }
    }
  }

  private void reverse(int start, int end, int[] nums) {
    while (start < end) {
      swap(start, end, nums);
      start++;
      end--;
    }
  }

  private void swap(int i, int j, int[] nums) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
