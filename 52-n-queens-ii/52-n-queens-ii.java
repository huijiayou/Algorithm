class Solution {
    public int totalNQueens(int n) {
        int[] res = new int[1];
        List<Integer> queens = new ArrayList<>();;
        dfs(n, 0, queens, res);
        return res[0];
    }
    private void dfs(int n, int index, List<Integer> queens, int[] res) {
        if (index == n) {
            res[0]++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(index, i, queens)) {
                queens.add(i);
                dfs(n, index + 1, queens, res);
                queens.remove(queens.size() - 1);
            }
        }
    }
    private boolean isValid(int row, int col, List<Integer> queens) {
        int n = queens.size();
        for (int i = 0; i < n; i++) {
            if (queens.get(i) == col || Math.abs(row - i) == Math.abs(queens.get(i) - col)) {
                return false;
            }
        }
        return true;
    }
}