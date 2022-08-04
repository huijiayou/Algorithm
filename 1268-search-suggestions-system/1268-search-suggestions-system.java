class Solution {
    static class TrieNode {
        private char letter;
        private TrieNode[] children;
        boolean isWord;
        public TrieNode(char letter) {
            this.letter = letter;
            children = new TrieNode[26];
        }
    }
    private TrieNode getTrie(String[] words) {
        TrieNode root = new TrieNode('/');
        for (String str : words) {
            insert(root, str, 0);
        }
        return root;
    }
    private void insert(TrieNode root, String word, int index) {
        if (index == word.length()) {
            root.isWord = true;
            return;
        }
        if (root.children[word.charAt(index) - 'a'] == null) {
            TrieNode node = new TrieNode(word.charAt(index));
            root.children[word.charAt(index) - 'a'] = node;
        }
        insert(root.children[word.charAt(index) - 'a'], word, index + 1);
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = getTrie(products);
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            StringBuilder sb = new StringBuilder();
            TrieNode newRoot = search(root, searchWord.substring(0, i + 1), sb,0);
            if (newRoot != null) {
                dfs(newRoot, temp, sb);
            }
            res.add(new ArrayList<>(temp));
            temp.clear();
        }
        return res;
    }
    private TrieNode search(TrieNode root, String word, StringBuilder sb, int index) {
        if (root == null) return null;
        if (index == word.length()) return root;
        if(root.letter != '/') sb.append(root.letter);
        TrieNode node = search(root.children[word.charAt(index) - 'a'], word, sb,index + 1);
        return node;

    }
    private void dfs(TrieNode root, List<String> temp, StringBuilder sb) {
        if (temp.size() == 3) {
            return;
        }
        sb.append(root.letter);
        if (root.isWord) {
            temp.add(sb.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                dfs(root.children[i], temp, sb);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}