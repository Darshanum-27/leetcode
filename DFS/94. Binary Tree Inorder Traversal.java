//94. Binary Tree Inorder Traversal

// Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

// Example 1:
// Input: root = [1,null,2,3]
// Output: [1,3,2]

// Example 2:
// Input: root = []
// Output: []

// Example 3:
// Input: root = [1]
// Output: [1]

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
    public static List<Integer> inorder(TreeNode root, List<Integer> Output){
        if(root!=null){
            if(root.left!=null){
                Output = Solution.inorder(root.left,Output);
            }
            Output.add(root.val);
            if(root.right != null){
                Output = Solution.inorder(root.right,Output);
            }
            return Output;
        }
        return Output;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> Output = new ArrayList<Integer>();
        return Solution.inorder(root, Output);
    }
}