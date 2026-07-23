/* 
  # LeetCode 53. Maximum Subarray

    ## Problem Statement
    Given an integer array `nums`, find the contiguous subarray with the largest sum and return its sum.

    ## Example 1
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation:
    The subarray [4,-1,2,1] has the largest sum of 6.

    ## Example 2
    Input: nums = [1]
    Output: 1
    Explanation:
    The subarray [1] has the largest sum of 1.

    ## Approach
    Kadane's Algorithm

    ## Complexity
    Time Complexity  : O(n)
    Space Complexity : O(1)
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];    // Assume the first element is the maximum initially.
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);    // Either extend the current subarray or start a new subarray from the current element

            maxSum = Math.max(maxSum, currentSum);                   // Update the overall maximum sum.
        }

        return maxSum;
    }
}
