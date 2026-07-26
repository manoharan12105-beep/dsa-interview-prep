/* 
  # LeetCode 125. Valid Palindrome

  ## Problem Statement
  A phrase is a palindrome if, after converting all uppercase letters
  into lowercase letters and removing all non-alphanumeric characters,
  it reads the same forward and backward.

  Given a string s, return true if it is a palindrome, or false otherwise.

  ## Example

  Input:
  s = "A man, a plan, a canal: Panama"

  Output:
  true

  Explanation:
  After removing non-alphanumeric characters and converting to lowercase,
  the string becomes "amanaplanacanalpanama", which is a palindrome.

  ## Approach
  Two Pointers

  - Convert the string to lowercase.
  - Remove all non-alphanumeric characters.
  - Place one pointer at the beginning and another at the end.
  - Compare both characters.
  - If they differ, return false.
  - Continue until the pointers meet.

  ## Complexity

  Time Complexity  : O(n)
  Space Complexity : O(n)
*/

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = s.length() - 1;

        while (left < right)
            if (s.charAt(left++) != s.charAt(right--))
                return false;

        return true;
    }
}
