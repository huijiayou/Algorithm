class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]> () {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return 0;
                }
                return arr1[0] < arr2[0] ? -1 : 1;
            }
        });
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] cur = intervals[i];
            while (i + 1 < n && cur[1] >= intervals[i + 1][0]) {
                cur[0] = Math.min(cur[0], intervals[i + 1][0]);
                cur[1] = Math.max(cur[1], intervals[i + 1][1]);
                i++;
            }
            list.add(cur);
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}