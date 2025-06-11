public class solution3_1 {
  public int lengthOfLIS(int[] nums) {
    List<Integer> lis = new ArrayList<>();
    for (int num : nums) {
      int index = lowerBound(lis, num);
      if (lis.size() <= index) {
        lis.add(num);
      } else {
        lis.set(index, num);
      }
    }
    return lis.size();
  }

  private int lowerBound(List<Integer> arr, int target) {
    int left = 0;
    int right = arr.size();
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr.get(mid) < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}
