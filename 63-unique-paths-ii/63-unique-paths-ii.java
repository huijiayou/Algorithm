class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] ways = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    if (obstacleGrid[i][j] == 1 || j > 1 && ways[i][j - 1] == 0) {
                        ways[i][j] = 0;
                    } else {
                        ways[i][j] = 1;
                    }
                } else if (j == 0) {
                    if (obstacleGrid[i][j] == 1 || i > 1 && ways[i - 1][j] == 0) {
                        ways[i][j] = 0;
                    } else {
                        ways[i][j] = 1;
                    }
                } else if (obstacleGrid[i][j] != 1) {
                    ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
                }
            }
        }
        return ways[n - 1][m - 1];
    }
}