package org.psk.interview;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Problem Statement #
 * Find the Corrupt Pair (easy) #
 * We are given an unsorted array containing 'n' numbers taken from the range 1
 * to 'n'. The array originally contained all the numbers from 1 to 'n', but due
 * to a data error, one of the numbers got duplicated which also resulted in one
 * number going missing. Find both these numbers.
 *
 * Example 1:
 *
 * Input: [3, 1, 2, 5, 2]
 * Output: [2, 4]
 * Explanation: '2' is duplicated and '4' is missing.
 * Example 2:
 *
 * Input: [3, 1, 2, 3, 6, 4]
 * Output: [3, 5]
 * Explanation: '3' is duplicated and '5' is missing.
 *
 * PSK NOTES
 * - critical info is that first bit: used to contain 1-N. So this means that we
 * can take shortcuts, but what
 * shortcuts?
 *
 */
public class FindTheCorruptPair {

  private static int[] findNumbers(int[] numbers) {
    int max = numbers.length;
    var numToCount = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
      numToCount.put(i + 1, 0);
    }
    for (int i = 0; i < numbers.length; i++) {
      // numToCount.computeIfAbsent(numbers[i], k -> 1);
      int ithVal = numbers[i];
      numToCount.put(ithVal, numToCount.get(ithVal) + 1);
    }

    for (var pair : numToCount.entrySet()) {
      System.out.println("Val: " + pair.getKey() + " -> " + pair.getValue());
    }

    var doop = numToCount.entrySet().stream().filter(x -> x.getValue() == 2).findFirst();
    var doop2 = numToCount.entrySet().stream().filter(x -> x.getValue() == 0).findFirst();

    return null;
  }

  public static void main(String[] args) {
    var arr = Arrays.asList(1, 5, 6, 4, 3, 6).stream().mapToInt(x -> x).toArray();
    findNumbers(arr);
    // arr = Arrays.asList(2, 6, 4, 3, 1, 5).stream().mapToInt(x -> x).toArray();
    // sortAndOutput(arr);
  }

}
