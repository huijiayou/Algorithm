class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, res, cur);
        return res;
    }
    private void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> cur) {
        if (index == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        dfs(nums, index + 1, res, cur);
        cur.remove(cur.size() - 1);
        
        dfs(nums, index + 1, res, cur);
    }
}