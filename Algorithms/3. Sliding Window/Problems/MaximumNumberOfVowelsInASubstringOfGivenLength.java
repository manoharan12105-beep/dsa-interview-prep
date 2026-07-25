/* 
  # LeetCode 1456. Maximum Number of Vowels in a Substring of Given Length

  ## Problem Statement
  Given a string s and an integer k, return the maximum number of vowel
  letters in any substring of s with length k.

  Vowels are: 'a', 'e', 'i', 'o', and 'u'.

  ## Example

  Input:
  s = "abciiidef"
  k = 3

  Output:
  3

  Explanation:
  The substring "iii" contains 3 vowels, which is the maximum.

  ## Approach
  Sliding Window (Fixed Size)

  - Count the vowels in the first window of size k.
  - Slide the window one character at a time.
  - If the incoming character is a vowel, increment the count.
  - If the outgoing character is a vowel, decrement the count.
  - Keep track of the maximum vowel count seen.

  ## Complexity

  Time Complexity  : O(n)
  Space Complexity : O(1)
*/

class Solution {
    public int maxVowels(String s, int k) {
        int result = 0;
        char[] cha = s.toCharArray();
        int max = 0;
        int forMax = 0;
        String isVowel = "aeiou";
        
        for(int i = 0; i < k; i++){
            char ch = cha[i];
            if(isVowel.indexOf(ch) != -1){
                forMax++;
            }
        }

        max = forMax;
        for(int i = k; i < cha.length; i++){
            char in = cha[i];
            char out = cha[i - k];
            if(isVowel.indexOf(in) != -1) forMax++;
            if(isVowel.indexOf(out) != -1) forMax--;
            if(max < forMax) max = forMax;
        }

        return max;
    }
}
