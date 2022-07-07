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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        bfs(root, map);
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (int key : keys) {
            res.add(map.get(key));
        }
        return res;
    }
    private void bfs(TreeNode root, Map<Integer, List<Integer>> map) {
        Queue<TreeNode> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        q1.offer(root);
        q2.offer(0);
        while (!q1.isEmpty()) {
            TreeNode cur = q1.poll();
            int col = q2.poll();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(cur.val);
            if (cur.left != null) {
                q1.offer(cur.left);
                q2.offer(col - 1);
            }
            if (cur.right != null) {
                q1.offer(cur.right);
                q2.offer(col + 1);
            }
        }
    }
}