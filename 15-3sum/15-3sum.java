/*
    using a loop + 2sum
    -1, 0,  1,  2,  -1, -4
    i
        2sum
*/


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            List<List<Integer>> cur = twoSum(nums, 0 - nums[i], i + 1);
            if (cur.size() > 0) {
                set.addAll(cur);
            }
            while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return new ArrayList<>(set);
    }
    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        int i = start;
        int j = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                res.add(Arrays.asList(nums[start - 1], nums[i], nums[j]));
                while (i + 1 < j && nums[i] == nums[i + 1]) {
                    i++;
                }
                while (j - 1 > i && nums[j] == nums[j - 1]) {
                    j--;
                }
                i++;
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}