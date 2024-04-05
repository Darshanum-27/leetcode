// 653. Two Sum IV - Input is a BST

// Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

// Example 1:
// Input: root = [5,3,6,2,4,null,7], k = 9
// Output: true

// Example 2:
// Input: root = [5,3,6,2,4,null,7], k = 28
// Output: false

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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<TreeNode> tree = new ArrayList<TreeNode>();
        tree.add(root);
        while(tree.size()>0){
            TreeNode t = null;
            if(tree.size()>0){
             t = tree.remove(0);}
            a.add(t.val);
            if(t.left!=null){
                tree.add(t.left);
            }
            if(t.right !=null){
                tree.add(t.right);
            }
        }

        for(int i=0;i<a.size();i++){
            if((a.contains(k-a.get(i)))&&(i!=a.indexOf(k-a.get(i)))){
                return true;
            }
        }
        return false;
    }
}