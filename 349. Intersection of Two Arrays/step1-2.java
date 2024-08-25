class Solution {
    // [1,2,3] [2,3,4] -> [2,3]
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        Set<Integer> duplicates = new HashSet<>();

        while(index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                duplicates.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
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
