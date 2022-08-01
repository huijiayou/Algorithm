/*
    0   1  2  3  4 5
    (X (X (L) X) L E
     k     i     l
    ( - 3 (i - k + 1)
    ) - 2 (l - i)
     so the total number of substring of "xxlx" is 3 * 2
    usually we focus on all substrings, now we focus on each letter and find out the contribution substring range
*/


class Solution {
    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!map.containsKey(cur)) {
                map.put(cur, new ArrayList<>());
            }
            map.get(cur).add(i);
        }
        int res = 0;
        Set<Character> keyset = map.keySet();
        for (char key : keyset) {
            List<Integer> list = map.get(key);
            for (int i = 0; i < list.size(); i++) {
                int mid = list.get(i);
                int left = i == 0 ? mid + 1 : mid - list.get(i - 1);
                int right = i == list.size() - 1 ? s.length() - mid : list.get(i + 1) - mid;
                res += left * right;
            }
        }
        return res;
    }
}