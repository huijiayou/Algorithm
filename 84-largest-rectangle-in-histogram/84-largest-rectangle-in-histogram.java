class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || heights[stack.peekLast()] > heights[i])) {
                int cur = stack.pollLast();
                int left = stack.isEmpty() ? -1 : stack.peekLast();
                res = Math.max(res, (i - left - 1) * heights[cur]);
            }
            stack.offerLast(i);
        }
        return res;
    }
}