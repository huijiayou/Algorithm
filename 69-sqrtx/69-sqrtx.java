class Solution {
    public int mySqrt(int x) {
        /*
            find the largest value that value * value <= x
            - binary search
            - left and right index to calculate mid
                while (left < right - 1)
                    - mid * mid == x, return mid
                    - mid * mid > x, right = mid
                    - mid * mid < x, left = mid
                compare right first, then left
            
            - or we can check left <= right and use result to save
            
        */
        int left = 1;
        int right = x;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}