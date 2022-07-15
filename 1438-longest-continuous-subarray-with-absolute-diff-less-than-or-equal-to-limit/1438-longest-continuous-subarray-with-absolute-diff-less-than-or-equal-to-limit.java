/*
        
    we want to get the largest and smallest difference
    we don't want n^2 TC, so only go through n, left index and right index can't go backwards
    use increasing monotonic queue and decreasing monotonic queue
        if the largest - smallest > limit, it mean we need to move left index
        else update the result
    
*/


class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();
        
        int res = 0, left = 0, right = 0;
        while (right < nums.length) {
            while (!min.isEmpty() && nums[min.peekLast()] >= nums[right]) {
                min.pollLast();
            }
            min.offerLast(right);
            
            while (!max.isEmpty() && nums[max.peekLast()] <= nums[right]) {
                max.pollLast();
            }
            max.offerLast(right);
            
            while (nums[max.peekFirst()] - nums[min.peekFirst()] > limit) {
                if (min.peekFirst() == left) min.pollFirst();
                if (max.peekFirst() == left) max.pollFirst();
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}