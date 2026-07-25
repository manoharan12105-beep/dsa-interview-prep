/* 
  # LeetCode 1004. Max Consecutive Ones III

  ## Problem Statement
  Given a binary array nums and an integer k, return the maximum number
  of consecutive 1's in the array if you can flip at most k 0's.

  ## Example

  Input:
  nums = [1,1,1,0,0,0,1,1,1,1,0]
  k = 2

  Output:
  6

  Explanation:
  Flip the two 0's at indices 5 and 10 (or any valid choice).
  The longest consecutive sequence of 1's has length 6.

  ## Approach
  Sliding Window (Variable Size)

  - Maintain a sliding window using two pointers.
  - Count the number of 0's within the current window.
  - If the number of 0's exceeds k, shrink the window
    from the left until it becomes valid.
  - Track the maximum window size.

  ## Complexity

  Time Complexity  : O(n)
  Space Complexity : O(1)
*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeros = 0;
        int max = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0)
                zeros++;

            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
