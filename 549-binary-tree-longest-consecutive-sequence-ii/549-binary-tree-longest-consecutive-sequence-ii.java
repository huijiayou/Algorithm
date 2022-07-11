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
    public int longestConsecutive(TreeNode root) {
        int[] res = {1};
        helper(root, res);
        return res[0];
    }
    private int[] helper(TreeNode root, int[] res) {
        if (root == null) return new int[] {0,0};
        int incr = 1;
        int decr = 1;
        if (root.left != null) {
            int[] left = helper(root.left, res);
            if (root.val == root.left.val + 1) {
                decr += left[1];
            } else if (root.val + 1 == root.left.val) {
                incr += left[0];
            }
        }
        if (root.right != null) {
            int[] right = helper(root.right, res);
            if (root.val == root.right.val + 1) {
                decr = Math.max(decr, right[1] + 1);
            } else if (root.val + 1 == root.right.val) {
                incr = Math.max(incr, right[0] + 1);
            }
        }
        res[0] = Math.max(res[0], incr + decr - 1);
        return new int[] {incr, decr};
    }
}


















