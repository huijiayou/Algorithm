/*
    1,2,3,4,5,6,7,8,9,10
    min weight 1
    max weight 10
    get mid (starting point)
    
    - if calculated days <= given days, right = mid
    - else left = mid + 1
*/


class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int item : weights) {
            min = Math.min(min, item);
            max += item;
        }
        while (min < max - 1) {
            int mid = min + (max - min) / 2;
            if (!couldFinished(weights, mid, days)) {
                min = mid;
            } else {
                max = mid;
            }
        }
        return couldFinished(weights, min, days) ? min : max;
    }
    private boolean couldFinished(int[] weights, int capacity, int days) {
        int daysNeed = 0;
        int load = capacity;
        for (int item : weights) {
            if (load == item) {
                daysNeed++;
                load = capacity;
            } else if (item > capacity) {
                return false;
            } else if (load < item) {
                daysNeed++;
                load = capacity - item;
                if (load == 0) {
                    daysNeed++;
                    load = capacity;
                }
            } else {
                load -= item;
            }
        }
        if (load < capacity && load > 0) {
            daysNeed++;
        }
        return daysNeed <= days;
    }
}