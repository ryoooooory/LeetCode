class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for(int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        List<ElementFrequency> elements = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            elements.add(new ElementFrequency(entry.getKey(), entry.getValue()));
        }
        Collections.sort(elements);
        int[] topKFrequentElements = new int[k];
        for(int i = 0; i < k; i++) {
            topKFrequentElements[i] = (int)elements.get(elements.size() - i - 1).value;
        }
        return topKFrequentElements;
    }
}

class ElementFrequency implements Comparable<ElementFrequency> {
    int value;
    int count;
    ElementFrequency(int value, int count) {
        this.value = value;
        this.count = count;
    }

    @Override
    public int compareTo(ElementFrequency other) {
        return Integer.compare(this.count, other.count);
    }

}
