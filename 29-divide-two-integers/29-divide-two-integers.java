class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNeg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        int count = 0;
        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs((long)divisor);
        int shift = 31;
        while (absDividend >= absDivisor) {
            while (absDividend < (absDivisor << shift)) {
                shift--;
            }
            absDividend -= (absDivisor << shift);
            count += (1 << shift);
        }
        return isNeg ? -count : count;
    }
}