/*
        1   3   0   -2  -3  1
sum 0   1   4   4   2   -1  0
%   0   1   1   1   2   2   0
v   1   1   2   3   1   2   2
    T=3
*/


class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, mode = 0, count = 0;
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            mode = (sum % k + k) % k;
            count += map.getOrDefault(mode, 0);
            map.put(mode, map.getOrDefault(mode, 0) + 1);
        }
        return count;
    }
}