class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while (map.size() > k) {
                char ch = s.charAt(left++);
                int count = map.get(ch) - 1;
                if (count == 0) map.remove(ch);
                else map.put(ch, count);
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}

/*
    eceba
    l
      i
    e-1
    c-1
    b-1
*/