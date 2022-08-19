class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        dfs(matrix, res, 0, matrix.length, matrix[0].length);
        return res;
    }
    private void dfs(int[][] matrix, List<Integer> res, int offset, int rows, int cols) {
        if (rows == 0 || cols == 0) {
            return;
        } else if (rows <= 1 && cols > 1) {
            for (int i = 0; i < cols; i++) {
                res.add(matrix[offset][offset + i]);
            }
            return;
        } else if (rows > 1 && cols <= 1) {
            for (int i = 0; i < rows; i++) {
                res.add(matrix[offset + i][offset]);
            }
            return;
        } else if(rows == 1 && cols == 1) {
            res.add(matrix[offset][offset]);
            return;
        }
        for (int i = 0; i < cols - 1; i++) {
            res.add(matrix[offset][offset + i]);
        }
        for (int i = 0; i < rows - 1; i++) {
            res.add(matrix[offset + i][offset + cols - 1]);
        }
        for (int i = cols - 1; i > 0; i--) {
            res.add(matrix[offset + rows - 1][offset + i]);
        }
        for (int i = rows - 1; i > 0; i--) {
            res.add(matrix[offset + i][offset]);
        }
        dfs(matrix, res, offset + 1, rows - 2, cols - 2);
    }
}