class Trie {
    static class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;
        public TrieNode(){
            children = new HashMap<>();
        }
    }
    
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        char[] arr = word.toCharArray();
        for (char ch : arr) {
            if (cur.children.get(ch) == null) {
                cur.children.put(ch, new TrieNode());
            }
            cur = cur.children.get(ch);
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        TrieNode cur = root;
        for (char ch : arr) {
            if (cur.children.get(ch) == null) {
                return false;
            }
            cur = cur.children.get(ch);
        }
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        TrieNode cur = root;
        for (char ch : arr) {
            if (cur.children.get(ch) == null) {
                return false;
            }
            cur = cur.children.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */