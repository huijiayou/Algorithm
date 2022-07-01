class LRUCache {
    static class Node {
        public int key;
        public int value;
        public Node next;
        public Node prev;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map =  new HashMap<>(capacity);
        head = new Node(-1, 0);
        tail = new Node(-1, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node.key);
        add(key, node.value);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(key);
        } else if (map.size() == capacity) {
            remove(tail.prev.key);
        }
        add(key, value);
    }
    
    private void remove(int key) {
        Node node = map.get(key);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        map.remove(key);
    }
    
    private void add(int key, int value) {
        Node newNode = new Node(key, value);
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
        
        map.put(key, newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */