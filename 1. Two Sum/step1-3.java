class Solution {
    // [1, 2, 3] t = 4  => ans = [0,2]
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visited = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int complement = target - currentNum;
            if (visited.containsKey(complement)) {
                return new int[] {i, visited.get(complement)};
            }
            visited.put(currentNum, i);
        }
        return new int[2];
    }
}