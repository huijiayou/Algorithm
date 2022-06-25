class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] incremental = new int[length + 1];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int increase = update[2];
            incremental[start] += increase;
            incremental[end + 1] -= increase;
        }
        for (int i = 1; i < incremental.length; i++) {
            incremental[i] += incremental[i - 1];
        }
        return Arrays.copyOfRange(incremental, 0, length);
    }
}