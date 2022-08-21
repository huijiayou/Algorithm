class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int max = 0;
        while (right < n) {
            while (!set.isEmpty() && set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right++));
            max = Math.max(max, right - left);
        }
        return max;
    }
}