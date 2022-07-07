class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int count = Integer.MAX_VALUE;
        long[] sum = new long[n + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n ; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 0; i < n + 1; i++) {
            while (!queue.isEmpty() && sum[i] <= sum[queue.peekLast()]) {
                queue.pollLast();
            }
            while (!queue.isEmpty() && sum[i] - sum[queue.peekFirst()] >= k) {
                count = Math.min(count, i - queue.pollFirst());
            }
            queue.offerLast(i);
        }
        return count == Integer.MAX_VALUE ? -1 : count;
    }
}