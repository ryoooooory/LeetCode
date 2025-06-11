/*
 * ・概要
 * Solution2_1の高速版（二分探索）
 * Solution2_1で線形探索していたものを、Pile自体がソートされていることを利用して二分探索をすることで探索自体をlog(n)に改善したもの。
 * pileについて一番上のものしかみなくていいので、１次元にした
 *
 *  *
 * ・計算量
 * 時間計算量：O(nlogn) :nはnumsの要素数
 * 空間計算量：O(n)
 *
 * ・所感
 * binarySearch, lowerBound, upperBoundなど左右、midの指定についてまとめたい。
 *
 *
 */

public class solution2_2 {
  public int lengthOfLIS(int[] nums) {
    List<Integer> piles = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int addIndex = lowerBound(piles, nums[i]);
      if (piles.size() <= addIndex) {
        piles.add(nums[i]);
      } else {
        piles.set(addIndex, nums[i]);
      }
    }
    return piles.size();
  }

  private int lowerBound(List<Integer> nums, int target) {
    int left = 0;
    int right = nums.size();
    while (left < right) {
      int mid = (left + right) / 2;
      if (nums.get(mid) < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}
