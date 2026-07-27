/* 
  # Moore's Voting Algorithm

  ## Problem
  Find the majority element in an array.

  A majority element is an element that appears
  more than n / 2 times.

  ## Approach
  Moore's Voting Algorithm

  - Maintain a candidate and a count.
  - If count becomes 0, choose the current element as the new candidate.
  - If the current element matches the candidate, increment the count.
  - Otherwise, decrement the count.
  - After one traversal, the remaining candidate is the majority element
    (if a majority element is guaranteed to exist).

  ## Complexity

  Time Complexity  : O(n)
  Space Complexity : O(1)
*/

public class MooresVotingAlgorithm {
  public static int findMajorityElement(int[] nums) {
    int candidate = 0;
    int count = 0;

    for(int num : nums) {
      if(count == 0) {
        candidate = num;
      }

      if(num == candidate) {
        count++;
      } else {
        count--;
      }
    }

    return candidate;
  }

  // Optional verification if majority is NOT guaranteed
  public static boolean isMajority(int[] nums, int candidate) {
    int count = 0;

    for (int num : nums)
      if (num == candidate) 
        count++;

    return count > nums.length / 2;
  }

  public static void main(String[] args) {

    int[] nums = {2, 2, 1, 1, 1, 2, 2};

    int candidate = findMajorityElement(nums);

    if(isMajority(nums, candidate)) {
      System.out.println("Majority Element: " + candidate);
    } else {
      System.out.println("No Majority Element");
    }

    // Output:
    // Majority Element: 2
  }
}