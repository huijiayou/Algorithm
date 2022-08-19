class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        dfs(res, 1, 0, n);
        return res;
    }
    private void dfs(int[][] matrix, int val, int offset, int length) {
        if (length == 0) {
            return;
        } else if (length == 1) {
            matrix[offset][offset] = val;
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            matrix[offset][offset + i] = val++;
        }
        for (int i = 0; i < length - 1; i++) {
            matrix[offset + i][offset + length - 1] = val++;
        }
        for (int i = length - 1; i > 0; i--) {
            matrix[offset + length - 1][offset + i] = val++;
        }
        for (int i = length - 1; i > 0; i--) {
            matrix[offset + i][offset] = val++;
        }
        dfs(matrix, val, offset + 1, length - 2);
    }
}