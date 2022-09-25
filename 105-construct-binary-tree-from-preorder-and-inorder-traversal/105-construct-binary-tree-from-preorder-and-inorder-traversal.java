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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, map, 0, inorder.length - 1, 0, inorder.length - 1);
    }
    private TreeNode dfs(int[] preorder, Map<Integer, Integer> map, int leftPre, int rightPre, int leftIn, int rightIn) {
        if (leftPre > rightPre) return null;
        TreeNode root = new TreeNode(preorder[leftPre]);
        int indexIn = map.get(preorder[leftPre]);
        int leftCount = indexIn - leftIn;
        root.left = dfs(preorder, map, leftPre + 1, leftPre + leftCount, leftIn, indexIn - 1);
        root.right = dfs(preorder, map, leftPre + leftCount + 1, rightPre, indexIn + 1, rightIn);
        return root;
    }
}