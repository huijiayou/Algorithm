class Solution {
    public void solveSudoku(char[][] board) {
        Map<String, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String str = Integer.toString(i) + "," + j;
                map.put(str, new HashSet<>());
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    String str = Integer.toString(i / 3) + "," + j / 3;
                    map.get(str).add(board[i][j]);
                }
            }
        }
        dfs(board, map);
    }
    private boolean dfs(char[][] board, Map<String, Set<Character>> map) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] != '.') continue;
                for (char candi = '1'; candi <= '9'; candi++) {
                    String key = Integer.toString(row / 3) + ',' + col / 3;
                    if (isValid(board, map, row, col, candi, key)) {
                        board[row][col] = candi;
                        Set<Character> set = map.get(key);
                        set.add(candi);
                        if (dfs(board, map)) {
                            return true;
                        } else {
                            board[row][col] = '.';
                            set.remove(candi);
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, Map<String, Set<Character>> map, int row, int col, char candi, String key) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == candi || board[i][col] == candi) return false;
        }
        Set<Character> set = map.get(key);
        if (set.contains(candi)) return false;
        return true;
    }
}