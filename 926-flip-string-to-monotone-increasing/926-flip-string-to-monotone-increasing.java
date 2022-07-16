/*
    zeroOnRight at i: the total zeros in the string after index i, that we need to flip
    onesOnLeft at i: the total ones in the string before index i, that we need to flip
    chose the minimum zerosOnRight+onesOnLeft
    
*/


class Solution {
    public int minFlipsMonoIncr(String s) {
        char[] arr = s.toCharArray();
        int zerosOnRight = 0;
        int onesOnLeft = 0;
        for (char i : arr) {
            if (i == '0') {
                zerosOnRight++;
            }
        }
        int res = zerosOnRight;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                zerosOnRight--;
            } else {
                onesOnLeft++;
            }
            res = Math.min(res, zerosOnRight + onesOnLeft);
        }
        return res;
    }
}