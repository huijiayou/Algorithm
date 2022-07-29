class FileSystem {
    static class TrieNode {
        String name;
        Map<String, TrieNode> map;
        StringBuilder content;
        boolean isFile;
        public TrieNode(String name) {
            this.name = name;
            map = new HashMap<>();
            isFile = false;
            content = new StringBuilder();
        }
    }

    TrieNode root;
    public FileSystem() {
        root = new TrieNode("/");
    }

    public List<String> ls(String path) {
        TrieNode node = traverse(path);
        List<String> res = new ArrayList<>();
        if (node.isFile) {
            res.add(node.name);
        } else {
            Set<String> set = node.map.keySet();
            for (String str : set) {
                res.add(str);
            }
        }
        Collections.sort(res);
        return res;
    }

    public void mkdir(String path) {
        traverse(path);
    }

    public void addContentToFile(String filePath, String content) {
        TrieNode cur = traverse(filePath);
        cur.isFile = true;
        cur.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        TrieNode cur = traverse(filePath);
        return cur.content.toString();
    }
    private TrieNode traverse(String path) {
        String[] arr = path.split("/");
        TrieNode cur = root;
        for (int i = 1; i < arr.length; i++) {
            if (!cur.map.containsKey(arr[i])) {
                TrieNode node = new TrieNode(arr[i]);
                cur.map.put(arr[i], node);
            }
            cur = cur.map.get(arr[i]);
        }
        return cur;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */