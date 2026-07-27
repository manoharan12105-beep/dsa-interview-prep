/* 
  # LeetCode 229. Majority Element II

  ## Problem Statement
  Given an integer array nums, return all elements that appear
  more than ⌊n / 3⌋ times.

  Since an element must appear more than ⌊n / 3⌋ times,
  there can be at most two such elements.

  ## Example

  Input:
  nums = [3,2,3]

  Output:
  [3]

  Explanation:
  The element 3 appears 2 times, which is more than ⌊3 / 3⌋ = 1.

  ## Approach
  Extended Moore's Voting Algorithm

  - Maintain two candidates and their vote counts.
  - If the current number matches a candidate, increment its vote.
  - If a candidate's vote becomes 0, replace it with the current number.
  - Otherwise, decrement both vote counts.
  - After the first traversal, verify the candidates by counting
    their actual occurrences.
  - Return the candidates whose frequency is greater than ⌊n / 3⌋.

  ## Complexity

  Time Complexity  : O(n)
  Space Complexity : O(1)
*/

class Solution {

    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, candidate2 = 0;
        int vote1 = 0, vote2 = 0;

        for (int num : nums) {
            if (candidate1 == num) {
                vote1++;
            } else if (candidate2 == num) {
                vote2++;
            } else if (vote1 == 0) {
                candidate1 = num;
                vote1 = 1;
            } else if (vote2 == 0) {
                candidate2 = num;
                vote2 = 1;
            } else {
                vote1--;
                vote2--;
            }
        }

        vote1 = 0;
        vote2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                vote1++;
            } else if (num == candidate2) {
                vote2++;
            }
        }

        List<Integer> result = new ArrayList<>();

        if (vote1 > nums.length / 3) {
            result.add(candidate1);
        }

        if (vote2 > nums.length / 3) {
            result.add(candidate2);
        }

        return result;
    }
}
