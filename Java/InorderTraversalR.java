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
import java.util.List;
import java.util.ArrayList;

class InorderTraversalR {
    public List<Integer> inorder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return arr;
        }

        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);

        return arr;
    } 
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        return inorder(root, arr);
    }
}