class Solution {
    // 計算O(2^n),空間O(n) 再帰の深さは最大でn
    // 初回AC、同じ配列を挿入するミスを何回かしてしまいフラグで修正した。
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        insertNum(nums, lists, new ArrayList<>(), 0, true);
        return lists;
    }

    private void insertNum(int[] nums, List<List<Integer>> lists, List<Integer> current, int index,
            boolean notDuplicatedArray) {
        if (notDuplicatedArray) {
            lists.add(new ArrayList<>(current));
        }
        if (nums.length <= index) {
            return;
        }

        current.add(nums[index]);
        insertNum(nums, lists, current, index + 1, true);
        current.remove(current.size() - 1);
        insertNum(nums, lists, current, index + 1, false);
    }
}
