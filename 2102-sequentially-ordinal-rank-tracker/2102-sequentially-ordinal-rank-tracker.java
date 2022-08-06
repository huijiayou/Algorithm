class SORTracker {
    static class Rank {
        String name;
        int score;
        public Rank (String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
    private PriorityQueue<Rank> minheap;
    private PriorityQueue<Rank> maxheap;

    public SORTracker() {
        minheap = new PriorityQueue<>(new Comparator<Rank>(){
            @Override
            public int compare(Rank r1, Rank r2) {
                int res = r2.name.compareTo(r1.name);
                if (r1.score == r2.score) return res;
                return r1.score < r2.score ? -1 : 1;
            }
        });
        maxheap = new PriorityQueue<>(new Comparator<Rank>(){
            @Override
            public int compare(Rank r1, Rank r2) {
                if (r1.score == r2.score) return r1.name.compareTo(r2.name);
                return r1.score < r2.score ? 1 : -1;
            }
        });
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