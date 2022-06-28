/*
    increasing stack: if cur element is smaller, pop out
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i < heights.length + 1; i++) {
            int height = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peekFirst()] > height) {
                int cur = stack.pollFirst();
                int start = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                area = Math.max(area, heights[cur] * (i - start));
            }
            stack.offerFirst(i);
        }
        return area;
    }
}