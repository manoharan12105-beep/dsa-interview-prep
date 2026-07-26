/* 
  # LeetCode 11. Container With Most Water

  ## Problem Statement
  You are given an integer array height of length n.

  There are n vertical lines drawn such that the two endpoints of the
  ith line are (i, 0) and (i, height[i]).

  Find two lines that, together with the x-axis, form a container
  that holds the maximum amount of water.

  Return the maximum amount of water the container can store.

  ## Example

  Input:
  height = [1,8,6,2,5,4,8,3,7]

  Output:
  49

  Explanation:
  The maximum area is formed by the lines with heights 8 and 7,
  which are 7 units apart.
  Area = min(8, 7) × 7 = 49

  ## Approach
  Two Pointers

  - Place one pointer at the beginning and another at the end.
  - Calculate the area formed by the two lines.
  - Update the maximum area if needed.
  - Move the pointer with the smaller height inward, since moving
    the taller one cannot increase the area.
  - Continue until the pointers meet.

  ## Complexity

  Time Complexity  : O(n)
  Space Complexity : O(1)
*/

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int b = Math.min(height[left], height[right]);
            int area = (right - left) * b;

            if (area > max)
                max = area;

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return max;
    }
}
