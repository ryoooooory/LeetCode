class Solution {
    int[] nums1;
    int[] nums2;

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        List<List<Integer>> kSmallestPairs = new ArrayList<>();
        Set<IndexPair> visited = new HashSet<>();
        PriorityQueue<IndexPair> minSortedPairs = new PriorityQueue<>((a, b) -> (a.sum - b.sum));
        IndexPair firstPair = new IndexPair(0, 0, nums1[0] + nums2[0]);
        minSortedPairs.add(firstPair);
        visited.add(firstPair);

        for(int i = 0; i < k; i++) {
            IndexPair currentMinPair = minSortedPairs.poll();
            int index1 = currentMinPair.index1;
            int index2 = currentMinPair.index2;
            kSmallestPairs.add(List.of(nums1[index1], nums2[index2]));
            insertPairIfNeeded(minSortedPairs, visited, index1 + 1, index2);
            insertPairIfNeeded(minSortedPairs, visited, index1, index2 + 1);
        }
        return kSmallestPairs;
    }

    private void insertPairIfNeeded(PriorityQueue<IndexPair> queue, Set<IndexPair> visited, int pos1, int pos2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 <= pos1 || len2 <= pos2) { 
            return;
        }
        IndexPair newPair = new IndexPair(pos1, pos2, nums1[pos1] + nums2[pos2]);
        if (visited.contains(newPair)) {
            return;
        }
        queue.add(newPair);
        visited.add(newPair);
    }
}

class IndexPair {
    int sum;
    int index1;
    int index2;

    IndexPair(int index1, int index2, int sum) {
        this.index1 = index1;
        this.index2 = index2;
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndexPair other = (IndexPair) o;
        return other.index1 == index1 && other.index2 == index2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index1, index2);
    }
}
