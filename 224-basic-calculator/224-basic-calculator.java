class Solution {
    public int calculate(String s) {
        return helper(s, 0)[0];
    }
     private int[] helper(String s, int i) {
        Deque<Integer> stack = new ArrayDeque<>();
        char operator = '+';
        int num = 0;
        while (i < s.length()) {
            char cur = s.charAt(i++);
            if (cur >= '0' && cur <= '9') {
                num = num * 10 + (cur - '0');
            }
            if (cur == '(') {
                int[] res = helper(s, i);
                num = res[0];
                i = res[1];
            }
            if (i == s.length() || cur == '+' || cur == '-' || cur == ')') {
                if (operator == '+') stack.offerFirst(num);
                else if (operator == '-') stack.offerFirst(-num);
                operator = cur;
                num = 0;
            }
            if (cur == ')') break;
        }
        int res = 0;
        for (int j : stack) {
            res += j;
        }
        return new int[] {res, i};
    }
}