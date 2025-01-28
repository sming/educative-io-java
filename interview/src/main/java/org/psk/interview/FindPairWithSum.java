package org.psk.interview;

import java.util.*;

/**
 * In problems where we deal with sorted arrays (or LinkedLists) and need to
 * find a set of elements that fulfill certain constraints, the Two Pointers
 * approach becomes quite useful. The set of elements could be a pair, a triplet
 * or even a subarray. For example, take a look at the following problem:
 ****
 ****
 * → Given an array of sorted numbers and a target sum, find a pair in the array
 * whose sum is equal to the given target.
 *
 * Example 1:
 *
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 * Example 2:
 *
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 ****
 */

public class FindPairWithSum {

  public static void main(String[] args) {
    {
      int[] arr = { 1, 2, 3, 4, 6 };
      int k = 6;
      var res = findPairWithSumBruteForceImpl(arr, k);
      System.out.println("Res: " + res);
    }
    {
      int[] arr = { 2, 5, 9, 11 };
      int k = 11;
      var res = findPairWithSumBruteForceImpl(arr, k);
      System.out.println("Res: " + res);
    }
    {
      int[] arr = { 1, 2, 3, 4, 6 };
      int k = 6;
      var res = findPairWithSumImpl(arr, k);
      System.out.println("Res: " + res);
    }
    {
      int[] arr = { 2, 5, 9, 11 };
      int k = 11;
      var res = findPairWithSumImpl(arr, k);
      System.out.println("Res: " + res);
    }
  }

  private static List<Integer> findPairWithSumBruteForceImpl(int[] arr, int k) {
    int amtL = arr[0], amtR = arr[0];

    for (int i = 0; i < arr.length; i++) {
      amtL = arr[i];
      for (int j = i + 1; j < arr.length; j++) {
        amtR = arr[j];
        if (amtL + amtR == k)
          return List.of(i, j);
      }
    }
    return null;
  }

  private static List<Integer> findPairWithSumImpl(int[] arr, int k) {

    int lhsIdx = 0, rhsIdx = arr.length - 1;

    while (lhsIdx != rhsIdx) {
      int total = arr[lhsIdx] + arr[rhsIdx];
      if (total == k)
        return List.of(lhsIdx, rhsIdx);
      else if (total < k)
        lhsIdx++;
      else
        rhsIdx--;
    }

    return null;
  }
}