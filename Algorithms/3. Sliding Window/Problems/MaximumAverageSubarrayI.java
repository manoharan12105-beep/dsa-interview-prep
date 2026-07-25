/* 
  # LeetCode 643. Maximum Average Subarray I

  ## Problem Statement
  Given an integer array nums consisting of n elements and an integer k,
  find the contiguous subarray of length k that has the maximum average value.

  Return the maximum average value. Answers within 10^-5 of the actual
  answer will be accepted.

  ## Example

  Input:
  nums = [1,12,-5,-6,50,3]
  k = 4

  Output:
  12.75

  Explanation:
  The subarray [12,-5,-6,50] has the maximum sum of 51.
  Maximum Average = 51 / 4 = 12.75

  ## Approach
  Sliding Window (Fixed Size)

  - Compute the sum of the first window of size k.
  - Slide the window by:
      - Adding the new element.
      - Removing the leftmost element.
  - Keep track of the maximum window sum.
  - Return maxSum / k.

  ## Complexity

  Time Complexity  : O(n)
  Space Complexity : O(1)
*/

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for(int i = 0; i < k; i++)
            sum += nums[i];

        int maxSum = sum;

        for(int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}
