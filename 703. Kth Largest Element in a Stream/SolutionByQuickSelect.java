import java.util.List;

public class SolutionByQuickSelect {
    private List<Integer> data;
    private int kthIndex;

    public kthLargest(int k, int[] nums) {
        data = new ArrayList<>();
        kthIndex = k - 1;
        for (int num : nums) {
            data.add(num);
        }
    }

    public int add(int val) {
        data.add(val);
        return quickSelect(0, data.size() - 1);
    }

    private int quickSelect(int left, int right) {
        if (left == right) {
            return data.get(left);
        }
        int pivotIndex = left + (right - left) / 2;
        pivotIndex = partition(left, right, pivotIndex);
        if (kthIndex == pivotIndex) {
            return data.get(kthIndex);
        } else if (kthIndex < pivotIndex) {
            return quickSelect(left, pivotIndex - 1);
        } else {
            return quickSelect(pivotIndex + 1, right);
        }
    }

    private int partition(int left, int right, int pivotIndex) {
        int pivotValue = data.get(pivotIndex);
        swap(pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (data.get(i) > pivotValue) {
                swap(storeIndex, i);
                storeIndex++;
            }
        }
        swap(right, storeIndex);
        return storeIndex;
    }

    private void swap(int index1, int index2) {
        int tmp = data.get(index1);
        data.set(index1, data.get(index2));
        data.set(index2, tmp);
    }
}
