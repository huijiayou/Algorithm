/*
    1. sort the 2-d array based on their start value
    2. for each inner array:
        - if end is larger than next start, but smaller than next end, update end
        - if end if larger than next end, skip next
        - else, go to next
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return 0;
                }
                return arr1[0] < arr2[0] ? -1 : 1;
            }
        });
        
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i]);
            while (i + 1 < intervals.length && list.get(list.size() - 1)[1] >= intervals[i + 1][0]) {
                int end = list.get(list.size() - 1)[1];
                if (end >= intervals[i + 1][0] && end < intervals[i + 1][1] ) {
                    list.get(list.size() - 1)[1] = intervals[i + 1][1];
                }
                i++;
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}