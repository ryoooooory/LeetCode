public class FirstSolution {
    private PriorityQueue<Integer> sortedValues;
    private int kth;

    public KthLargest(int k, int[] nums) {
        sortedValues = new PriorityQueue<>();
        kth = k;
        for(int num: nums) {
            addQueue(num);
        }
    }

    public int add(int val) {
        addQueue(val);
        return sortedValues.peek();
    }

    private void addQueue(int val) {
        sortedValues.add(val);
        if (sortedValues.size() > kth) {
            sortedValues.poll();
        }
    }
}
