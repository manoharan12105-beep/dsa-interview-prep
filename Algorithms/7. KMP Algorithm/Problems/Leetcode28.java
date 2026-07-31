/* 
  # LeetCode 28. Find the Index of the First Occurrence in a String

  ## Problem Statement
  Given two strings needle and haystack, return the index of the
  first occurrence of needle in haystack, or -1 if needle is not
  part of haystack.

  ## Example

  Input:
  haystack = "sadbutsad"
  needle = "sad"

  Output:
  0

  Explanation:
  "sad" occurs at index 0 and 6.
  Return the first occurrence, which is index 0.

  ## Approach
  KMP (Knuth-Morris-Pratt) Algorithm

  - Build the LPS (Longest Prefix Suffix) array for the pattern.
  - Compare characters of the text and pattern.
  - If characters match, move both pointers.
  - If a mismatch occurs, use the LPS array to skip unnecessary
    comparisons instead of restarting the search.
  - Return the index when the entire pattern is matched.

  ## Complexity

  Time Complexity  : O(n + m)
  Space Complexity : O(m)
*/

class Solution {

  public int strStr(String haystack, String needle) {

    if (needle.length() == 0) {
      return 0;
    }

    int[] lps = buildLPS(needle);

    int textIndex = 0;
    int patternIndex = 0;

    while (textIndex < haystack.length()) {

      if (haystack.charAt(textIndex) == needle.charAt(patternIndex)) {
        textIndex++;
        patternIndex++;

        if (patternIndex == needle.length()) {
          return textIndex - patternIndex;
        }

      } else {

        if (patternIndex != 0) {
          patternIndex = lps[patternIndex - 1];
        } else {
          textIndex++;
        }
      }
    }

    return -1;
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
