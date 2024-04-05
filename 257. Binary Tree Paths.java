// 257. Binary Tree Paths

// Given the root of a binary tree, return all root-to-leaf paths in any order.

// A leaf is a node with no children.

// Example 1:
// Input: root = [1,2,3,null,5]
// Output: ["1->2->5","1->3"]

// Example 2:

// Input: root = [1]
// Output: ["1"]

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
    public static List<String> binary(TreeNode root, List<String> output, String strs){
        if(root!=null){
            if((root.left == null)&&(root.right == null)){
                if(strs == ""){
                output.add(strs+String.valueOf(root.val));
                return output;
                } else{
                    output.add(strs+"->"+String.valueOf(root.val));
                    return output;
                }
            }
            else{
                if(strs == "")
                    strs = strs+String.valueOf(root.val);
                else
                    strs = strs+"->"+String.valueOf(root.val);
            }
            if(root.left!=null){
                output = Solution.binary(root.left,output,strs);
            }
            if(root.right!=null){
                output = Solution.binary(root.right,output,strs);
            }
            return output;
        }
        return output;
    }
    public List<String> binaryTreePaths(TreeNode root) {
        return Solution.binary(root, new ArrayList<String>(),"");
    }
}