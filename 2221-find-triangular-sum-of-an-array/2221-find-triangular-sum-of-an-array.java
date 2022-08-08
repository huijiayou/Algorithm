class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] newarray;
        for (int i = n - 1; i >= 1; i--) {
            newarray = new int[i];
            for (int j = 0; j < i; j++) {
                newarray[j] = (nums[j] + nums[j + 1]) % 10;
            }
            if (i == 1) return newarray[0];
            nums = newarray;
        }
        return 0;
    }
}