class Solution {
    int[][] dirs = {{1,0}, {0,1}};
    public int uniquePaths(int m, int n) {
        int[][] ways = new int[m][n];
        return dfs(m, n, 0, 0, ways);
    }
    private int dfs(int m, int n, int x, int y, int[][] ways) {
        if (ways[x][y] > 0) {
            return ways[x][y];
        }
        if (x == m - 1 && y == n - 1) {
            ways[x][y] = 1;
            return 1;
        }
        int res = 0;
        for (int[] dir : dirs) {
            int row = x + dir[0];
            int col = y + dir[1];
            if (row < m && col < n) {
                res += dfs(m, n, row, col, ways);
            }
        }
        ways[x][y] = res;
        return res;
    }
}