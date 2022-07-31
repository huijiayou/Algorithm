class TicTacToe {
    private char[][] board;
    
    public TicTacToe(int n) {
        board = new char[n][n];
    }
    
    public int move(int row, int col, int player) {
        char piece = player == 1 ? 'X' : 'O';
        board[row][col] = piece;
        boolean win = checkWin(row, col, player);
        if (win) {
            return player;
        } else {
            return 0;
        }
    }
    
    private boolean checkWin(int row, int col, int player) {
        char piece = player == 1 ? 'X' : 'O';
        int n = board.length;
        int[] total = new int[4];
        for (int i = 0; i < n; i++) {
            if (board[i][col] == piece) total[0]++;
            if (board[row][i] == piece) total[1]++;
            if (row + i < n && col + i < n && board[row + i][col + i] == piece) total[2]++;
            if (i > 0 && row - i >= 0 && col - i >= 0 && board[row - i][col - i] == piece) total[2]++;
            if (row + i < n && col - i >= 0 && board[row + i][col - i] == piece) total[3]++;
            if (i > 0 && row - i >= 0 && col + i < n && board[row - i][col + i] == piece) total[3]++;
            if (total[0] == n || total[1] == n || total[2] == n || total[3] == n) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */