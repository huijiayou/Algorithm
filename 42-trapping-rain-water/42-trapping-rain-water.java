class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peekLast()] <= height[i]) {
                int cur = stack.pollLast();
                int left = stack.isEmpty() ? 0 : stack.peekLast() + 1;
                int leftHeight = stack.isEmpty() ? height[cur] : height[stack.peekLast()];
                int rightHeight = i == n ? 0 : height[i];
                res += (Math.min(leftHeight, rightHeight) - height[cur]) * (i - left);
            }
            stack.offerLast(i);
        }
        return res;
    }
}