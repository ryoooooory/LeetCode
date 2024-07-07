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
            int pivot = left + (right - left) / 2;
            int count = partition(left, right, pivot, frequency);
            if (count == target) {
                return;
            } else if (count < target) {
                left = count + 1;
            } else {
                right = count - 1;
            }
        }
    }

    private int partition(int left, int right, int pivot, List<Map.Entry<Integer, Integer>> frequency) {
        int leftCount = left;
        int pivotValue = frequency.get(pivot).getValue();
        Collections.swap(frequency, right, pivot);
        for(int i = left; i < right; i++) {
            if (frequency.get(i).getValue() < pivotValue) {
                Collections.swap(frequency, i, leftCount);
                leftCount++;
            }
        }
        Collections.swap(frequency, leftCount, right);
        return leftCount;
    }
}
