/* 
  # LeetCode 3. Longest Substring Without Repeating Characters

  ## Problem Statement
  Given a string s, find the length of the longest substring
  without repeating characters.

  A substring is a contiguous sequence of characters.

  ## Example

  Input:
  s = "abcabcbb"

  Output:
  3

  Explanation:
  The answer is "abc", with a length of 3.

  ## Approach
  Sliding Window (Variable Size) + HashSet

  - Use two pointers (left and right) to maintain a sliding window.
  - Expand the window by moving the right pointer.
  - If a duplicate character is found, shrink the window from the left
    until the duplicate is removed.
  - Track the maximum window size throughout the traversal.

  ## Complexity

  Time Complexity  : O(n)
  Space Complexity : O(min(n, alphabet_size))
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
