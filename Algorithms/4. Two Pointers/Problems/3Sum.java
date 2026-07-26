/* 
  # LeetCode 15. 3Sum

  ## Problem Statement
  Given an integer array nums, return all the unique triplets
  [nums[i], nums[j], nums[k]] such that:

      nums[i] + nums[j] + nums[k] == 0

  The solution set must not contain duplicate triplets.

  ## Example

  Input:
  nums = [-1,0,1,2,-1,-4]

  Output:
  [[-1,-1,2],[-1,0,1]]

  Explanation:
  The triplets [-1,-1,2] and [-1,0,1] both sum to 0.

  ## Approach
  Sorting + Two Pointers

  - Sort the array.
  - Fix one element at a time.
  - Use two pointers to find the remaining two elements.
  - Skip duplicate values to avoid duplicate triplets.
  - Continue until all unique triplets are found.

  ## Complexity

  Time Complexity  : O(n²)
  Space Complexity : O(1) (excluding the output list)
*/

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];

                if (total > 0) {
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }

        return list;
    }
}
