class Solution {
    // 修正回答、ちゃんとアルゴリズムを考えて行う必要がある。おそらく面接ではO(n^2)だともう少し改善できますかと言われると思うので5分くらいでO(n^2)でといて、そこから改善した答えを10分とかでできると良さそう
    //
    public int subarraySum(int[] nums, int k) {
        int sumEqualToKWithSection = 0;
        Map<Integer, Integer> sumForSection = new HashMap<>();
        sumForSection.put(0, 1);
        int countForSumEqualK = 0;
        for (int i = 0; i < nums.length; i++) {
            countForSumEqualK += nums[i];
            if (sumForSection.containsKey(countForSumEqualK - k)) {
                sumEqualToKWithSection += sumForSection.get(countForSumEqualK - k);
            }
            sumForSection.put(countForSumEqualK,
                    sumForSection.getOrDefault(countForSumEqualK, 0) + 1);
        }
        return sumEqualToKWithSection;
    }
}
