class Solution {
    static class Element implements Comparable<Element> {
        int row;
        int col;
        int val;
        public Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
        @Override
        public int compareTo(Element e1) {
            if (this.val == e1.val) return 0;
            return this.val < e1.val ? 1 : -1;
        }
    }
    private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int maximumMinimumPath(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        PriorityQueue<Element> maxheap = new PriorityQueue<>();
        maxheap.offer(new Element(0, 0, grid[0][0]));
        visited[0][0] = true;
        int max = Math.min(grid[0][0], grid[row - 1][col - 1]);
        while (!maxheap.isEmpty()) {
            Element cur = maxheap.poll();
            max = Math.min(max, cur.val);
            if (cur.row == row - 1 && cur.col == col - 1) return max;
            for (int[] dir : dirs) {
                int r = cur.row + dir[0];
                int c = cur.col + dir[1];
                if (r >= 0 && r < row && c >= 0 && c < col && !visited[r][c]) {
                    maxheap.offer(new Element(r, c, grid[r][c]));
                    visited[r][c] = true;
                }
            }
        }
        return max;
    }
}