class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        return dfs(s, 0, dp);
    }
    private int dfs(String s, int i, int[] dp) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (dp[i] > 0) return dp[i];
        int one = dfs(s, i + 1, dp);
        int two = 0;
        if (i + 1 < s.length() && Integer.valueOf(s.substring(i, i + 2)) <= 26) {
            two = dfs(s, i + 2, dp);
        }
        dp[i] = one + two;
        return dp[i];
    }
}