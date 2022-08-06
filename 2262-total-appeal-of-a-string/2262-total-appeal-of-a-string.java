class Solution {
    public long appealSum(String s) {
        /*
            since the input size is 10^5, we have use O(n) algorithm to finish it
            instead of checking all substring, 
            we can focus on each element to get it's valid subarray
            use a 26 length int array to remember the latest same letter position
            [xxxx a xxxaxxxa]
            xxxxa[xxx a xxxa]
            xxxxaxxxaxxx[ a ]
            
        */
        int[] dupli = new int[26];
        for (int i = 0; i < 26; i++) {
            dupli[i] = -1;
        }
        long res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int left = dupli[s.charAt(i) - 'a'];
            res += (long)(i - left) * (long)(n - i);
            dupli[s.charAt(i) - 'a'] = i;
        }
        return res;
    }
}