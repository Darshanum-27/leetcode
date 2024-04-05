// 938. Range Sum of BST

// Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

// Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
// Output: 32
// Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32

// Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
// Output: 23
// Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.

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
    public static int sumOf(TreeNode t, int low, int high){
		ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
		arr.add(t);
		int sum = 0;
		while(arr.size()>0){
			TreeNode t1 = arr.remove(0);
			if ((t1.val>=low) && (t1.val<=high))
				sum+=t1.val;
			System.out.println(t1.val);
			if(t1.left != null)arr.add(t1.left);
			if(t1.right != null) arr.add(t1.right);
		}
		return sum;
	}
    public int rangeSumBST(TreeNode root, int low, int high) {
        return Solution.sumOf(root,low,high);
    }
}