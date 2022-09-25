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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int[] res = new int[1];
        List<Integer> temp = new ArrayList<>();
        dfs(root, targetSum, res, temp);
        return res[0];
    }
    private void dfs(TreeNode root, int target, int[] res, List<Integer> temp) {
        if (root == null) return;
        temp.add(root.val);
        long sum = 0;
        for (int i = temp.size() - 1; i >= 0; i--) {
            sum += temp.get(i);
            if (sum == target) {
                res[0]++;
            }
        }
        dfs(root.left, target, res, temp);
        dfs(root.right, target, res, temp);
        temp.remove(temp.size() - 1);
    }
}