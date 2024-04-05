// 637. Average of Levels in Binary Tree

// Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [3.00000,14.50000,11.00000]
// Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
// Hence return [3, 14.5, 11].

// Example 2:
// Input: root = [3,9,20,15,7]
// Output: [3.00000,14.50000,11.00000]

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
    public static HashMap<Integer,ArrayList<Integer>> inorder(TreeNode root, HashMap<Integer,ArrayList<Integer>> Output,int count){
        if(root!=null){
            ArrayList<Integer> arr = Output.getOrDefault(count-1, new ArrayList<Integer>());
            arr.add(root.val);
            Output.put(count-1,arr);
            if(root.left!= null){
                Output = Solution.inorder(root.left,Output,count+1);
            }
            if(root.right != null){
                Output = Solution.inorder(root.right,Output,count+1);
            }
            return Output;
        }
        return Output;
    }
    public List<Double> averageOfLevels(TreeNode root) {
        HashMap<Integer,ArrayList<Integer>> arr = Solution.inorder(root,new HashMap<Integer,ArrayList<Integer>>(), 1);
        List<Double> output= new ArrayList<Double>();
        for(ArrayList<Integer> arr1: arr.values()){
            Double sum = 0.0;
            for(int i=0;i<arr1.size();i++){
                sum+=arr1.get(i);
            }
            output.add(Double.valueOf(sum)/arr1.size());
        }
        return output;
    }
}