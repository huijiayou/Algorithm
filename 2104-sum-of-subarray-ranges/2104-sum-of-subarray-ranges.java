class Solution {
    public long subArrayRanges(int[] nums) {
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();
        int n = nums.length;
        
        long total = 0;
        for (int i = 0; i < n; i++) {
            max.clear();
            min.clear();
            for (int j = i; j < n; j++) {
                while (!max.isEmpty() && max.peekLast() <= nums[j]) {
                    max.pollLast();
                }
                max.offerLast(nums[j]);
                while(!min.isEmpty() && min.peekLast() >= nums[j]) {
                    min.pollLast();
                }
                min.offerLast(nums[j]);
                total += (max.peekFirst() - min.peekFirst());
            }
        }
        return total;
    }
}