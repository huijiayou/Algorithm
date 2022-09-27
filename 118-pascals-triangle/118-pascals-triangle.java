class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(new Integer[] {1})));
        if (numRows == 1) return res;
        res.add(new ArrayList<>(Arrays.asList(new Integer[] {1,1})));
        if (numRows == 2) return res;
        for (int i = 2; i < numRows; i++) {
            List<Integer> prev = res.get(res.size() - 1);
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 0; j < prev.size() - 1; j++) {
                cur.add(prev.get(j) + prev.get(j + 1));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
}