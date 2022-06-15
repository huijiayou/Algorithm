/*

    input: int[] piles, int h
    output: int minimum k
    
    h hours
    k speed
    n+nlogn
*/


class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minLen = 1;
        int maxLen = piles[0];
        for (int i = 1; i < piles.length; i++) {
            maxLen = Math.max(maxLen, piles[i]);
        }
        
        while (minLen + 1 < maxLen) {
            int midLen = (maxLen - minLen) / 2 + minLen;
            int count = getCount(piles, midLen);
            if (count > h) {
                minLen = midLen;
            } else {
                maxLen = midLen;
            }
        }
        
        if (getCount(piles, minLen) < h) {
            return minLen;
        }
        return maxLen;
    }
    
    private int getCount(int[] piles, int midLen) {
        int count = 0;
        for (int i = 0; i < piles.length; i++) {
            int num = piles[i];
            count += num / midLen;
            count += (num % midLen == 0 ? 0 : 1);
        }
        return count;
    }
}