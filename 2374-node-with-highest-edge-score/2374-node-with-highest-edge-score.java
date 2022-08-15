class Solution {
    public int edgeScore(int[] edges) {
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.put(edges[i], map.getOrDefault(edges[i], 0L) + i);
        }
        int node = edges.length;
        long count = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > count || (map.get(key) == count && key < node)) {
                node = key;
                count = map.get(key);
            }
        }
        return node;
    }
}