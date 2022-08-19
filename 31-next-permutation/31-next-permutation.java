class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i + 1] > nums[i]) {
                break;
            }
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }
    // 1   2    5   8   7   6
    //          i
    // 2 3 1
    // 1 2 3
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}