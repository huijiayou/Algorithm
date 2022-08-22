class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                if (Math.abs(res - target) > Math.abs(nums[i] + nums[left] + nums[right] - target)) {
                    res = nums[i] + nums[left] + nums[right];
                }
                if (nums[left] + nums[right] < target - nums[i]) {
                    left++;
                } else if (nums[left] + nums[right] > target - nums[i]){
                    right--;
                } else {
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}