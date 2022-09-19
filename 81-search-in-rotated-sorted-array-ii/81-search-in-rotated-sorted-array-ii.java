class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int split = -1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                split = i;
                break;
            }
        }
        if (split != -1) {
            if (target >= nums[0] && target <= nums[split]) {
                return binarySearch(nums, target, 0, split);
            } else if (target >= nums[split + 1] && target <= nums[n - 1]) {
                return binarySearch(nums, target, split + 1, n - 1);
            } else {
                return false;
            }
        } else {
            return binarySearch(nums, target, 0, n - 1);
        }
    }
    private boolean binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}