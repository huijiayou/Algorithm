class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int x = 0; i - x >= 0 && i + x < n; x++) {
                if (s.charAt(i - x) != s.charAt(i + x)) {
                    break;
                }
                res++;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int x = 1; i - x + 1 >= 0 && i + x < n; x++) {
                if (s.charAt(i - x + 1) != s.charAt(i + x)) {
                    break;
                }
                res++;
            }
        }
        return res;
    }
}