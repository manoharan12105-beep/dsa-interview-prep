/* 
  # Sliding Window

  ## Problem Statement
  Given an integer array nums and an integer k, find the maximum sum
  of any contiguous subarray of size k.

  ## Example

  Input:
  nums = [2, 1, 5, 1, 3, 2]
  k = 3

  Output:
  9

  Explanation:
  Subarrays of size 3:
  [2,1,5] -> 8
  [1,5,1] -> 7
  [5,1,3] -> 9
  [1,3,2] -> 6

  Maximum Sum = 9

  ## Approach
  Sliding Window

  - Compute the sum of the first window.
  - Slide the window one element at a time.
  - Remove the leftmost element.
  - Add the new rightmost element.
  - Keep track of the maximum window sum.

  ## Complexity

  Time Complexity  : O(n)
  Space Complexity : O(1)
*/

public class SlidingWindow {

  public static int maxSumSubarray(int[] nums, int k) {

    if(nums == null || nums.length < k) {
      throw new IllegalArgumentException("Invalid input");
    }

    int windowSum = 0;

    for (int i = 0; i < k; i++) {
      windowSum += nums[i];
    }

    int maxSum = windowSum;

    for (int i = k; i < nums.length; i++) {
      windowSum += nums[i] - nums[i - k];
      maxSum = Math.max(maxSum, windowSum);
    }

    return maxSum;
  }

  public static void main(String[] args) {
    int[] nums = {2, 1, 5, 1, 3, 2};
    int k = 3;

    System.out.println(maxSumSubarray(nums, k));

    // Output:
    // 9
  }
}