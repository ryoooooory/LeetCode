class Solution {
    // [1,2,3] [2,3,4] -> [2,3]
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        Set<Integer> elementsInNums1AndNums2 = new HashSet<>();

        while(index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                elementsInNums1AndNums2.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
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
