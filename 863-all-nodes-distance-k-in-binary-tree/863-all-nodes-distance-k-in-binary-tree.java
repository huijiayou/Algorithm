/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
        build undirectional graph
    */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (k == 0) return new ArrayList<>(Arrays.asList(target.val));
        Map<TreeNode, List<TreeNode>> adj = new HashMap<>();
        preorder(root, adj);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        int steps = 0;
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty() && steps < k) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                List<TreeNode> neis = adj.get(cur);
                for (TreeNode nei : neis) {
                    if (visited.add(nei)) {
                        queue.offer(nei);
                        visited.add(nei);
                        if (steps == k) {
                            res.add(nei.val);
                        }
                    }
                }
            }
        }
        return res;
    }
    private void preorder(TreeNode root, Map<TreeNode, List<TreeNode>> map) {
        if (root == null) return;
        if (!map.containsKey(root)) {
            map.put(root, new ArrayList<>());
        }
        if (root.left != null && !map.containsKey(root.left)) {
            map.put(root.left, new ArrayList<>());
        }
        if (root.right != null && !map.containsKey(root.right)) {
            map.put(root.right, new ArrayList<>());
        }
        if(root.left != null) {
            map.get(root).add(root.left);
            map.get(root.left).add(root);
        }
        if(root.right != null) {
            map.get(root).add(root.right);
            map.get(root.right).add(root);
        }
        preorder(root.left, map);
        preorder(root.right, map);
    }
}








