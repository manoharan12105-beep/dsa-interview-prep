/* 
  # LeetCode 152. Maximum Product Subarray

    ## Problem Statement
    Given an integer array `nums`, find the contiguous non-empty subarray that has the largest product and return its product.

    A subarray is a contiguous sequence of elements within the array.

    ## Example 1
    Input: nums = [2,3,-2,4]
    Output: 6
    Explanation:
    The subarray [2,3] has the largest product = 6.

    ## Example 2
    Input: nums = [-2,0,-1]
    Output: 0
    Explanation:
    The result cannot be 2 because [-2,-1] is not a contiguous subarray.

    ## Approach
    Modified Kadane's Algorithm
    - Maintain both the maximum and minimum product ending at the current index.
    - A negative number can turn the minimum product into the maximum product (and vice versa).
    - Update the global maximum product at every step.

    ## Complexity
    Time Complexity  : O(n)
    Space Complexity : O(1)
*/

class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0], minProd = nums[0], result = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(maxProd * curr, minProd * curr));
            
            minProd = Math.min(curr, Math.min(maxProd * curr, minProd * curr));
            maxProd = tempMax;
            result = Math.max(result, maxProd);
        }

        return result;
    }
}
