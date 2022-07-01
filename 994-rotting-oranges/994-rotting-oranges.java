/*
    go through all cells and add routten orange in the stack
    remember the size and poll each one and add its adjacent fresh orange
*/

class Solution {
    static class Cell {
        int row;
        int col;
        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int row = grid.length;
        int col = grid[0].length;
        int steps = 0;
        int count = 0;
        boolean[][] visited = new boolean[row][col];
        Queue<Cell> queue = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Cell(i, j));
                    visited[i][j] = true;
                }
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        if (count == 0) {
            return 0;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Cell cur = queue.poll();
                size--;
                for (int[] dir : directions) {
                    int r = cur.row + dir[0];
                    int c = cur.col + dir[1];
                    if (r < row && r >= 0 && c < col && c >= 0 && grid[r][c] == 1 && !visited[r][c]) {
                        queue.offer(new Cell(r, c));
                        visited[r][c] = true;
                        count--;
                    }
                }
            }
            steps++;
        }
        return count > 0 ? -1 : steps - 1;
    }
}