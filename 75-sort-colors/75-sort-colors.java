/*
    using 2 index to maintain 3 ranges:
    i,j,k
    [0, i): red 0
    [i, j): white 1
    [j, k]: unprocessed
    [k+1, end]: blue 2
    
    i,j goes from left to right
    k goes from right to left
    
    0,  0,  1,  1,  2,  2
            i
                j
                k
    if i == 0; swap j and i, i++ j++
    if i == 1; j++
    if i == 2; swap j and k, k--
    
    0   0   1   1   2  2
            i
                    j
                k
    
    
*/


class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = 0;
        int k = nums.length - 1;
        while (j <= k) {
            if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            } else if (nums[j] == 1) {
                j++;
            } else {
                swap(nums, j, k);
                k--;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}