/*
  KMP (Knuth-Morris-Pratt) Algorithm

  KMP efficiently searches for a pattern inside a text by using
  the LPS (Longest Prefix Suffix) array to skip unnecessary comparisons.

  Time Complexity  : O(n + m)
  Space Complexity : O(m)

  n = Length of the text
  m = Length of the pattern
*/

public class KMPAlgorithm {

  // Returns the first occurrence of the pattern in the text.
  // Returns -1 if the pattern is not found.
  public static int search(String text, String pattern) {

    if (pattern.length() == 0) {
      return 0;
    }

    int[] lps = buildLPS(pattern);

    int textIndex = 0;
    int patternIndex = 0;

    while (textIndex < text.length()) {

      if (text.charAt(textIndex) == pattern.charAt(patternIndex)) {
        textIndex++;
        patternIndex++;

        if (patternIndex == pattern.length()) {
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

  // Builds the Longest Prefix Suffix (LPS) array.
  private static int[] buildLPS(String pattern) {
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

  public static void main(String[] args) {

    String text = "ABABDABABC";
    String pattern = "ABABC";

    int index = search(text, pattern);

    if (index != -1) {
      System.out.println("Pattern found at index: " + index);
    } else {
      System.out.println("Pattern not found.");
    }
  }
}