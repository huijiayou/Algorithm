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
        */
        int left = 0;
        int right = x;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            long power = (long)mid * (long)mid;
            if (power == x) {
                return mid;
            } else if (power > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        long rightPower = (long)right * (long)right;
        if (rightPower <= x) return right;
        return left;
    }
}