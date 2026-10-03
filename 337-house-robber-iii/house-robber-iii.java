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
    public int rob(TreeNode root) {
        int []option=traverse(root);
        return Math.max(option[0],option[1]);
    }
    public int[] traverse(TreeNode root){
        if(root==null)return new int[2];
        int []left=traverse(root.left);
        int []right=traverse(root.right);
        int []option=new int[2];
        option[0]=root.val+left[1]+right[1];
        option[1]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return option;
    }
}