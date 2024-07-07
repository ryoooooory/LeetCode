class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToCount = new HashMap<>();
        for(int num : nums) {
            numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> frequency = new ArrayList<>();
        frequency.addAll(numToCount.entrySet());
        quickSelect(0, frequency.size() - 1, frequency, frequency.size() - k);

        int[] topKFrequentElements = new int[k];
        for(int i = 0; i < k; i++) {
            topKFrequentElements[i] = (int)frequency.get(frequency.size() - i - 1).getKey();
        }
        return topKFrequentElements;
    }

    private void quickSelect(int left, int right, List<Map.Entry<Integer, Integer>> frequency, int target) {
        while(left < right) {
            int pivotIndex = left + (right - left) / 2;
            pivotIndex = partition(left, right, pivotIndex, frequency);
            if (pivotIndex == target) {
                return;
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
    }

    private int partition(int left, int right, int pivotIndex, List<Map.Entry<Integer, Integer>> frequency) {
        int storeIndex = left;
        int pivotValue = frequency.get(pivotIndex).getValue();
        Collections.swap(frequency, right, pivotIndex);
        for(int i = left; i < right; i++) {
            if (frequency.get(i).getValue() < pivotValue) {
                Collections.swap(frequency, i, storeIndex);
                storeIndex++;
            }
        }
        Collections.swap(frequency, storeIndex, right);
        return storeIndex;
    }
}
