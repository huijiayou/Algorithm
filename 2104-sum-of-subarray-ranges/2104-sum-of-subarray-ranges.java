class Solution {
    public long subArrayRanges(int[] nums) {
        /*
            we use monotonic stack go over elements twice to get the left and right boundaries for the current element that 
            the current element is the smallest or largest in this range
            2 [4 5 3 6 5] 1
                   c
            l      i       r
            i-l means how many positions that we can place [
            r-i means how many positions that we can place]
            we choose one from left side and one from right side and multiple them
        
            then sum += element * (i - l) * (r - i)
            then sum -= element * (i' - l') * (r' - i')
        */
        
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();
        long sum = 0;
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            while(!max.isEmpty() && (i == n || nums[max.peekLast()] <= nums[i])) {
                int cur = max.pollLast();
                int left = max.isEmpty() ? -1 : max.peekLast();
                sum += (long)nums[cur] * (cur - left) * (i - cur);
            }
            max.offerLast(i);
            while(!min.isEmpty() && (i == n || nums[min.peekLast()] >= nums[i])) {
                int cur = min.pollLast();
                int left = min.isEmpty() ? -1 : min.peekLast();
                sum -= (long)nums[cur] * (cur - left) * (i - cur);
            }
            min.offerLast(i);
        }
        return sum;
    }
}