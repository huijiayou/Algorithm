/*
    we can try monotonic stack by reducing some letters to get the smallest number
    1432219
          i
    10200
      i
*/


class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && num.charAt(i) < stack.peekFirst() && k > 0) {
                stack.pollFirst();
                k--;
            }
            stack.offerFirst(num.charAt(i));
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pollFirst();
            k--;
        }
        while (!stack.isEmpty() && stack.peekLast() == '0') {
            stack.pollLast();
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}