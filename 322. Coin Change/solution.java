import java.util.Arrays;

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
        Arrays.fill(minimumSteps, Integer.MAX_VALUE);
        minimumSteps[0] = 0;

        for (int currentSum = 0; currentSum <= amount; currentSum++) {
            if (minimumSteps[currentSum] == Integer.MAX_VALUE) {
                continue;
            }
            for (int coin : coins) {
                if (amount < coin) {
                    continue;
                }
                long nextSum = currentSum + coin;
                if (amount < nextSum || Integer.MAX_VALUE < nextSum) {
                    continue;
                }
                int next = currentSum + coin;
                if (minimumSteps[next] == Integer.MAX_VALUE) {
                    minimumSteps[next] = minimumSteps[currentSum] + 1;
                } else {
                    minimumSteps[next] = Math.min(minimumSteps[next], minimumSteps[currentSum] + 1);
                }
            }
        }
        return minimumSteps[amount] == Integer.MAX_VALUE ? -1 : minimumSteps[amount];
    }
}
