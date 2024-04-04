package org.psk.interview;

/**
 * Problem Statement #
 * Given an array of sorted numbers, remove all duplicates from it. You should
 * not use any extra space; after removing the duplicates in-place return the
 * new length of the array.
 *
 * Example 1:
 *
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 * Explanation: The first four elements after removing the duplicates will be
 * [2, 3, 6, 9].
 * Example 2:
 *
 * Input: [2, 2, 2, 11]
 * Output: 2
 * Explanation: The first two elements after removing the duplicates will be [2,
 * 11].
 */
public class RemoveDuplicatesFromSortedArray {

  /**
   * so we're gonna have 2 pointers: where we're reading from and where we're
   * writing to
   *
   * @param arr
   * @return
   */
  public static int remove(int[] arr) {
    if (arr.length < 2)
      return arr.length;

    int readIdx = 1, writeIdx = 1;
    int prevVal = arr[0];

    while (readIdx < arr.length) {
      int val = arr[readIdx];
      if (val != prevVal) {
        arr[writeIdx] = arr[readIdx];
        writeIdx++;
      }

      prevVal = arr[readIdx];
      readIdx++;
    }
    return writeIdx;

  }
}
