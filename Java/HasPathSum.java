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
class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return path_sum(root, targetSum, 0);
    }

    private boolean path_sum(TreeNode root, int target, int sum) {
        if ((root == null)) {
            return false;
        }
        sum += root.val;
        if (root.left == null && root.right == null && sum == target) {
            return true;
        } 
        if (path_sum(root.left, target, sum)) {
            return true;
        }
        if (path_sum(root.right, target, sum)) {
            return true;
        }
        return false;
    }
}