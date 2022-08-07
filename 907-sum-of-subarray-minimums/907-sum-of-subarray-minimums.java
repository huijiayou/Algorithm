class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int modulo = 1000000007;
        int[] left = new int[n];
        Arrays.fill(left, -1);
        Deque<Integer> min = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!min.isEmpty() && arr[min.peekLast()] > arr[i]) {
                min.pollLast();
            }
            left[i] = min.isEmpty() ? -1 : min.peekLast();
            min.offerLast(i);
        }
        min = new ArrayDeque<>();
        int[] right = new int[n];
        Arrays.fill(right, n);
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!min.isEmpty() && arr[min.peekLast()] >= arr[i]) {
                min.pollLast();
            }
            right[i] = min.isEmpty() ? n : min.peekLast();
            min.offerLast(i);
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (arr[i] * (long)(i - left[i]) * (long)(right[i] - i));
            sum %= modulo;
        }
        return (int)sum;
    }
}