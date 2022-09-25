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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> temp = new ArrayList<>();
        dfs(root, targetSum, 0, temp, res);
        return res;
    }
    private void dfs(TreeNode root, int target, int sum, List<Integer> temp, List<List<Integer>> res) {
        if (root.left == null && root.right == null) {
            if (sum + root.val == target) {
                temp.add(root.val);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            }
            return;
        }
        temp.add(root.val);
        if (root.left != null) {
            dfs(root.left, target, sum + root.val, temp, res);
        }
        if (root.right != null) {
            dfs(root.right, target, sum + root.val, temp, res);
        }
        temp.remove(temp.size() - 1);
    }
}