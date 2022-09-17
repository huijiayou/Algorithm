class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if (n + m != s3.length()) return false;
        boolean[][] isvalid = new boolean[n + 1][m + 1];
        return dfs(s1, s2, s3, 0, 0, 0, isvalid);
    }
    private boolean dfs(String s1, String s2, String s3, int i, int j, int k, boolean[][] isvalid) {
        if (isvalid[i][j]) return false;
        if (k == s3.length() && i == s1.length() && j == s2.length()) return true;
        boolean first = i < s1.length() && s1.charAt(i) == s3.charAt(k) && dfs(s1, s2, s3, i + 1, j, k + 1, isvalid);
        if (first) {
            return true;
        }
        boolean second = j < s2.length() && s2.charAt(j) == s3.charAt(k) && dfs(s1, s2, s3, i, j + 1, k + 1, isvalid);
        if (second) {
            return true;
        }
        isvalid[i][j] = true;
        return false;
    }
}