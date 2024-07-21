import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstSolution {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> numToCount = new HashMap<>();
    for (int num : nums) {
      numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
    }

    List<Map.Entry<Integer, Integer>> frequency = new ArrayList<>(numToCount.entrySet());
    frequency.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
    int[] topKFrequentElements = new int[k];
    for (int i = 0; i < k; i++) {
      topKFrequentElements[i] = frequency.get(i).getKey();
    }
    return topKFrequentElements;
  }

  // priority queue version - 1
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> numToCount = new HashMap<>();
    for (int num : nums) {
      numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Map.Entry<Integer, Integer>> numToCountQueue =
        new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));
    numToCountQueue.addAll(numToCount.entrySet());
    int[] topKFrequentElements = new int[k];
    for (int i = 0; i < k; i++) {
      topKFrequentElements[i] = (int) numToCountQueue.poll().getKey();
    }
    return topKFrequentElements;
  }

  // priority queue version - 2
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> numToCount = new HashMap<>();
    for (int num : nums) {
      numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Map.Entry<Integer, Integer>> numToCountQueue =
        new PriorityQueue<>((a, b) -> a.getValue().compareTo(b.getValue()));
    for (Map.Entry entry : numToCount.entrySet()) {
      numToCountQueue.add(entry);
      if (k < numToCountQueue.size()) {
        numToCountQueue.poll();
      }
    }
    int[] topKFrequentElements = new int[k];
    for (int i = 0; i < k; i++) {
      topKFrequentElements[i] = (int) numToCountQueue.poll().getKey();
    }
    return topKFrequentElements;
  }
}
