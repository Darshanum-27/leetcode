// 145. Binary Tree Postorder Traversal

// Given the root of a binary tree, return the postorder traversal of its nodes' values.

// Example 1:
// Input: root = [1,null,2,3]
// Output: [3,2,1]

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
    public static List<Integer> postOrder(TreeNode root, List<Integer> output){
        if(root!=null){
            if(root.left !=null){
                output = Solution.postOrder(root.left,output);
            }
            if(root.right !=null){
                output = Solution.postOrder(root.right,output);
            }
            output.add(root.val);
            return output;
        }
        return output;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        return Solution.postOrder(root,new ArrayList<Integer>());
    }
}