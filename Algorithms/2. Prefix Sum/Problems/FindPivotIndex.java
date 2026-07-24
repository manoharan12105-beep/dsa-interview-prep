/*
 * LeetCode 724. Find Pivot Index
 *
 * Problem Statement:
 * Given an integer array nums, return the leftmost pivot index.
 *
 * A pivot index is an index where the sum of all elements strictly to the left
 * of the index is equal to the sum of all elements strictly to the right.
 *
 * If no such index exists, return -1.
 *
 * Example:
 * Input:  nums = [1,7,3,6,5,6]
 * Output: 3
 * Explanation:
 * Left sum  = 1 + 7 + 3 = 11
 * Right sum = 5 + 6 = 11
 */

class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        int[] leftSum = new int[n];
        leftSum[0] = nums[0];

        int[] rightSum = new int[n];
        rightSum[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++)
            leftSum[i] = nums[i] + leftSum[i - 1];

        for (int i = n - 2; i >= 0; i--)
            rightSum[i] = nums[i] + rightSum[i + 1];

        for (int i = 0; i < n; i++)
            if (leftSum[i] == rightSum[i])
                return i;

        return -1;
    }
}
