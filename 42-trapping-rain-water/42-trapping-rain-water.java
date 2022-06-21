/*
    from left and right to middle
    which side is lower, move it's pointer
    
    4   2   0   3   2   5
            i
                    j
    left        
                        right
        2   4   1   2        
   
    0    1   0   2   1   0   1   3   2   1   2   1
                                left   
                                     right
                        i
                                            j
             1      1   2   1           1
*/

class Solution {
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int left = height[0];
        int right = height[height.length - 1];
        int i = 1;
        int j = height.length - 2;
        int total = 0;
        while (i <= j) {
            if (left <= right) {
                left = Math.max(left, height[i]);
                total += left - height[i++];
            } else {
                right = Math.max(right, height[j]);
                total += right - height[j--];
            }
        }
        return total;
    }
}