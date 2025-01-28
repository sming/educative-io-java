package org.psk.interview;

import java.util.Arrays;

/**
 * Problem Statement #
 * We are given an array containing 'n' objects. Each object, when created, was
 * assigned a unique number from 1 to 'n' based on their creation sequence. This
 * means that the object with sequence number '3' was created just before the
 * object with sequence number '4'.
 *
 * Write a function to sort the objects in-place on their creation sequence
 * number in O(n) and without any extra space. For simplicity, let's assume we
 * are passed
 * an integer array containing only the sequence numbers, though each number is
 * actually an object.
 *
 * Example 1:
 *
 * Input: [3, 1, 5, 4, 2]
 * Output: [1, 2, 3, 4, 5]
 * Example 2:
 *
 * Input: [2, 6, 4, 3, 1, 5]
 * Output: [1, 2, 3, 4, 5, 6]
 * Example 3:
 *
 * Input: [1, 5, 6, 4, 3, 2]
 * Output: [1, 2, 3, 4, 5, 6]
 *
 * PSK NOTES
 * ———————
 * so let's assume worst case scenario in size 5 array, 54321 -> 14325 -> 12345
 * and if we've got 1-5, each number represents is i+1, so we take 1 off
 * so let's say we encounter 4. What does that mean? it means we swap whatever
 * the value
 * is we're looking at with the contents of #3
 * 52314 -> 42315 -> 42315 -> 42315 -> 12345
 * 53214 -> 43215 -> 42315 -> 42315 -> 12345
 * 156432 -> 156432 -> 136452 -> 132456
 * 156432 -> 126453 -> 123456
 *
 * TODO : WRONG 564321 -> 264351 -> 214356 ->
 *
 */
public class CyclicSortArrayOfObjectsV1 {
  public static void sort(int[] nums) {
    for (int j = 0; j < nums.length - 1; j++) {
      int tmp = nums[j];
      nums[tmp - 1] = tmp;
      nums[j] = tmp;
    }
  }

  public static void main(String[] args) {
    var arr = Arrays.asList(1, 5, 6, 4, 3, 2).stream().mapToInt(x -> x).toArray();
    sortAndOutput(arr);
    arr = Arrays.asList(2, 6, 4, 3, 1, 5).stream().mapToInt(x -> x).toArray();
    sortAndOutput(arr);
  }

  private static void sortAndOutput(int[] arr) {
    sort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(i + ":" + arr[i]);
    }
  }
}
