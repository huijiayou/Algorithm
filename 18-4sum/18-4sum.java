class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                long remains = (long)target - (nums[i] + nums[j]);
                List<List<Integer>> cur = twoSum(nums, remains, i, j);
                if (cur.size() > 0) {
                    res.addAll(cur);
                }
            }
        }
        return new ArrayList<>(res);
    }
    public List<List<Integer>> twoSum(int[] nums, long target, int first, int second) {
        int i = second + 1;
        int j = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (i < j) {
            long sum = nums[i] + nums[j];
            if (sum == target) {
                res.add(Arrays.asList(nums[first], nums[second], nums[i++], nums[j--]));
                while (i < j && nums[i - 1] == nums[i]) {
                    i++;
                }
                while (j > i && nums[j] == nums[j + 1]) {
                    j--;
                }
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}