# 226. Invert Binary Tree
# Example 1:

# Input: root = [4,2,7,1,3,6,9]
# Output: [4,7,2,9,6,3,1]

# Example 2:


# Input: root = [2,1,3]
# Output: [2,3,1]

# Example 3:

# Input: root = []
# Output: []

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

def bfsReverse(queue,visited,ptr): #to reverse the tree
    queue.append(ptr)   #add pointer to queue
    visited.append(ptr) #add pointer to visited
    
    while(queue):   #while queue is not empty
        data = queue.pop(0) #pop the queue
        if(data):           #if the data exits
            if(data.left) or (data.right):  #if node had 2 children or single one which is going to be swapped
                temp = data.left
                data.left = data.right
                data.right = temp       #swapping using 3rd variable
                if(data.left not in visited) and (data.right not in visited):   #adding child to queue
                    queue.append(data.left)
                    queue.append(data.right)    
            visited.append(data)    #adding node to visited
    return ptr                      #return ptr
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        return bfsReverse([],[],root)       #function call
        