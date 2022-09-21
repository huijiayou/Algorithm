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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(postorder, map, 0, n - 1, 0, n - 1);
    }
    private TreeNode buildTree(int[] postorder, Map<Integer, Integer> map, int leftPost, int rightPost, int leftIn, int rightIn) {
        if(leftPost > rightPost) return null;
        TreeNode root = new TreeNode(postorder[rightPost]);
        int rootIndex = map.get(postorder[rightPost]);
        int leftCount = rootIndex - leftIn;
        root.left = buildTree(postorder, map, leftPost, leftPost + leftCount - 1, leftIn, rootIndex - 1);
        root.right = buildTree(postorder, map, leftPost + leftCount, rightPost - 1, rootIndex + 1, rightIn);
        return root;
    }
}