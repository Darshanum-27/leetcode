# 852. Peak Index in a Mountain Array
# Medium
# 5K
# 1.8K
# company
# Bloomberg
# company
# Facebook
# company
# Amazon
# An array arr a mountain if the following properties hold:

# arr.length >= 3
# There exists some i with 0 < i < arr.length - 1 such that:
# arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
# arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
# Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

# You must solve it in O(log(arr.length)) time complexity.

 

# Example 1:

# Input: arr = [0,1,0]
# Output: 1
# Example 2:

# Input: arr = [0,2,1,0]
# Output: 1
# Example 3:

# Input: arr = [0,10,5,2]
# Output: 1


class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        a = arr.index(max(arr))  #find max array and its index
        if a < len(arr):    #check if the index is less than length - 1
            return a