class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        Deque<Integer> min = new ArrayDeque<>();
        int modulo = 1000000007;
        int n = arr.length;
        for (int i = 0; i <= n; i++) {
            while (!min.isEmpty() && (i == n || arr[min.peekLast()] > arr[i])) {
                int c = min.pollLast();
                int l = min.isEmpty() ? -1 : min.peekLast();
                sum += arr[c] * (long)(c - l) * (long)(i - c);
                sum %= modulo;
            }
            min.offerLast(i);
        }
        return (int)sum;
    }
}