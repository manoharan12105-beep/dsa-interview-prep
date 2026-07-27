/* 
  # LeetCode 169. Majority Element

  ## Problem Statement
  Given an integer array nums of size n, return the majority element.

  The majority element is the element that appears more than
  ⌊n / 2⌋ times in the array.

  You may assume that the majority element always exists in the array.

  ## Example

  Input:
  nums = [2,2,1,1,1,2,2]

  Output:
  2

  Explanation:
  The element 2 appears 4 times, which is more than ⌊7 / 2⌋ = 3.

  ## Approach
  Moore's Voting Algorithm

  - Maintain a candidate and a vote count.
  - If the vote count becomes 0, choose the current element
    as the new candidate.
  - If the current element matches the candidate, increment the vote.
  - Otherwise, decrement the vote.
  - After one traversal, the remaining candidate is the majority element.

  ## Complexity

  Time Complexity  : O(n)
  Space Complexity : O(1)
*/

class Solution {

  public int majorityElement(int[] nums) {
    // HashMap<Integer, Integer> map = new HashMap<>();
    // for(int i : nums){
    //   map.put(i, map.getOrDefault(i, 0) + 1);
    // }

    // int res = Integer.MIN_VALUE;
    // int maxCount = 0;

    // for(Map.Entry<Integer, Integer> entry : map.entrySet()){
    //   if(entry.getValue() > maxCount){
    //     maxCount = entry.getValue();
    //     res = entry.getKey();
    //   }
    // }
    // return res;

    int candidate = 0;
    int vote = 0;

    for (int num : nums) {

      if (vote == 0) {
        candidate = num;
      }

      if (candidate == num) {
        vote++;
      } else {
        vote--;
      }
    }

    return candidate;
  }
}