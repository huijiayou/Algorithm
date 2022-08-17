class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int res = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int len = 1;
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    len = Math.max(len, dp[j] + 1);
                }
            }
            dp[i] = len;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}