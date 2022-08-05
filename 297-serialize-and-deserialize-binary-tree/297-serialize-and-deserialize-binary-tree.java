/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty() && flag) {
            flag = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    sb.append("null,");
                } else {
                    sb.append(cur.val).append(",");
                }
                if (cur != null) {
                    if (cur.left == null && cur.right == null) {
                        queue.offer(null);
                        queue.offer(null);
                    } else {
                        if (cur.left != null || cur.right != null) flag = true;
                        if (cur.left != null) queue.offer(cur.left);
                        else queue.offer(null);

                        if (cur.right != null) queue.offer(cur.right);
                        else queue.offer(null);
                    }
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] arr = data.split(",");
        TreeNode root = bfs(arr);
        return root;
    }

    private TreeNode bfs(String[] arr) {
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < arr.length) {
            TreeNode node = queue.poll();
            if (!arr[index].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(arr[index]));
                queue.offer(node.left);
            }
            index++;
            if (index < arr.length && !arr[index].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(arr[index]));
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }
    private TreeNode dfs(String[] arr, int index) {
        if (index < arr.length && !arr[index].equals("null")) {
            TreeNode node = new TreeNode(Integer.parseInt(arr[index]));
            node.left = dfs(arr, index * 2 + 1);
            node.right = dfs(arr, index * 2 + 2);
            return node;
        }
        return null;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));












