/*
    template:
    for (start : end) {
        while (!stack.isEmpty() && array[i] > array[stack.peekFirst()]) {
            stack.pollFirst()
        }
        map.put(...)
        stack.offerFirst(i)
    }
    
    this question 
*/


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n];
        for (int i = n * 2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % nums.length] >= stack.peekFirst()) {
                stack.pollFirst();
            }
            res[i % nums.length] = stack.isEmpty() ? -1 : stack.peekFirst();
            stack.offerFirst(nums[i % nums.length]);
        }
        return res;
    }
}