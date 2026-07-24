/**
 * Prefix Sum
 *
 * Prefix Sum is a preprocessing technique used to answer
 * range sum queries efficiently.
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(n)
 */

public class PrefixSum {

  // Builds and returns the Prefix Sum array.
  public static int[] buildPrefixSum(int[] nums) {

    int[] prefix = new int[nums.length];

    prefix[0] = nums[0];

    for(int i = 1; i < nums.length; i++) {
      prefix[i] = prefix[i - 1] + nums[i];
    }

    return prefix;
  }

  public static void main(String[] args) {

    int[] nums = {2, 4, 1, 7, 3, 6};

    int[] prefix = buildPrefixSum(nums);

    System.out.print("Original Array : ");

    for(int num : nums) {
      System.out.print(num + " ");
    }

    System.out.println();

    System.out.print("Prefix Sum Array : ");

    for(int sum : prefix) {
      System.out.print(sum + " ");
    }
  }
}


/*
  Output : 
    Original Array   : 2  4  1  7  3  6
    Prefix Sum Array : 2  6  7 14 17 23
*/