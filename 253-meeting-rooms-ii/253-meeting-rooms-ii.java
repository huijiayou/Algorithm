class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        int i = 0;
        for (int[] interval : intervals) {
            starts[i] = interval[0];
            ends[i] = interval[1];
            i++;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int count = 0;
        int pre = 0;
        for (int j = 0; j < n; j++) {
            count++;
            if (ends[pre] <= starts[j]) {
                count--;
                pre++;
            }
        }
        return count;
    }
}