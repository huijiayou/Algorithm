class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        dfs(matrix, row, col, 0, res);
        return res;
    }
    private void dfs(int[][] matrix, int rowLen, int colLen, int offset, List<Integer> res) {
        if (rowLen == 0 || colLen == 0) {
            return;
        } else if (rowLen == 1 && colLen == 1) {
            res.add(matrix[offset][offset]);
            return;
        } else if (rowLen == 1 && colLen > 1) {
            for (int i = 0; i < colLen; i++) {
                res.add(matrix[offset][offset + i]);
            }
            return;
        } else if (colLen == 1 && rowLen > 1) {
            for (int i = 0; i < rowLen; i++) {
                res.add(matrix[offset + i][offset]);
            }
            return;
        }
        for (int i = 0; i < colLen - 1; i++) {
            res.add(matrix[offset][offset + i]);
        }
        for (int i = 0; i < rowLen - 1; i++) {
            res.add(matrix[offset + i][offset + colLen - 1]);
        }
        for (int i = colLen - 1; i > 0; i--) {
            res.add(matrix[offset + rowLen - 1][offset + i]);
        }
        for (int i = rowLen - 1; i > 0; i--) {
            res.add(matrix[offset + i][offset]);
        }
        dfs(matrix, rowLen - 2, colLen - 2, offset + 1, res);
    }
}