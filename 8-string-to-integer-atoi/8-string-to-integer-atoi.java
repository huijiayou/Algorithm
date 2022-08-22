class Solution {
    public int myAtoi(String s) {
        int start = 0;
        int n = s.length();
        // check space
        while (start < n && s.charAt(start) == ' ') {
            start++;
        }
        if (start == n) return 0;
        int sign = 1;
        // check sign
        if (s.charAt(start) == '-') {
            sign = -1;
            start++;
        } else if (s.charAt(start) == '+'){
            sign = 1;
            start++;
        }
        if (start == n) return 0;
        int res = 0;
        while (start < n) {
            int digit = s.charAt(start++) - '0';
            if (digit < 0 || digit > 9) {
                return res * sign;
            }
            int newResult = res * 10 + digit;
            if (newResult / 10 != res) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = newResult;
        }
        return res * sign;
    }
}