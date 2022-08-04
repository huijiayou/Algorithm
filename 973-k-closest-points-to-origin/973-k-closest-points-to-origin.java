class Solution {
   static class Points {
        int x;
        int y;
        int distance;
        public Points (int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    private Points[] getArray(int[][] points) {
        Points[] res = new Points[points.length];
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int distance = x * x + y * y;
            res[i] = new Points(x, y, distance);
        }
        return res;
    }
    public int[][] kClosest(int[][] points, int k) {
        Points[] arr = getArray(points);
        helper(arr, 0, arr.length - 1, k);
        int[][] res = new int[k][];
        for (int i = 0; i < k; i++) {
            int[] cur = {arr[i].x, arr[i].y};
            res[i] = cur;
        }
        return res;
    }
    private void helper(Points[] points, int left, int right, int k) {
        if (left >= right) return;
        int index = ThreadLocalRandom.current().nextInt(left, right);
        int pivot = points[index].distance;
        swap(points, index, right);
        int l = left;
        int r = right - 1;
        while (l <= r) {
            if (points[l].distance >= pivot) {
                swap(points, l, r);
                r--;
            } else {
                l++;
            }
        }
        swap(points, l, right);
        int leftLength = l - left + 1;
        if (k < leftLength) {
            helper(points, left, l - 1, k);
        } else if (k > leftLength) {
            helper(points, l + 1, right, k - leftLength);
        }
    }
    private void swap(Points[] points, int i, int j) {
        Points temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}






