class Solution {
    public String longestPalindrome(String s) {
        /*
            babad
            
            abba
            using each letter as the center and expand
            - aba
            - bb
        */
        int bestLen = 0;
        String res = "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int x = 0; i - x >= 0 && i + x < n; x++) {
                if (s.charAt(i - x) != s.charAt(i + x)) {
                    break;
                }
                int len = 2 * x + 1;
                if (len > bestLen) {
                    bestLen = len;
                    res = s.substring(i - x, i - x + bestLen);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int x = 1; i - x + 1 >= 0 && i + x < n; x++) {
                if (s.charAt(i - x + 1) != s.charAt(i + x)) {
                    break;
                }
                int len = 2 * x;
                if (len > bestLen) {
                    bestLen = len;
                    res = s.substring(i - x + 1, i - x + 1 + bestLen);
                }
            }
        }
        return res;
    }
}