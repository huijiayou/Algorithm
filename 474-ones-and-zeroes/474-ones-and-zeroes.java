class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        /*
            knapsack problem
            we have m and n limits
            max(dp[i - m][j - n], dp[i][j])
                add the string      not
        */
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeros = 0;
            int ones = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    ones++;
                } else {
                    zeros++;
                }
                
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}