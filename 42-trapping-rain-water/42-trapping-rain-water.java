class Solution {
    public int trap(int[] height) {
        int left = 0;
        int n = height.length;
        int right = n - 1;
        int res = 0;
        int heightLeft = height[left];
        int heightRight = height[right];
        while (left < right) {
            if (heightLeft <= heightRight) {
                res += heightLeft - height[left++];
                heightLeft = Math.max(heightLeft, height[left]);
            } else {
                res += heightRight - height[right--];
                heightRight = Math.max(heightRight, height[right]);
            }
        }
        return res;
    }
}