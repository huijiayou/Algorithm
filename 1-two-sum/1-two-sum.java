/*
    return indices, so we can sort the array
    using a map to check if each element's complement exists in the map
    
    target = 9
    2   11  7   15
            i
    comple=-2?
    map=2-0,11-1,
*/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (map.containsKey(target - cur)) {
                res[0] = i;
                res[1] = map.get(target - cur);
                break;
            }
            map.put(cur, i);
        }
        return res;
    }
}