class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            int[] cur = intervals[i];
            if (newInterval[0] > cur[1]) {
                list.add(cur);
            } else if (newInterval[1] < cur[0]) {
                if (flag) {
                    list.add(newInterval);
                    flag = false;
                }
                list.add(cur);
            } else {
                newInterval = new int[] {Math.min(newInterval[0], cur[0]), Math.max(newInterval[1], cur[1])};
            }
        }
        if (flag) list.add(newInterval);
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}