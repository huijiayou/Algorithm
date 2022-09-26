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
    public int maxPathSum(TreeNode root) {
        int[] maxsum = {Integer.MIN_VALUE};
        dfs(root, maxsum);
        return maxsum[0];
    }
    private int dfs(TreeNode root, int[] maxsum) {
        if (root == null) return 0;
        int left = dfs(root.left, maxsum);
        left = left < 0 ? 0 : left;
        int right = dfs(root.right, maxsum);
        right = right < 0 ? 0 : right;
        maxsum[0] = Math.max(maxsum[0], left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}