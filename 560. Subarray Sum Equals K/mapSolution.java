class Solution {
    // 修正回答、ちゃんとアルゴリズムを考えて行う必要がある。おそらく面接ではO(n^2)だともう少し改善できますかと言われると思うので5分くらいでO(n^2)でといて、そこから改善した答えを10分とかでできると良さそう
    //
    public int subarraySum(int[] nums, int k) {
        int targetSubArrayCount = 0;
        Map<Integer, Integer> prefixSumToCount = new HashMap<>();
        prefixSumToCount.put(0, 1);
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (prefixSumToCount.containsKey(prefixSum - k)) {
                targetSubArrayCount += prefixSumToCount.getOrDefault(prefixSum - k, 0);
            }
            prefixSumToCount.put(prefixSum, prefixSumToCount.getOrDefault(prefixSum, 0) + 1);
        }
        return targetSubArrayCount;
    }
}
