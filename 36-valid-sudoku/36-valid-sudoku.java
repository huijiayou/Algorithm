class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Character>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String key = Integer.toString(i) + ',' + j;
                map.put(key, new HashSet());
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char cur = board[i][j];
                if (cur == '.') continue;
                String row = cur + " in row " + i;
                String col = cur + " in col " + j;
                String block = Integer.toString(i / 3) + ',' + j / 3;
                Set<Character> blockset = map.get(block);
                if (!set.add(row) || !set.add(col) || !blockset.add(cur)) {
                    return false;
                }
            }
        }
        return true;
    }
}