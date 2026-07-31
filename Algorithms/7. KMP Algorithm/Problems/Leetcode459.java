/* 
  # LeetCode 459. Repeated Substring Pattern

  ## Problem Statement
  Given a string s, determine if it can be constructed by taking
  a substring of it and appending multiple copies of the substring.

  Return true if possible; otherwise, return false.

  ## Example

  Input:
  s = "abab"

  Output:
  true

  Explanation:
  The string "abab" is formed by repeating the substring "ab".

  ## Approach
  KMP (Longest Prefix Suffix)

  - Build the LPS (Longest Prefix Suffix) array for the string.
  - The last value of the LPS array represents the length of the
    longest proper prefix that is also a suffix.
  - If this value is greater than 0 and the remaining length divides
    the entire string evenly, then the string is made by repeating
    one of its substrings.

  ## Complexity

  Time Complexity  : O(n)
  Space Complexity : O(n)
*/

class Solution {

    public boolean repeatedSubstringPattern(String s) {
        int[] lps = buildLPS(s);

        int n = s.length();
        int longestPrefixSuffix = lps[n - 1];

        return longestPrefixSuffix > 0 && n % (n - longestPrefixSuffix) == 0;
    }

    private int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];

        int length = 0;
        int index = 1;

        while (index < pattern.length()) {

            if (pattern.charAt(index) == pattern.charAt(length)) {
                length++;
                lps[index] = length;
                index++;

            } else {

                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[index] = 0;
                    index++;
                }
            }
        }

        return lps;
    }
}
