class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        List<List<Integer>> kSmallestPairs = new ArrayList<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        PriorityQueue<int[]> minSums = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minSums.add(new int[] {nums1[0] + nums2[0], 0, 0});
        visited.add(new Pair<Integer, Integer>(0, 0));

        while(kSmallestPairs.size() < k) {
            int[] currentMinPair = minSums.poll();
            int index1 = currentMinPair[1];
            int index2 = currentMinPair[2];
            kSmallestPairs.add(List.of(nums1[index1], nums2[index2]));
            if (index1 + 1 < length1 && !visited.contains(new Pair<Integer, Integer>(index1 + 1, index2))) {
                minSums.add(new int[] {nums1[index1 + 1] + nums2[index2], index1 + 1, index2});
                visited.add(new Pair<Integer, Integer>(index1 + 1, index2));
            }
            if (index2 + 1 < length2 && !visited.contains(new Pair<Integer, Integer>(index1, index2 + 1))) {
                minSums.add(new int[] {nums1[index1] + nums2[index2 + 1], index1, index2 + 1});
                visited.add(new Pair<Integer, Integer>(index1, index2 + 1));
            }
        }
        return kSmallestPairs;
    }
}
