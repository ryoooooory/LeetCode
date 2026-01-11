/*
https://github.com/Satorien/LeetCode/pull/57/files
２重ループでやってる

https://github.com/shintaro1993/arai60/pull/62/files
solution1とかと比べるとネストすくなくていいなと思った。最初のfor文で、pivotみつけたらループ抜けるでもいいかも

https://github.com/shintaro1993/arai60/pull/62/files#r2514216501
確かに最初の降順チェックにboolean使わなくても初期値を-1にすればみつかったかどうかわかるか

https://discord.com/channels/1084280443945353267/1201211204547383386/1232011836543467660
c++の実装、大体考えは一緒で、Swapするのを2部探索でやってさらに効率化している
*/

public class solution2_2 {
  public void nextPermutation(int[] nums) {
    int swapLeftIndex = -1;
    for (int i = nums.length - 2; 0 <= i; i--) {
      if (nums[i] < nums[i + 1]) {
        swapLeftIndex = i;
        break;
      }
    }
    // 全部降順かチェック。
    if (swapLeftIndex == -1) {
      Arrays.sort(nums);
      return;
    }
    int swapRightIndex = swapLeftIndex + 1;
    for (int j = swapLeftIndex + 2; j < nums.length; j++) {
      if (nums[swapLeftIndex] < nums[j] && nums[j] <= nums[swapRightIndex]) {
        swapRightIndex = j;
      }
    }
    swap(swapLeftIndex, swapRightIndex, nums);
    reverse(swapLeftIndex + 1, nums.length - 1, nums);
    return;
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
