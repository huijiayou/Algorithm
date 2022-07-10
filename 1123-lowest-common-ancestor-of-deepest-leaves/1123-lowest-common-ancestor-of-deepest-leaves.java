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
    static class Pair{
        TreeNode node;
        int height;
        public Pair(TreeNode node, int height) {
            this.node = node;
            this.height = height;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair lca = helper(root);
        return lca.node;
    }
    private Pair helper(TreeNode root) {
        if (root == null) return new Pair(root, 0);
        
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        if (left.height == right.height) {
            return new Pair(root, left.height + 1);
        } else if (left.height < right.height) {
            right.height += 1;
            return right;
        } else {
            left.height += 1;
            return left;
        }
    }
}