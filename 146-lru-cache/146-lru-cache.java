class LRUCache {
    
    static class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    private int capacity;
    private int size;
    private Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        head = new Node(Integer.MAX_VALUE, -1);
        tail = new Node(Integer.MAX_VALUE, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            update(key, node.value);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            update(key, value);
        } else {
            if (size == capacity) {
                remove();
            }
            add(key, value);
        }
    }
    private void remove() {
        Node node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        node.next = null;
        node.prev = null;
        map.remove(node.key);
        size--;
    }
    
    private void update(int key, int value) {
        Node node = map.get(key);
        node.value = value;
        if (size > 1 && head.next != node) {
            Node pre = node.prev;
            Node next = node.next;
            pre.next = next;
            next.prev = pre;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }
    }
    
    private void add(int key, int value) {
        Node node = new Node(key, value);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        map.put(key, node);
        size++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */