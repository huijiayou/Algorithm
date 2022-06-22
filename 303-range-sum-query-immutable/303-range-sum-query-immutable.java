class NumArray {
    private int[] sumArray;
    
    public NumArray(int[] nums) {
        sumArray = new int[nums.length];
        getSumArray(nums);
    }
    
    private void getSumArray(int[] nums) {
        sumArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumArray[i] = sumArray[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) {
            return sumArray[right];
        } else {
            return sumArray[right] - sumArray[left - 1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */