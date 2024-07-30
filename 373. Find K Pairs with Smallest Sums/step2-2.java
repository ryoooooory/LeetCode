class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        List<List<Integer>> kSmallestPairs = new ArrayList<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        PriorityQueue<SumPair> minSortedPairs = new PriorityQueue<>((a, b) -> (a.sum - b.sum));
        minSortedPairs.add(new SumPair(nums1, 0, nums2, 0));
        visited.add(new Pair<Integer, Integer>(0, 0));

        for(int i = 0; i < k; i++) {
            SumPair currentMinPair = minSortedPairs.poll();
            int index1 = currentMinPair.indice.getKey();
            int index2 = currentMinPair.indice.getValue();
            kSmallestPairs.add(List.of(currentMinPair.elements.getKey(), currentMinPair.elements.getValue()));
            if (index1 + 1 < length1 && !visited.contains(new Pair<Integer, Integer>(index1 + 1, index2))) {
                minSortedPairs.add(new SumPair(nums1, index1 + 1, nums2, index2));
                visited.add(new Pair<Integer, Integer>(index1 + 1, index2));
            }
            if (index2 + 1 < length2 && !visited.contains(new Pair<Integer, Integer>(index1, index2 + 1))) {
                minSortedPairs.add(new SumPair(nums1, index1, nums2, index2 + 1));
                visited.add(new Pair<Integer, Integer>(index1, index2 + 1));
            }
        }
        return kSmallestPairs;
    }
}

class SumPair {
    int sum;
    Pair<Integer, Integer> elements;
    Pair<Integer, Integer> indice;

    SumPair(int[] nums1, int index1, int[] nums2, int index2) {
        this.sum = nums1[index1] + nums2[index2];
        this.elements = new Pair(nums1[index1], nums2[index2]);
        this.indice = new Pair(index1, index2);
    }
}
