class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, word, visited, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean search(char[][] board, String word, boolean[][] visited, int row, int col, int index) {
        if (index == word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index)) return false;
        visited[row][col] = true;
        for (int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (search(board, word, visited, r, c, index + 1)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}