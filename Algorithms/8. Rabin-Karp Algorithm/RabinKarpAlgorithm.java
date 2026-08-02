/*
  Rabin-Karp Algorithm

  Rabin-Karp efficiently searches for a pattern inside a text
  using a rolling hash.

  Instead of comparing every character, it compares the hash
  values of the pattern and the current window of the text.

  If the hash values match, it verifies by comparing the characters.

  Time Complexity
    Average : O(n + m)
    Worst   : O(n × m)

  Space Complexity : O(1)

  n = Length of the text
  m = Length of the pattern
*/

public class RabinKarpAlgorithm {

  private static final int BASE = 256;
  private static final int PRIME = 101;

  // Returns the first occurrence of the pattern in the text.
  // Returns -1 if the pattern is not found.
  public static int search(String text, String pattern) {

    int n = text.length();
    int m = pattern.length();

    if (m == 0) {
      return 0;
    }

    if (m > n) {
      return -1;
    }

    int patternHash = 0;
    int windowHash = 0;
    int highestPower = 1;

    // Calculate BASE^(m-1) % PRIME
    for (int i = 0; i < m - 1; i++) {
      highestPower = (highestPower * BASE) % PRIME;
    }

    // Compute initial hashes
    for (int i = 0; i < m; i++) {
      patternHash = (BASE * patternHash + pattern.charAt(i)) % PRIME;
      windowHash = (BASE * windowHash + text.charAt(i)) % PRIME;
    }

    for (int i = 0; i <= n - m; i++) {

      // If hash matches, verify character by character
      if (patternHash == windowHash) {

        int j = 0;

        while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
          j++;
        }

        if (j == m) {
          return i;
        }
      }

      // Compute rolling hash
      if (i < n - m) {

        windowHash = (BASE * (windowHash - text.charAt(i) * highestPower)
                    + text.charAt(i + m)) % PRIME;

        if (windowHash < 0) {
          windowHash += PRIME;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {

    String text = "ABCDABCAB";
    String pattern = "ABC";

    int index = search(text, pattern);

    if (index != -1) {
      System.out.println("Pattern found at index: " + index);
    } else {
      System.out.println("Pattern not found.");
    }
  }
}