#702. Search in a Sorted Array of Unknown Size
#__________________________________________________________________________________

# This is an interactive problem.

# You have a sorted array of unique elements and an unknown size. You do not have an access to the array but you can use the ArrayReader interface to access it. You can call ArrayReader.get(i) that:

# returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
# returns 231 - 1 if the i is out of the boundary of the array.
# You are also given an integer target.

# Return the index k of the hidden array where secret[k] == target or return -1 otherwise.

# You must write an algorithm with O(log n) runtime complexity.

 

# Example 1:

# Input: secret = [-1,0,3,5,9,12], target = 9
# Output: 4
# Explanation: 9 exists in secret and its index is 4.
# Example 2:

# Input: secret = [-1,0,3,5,9,12], target = 2
# Output: -1
# Explanation: 2 does not exist in secret so return -1.

#program
def searcharr(arr,target,i):
    if target == arr.get(i): #return index if it matches
        return i
    try:# try to handle any other exceptions like single element 
        if (target>arr.get(i) and target<arr.get(i+1)) or (target>arr.get(i) and (arr.get(i+1) == None)):
            return -1 #if current element is less than target and greater than next element then target does not exit so return -1
            # if only one element exist then second condition after or.
            # anything else Try Except handles it
        else:
            i = i+1 if arr.get(i)<target else i-1 #incrementing or decrementing I value based on target element
            return searcharr(arr,target,i)# if element is less or greater than current element call again
    except:
        return -1 #if any exception comes call the -1
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        return searcharr(reader,target,5) #calling the function