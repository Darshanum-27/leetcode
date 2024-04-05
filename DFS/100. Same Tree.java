//100. Same Tree

// Given the roots of two binary trees p and q, write a function to check if they are the same or not.

// Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

// Example 1:
// Input: p = [1,2,3], q = [1,2,3]
// Output: true

// Example 2:
// Input: p = [1,2], q = [1,null,2]
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
    public static boolean isSame(TreeNode p, TreeNode q, boolean output){
        if((p!=null)&&(q!=null)){
            if (output == false){
                return false;          //return false if already false
            }
            if(p.val!=q.val){           // check value if different then change it 
                System.out.println(p.val == q.val);
                return false;
            }
            //LEFT NODE
            if((p.left!=null)&&(q.left!=null)){  
                // if left node exist for both node
                output = Solution.isSame(p.left, q.left, output);
            } 
            else if(((p.left==null)&&(q.left==null))&&(output == true)){
                // if it has reached leaf node and output if not false else there will be true for different values
                // [0,-5] and [0,-8] will come true because
                // false comes from above if loop and and since the condition for this if is to check if leaf node
                // false becomes true and gives overall true
                output = true;
            }
            else if(((p.left == null)&&(q.left!=null))||((p.left!=null)&&(q.left==null))){
                // check if one node has child and other does not
                output = false;
            }
            else{
                // if none of the above match return false
                output = false;
            }
            // RIGHT NODE
            if((p.right!=null)&&(q.right!=null)){
                output = Solution.isSame(p.right, q.right, output);
            } 
            else if(((p.right==null)&&(q.right==null))&&(output == true)){
                output = true;
            }
            else if(((p.right == null)&&(q.right!=null))||((p.right!=null)&&(q.right==null))){
                output = false;
            }
            else{
                output = false;
            }
        } else if (((p!=null)&&(q==null))||((p==null)&&(q!=null))){ // check if one node exist and other does not
            return false;
        } else{
            // return true if both nodes are null
            return true;
        }
    return output;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Solution s = new Solution();
        return Solution.isSame(p,q,true);
    }
}
