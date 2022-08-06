class SORTracker {
    static class Rank implements Comparable<Rank>{
        String name;
        int score;
        public Rank (String name, int score) {
            this.name = name;
            this.score = score;
        }
        @Override
        public int compareTo(Rank r1) {
            if (this.score == r1.score) return r1.name.compareTo(this.name);
            return this.score < r1.score ? -1 : 1;
        }
    }
    private PriorityQueue<Rank> minheap;
    private PriorityQueue<Rank> maxheap;
    
    public SORTracker() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void add(String name, int score) {
        minheap.offer(new Rank(name, score));
        maxheap.offer(minheap.poll());
    }
    
    public String get() {
        minheap.offer(maxheap.poll());
        return minheap.peek().name;
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */