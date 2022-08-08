class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int getFood(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] start = new int[2];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '*') {
                    start[0] = i;
                    start[1] = j;
                    break;
                }
            }
        }
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new ArrayDeque<>();
        int steps = 0;
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (grid[cur[0]][cur[1]] == '#') return steps;
                for (int[] dir : dirs) {
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    if (r >= 0 && r < row && c >= 0 && c < col && grid[r][c] != 'X' && !visited[r][c]) {
                        queue.offer(new int[]{r, c});
                        visited[r][c] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}