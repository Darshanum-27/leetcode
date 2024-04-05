// 1469. Find All The Lonely Nodes

// Example 1:
// Input: root = [1,2,3,null,4]
// Output: [4]
// Explanation: Light blue node is the only lonely node.
// Node 1 is the root and is not lonely.
// Nodes 2 and 3 have the same parent and are not lonely.

// Example 2:
// Input: root = [7,1,4,6,null,5,3,null,null,null,null,null,2]
// Output: [6,2]
// Explanation: Light blue nodes are lonely nodes.
// Please remember that order doesn't matter, [2,6] is also an acceptable answer.

// Example 3:
// Input: root = [11,99,88,77,null,null,66,55,null,null,44,33,null,null,22]
// Output: [77,55,33,66,44,22]
// Explanation: Nodes 99 and 88 share the same parent. Node 11 is the root.
// All other nodes are lonely.

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
    public List<Integer> getLonelyNodes(TreeNode root) {
        Stack<TreeNode> arr = new Stack<TreeNode>();
        arr.push(root);
        ArrayList<Integer> l = new ArrayList<Integer>();
        while(!arr.isEmpty()){
            TreeNode x = arr.pop();
            if((x.left!=null)&&(x.right == null)) l.add(x.left.val);
            if((x.left==null)&&(x.right != null)) l.add(x.right.val);
            if(x.left != null) arr.push(x.left);
            if(x.right != null) arr.push(x.right);
        }
        return l;
    }
}