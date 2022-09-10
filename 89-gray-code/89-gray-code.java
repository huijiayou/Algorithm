class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);
        for (int i = 2; i <= n; i++) {
            int last = result.size() - 1;
            for (int j = last; j >= 0; j--) {
                result.add(result.get(j) | (1 << i - 1));
            }
        }
        return result;
    }
}