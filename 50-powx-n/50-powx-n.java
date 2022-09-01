class Solution {
    public double myPow(double x, int n) {
        if (x == 0 && n == 0) {
            return 1.0;
        } else if (x == 0) {
            return 0.0;
        } else if (n == 0) {
            return 1.0;
        }
        double result = dfs(x, Math.abs(n));
        if (n > 0) {
            return result;
        } else {
            return 1.0 / result;
        }
    }
    private double dfs(double x, int n) {
        if (n == 1) {
            return x;
        } else if (n == 0) {
            return 1.0;
        }
        double result = dfs(x, n / 2);
        if (n % 2 == 0) {
            return result * result;
        } else {
            return result * result * x;
        }
    }
}