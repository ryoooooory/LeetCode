class Solution {
    // DP
    // dp[i]: iの時の最小値
    // dp[i] = min(dp[i - j] + 1)
    // O(n): n: amount
    // 初回AC,ただコーナーケースと桁溢れの処理ができていなかった
    // 桁あふれの処理
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] minimumSteps = new int[amount + 1];
        for (int coin : coins) {
            if (coin <= amount) {
                minimumSteps[coin] = 1;
            }
        }

        for (int currentSum = 1; currentSum <= amount; currentSum++) {
            if (minimumSteps[currentSum] != 0) {
                for (int coin : coins) {
                    int nextLongSum = currentSum + coin;
                    if (nextLongSum <= amount && currentSum <= Integer.MAX_VALUE - coin) {
                        int nextSum = nextLongSum;
                        if (minimumSteps[nextSum] == 0) {
                            minimumSteps[nextSum] = minimumSteps[currentSum] + 1;
                        } else {
                            minimumSteps[nextSum] =
                                    Math.min(minimumSteps[nextSum], minimumSteps[currentSum] + 1);
                        }
                    }
                }
            }
        }
        return minimumSteps[amount] == 0 ? -1 : minimumSteps[amount];
    }
}
