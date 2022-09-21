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
        int n = preorder.length;
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return buildTree(preorder, inOrderMap, 0, n - 1, 0, n - 1);
    }
    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> inOrderMap, int leftPre, int rightPre, int leftIn, int rightIn) {
        if (leftPre > rightPre) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[leftPre]);
        int rootIndexIn = inOrderMap.get(preorder[leftPre]);
        int leftCount = rootIndexIn - leftIn;
        root.left = buildTree(preorder, inOrderMap, leftPre + 1, leftPre + leftCount, leftIn, rootIndexIn - 1);
        root.right = buildTree(preorder, inOrderMap, leftPre + leftCount + 1, rightPre, rootIndexIn + 1, rightIn);
        return root;
    }
}