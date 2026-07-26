/* 
  # LeetCode 167. Two Sum II - Input Array Is Sorted

  ## Problem Statement
  Given a 1-indexed array of integers numbers that is sorted in
  non-decreasing order, find two numbers such that they add up
  to a specific target number.

  Return the indices of the two numbers (1-indexed) as an integer
  array of length 2.

  You may assume that each input has exactly one solution, and you
  may not use the same element twice.

  ## Example

  Input:
  numbers = [2,7,11,15]
  target = 9

  Output:
  [1,2]

  Explanation:
  numbers[1] + numbers[2] = 2 + 7 = 9

  ## Approach
  Two Pointers

  - Place one pointer at the beginning and another at the end.
  - Calculate the sum of both elements.
  - If the sum is smaller than the target, move the left pointer.
  - If the sum is larger than the target, move the right pointer.
  - Repeat until the target sum is found.

  ## Complexity

  Time Complexity  : O(n)
  Space Complexity : O(1)
*/

class Solution {

    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        int a = 0, b = n - 1;

        while (a < b) {
            int sum = arr[a] + arr[b];

            if (sum == target) {
                return new int[] { a + 1, b + 1 };
            } else if (sum < target) {
                a++;
            } else {
                b--;
            }
        }

        return new int[] { -1, -1 };
    }
}
