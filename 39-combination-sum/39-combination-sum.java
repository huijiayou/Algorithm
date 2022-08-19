class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(candidates, target, res, cur, 0);
        return res;
    }
    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> cur, int index) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            cur.add(candidates[i]);
            dfs(candidates, target - candidates[i], res, cur, i);
            cur.remove(cur.size() - 1);
        }
    }
}