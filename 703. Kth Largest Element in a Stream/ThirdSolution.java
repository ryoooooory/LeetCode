import java.util.List;

public class ThirdSolution {
  private MinHeap sortedValues;
  private int kthIndex;

  public kthLargest(int k, int[] nums) {
    sortedValues = new MinHeap();
    kthIndex = k;
    for (int num : nums) {
      add(num);
    }
  }

  public int add(int val) {
    if (sortedValues.getSize() == kthIndex && sortedValues.getMin() >= val) {
      return sortedValues.getMin();
    }
    sortedValues.add(val);
    if (sortedValues.getSize() > kthIndex) {
      sortedValues.pop();
    }
    return sortedValues.getMin();
  }
}

class MinHeap {
  private List<Integer> data;

  MinHeap() {
    data = new ArrayList<>();
  }

  int getSize() {
    return data.size();
  }

  private int parent(int index) {
    return (index - 1) / 2;
  }

  private int leftIndex(int index) {
    return 2 * index + 1;
  }

  private int rightIndex(int index) {
    return 2 * index + 2;
  }

  private void swap(int i, int j) {
    int temp = data.get(i);
    data.set(i, data.get(j));
    data.set(j, temp);
  }

  private void heapifyUp(int index) {
    while (0 < index && data.get(index) < data.get(parent(index))) {
      swap(parent(index), index);
      index = parent(index);
    }
  }

  private void heapifyDown(int index) {
    int minIndex = index;
    int leftIndex = leftIndex(index);
    if (leftIndex < data.size() && data.get(leftIndex) < data.get(minIndex)) {
      minIndex = leftIndex;
    }
    int rightIndex = rightIndex(index);
    if (rightIndex < data.size() && data.get(rightIndex) < data.get(minIndex)) {
      minIndex = rightIndex;
    }
    if (index != minIndex) {
      swap(index, minIndex);
      heapifyDown(minIndex);
    }
  }

  void add(int val) {
    data.add(val);
    heapifyUp(data.size() - 1);
  }

  int getMin() {
    return data.get(0);
  }

  int pop() {
    int min = data.get(0);
    data.set(0, data.get(data.size() - 1));
    data.remove(data.size() - 1);
    heapifyDown(0);
    return min;
  }
}
