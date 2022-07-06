/*
    23, 2,  4,  6,  7
    23  25  29  35  42
    5   1   5   5   0
    t=6
*/


class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, mode = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            mode = sum % k;
            if (map.containsKey(mode)) {
                if (i - map.get(mode) > 1) {
                    return true;
                }
            } else {
                map.put(mode, i);
            }
        }
        return false;
    }
}