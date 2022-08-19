class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] >= 0 && nums[j] >= i - j) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}