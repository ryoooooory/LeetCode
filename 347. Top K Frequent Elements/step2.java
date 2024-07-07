class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToCount = new HashMap<>();
        for(int num : nums) {
            numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minCountAndNums = new PriorityQueue<>(
            (a, b) -> a.getValue().compareTo(b.getValue())
        );
        for (Map.Entry entry : numToCount.entrySet()) {
            minCountAndNums.add(entry);
            if (k < minCountAndNums.size()) {
                minCountAndNums.poll();
            }
        }
        int[] topKFrequentElements = new int[k];
        for(int i = 0; i < k; i++) {
            topKFrequentElements[i] = (int)minCountAndNums.poll().getKey();
        }
        return topKFrequentElements;
    }
}
