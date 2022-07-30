class Solution {
        static class TrieNode {
        TrieNode[] children;
        int count;
        char key;
        public TrieNode(char key) {
            this.key = key;
            children = new TrieNode[26];
        }
    }
    TrieNode root = new TrieNode('/');
    private void insert(String s) {
        char[] arr = s.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < arr.length; i++) {
            if (cur.children[arr[i] - 'a'] == null) {
                cur.children[arr[i] - 'a'] = new TrieNode(arr[i]);
            }
            cur = cur.children[arr[i] - 'a'];
        }
        cur.count++;
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        for (String str : wordDict) {
            insert(str);
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(s, res, sb, root.children[s.charAt(0) - 'a'], 0);
        return res;
    }
    private void dfs(String s, List<String> res, StringBuilder sb, TrieNode node, int index) {
        if (index == s.length()) {
            res.add(sb.toString());
            return;
        }
        char cur = s.charAt(index);
        if (node == null || node.key != cur) return;
        if (node.count == 0) {
            sb.append(cur);
            if (index + 1 < s.length()) dfs(s, res, sb, node.children[s.charAt(index + 1) - 'a'], index + 1);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            int size = sb.length();
            sb.append(cur).append(" ");
            if (index + 1 < s.length()) {
                dfs(s, res, sb, root.children[s.charAt(index + 1)  - 'a'], index + 1);
            } else {
                sb.deleteCharAt((sb.length() - 1));
                res.add(sb.toString());
            }
            sb.setLength(size);

            sb.append(cur);
            if (index + 1 < s.length()) dfs(s, res, sb, node.children[s.charAt(index + 1)  - 'a'], index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}