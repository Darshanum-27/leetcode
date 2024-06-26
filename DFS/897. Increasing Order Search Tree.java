// 897. Increasing Order Search Tree

// Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.

 

// Example 1:
// Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
// Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

// Example 2:
// Input: root = [5,1,7]
// Output: [1,null,5,null,7]

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
    public static TreeNode Dfs1(TreeNode t, TreeNode newTree){
		if(t.left!=null){
			newTree = Solution.Dfs1(t.left,newTree); 
		}
		newTree.right = new TreeNode(t.val,null,null);
		newTree = newTree.right;
		if(t.right!=null){
			newTree = Solution.Dfs1(t.right, newTree);
		}
		return newTree;
	}
    public TreeNode increasingBST(TreeNode root) {
        TreeNode outputPtr = new TreeNode(-100,null,null);
		TreeNode output = Solution.Dfs1(root, outputPtr);
		return outputPtr.right;
    }
}
