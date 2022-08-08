class Solution {
    public int getMaxLen(int[] nums) {
        /*
            xx 0 [1xxx] 0 xxx
            - every time we meet 0, start over
            - if we meet a 0, update i to the first negative position, then check the size
            - if we have even negative numbers, count everything,
            - if we have odd negative numbers, count after the first negative number
            
            [3 2 1 -5 1 2 -1 2] -5 1 1 1 1 1 1 1
            3 2 1 -5 [1 2 -1 2 -5 1 1 1 1 1 1 1]
        */
        int max = 0;
        int n = nums.length;
        int totalLength = 0;
        int lengthAfter1stNeg = 0;
        boolean evenNegFlag = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                totalLength = 0;
                lengthAfter1stNeg = 0;
                evenNegFlag = true;
                continue;
            } else {
                if (nums[i] > 0) {
                    lengthAfter1stNeg = lengthAfter1stNeg == 0 ? 0 : lengthAfter1stNeg + 1;
                } else {
                    evenNegFlag = !evenNegFlag;
                    lengthAfter1stNeg++;
                }
                totalLength++;
                max = Math.max(max, evenNegFlag ? totalLength : lengthAfter1stNeg - 1);
            }
        }
        return max;
    }
}