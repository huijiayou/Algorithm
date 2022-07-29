class Trie {
    static class TrieNode {
        Map<Character, TrieNode> children;
        Character name;
        int count;
        int prefix;
        public TrieNode(Character name) {
            this.name = name;
            children = new HashMap<>();
        }
    }
    private TrieNode root;
    public Trie() {
        root = new TrieNode('/');
    }

    public void insert(String word) {
        TrieNode cur = root;
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (!cur.children.containsKey(arr[i])) {
                TrieNode node = new TrieNode(arr[i]);
                cur.children.put(arr[i], node);
            }
            if (i > 0) cur.prefix++;
            cur = cur.children.get(arr[i]);
        }
        cur.prefix++;
        cur.count++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode node = search(word);
        if (node == null) return 0;
        return node.count;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode node = search(prefix);
        if (node == null) return 0;
        return node.prefix;
    }

    public void erase(String word) {
        TrieNode node = search(word);
        if (node == null || node.count == 0) return;
        TrieNode cur = root;
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) cur.prefix--;
            cur = cur.children.get(arr[i]);
        }
        cur.prefix--;
        cur.count--;
    }
    private TrieNode search(String word) {
        TrieNode cur = root;
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (!cur.children.containsKey(arr[i])) {
                return null;
            }
            cur = cur.children.get(arr[i]);
        }
        return cur;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */