class Solution {
    public double myPow(double x, int n) {
        if (x == 0 && n == 0) {
            return 1.0;
        } else if (x == 0) {
            return 0.0;
        } else if (n == 0) {
            return 1.0;
        }
        long size = Math.abs((long)n);
        double res = 1.0;
        while (size > 0) {
            if (size % 2 != 0) res *= x;
            size /= 2;
            x *= x;
        }
        if (n > 0) {
            return res;
        } else {
            return 1 / res;
        }
    }
}