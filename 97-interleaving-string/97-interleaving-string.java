class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if (n + m != s3.length()) return false;
        boolean[][] invalid = new boolean[n + 1][m + 1];
        return dfs(s1, s2, s3, 0, 0, 0, invalid);
    }
    private boolean dfs(String s1, String s2, String s3, int i, int j, int k, boolean[][] invalid) {
        if (invalid[i][j]) return false;
        if (s3.length() == k) return true;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            if (dfs(s1, s2, s3, i + 1, j, k + 1, invalid)) {
                return true;
            }
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            if (dfs(s1, s2, s3, i, j + 1, k + 1, invalid)) {
                return true;
            }
        }
        invalid[i][j] = true;
        return false;
    }
}