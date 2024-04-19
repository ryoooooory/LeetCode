import java.util.Arrays;

class Solution {
    // 指摘を受けての修正
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] minimumSteps = new int[amount + 1];
        Arrays.fill(minimumSteps, Integer.MAX_VALUE);
        minimumSteps[0] = 0;

        for (int currentSum = 0; currentSum <= amount; currentSum++) {
            if (minimumSteps[currentSum] != Integer.MAX_VALUE) {
                for (int coin : coins) {
                    if (amount < currentSum + (long) coin) {
                        continue;
                    }
                    int nextSum = currentSum + coin;
                    minimumSteps[nextSum] =
                            Math.min(minimumSteps[nextSum], minimumSteps[currentSum] + 1);
                }
            }
        }
        return minimumSteps[amount] == Integer.MAX_VALUE ? -1 : minimumSteps[amount];
    }
}
