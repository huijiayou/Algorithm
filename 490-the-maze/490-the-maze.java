class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int row = maze.length;
        int col = maze[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[row][col];
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1]) return true;
            for (int[] dir : dirs) {
                int r = cur[0];
                int c = cur[1];
                while (r < row && r >= 0 && c < col && c >= 0 && maze[r][c] == 0) {
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];
                if (!visited[r][c]) {
                    queue.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        return false;
    }
}