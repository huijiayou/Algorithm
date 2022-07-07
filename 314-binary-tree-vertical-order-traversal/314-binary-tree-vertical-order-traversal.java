/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static class Pair {
        int row;
        int col;
        int val;
        public Pair(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Pair>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, 0, map);
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (Integer key : keys) {
            List<Pair> list = map.get(key);
            Collections.sort(list, (Pair a, Pair b) -> a.row - b.row);
            List<Integer> cur = new ArrayList<>();
            for (Pair i : list) {
                cur.add(i.val);
            }
            res.add(cur);
        }
        return res;
    }
    private void helper(TreeNode root, int row, int col, Map<Integer, List<Pair>> map) {
        if (root == null) return;
        if (!map.containsKey(col)) {
            map.put(col, new ArrayList<>());
        }
        map.get(col).add(new Pair(row, col, root.val));
        
        helper(root.left, row + 1, col - 1, map);
        helper(root.right, row + 1, col + 1, map);
    }
}