class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int max = 0;
        while (r < s.length()) {
            char cur = s.charAt(r);
            while (l < s.length() && !set.isEmpty() && set.contains(cur)) {
                set.remove(s.charAt(l++));
            }
            set.add(cur);
            max = Math.max(max, set.size());
            r++;
        }
        return max;
    }
}