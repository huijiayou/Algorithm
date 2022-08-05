class MedianFinder {

    /*
        - we want to find the middle point
        - use 2 heaps to save samller half and larger half
        - for larger half, we need to get the smallest number, so if we use maxHeap, we can only get max value so
        - fro larger half, we use minheap, for smaller half, we use maxheap
        
            /       minheap
            |
           /        maxheap
        - if both heaps are empty, we add the value in minheap
        - if one heap is empty
            - if minheap is not, we need to check if the cur value > minheap.peek(), we add it into minheap, and 
              poll one from minheap and add it into maxheap
            - else, check if cur > minheap -> add into minheap
                             cur < maxHeap - > add into maxheap
            - check balance, adjust if necessary
            
        - find median:
            - if both size are equal, return the average of minheap.peek and max.peek
            - else, return the bigger one peek
    */
    
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;
    
    public MedianFinder() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                if (i1 == i2) return 0;
                return i1 < i2 ? 1 : -1;
            }
        });
    }
    
    public void addNum(int num) {
        if (minheap.isEmpty() && maxheap.isEmpty()) {
            minheap.offer(num);
        } else {
            if (!minheap.isEmpty() && minheap.peek() < num) {
                minheap.offer(num);
            } else if (!maxheap.isEmpty() && maxheap.peek() > num) {
                maxheap.offer(num);
            } else if (minheap.isEmpty()) {
                minheap.offer(num);
            } else {
                maxheap.offer(num);
            }
        }
        balance();
    }
    private void balance() {
        if (Math.abs(minheap.size() - maxheap.size()) > 1) {
            if (minheap.size() > maxheap.size()) {
                maxheap.offer(minheap.poll());
            } else {
                minheap.offer(maxheap.poll());
            }
        }
    }
    
    public double findMedian() {
        if (minheap.size() == maxheap.size()) {
            return ((double)minheap.peek() + maxheap.peek()) / 2;
        } else {
            return minheap.size() > maxheap.size() ? minheap.peek() : maxheap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */