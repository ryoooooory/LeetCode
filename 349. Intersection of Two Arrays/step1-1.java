class Solution {
    // [1,2,3] [2,3,4] -> [2,3]
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums = new HashSet<>();
        for(int num : nums1) {
            nums.add(num);
        }
        Set<Integer> duplicates = new HashSet<>();
        for(int num : nums2) {
            if (nums.contains(num)) {
                duplicates.add(num);
            }
        }
        int[] intersection = new int[duplicates.size()];
        int index = 0;
        for(int num : duplicates) {
            intersection[index++] = num;
        }
        return intersection;
    }
}
