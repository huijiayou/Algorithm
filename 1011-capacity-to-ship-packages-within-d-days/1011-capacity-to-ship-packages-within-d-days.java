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
        int min = Integer.MIN_VALUE;
        int max = 0;
        for (int item : weights) {
            min = Math.max(min, item);
            max += item;
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (!couldFinished(weights, mid, days)) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
    private boolean couldFinished(int[] weights, int capacity, int days) {
        int daysNeed = 0;
        int load = capacity;
        for (int item : weights) {
            if (load == item) {
                daysNeed++;
                load = capacity;
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