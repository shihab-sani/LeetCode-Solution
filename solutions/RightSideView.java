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
import java.util.Queue;
import java.util.LinkedList;

 class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root != null) {
            que.add(root);
        }

        while (!que.isEmpty()) {
            TreeNode right_side = null;
            for (int i = 0, length = que.size(); i < length; i++) {
                TreeNode data = que.poll();
                if (data != null) {
                    right_side = data;
                    que.add(data.left);
                    que.add(data.right);
                }
            }
            if (right_side != null) {
                arr.add(right_side.val);
            }
        }
        return arr;
    }
}
