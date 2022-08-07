class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        getAdj(numCourses, prerequisites, adj, indegree);
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int index = queue.poll();
            count++;
            List<Integer> depe = adj.get(index);
            for (int i : depe) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return count == numCourses ? true : false;
    }
    private void getAdj(int numCourses, int[][] prerequisites, Map<Integer, List<Integer>> adj, int[] indegree) {
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<Integer>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
    }
}