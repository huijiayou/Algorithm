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
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {
        dfs(root);
        int temp = second.val;
        second.val = first.val;
        first.val = temp;
    }
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
                second = root;
            } else {
                second = root;
                return;
            }
        }
        prev = root;
        dfs(root.right);
    }
}