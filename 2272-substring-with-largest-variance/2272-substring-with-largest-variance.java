class Solution {
    public int largestVariance(String s) {
        /*
            for substring, think about use string pair to replace the given string
            26*26
            replace by 1 and -1 for each letter pair,
            calculate the max subarray sum
            since we have to include one -1, so using each -1 as center, check it's left and right
            combine them - num[i]
            go from left -> right
            go from right -> left
            
        */
        
        int res = 0;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j) continue;
                if (freq[i] == 0 || freq[j] == 0) continue;
                res = Math.max(res, helper(s, (char)(i + 'a'), (char)(j + 'a')));
            }
        }
        return res;
    }
    private int helper(String s, char a, char b) {
        int n = s.length();
        int res = 0;
        int[] arr = new int[n];
        // change to 1 and -1 array
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == a) arr[i] = 1;
            else if (s.charAt(i) == b) arr[i] = -1;
            else arr[i] = 0;
        }
        int[] sum = new int[n];
        sum[0] = arr[0];
        // from left to right
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] > 0 ? sum[i - 1] + arr[i] : arr[i];
        }
        // from right to left
        int secsum = 0;
        for (int i = n - 1; i >= 0; i--) {
            secsum = secsum > 0 ? secsum + arr[i] : arr[i];
            if (arr[i] == - 1) {
                res = Math.max(res, sum[i] + secsum - arr[i]);
            }
        }
        return res;
    }
}













