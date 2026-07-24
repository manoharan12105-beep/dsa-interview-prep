/* 
  # LeetCode 560. Subarray Sum Equals K

  ## Problem Statement
  Given an integer array nums and an integer k, return the total number
  of continuous subarrays whose sum equals k.

  A subarray is a contiguous non-empty sequence of elements within an array.

  ## Example

  Input:
  nums = [1,1,1], k = 2

  Output:
  2

  Explanation:
  The subarrays [1,1] (indices 0-1) and [1,1] (indices 1-2)
  both have a sum equal to 2.

  ## Approach
  Prefix Sum + HashMap

  - Maintain a running prefix sum.
  - If (currentPrefixSum - k) has appeared before, then each occurrence
    represents a subarray whose sum is k.
  - Store the frequency of each prefix sum in a HashMap.

  ## Complexity

  Time Complexity  : O(n)
  Space Complexity : O(n)
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum - k;

            if(map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
