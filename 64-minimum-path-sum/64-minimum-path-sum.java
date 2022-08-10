class Solution {
    public int minPathSum(int[][] grid) {
        
        /*
            two methods: DP and dijkstra
            1. DP TC: O(m*n)
             - if i == 0, it mean from 0 to j the minimum cost: cost[i][j] = cost[i][j - 1]
             - if j == 0, it mean from i to 0, the minimu: cost[i][j] = cost[i - 1][j]
             - else, compare cost[i - 1][j], cost[i][j - 1], choose the min + grid[i][j]
            2. BFS TC: O(VE)
        */
        int row = grid.length;
        int col = grid[0].length;
        int[][] cost = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    cost[i][j] = grid[i][j];
                } else if (i == 0) {
                    cost[i][j] = cost[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    cost[i][j] = cost[i - 1][j] + grid[i][j];
                } else {
                    cost[i][j] = Math.min(cost[i][j - 1], cost[i - 1][j]) + grid[i][j];
                }
            }
        }
        return cost[row - 1][col - 1];
    }
}