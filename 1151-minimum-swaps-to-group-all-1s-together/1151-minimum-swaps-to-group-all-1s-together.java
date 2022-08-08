class Solution {
    public int minSwaps(int[] data) {
        /*
            1,0,1,0,1,0,0,1,1,0,1
                      ___________
            - total the number of 1 sliding window
            check the max prefix
            return total - pre
        */
        int slidingWindow = 0;
        for (int i : data) {
            if (i == 1) slidingWindow++;
        }
        int n = data.length;
        int res = 0;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + data[i];
        }
        for (int i = slidingWindow; i <= n; i++) {
            res = Math.max(res, prefix[i] - prefix[i - slidingWindow]);
        }
        return slidingWindow - res;
    }
}