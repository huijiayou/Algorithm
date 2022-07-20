class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        dfs(board, res, visited, 0);
        return res;
    }
    private void dfs(char[][] board, List<List<String>> res, List<Integer> visited, int row) {
        if (row == board.length) {
            List<String> cur = new ArrayList<>();
            for (char[] line : board) {
                cur.add(new String(line));
            }
            res.add(cur);
            return;
        }
        
        for (int col = 0; col < board.length; col++) {
            if (isValid(board, visited, row, col)) {
                board[row][col] = 'Q';
                visited.add(col);
                dfs(board, res, visited, row + 1);
                board[row][col] = '.';
                visited.remove(visited.size() - 1);
            }
        }
    }
    private boolean isValid(char[][] board, List<Integer> visited, int row, int col) {
        for (int i = 0; i < visited.size(); i++) {
            if (visited.get(i) == col) return false;
            if (Math.abs(i - row) == Math.abs(visited.get(i) - col)) return false;
        }
        return true;
    }
}