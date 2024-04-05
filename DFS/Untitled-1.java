// 501. Find Mode in Binary Search Tree

// Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

// If the tree has more than one mode, return them in any order.

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than or equal to the node's key.
// The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
// Both the left and right subtrees must also be binary search trees.
 

// Example 1:
// Input: root = [1,null,2,2]
// Output: [2]

// Example 2:
// Input: root = [0]
// Output: [0]

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
    public static HashMap<Integer,Integer> findMode(TreeNode root, HashMap<Integer,Integer> arr){
        if(root!=null){
            arr.put(root.val,arr.getOrDefault(root.val,0)+1);
            if(root.left!=null){
                arr = Solution.findMode(root.left,arr);
            }
            if(root.right!=null){
                arr = Solution.findMode(root.right,arr);
            }
            return arr;
        }
        return arr;
    }
    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> arr = Solution.findMode(root,new HashMap<Integer,Integer>());
        System.out.println(arr);
        int maxval = 0;
        for(int i:arr.keySet()){
            if(arr.get(i)>maxval){
                maxval = arr.get(i);
            }
        }
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        for(int i:arr.keySet()){
            if(arr.get(i)==maxval){
                a1.add(i);
            }
        }
        int[] arr1 = new int[a1.size()];
        for(int i=0;i<a1.size();i++){
            arr1[i] = a1.get(i);
        }
        return arr1;
    }
}