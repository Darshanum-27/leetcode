// 404. Sum of Left Leaves

// Given the root of a binary tree, return the sum of all left leaves.

// A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: 24
// Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.

// Example 2:
// Input: root = [1]
// Output: 0

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
    public static int dfsParse(TreeNode root, int sum, int dir){
        if(root!=null){ //dir is used to check if the value is from left leaf node
            if((root.left==null)&&(root.right==null)&&(dir == 1)){ //first two conditions are for leaf node check
            //dir == indicates its a left leaf so together it is a left leaf node
                sum+=root.val;
            }
            if(root.left!=null){
                sum = Solution.dfsParse(root.left,sum,1); //going to left node so send 1 for dir
            }
            if(root.right!=null){
                sum = Solution.dfsParse(root.right,sum,0); // going right so send -1 for dir
            }
            return sum;
        }
        return 0;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        return Solution.dfsParse(root,0,-1); // dfs search
    }
}