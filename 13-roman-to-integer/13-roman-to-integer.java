class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            res += map.get(s.charAt(i));
            if (i - 1 >= 0 && map.get(s.charAt(i - 1)) < map.get(s.charAt(i))) res -= 2 * map.get(s.charAt(i - 1));
        }
        return res;
    }
}