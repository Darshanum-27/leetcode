// 104. Maximum Depth of Binary Tree

// Given the root of a binary tree, return its maximum depth.

// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: 3

// Example 2:
// Input: root = [1,null,2]
// Output: 2

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
    public static int MaxDepth(TreeNode t,int count){
        int leftCount = 0;
        int rightCount = 0;
        if(t.left == null && t.right == null) return count;
        if(t.left!= null){
            leftCount = MaxDepth(t.left,count+1);
        }
        if(t.right!=null){
            rightCount = MaxDepth(t.right,count+1);
        }
        if((leftCount == rightCount)||(rightCount>leftCount)) return rightCount;
        if(leftCount>rightCount) return leftCount;
        return -1;
    }
    public int maxDepth(TreeNode root) {
        if(root != null) {return MaxDepth(root,1);}
        return 0;
    }
}