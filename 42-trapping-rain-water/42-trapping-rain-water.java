class Solution {
    public int trap(int[] height) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peekFirst()]) {
                int bottom = stack.pollFirst();
                if (stack.isEmpty()) break;
                res += (Math.min(height[i], height[stack.peekFirst()]) - height[bottom]) * (i - stack.peekFirst() - 1);
            }
            stack.offerFirst(i);
        }
        return res;
    }
}