/**
 * Chapter 01 - Kadane's Algorithm
 *
 * Problem: Leetcode : 53 (https://leetcode.com/problems/maximum-subarray/description/)
 * Find the maximum sum of a contiguous subarray.
 *
 * Time Complexity : O(n)
 * Space Complexity: O(1)
 */

public class KadaneAlgorithm {

  // Returns the maximum sum of any contiguous subarray.
  public static int maxSubArray(int[] nums) { 
    int currentSum = nums[0];    // Assume the first element is the maximum initially.
    int maxSum = nums[0];

    for(int i = 1; i < nums.length; i++) {
      currentSum = Math.max(nums[i], currentSum + nums[i]);    // Either extend the current subarray or start a new subarray from the current element

      maxSum = Math.max(maxSum, currentSum);                   // Update the overall maximum sum.
    }

    return maxSum;
  }

  public static void main(String[] args) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int answer = maxSubArray(nums);

    System.out.println("Maximum Subarray Sum : " + answer);
  }
}