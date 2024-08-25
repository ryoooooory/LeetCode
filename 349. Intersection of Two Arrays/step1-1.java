class Solution {
    // [1,2,3] [2,3,4] -> [2,3]
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Elements = new HashSet<>();
        for(int num : nums1) {
            nums1Elements.add(num);
        }
        Set<Integer> elementsInNums1AndNums2 = new HashSet<>();
        for(int num : nums2) {
            if (nums1Elements.contains(num)) {
                elementsInNums1AndNums2.add(num);
            }
        }
        int[] intersection = new int[elementsInNums1AndNums2.size()];
        int index = 0;
        for(int num : elementsInNums1AndNums2) {
            intersection[index++] = num;
        }
        return intersection;
    }
}
