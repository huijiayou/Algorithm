class Solution {
    public int change(int amount, int[] coins) {
        /*
            amount = 3 coins={1,2,5}
                 0 1 2 3 4 5
               0 1 0 0 0 0 0
           (1) 1 1 1 1 1 1 1
           (2) 2 1 1 2 2 3 3
           {5} 3 1 1 2 2 3 4
        */
        int row = coins.length;
        int[][] dp = new int[row + 1][amount + 1];
        for (int i = 0; i < row + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[row][amount];
    }
}