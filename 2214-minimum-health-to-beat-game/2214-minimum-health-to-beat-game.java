class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long sum = 0;
        long max = 0;
        for (int i : damage) {
            sum += i;
            max = Math.max(max, i);
        }
        if (max > armor) {
            return sum - armor + 1;
        } else {
            return sum - max + 1;
        }
    }
}