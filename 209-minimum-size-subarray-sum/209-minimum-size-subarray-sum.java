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
        int count = Integer.MAX_VALUE;
        int total = 0;
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            total += nums[j++];
            while (total >= target) {
                count = Math.min(count, j - i);
                total -= nums[i++];
            }
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }
}