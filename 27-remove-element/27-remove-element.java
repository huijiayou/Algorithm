class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        int n = nums.length;
        while (fast < n) {
            if (nums[fast] == val) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }
        return slow;
    }
}