/* 
  # Two Pointers

  ## Problem Statement
  Given a sorted integer array nums and an integer target,
  return the indices of the two numbers such that they add up
  to the target.

  Assume exactly one solution exists, and you may not use the
  same element twice.

  ## Example

  Input:
  nums = [2, 7, 11, 15]
  target = 9

  Output:
  [0, 1]

  Explanation:
  nums[0] + nums[1] = 2 + 7 = 9

  ## Approach
  Two Pointers

  - Place one pointer at the beginning of the array.
  - Place another pointer at the end.
  - If the current sum is smaller than the target,
    move the left pointer to increase the sum.
  - If the current sum is larger than the target,
    move the right pointer to decrease the sum.
  - Repeat until the target sum is found.

  ## Complexity

  Time Complexity  : O(n)
  Space Complexity : O(1)
*/

public class TwoPointers {

    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{left, right};
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println("Indices: " + result[0] + ", " + result[1]);

        // Output:
        // Indices: 0, 1
    }
}