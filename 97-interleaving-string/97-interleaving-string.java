class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        char[] char3 = s3.toCharArray();
        int n = s1.length();
        int m = s2.length();
        int l = s3.length();
        if (n + m != l) return false;
        boolean[][] isvalid = new boolean[n + 1][m + 1];
        return dfs(char1, char2, char3, 0, 0, 0, isvalid);
    }
    private boolean dfs(char[] char1, char[] char2, char[] char3, int i, int j, int k, boolean[][] isvalid) {
        if(isvalid[i][j]) return false;
        if(k == char3.length) return true;
        /*
        boolean left = false;
        if (i < char1.length && char1[i] == char3[k] && dfs(char1, char2, char3, i + 1, j, k + 1, isvalid)) {
            left = true;
        }
        boolean right = false;
        if (j < char2.length && char2[j] == char3[k] && dfs(char1, char2, char3, i, j + 1, k + 1, isvalid)) {
            right = true;
        }
        */
        boolean valid = i < char1.length && char1[i] == char3[k] && dfs(char1, char2, char3, i + 1, j, k + 1, isvalid) ||
            j < char2.length && char2[j] == char3[k] && dfs(char1, char2, char3, i, j + 1, k + 1, isvalid);
        if(!valid) isvalid[i][j] = true;
        return valid;
    }
}