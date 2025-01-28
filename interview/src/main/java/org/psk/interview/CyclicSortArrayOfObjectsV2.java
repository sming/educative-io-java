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
 * so V1 vs V2 is that V2 puts the "other" number in its right spot at the same
 * stroke
 *
 * 156432 ->
 *
 */
public class CyclicSortArrayOfObjectsV2 {
  public static void sort(int[] nums) {
    int numMoves = nums.length;
    int n = 0;
    int buyer = nums[n];
    while (n < numMoves) {
      int evictee = nums[buyer - 1];
      System.out.println("n: " + n + ", evictee: " + evictee + ", buyer: " + buyer);
      n++;
      if (evictee != n) {
        nums[buyer - 1] = buyer;
        buyer = evictee;
      } else {
        buyer = nums[n];
      }
    }
  }

  public static void main(String[] args) {
    var arr = Arrays.asList(1, 5, 6, 4, 3, 2).stream().mapToInt(x -> x).toArray();
    sortAndOutput(arr);
    // arr = Arrays.asList(2, 6, 4, 3, 1, 5).stream().mapToInt(x -> x).toArray();
    // sortAndOutput(arr);
  }

  private static void sortAndOutput(int[] arr) {
    sort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(i + ":" + arr[i]);
    }
  }
}
