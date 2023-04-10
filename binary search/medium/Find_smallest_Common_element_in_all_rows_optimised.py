#1198. Find Smallest Common Element in All Rows


#_________________________________________________
# Given an m x n matrix mat where every row is sorted in strictly increasing order, return the smallest common element in all rows.

# If there is no common element, return -1.

# Example 1:

# Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
# Output: 5
# Example 2:

# Input: mat = [[1,2,3],[2,3,4],[2,3,5]]
# Output: 2

# program
def req(mat,l):
        if mat == []:   #if you have reached last subarray of mat array
            return l    # return l
        for i in l:        
            if i not in mat[0]: #if element of l not in list
                l.remove(i) # remove element from the list
        return(req(mat[1:],l))  #move to next subarray by shrinking the list 

class Solution:
    def smallestCommonElement(self, mat: List[List[int]]) -> int:
        a = req(mat[1:],mat[0])         #pass remaining elements of array except first and pass first as second 
        return -1 if len(a)==0 else a[0]    #if no repeatative elements pass -1 else pass zero