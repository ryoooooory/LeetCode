class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for(int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<ElementFrequency> minCountAndNums = new PriorityQueue<>((a, b) -> a.count - b.count);
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (minCountAndNums.size() == k && entry.getValue() < minCountAndNums.peek().count) {
                continue;
            }
            minCountAndNums.add(new ElementFrequency(entry.getKey(), entry.getValue()));
            if (k < minCountAndNums.size()) {
                minCountAndNums.poll();
            }
        }
        int[] topKFrequentElements = new int[k];
        Iterator<ElementFrequency> iterator = minCountAndNums.iterator();
        int index = 0;
        while(iterator.hasNext()) {
            topKFrequentElements[index++] = iterator.next().value;
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
        return Integer.compare(other.count, this.count);
    }

}
