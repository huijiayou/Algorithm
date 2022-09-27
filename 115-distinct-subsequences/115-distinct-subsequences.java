class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        Integer[][] dp = new Integer[n][m];
        return dfs(s, t, 0, 0, dp);
    }
    private int dfs(String s, String t, int i, int j, Integer[][] dp) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;
        if (dp[i][j] != null) return dp[i][j];
        int count = 0;
        if (s.charAt(i) == t.charAt(j)) {
            count += dfs(s, t, i + 1, j + 1, dp);
        }
        count += dfs(s, t, i + 1, j, dp);
        dp[i][j] = count;
        return count;
    }
}