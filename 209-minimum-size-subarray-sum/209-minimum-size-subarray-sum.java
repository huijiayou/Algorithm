/*
    subarray means the elements in the results should be continuous
    sliding window
    0   1   2   3   4   5
    2   3   1   2   4   3
                        i
                            j
    total = 9
    if the total value in the sliding window < target - j++
    if the total value > target - i++
*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 1;
        int sum = nums[l];
        int count = Integer.MAX_VALUE;
        while(r < nums.length) {
            if (sum < target) {
                sum += nums[r++];
            }
            while (sum >= target) {
                count = Math.min(count, r - l);
                sum -= nums[l++];
            }
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }
}