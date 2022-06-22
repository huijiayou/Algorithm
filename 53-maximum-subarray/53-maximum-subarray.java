class Solution {
    public int maxSubArray(int[] nums) {
        int globalMax = Integer.MIN_VALUE;
        int curMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            curMax = curMax > 0 ? curMax + nums[i] : nums[i];
            globalMax = Math.max(globalMax, curMax);
        }
        return globalMax;
    }
}