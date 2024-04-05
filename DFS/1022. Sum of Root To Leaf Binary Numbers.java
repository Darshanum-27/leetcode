// 1022. Sum of Root To Leaf Binary Numbers

// Hint
// You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit.

// For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
// For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.

// The test cases are generated so that the answer fits in a 32-bits integer.

// Example 1:
// Input: root = [1,0,1,0,1,0,1]
// Output: 22
// Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22

// Example 2:
// Input: root = [0]
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
    public static int convertToBinary(ArrayList<String> arr){
        int sum = 0;
        for(int i=0;i<arr.size();i++){
            String s1 = arr.get(i);
            int val = 0;
            for(int j=0;j<s1.length();j++){
                String s = String.valueOf(s1.charAt(j));
                val = val+(int)Math.pow(2,Integer.parseInt(s)*s1.length()-j-1);
            }
            sum = sum+val;
        }
        return sum;
    }
    
    public static List<String> inorder(TreeNode root, List<String> Output,String val){
        if(root!=null){
            val = val+String.valueOf(root.val);
            if((root.left == null) &&(root.right == null)){
                Output.add(val);
            }
            if(root.left!=null){
                Output = Solution.inorder(root.left,Output,val);
            }
            if(root.right!=null){
                Output = Solution.inorder(root.right,Output,val);
            }
            return Output;
        }
        return Output;
    }
    public int sumRootToLeaf(TreeNode root) {
        ArrayList arr = new ArrayList(Solution.inorder(root,new ArrayList<String>(),""));
        System.out.println(arr);
        return Solution.convertToBinary(arr);
    }
}