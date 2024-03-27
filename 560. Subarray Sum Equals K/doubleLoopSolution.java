class Solution {
    // 初回回答、解けたが15分くらいかかってるので遅い。かつ計算量も悪い
    public int subarraySum(int[] nums, int k) {
        int countForSumEqualK = 0;
        for (int start = 0; start < nums.length; start++) {
            int sumForSection = 0;
            for (int end = start; end < nums.length; end++) {
                sumForSection += nums[end];
                if (sumForSection == k) {
                    countForSumEqualK++;
                }
            }
        }
        return countForSumEqualK;
    }
}
