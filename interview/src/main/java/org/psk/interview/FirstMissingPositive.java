package org.psk.interview;

import java.util.TreeSet;

/**
 * Find the Smallest Missing Positive Number (medium) #
 * Given an unsorted array containing numbers, find the smallest missing
 * positive number in it.
 *
 * Example 1:
 *
 * Input: [-3, 1, 5, 4, 2]
 * Output: 3
 * Explanation: The smallest missing positive number is '3'
 * Example 2:
 *
 * Input: [3, -2, 0, 1, 2]
 * Output: 4
 * Example 3:
 *
 * Input: [3, 2, 5, 1]
 * Output: 4
 *
 */
public class FirstMissingPositive {
  public static int findNumber(int[] nums) {
    var set = new TreeSet<Integer>();
    for (int i : nums) {
      if (i > 0)
        set.add(i);
    }

    Integer prevNum = -1;
    for (Integer num : set) {
      if (prevNum != -1) {
        if (num - prevNum != 1)
          return (num + prevNum) / 2;
      }
      prevNum = num;
    }

    return prevNum + 1;
  }

  public static void main(String[] args) {
    int[] arr = { -3, 1, 5, 4, 2 };
    runAndPrint(arr);

    int[] arr2 = { 3, 2, 5, 1 };
    runAndPrint(arr2);

    int[] arr3 = { 3, -2, 0, 1, 2 };
    runAndPrint(arr3);
  }

  private static void runAndPrint(int[] arr) {
    int res = findNumber(arr);
    System.out.println("Smallest Missing +ve: " + res);
  }
}
