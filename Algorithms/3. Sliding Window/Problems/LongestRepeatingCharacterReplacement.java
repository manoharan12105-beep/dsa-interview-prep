/* 
  # LeetCode 424. Longest Repeating Character Replacement

  ## Problem Statement
  Given a string s and an integer k, you can change at most k characters
  in the string to any other uppercase English character.

  Return the length of the longest substring containing the same letter
  after performing at most k replacements.

  ## Example

  Input:
  s = "ABAB"
  k = 2

  Output:
  4

  Explanation:
  Replace the two 'A's with 'B's (or vice versa) to get "BBBB".
  The longest repeating substring has length 4.

  ## Approach
  Sliding Window (Variable Size)

  - Maintain a sliding window using two pointers.
  - Count the frequency of each character inside the window.
  - Keep track of the highest frequency character.
  - If the number of characters to replace exceeds k,
    shrink the window from the left.
  - Record the maximum valid window size.

  ## Complexity

  Time Complexity  : O(n)
  Space Complexity : O(1)
*/

class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxFreq = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {

            count[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
