/* 
  # LeetCode 75. Sort Colors

  ## Problem Statement
  Given an array nums containing n objects colored red, white, or blue,
  sort them in-place so that objects of the same color are adjacent.

  The colors are represented by the integers:
  0 -> Red
  1 -> White
  2 -> Blue

  You must solve this problem without using the library's sort function.

  ## Example

  Input:
  nums = [2,0,2,1,1,0]

  Output:
  [0,0,1,1,2,2]

  Explanation:
  Rearrange the array so that all 0s come first,
  followed by all 1s, and then all 2s.

  ## Approach
  Dutch National Flag Algorithm

  - Maintain three pointers: left, mid, and right.
  - Elements before 'left' are 0s.
  - Elements after 'right' are 2s.
  - Traverse the array using 'mid':
      • If nums[mid] == 0, swap with left and move both pointers.
      • If nums[mid] == 1, move mid.
      • If nums[mid] == 2, swap with right and move right only.
  - Continue until mid crosses right.

  ## Complexity

  Time Complexity  : O(n)
  Space Complexity : O(1)
*/

class Solution {

  public void sortColors(int[] arr) {
    int left = 0;
    int mid = 0;
    int right = arr.length - 1;

    while (mid <= right) {
      if (arr[mid] == 0) {
        int temp = arr[left];
        arr[left] = arr[mid];
        arr[mid] = temp;

        left++;
        mid++;

      } else if (arr[mid] == 1) {
        mid++;

      } else {
        int temp = arr[mid];
        arr[mid] = arr[right];
        arr[right] = temp;

        right--;
      }
    }
  }
}
