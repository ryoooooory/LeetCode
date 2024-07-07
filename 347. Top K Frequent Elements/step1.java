import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstSolution {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequency = new HashMap<>();
    for (int num : nums) {
      frequency.put(num, frequency.getOrDefault(num, 0) + 1);
    }

    List<Map.Entry<Integer, Integer>> frequencyList = new ArrayList<>(frequency.entrySet());
    frequencyList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
    int[] topKFrequencyElements = new int[k];
    for (int i = 0; i < k; i++) {
      topKFrequencyElements[i] = frequencyList.get(i).getKey();
    }
    return topKFrequencyElements;
  }

  // priority queue version - 1
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequency = new HashMap<>();
    for (int num : nums) {
      frequency.put(num, frequency.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Map.Entry<Integer, Integer>> frequencyQueue =
        new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));
    frequencyQueue.addAll(frequency.entrySet());
    int[] topKFrequentElements = new int[k];
    for (int i = 0; i < k; i++) {
      topKFrequentElements[i] = (int) frequencyQueue.poll().getKey();
    }
    return topKFrequentElements;
  }

  // priority queue version - 2
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequency = new HashMap<>();
    for (int num : nums) {
      frequency.put(num, frequency.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Map.Entry<Integer, Integer>> frequencyQueue =
        new PriorityQueue<>((a, b) -> a.getValue().compareTo(b.getValue()));
    for (Map.Entry entry : frequency.entrySet()) {
      frequencyQueue.add(entry);
      if (k < frequencyQueue.size()) {
        frequencyQueue.poll();
      }
    }
    int[] topKFrequentElements = new int[k];
    for (int i = 0; i < k; i++) {
      topKFrequentElements[i] = (int) frequencyQueue.poll().getKey();
    }
    return topKFrequentElements;
  }
}
