class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(candidates, target, 0, res, cur);
        return res;
    }
    private void dfs(int[] candidates, int target, int index, List<List<Integer>> res, List<Integer> cur) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (index == candidates.length) return;
        cur.add(candidates[index]);
        dfs(candidates, target - candidates[index], index + 1, res, cur);
        cur.remove(cur.size() - 1);
        
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }
        dfs(candidates, target, index + 1, res, cur);
    }
}