class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0) == 0) return 0;
        int[] dp = new int[n];
        // dp[n] is for out of bound purpose
        return dfs(s, 0, dp);
    }
    private int dfs(String s, int index, int[] dp) {
        if (index == s.length()) return 1;
        if (dp[index] > 0) return dp[index];
        if(s.charAt(index) == '0') return 0;
        dp[index] += dfs(s, index + 1, dp);
        if(index + 1 < s.length() && Integer.valueOf(s.substring(index, index + 2)) <= 26) {
            dp[index] += dfs(s, index + 2, dp);
        }
        return dp[index];
    }
}