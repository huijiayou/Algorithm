class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        /*
            30  20  150 100 40
            30  20  30  40  40
        */
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            int reduceTime = time[i] % 60;
            int other = reduceTime == 0 ? 0 : 60 - reduceTime;
            res += map.getOrDefault(other, 0);
            map.put(reduceTime, map.getOrDefault(reduceTime, 0) + 1);
        }
        return res;
    }
}