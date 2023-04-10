#Question
# Given an m x n matrix mat where every row is sorted in strictly increasing order, return the smallest common element in all rows.

# If there is no common element, return -1.

# Example 1: Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
#             Output: 5

# Example 2:Input: mat = [[1,2,3],[2,3,4],[2,3,5]]
#             Output: 2
            
# Program
class Solution:
    def smallestCommonElement(self, mat: List[List[int]]) -> int:
        d ={}           # empty dictionary
        for i in mat[0]:        #creating dictionary for first array rows
            d[i] = d.get(i,0)+1
        for j in mat[1:len(mat)]: # comparing first array row elements to remaining row elements
            for i in j:
                if i in d.keys():
                    d[i] = d.get(i,0)+1
        highest = sorted(d.values())[-1]        #fininding the highest common elements
        if highest != len(mat):                 #checking if repeatation of highest common elements matches the size of list to ensure it appears in all elements.
            return -1
        else:
            print(sorted(d.values()))
            key = 0
            for i in d:
                if d[i] == highest:
                    key = i
                    break                   #determining the key for highest common element
            return key