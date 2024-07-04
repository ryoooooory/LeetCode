import java.util.List;

public class SecondSolution {
    private MinHeap sortedValues;
    private int kth;

    public KthLargest(int k, int[] nums) {
        sortedValues = new MinHeap();
        kth = k;
        for(int num: nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (sortedValues.getSize() > kth && sortedValues.getMin() >= val) {
            return sortedValues.getMin();
        }
        sortedValues.add(val);
        if (sortedValues.getSize() > kth) {
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

    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int rightChildIndex(int index) {
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
        int leftChildIndex = leftChildIndex(index);
        if (leftChildIndex < data.size() && data.get(leftChildIndex) < data.get(minIndex)) {
            minIndex = leftChildIndex;
        }
        int rightChildIndex = rightChildIndex(index);
        if (rightChildIndex < data.size() && data.get(rightChildIndex) < data.get(minIndex)) {
            minIndex = rightChildIndex;
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
