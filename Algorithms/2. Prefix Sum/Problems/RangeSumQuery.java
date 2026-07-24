/* 
  # LeetCode 303. Range Sum Query - Immutable

    ## Problem Statement
    Given an integer array nums, handle multiple queries to find the sum of the
    elements between indices left and right (inclusive).

    Implement the NumArray class:

    - NumArray(int[] nums)
      Initializes the object with the integer array nums.

    - int sumRange(int left, int right)
      Returns the sum of the elements from index left to right (inclusive).

    ## Example

    Input:
    ["NumArray", "sumRange", "sumRange", "sumRange"]
    [[[-2,0,3,-5,2,-1]], [0,2], [2,5], [0,5]]

    Output:
    [null, 1, -1, -3]

    Explanation:
    NumArray numArray = new NumArray([-2,0,3,-5,2,-1]);
    numArray.sumRange(0, 2); // Returns 1
    numArray.sumRange(2, 5); // Returns -1
    numArray.sumRange(0, 5); // Returns -3

    ## Approach
    Prefix Sum

    ## Complexity

    Constructor:
    Time Complexity  : O(n)
    Space Complexity : O(n)

    sumRange():
    Time Complexity  : O(1)
    Space Complexity : O(1)
*/
public class RangeSumQuery {
  class NumArray {
    int[] arr;
    public NumArray(int[] nums) {
      arr = new int[nums.length + 1];
      for(int i = 0; i < nums.length; i++) {
        arr[i + 1] = arr[i] + nums[i];
      }
    }
    
    public int sumRange(int left, int right) {
      return arr[right + 1] - arr[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
}
