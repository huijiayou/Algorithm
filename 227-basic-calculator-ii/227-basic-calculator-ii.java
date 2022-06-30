class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= '0' && cur <= '9') {
                num = num * 10 + (cur - '0');
            }
            if (i == s.length() - 1 || cur == '+' || cur == '-' || cur == '*' || cur == '/') {
                if (operator == '+') stack.offerFirst(num);
                else if (operator == '-') stack.offerFirst(-num);
                else if (operator == '*') stack.offerFirst(stack.pollFirst() * num);
                else if (operator == '/') stack.offerFirst(stack.pollFirst() / num);
                operator = cur;
                num = 0;
            }
        }
        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;
    }
}