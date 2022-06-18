/*
    kth largest value
    maintain a minheap (size k), each time if an element is larger than the peak (the smallest),
    replace it with the larger one, therefore, in the end the minheap is maintain the top k largest number
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                minheap.offer(nums[i]);
            } else {
                if (nums[i] > minheap.peek()) {
                    minheap.poll();
                    minheap.offer(nums[i]);
                }
            }
        }
        return minheap.poll();
    }
}