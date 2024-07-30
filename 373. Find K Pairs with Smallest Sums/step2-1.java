class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        List<List<Integer>> kSmallestPairs = new ArrayList<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        PriorityQueue<int[]> minSortedPairs = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
        minSortedPairs.add(new int[] {0, 0});
        visited.add(new Pair<Integer, Integer>(0, 0));

        while(kSmallestPairs.size() < k) {
            int[] currentMinPair = minSortedPairs.poll();
            int index1 = currentMinPair[0];
            int index2 = currentMinPair[1];
            kSmallestPairs.add(List.of(nums1[index1], nums2[index2]));
            if (index1 + 1 < length1 && !visited.contains(new Pair<Integer, Integer>(index1 + 1, index2))) {
                minSortedPairs.add(new int[] {index1 + 1, index2});
                visited.add(new Pair<Integer, Integer>(index1 + 1, index2));
            }
            if (index2 + 1 < length2 && !visited.contains(new Pair<Integer, Integer>(index1, index2 + 1))) {
                minSortedPairs.add(new int[] {index1, index2 + 1});
                visited.add(new Pair<Integer, Integer>(index1, index2 + 1));
            }
        }
        return kSmallestPairs;
    }
}
