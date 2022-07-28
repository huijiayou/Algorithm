class Solution {
    private int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int area = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int cur = bfs(grid, visited, i, j);
                    area = Math.max(area, cur);
                }
            }
        }
        return area;
    }
    private int bfs(int[][] grid, boolean[][] visited, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        int area = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            area++;
            for (int[] dir : dirs) {
                int row = dir[0] + cur[0];
                int col = dir[1] + cur[1];
                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1 && !visited[row][col]) {
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }
        return area;
    }
}