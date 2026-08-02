/* 
  # LeetCode 187. Repeated DNA Sequences

  ## Problem Statement
  A DNA sequence is composed of the characters 'A', 'C', 'G', and 'T'.

  Given a string s representing a DNA sequence, return all the
  10-letter-long sequences (substrings) that occur more than once
  in the DNA molecule.

  You may return the answer in any order.

  ## Example

  Input:
  s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

  Output:
  ["AAAAACCCCC","CCCCCAAAAA"]

  Explanation:
  Both "AAAAACCCCC" and "CCCCCAAAAA" appear more than once.

  ## Approach
  Rabin-Karp (Rolling Hash)

  - Treat every 10-character substring as a sliding window.
  - Compute the hash of the first window.
  - Update the hash efficiently using a rolling hash.
  - Store previously seen hashes and their starting indices.
  - If a hash repeats, verify the actual substring to avoid
    hash collisions.
  - Add verified repeated sequences to the result.

  ## Complexity

  Average Time Complexity : O(n)
  Worst Time Complexity   : O(n × 10)
  Space Complexity        : O(n)
*/

class Solution {
    private static final int BASE = 256;
    private static final int PRIME = 101;
    private static final int WINDOW = 10;

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();

        if (s.length() < WINDOW)
            return result;

        int highestPower = 1;

        for (int i = 0; i < WINDOW - 1; i++)
            highestPower = (highestPower * BASE) % PRIME;

        int hash = 0;

        for (int i = 0; i < WINDOW; i++)
            hash = (BASE * hash + s.charAt(i)) % PRIME;

        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        hashMap.put(hash, new ArrayList<>());
        hashMap.get(hash).add(0);

        Set<String> repeated = new HashSet<>();

        for (int i = 1; i <= s.length() - WINDOW; i++) {

            hash = (BASE * (hash - s.charAt(i - 1) * highestPower)
                  + s.charAt(i + WINDOW - 1)) % PRIME;

            if (hash < 0)
                hash += PRIME;

            if (hashMap.containsKey(hash)) {

                String current = s.substring(i, i + WINDOW);

                for (int start : hashMap.get(hash)) {
                    if (s.substring(start, start + WINDOW).equals(current)) {
                        repeated.add(current);
                        break;
                    }
                }

                hashMap.get(hash).add(i);

            } else {

                hashMap.put(hash, new ArrayList<>());
                hashMap.get(hash).add(i);
            }
        }

        result.addAll(repeated);
        return result;
    }
}
