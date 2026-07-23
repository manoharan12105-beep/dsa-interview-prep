/* 
  # LeetCode 1191. K-Concatenation Maximum Sum

    ## Problem Statement
    Given an integer array `arr` and an integer `k`, create a new array by concatenating
    `arr` exactly `k` times.

    Return the maximum subarray sum of the concatenated array.
    Since the answer can be very large, return it modulo 10^9 + 7.

    Note:
    - A subarray is a contiguous part of the array.
    - An empty subarray is allowed, so the answer can be 0.

    ## Example 1
    Input: arr = [1,2], k = 3
    Output: 9
    Explanation:
    The concatenated array is [1,2,1,2,1,2].
    The maximum subarray is the entire array with sum = 9.

    ## Example 2
    Input: arr = [1,-2,1], k = 5
    Output: 2
    Explanation:
    The maximum subarray sum is 2.

    ## Example 3
    Input: arr = [-1,-2], k = 7
    Output: 0
    Explanation:
    Since an empty subarray is allowed, the maximum sum is 0.

    ## Approach
    - Use Kadane's Algorithm to find the maximum subarray sum.
    - Compute the total sum, maximum prefix sum, and maximum suffix sum.
    - If the total sum is positive, use:
          maxSuffix + (k - 2) * totalSum + maxPrefix
    - Otherwise, run Kadane's Algorithm on two concatenated arrays.
    - Return the answer modulo 10^9 + 7.

    ## Complexity
    Time Complexity  : O(n)
    Space Complexity : O(1)
*/

class Solution {
    static int MOD = 1_000_000_007;

    public int kConcatenationMaxSum(int[] nums, int k) {
        int n = nums.length;

        if(k == 1) {
            long maxSum = 0;
            long currentSum = 0;

            for(int i = 0; i < n; i++) {
                currentSum = Math.max(0, currentSum + nums[i]);
                maxSum = Math.max(maxSum, currentSum);
            }

            return (int)(maxSum % MOD);
        }

        long totalSum = 0;
        long prefixMax = 0, currentPrefixSum = 0;
        long suffixMax = 0, currentsuffixSum = 0;

        // Total Array Sum
        for(int num : nums)
            totalSum += num;

        // Maximum prefix sum of the Array
        for(int i = 0; i < n; i++) {
            currentPrefixSum += nums[i];
            prefixMax = Math.max(prefixMax, currentPrefixSum);
        }

        // Maximum Suffix sum of the Array
        for(int i = n - 1; i > -1; i--) {
            currentsuffixSum += nums[i];
            suffixMax = Math.max(suffixMax, currentsuffixSum);
        }

        // Kadane's Algorithm on Two Concatenated Arrays
        long maxSum = 0;
        long currentSum = 0;

        for(int i = 0; i < 2 * n; i++) {
            currentSum = Math.max(0, currentSum + nums[i % n]);
            maxSum = Math.max(maxSum, currentSum);
        }

        if(totalSum <= 0)
            return (int)(maxSum % MOD);

        return (int)(Math.max(maxSum, suffixMax + (long)(k - 2) * totalSum + prefixMax) % MOD);
    }
}
