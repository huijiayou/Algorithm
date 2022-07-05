class Solution {
    final int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int row = maze.length;
        int col = maze[0].length;
        int[][] distance = new int[row][col];
        for (int[] arr : distance) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[2] == arr2[2]) return 0;
                return arr1[2] < arr2[2] ? -1 : 1;
            }
        });
        heap.offer(new int[]{start[0], start[1], 0});
        distance[start[0]][start[1]] = 0;
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            for (int[] dir : dirs) {
                int steps = 0;
                int r = cur[0];
                int c = cur[1];
                while (r >= 0 && r < row && c >= 0 && c < col && maze[r][c] == 0) {
                    r += dir[0];
                    c += dir[1];
                    steps++;
                }
                r -= dir[0];
                c -= dir[1];
                if (distance[cur[0]][cur[1]] + steps - 1 < distance[r][c]) {
                    distance[r][c] = distance[cur[0]][cur[1]] + steps - 1 ;
                    heap.offer(new int[]{r, c, distance[r][c]});
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
}