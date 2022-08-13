class Solution {
    static class Pair{
        char ch;
        int count;
        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {
        /*
            d   e   e   e   d   b   b   c   c   c   b   d   a   a
            
            pair<character, frequency> when frequency==k, pop it out
        */
        char[] arr = s.toCharArray();
        Deque<Pair> stack = new ArrayDeque<>();
        for (char cur : arr) {
            if (!stack.isEmpty() && stack.peekLast().ch == cur) {
                stack.peekLast().count++;
                if (stack.peekLast().count == k) {
                    stack.pollLast();
                }
            } else {
                stack.offerLast(new Pair(cur, 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Pair i : stack) {
            int count = i.count;
            while (count > 0) {
                sb.append(i.ch);
                count--;
            }
        }
        return sb.toString();
    }
}