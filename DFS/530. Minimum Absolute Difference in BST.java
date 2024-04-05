// 530. Minimum Absolute Difference in BST

// Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

 

// Example 1:
// Input: root = [4,2,6,1,3]
// Output: 1

// Example 2:
// Input: root = [1,0,48,null,null,12,49]
// Output: 1

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
    public static int findMin(TreeNode root, int min, ArrayList<Integer> arr){
        if(root!=null){
            for(Integer i: arr){
                if((i!=root.val)&&(min>Math.abs(i-root.val))){
                    min = Math.abs(i-root.val);
                }
            }
            if(root.left!=null){
                min = Solution.findMin(root.left,min,arr);
            }
            if(root.right!=null){
                min = Solution.findMin(root.right,min,arr);
            }
            return min;
        }
        return min;
    }
    public int getMinimumDifference(TreeNode root) {
        ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr.add(root);
        while(arr.size()>0){
            TreeNode r = arr.remove(0);
            arr1.add(r.val);
            if(r.left!=null){
                arr.add(r.left);
            }
            if(r.right!=null){
                arr.add(r.right);
            }
        }
        return Solution.findMin(root,100000,arr1);
    }
}
