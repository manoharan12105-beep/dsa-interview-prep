/* 
  # LeetCode 28. Find the Index of the First Occurrence in a String

  ## Problem Statement
  Given two strings haystack and needle, return the index of the
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
  Rabin-Karp Algorithm

  - Compute the hash of the pattern.
  - Compute the hash of the first window of the text.
  - Compare the hash values.
  - If the hashes match, verify by comparing the characters.
  - Slide the window using a rolling hash and repeat until
    the pattern is found or the text ends.

  ## Complexity

  Average Time Complexity : O(n + m)
  Worst Time Complexity   : O(n × m)
  Space Complexity        : O(1)
*/

class Solution {

    private static final int BASE = 256;
    private static final int PRIME = 101;

    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        if (m == 0) {
            return 0;
        }

        if (m > n) {
            return -1;
        }

        int patternHash = 0;
        int windowHash = 0;
        int highestPower = 1;

        // BASE^(m-1) % PRIME
        for (int i = 0; i < m - 1; i++) {
            highestPower = (highestPower * BASE) % PRIME;
        }

        // Initial hash
        for (int i = 0; i < m; i++) {
            patternHash = (BASE * patternHash + needle.charAt(i)) % PRIME;
            windowHash = (BASE * windowHash + haystack.charAt(i)) % PRIME;
        }

        for (int i = 0; i <= n - m; i++) {

            // Hash matched, verify characters
            if (patternHash == windowHash) {

                int j = 0;

                while (j < m &&
                       haystack.charAt(i + j) == needle.charAt(j)) {
                    j++;
                }

                if (j == m) {
                    return i;
                }
            }

            // Rolling Hash
            if (i < n - m) {

                windowHash = (BASE * (windowHash - haystack.charAt(i) * highestPower)
                            + haystack.charAt(i + m)) % PRIME;

                if (windowHash < 0) {
                    windowHash += PRIME;
                }
            }
        }

        return -1;
    }
}
