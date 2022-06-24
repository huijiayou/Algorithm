/*
    (   )   {   }   [   ]
    1   2   3   4   5   6  
    i
        j
    stack: (}
    ({[]})
    TC: O(n)
    SC: O(n)
*/

class Solution {
    public boolean isValid(String s) {
        // main
        // key '('')', value 1-6
        Map<Character, Integer> map = getMap();
        Deque<Character> stack = new ArrayDeque<>();
        char[] array = s.toCharArray();
        for (int i = 0 ; i < array.length; i++) {
            if (stack.isEmpty() || map.get(array[i]) % 2 != 0) {
                stack.offerFirst(array[i]);
            } else {
                if (map.get(stack.peekFirst()) != map.get(array[i]) - 1) {
                    return false;
                } else {
                    stack.pollFirst();
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
    private Map<Character, Integer> getMap() {
        String s = "()[]{}";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            map.put(cur, i + 1);
        }
        return map;
    }
}