/*
    it requires the order (lexicographical), try monotonic stack
    from left to right
    has duplicates, so until the last time of an element, a larger element can be replaced by smaller one
*/



class Solution {
    public String removeDuplicateLetters(String s) {
        char[] array = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int[] count = new int[26];
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - 'a';
            count[index]++;
        }
        for (int i = 0; i < array.length; i++) {
            count[array[i] - 'a']--;
            if (stack.contains(array[i])) continue;
            while (!stack.isEmpty() && array[i] < stack.peekFirst() && count[stack.peekFirst() - 'a'] > 0) {
                stack.pollFirst();
            }
            stack.offerFirst(array[i]);
        }
        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}