/* 
  # LeetCode 918. Maximum Sum Circular Subarray

    ## Problem Statement
    Given a circular integer array `nums`, return the maximum possible sum of a non-empty subarray.

    A circular array means the element after the last index is the first element of the array.
    A subarray may wrap around the end of the array, but each element can be used at most once.

    ## Example 1
    Input: nums = [1,-2,3,-2]
    Output: 3
    Explanation:
    The maximum subarray is [3], so the answer is 3.

    ## Example 2
    Input: nums = [5,-3,5]
    Output: 10
    Explanation:
    The maximum circular subarray is [5,-3,5] (wrapping around), giving a sum of 10.

    ## Example 3
    Input: nums = [-3,-2,-3]
    Output: -2
    Explanation:
    The maximum subarray is [-2].

    ## Approach
    1. Find the maximum subarray sum using Kadane's Algorithm.
    2. Find the minimum subarray sum using a modified Kadane's Algorithm.
    3. Compute the total sum of the array.
    4. The answer is the maximum of:
       - Normal maximum subarray sum.
       - Total Sum - Minimum Subarray Sum (circular case).
    5. If all elements are negative, return the normal maximum subarray sum.

    ## Complexity
    Time Complexity  : O(n)
    Space Complexity : O(1)
*/



class Solution {
/*  ==== Brute Force (TLE) ==== Time : O(n²)
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int currentSum = nums[0];

        for(int i = 1; i < n; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        for(int i = 0; i < n - 1; i++) {
            currentSum = nums[i % n];
            for(int j = 1; j < n; j++) {
                currentSum = Math.max(nums[(i + j) % n], currentSum + nums[(i + j) % n]);

                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
*/

    // Time : O(n)
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int currentSum = nums[0];

        for(int i = 1; i < n; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }

        int minSum = nums[0];
        int currentMin = nums[0];

        for(int i = 1;  i < n; i++) {
            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minSum = Math.min(minSum, currentMin);
        }

        int ans = (minSum == totalSum) ? minSum : totalSum - minSum;

        return Math.max(maxSum, ans);
    }
}
