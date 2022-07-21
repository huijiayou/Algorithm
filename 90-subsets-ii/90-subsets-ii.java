class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, res, cur, 0);
        return res;
    }
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        dfs(nums, res, cur, index + 1);
        cur.remove(cur.size() - 1);
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        dfs(nums, res, cur, index + 1);
    }
}