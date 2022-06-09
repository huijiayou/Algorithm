class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int lowbit = xor & -xor;
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & lowbit) == 0) { // the bit is not set
                res[0] = res[0] ^ num;
            } else { // the bit is set
                res[1] = res[1] ^ num;
            }
        }
        return res;
    }
}