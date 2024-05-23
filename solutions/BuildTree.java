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
import java.util.Arrays;

class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0 || preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }

        int[] left_inorder = Arrays.copyOfRange(inorder, 0, mid);
        int[] left_preorder = Arrays.copyOfRange(preorder, 1, mid + 1);
        root.left = buildTree(left_preorder, left_inorder);

        int[] right_inorder = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
        int[] right_preorder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        root.right = buildTree(right_preorder, right_inorder);

        return root;
    }
}