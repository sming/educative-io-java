package org.psk.interview;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * In many problems dealing with an array (or a LinkedList), we are asked to
 * find or calculate something among all the contiguous subarrays (or sublists)
 * of a given size. For example, take a look at this problem:
 *
 * → Given an array, find the average of all contiguous subarrays of size ‘K’ in
 * it.
 *
 * Let’s understand this problem with a real input:
 *
 * Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
 * Here, we are asked to find the average of all contiguous subarrays of size
 * ‘5’ in the given array. Let’s solve this:
 *
 * For the first 5 numbers (subarray from index 0-4), the average is:
 * ( 1 + 3 + 2 + 6 − 1 ) / 5 = > 2 . 2
 * (1+3+2+6−1)/5=>2.2
 * The average of next 5 numbers (subarray from index 1-5) is:
 * (3+2+6−1+4)/5=>2.8
 * For the next 5 numbers (subarray from index 2-6), the average is:
 * (2+6−1+4+1)/5=>2.4
 * ...
 */

public class CalculateSubarrayAverage {

  public static void main(String[] args) {
    int[] arr = { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
    int k = 5;
    var res = findAveragesBruteForce(arr, k);
    System.out.println("Res: " + res);

    var resSliding = findAveragesSlidingWindow(arr, k);
    System.out
        .println("Res Sliding: " + resSliding.stream().map(x -> Double.toString(x)).collect(Collectors.joining(", ")));

  }

  private static List<Double> findAveragesBruteForce(int[] arr, int k) {
    var res = new ArrayList<Double>();
    var input = Arrays.stream(arr).boxed().toList();
    for (int i = 0; i < arr.length - k + 1; i++) {

      Stream<Integer> streamz = input.stream().skip(i).limit(k);
      var doop = streamz.toList();
      System.out.println(i + 1 + "th k nums: ");
      doop.forEach(s -> System.out.println(s));

      Stream<Integer> streamz2 = input.stream().skip(i).limit(k);

      double total = streamz2.collect(Collectors.averagingInt(Integer::intValue));
      System.out.println(i + 1 + "th average:" + total);
      res.add(total);
    }
    return res;
  }

  /**
   * So the idea here is that we're gonna keep a sliding window style total as we
   * traverse the array once.
   * We're gonna need a Queue basically. Push onto the head (actually the end of
   * the queue) and pop off the tail
   * (actually the head of the queue).
   *
   * @param arr
   * @param k
   * @return
   */
  private static List<Double> findAveragesSlidingWindow(int[] arr, int k) {
    int len = arr.length;
    if (len < k) {
      return null;
    }

    final Queue<Integer> q = new LinkedList<>();
    final List<Double> res = new ArrayList<>();

    for (int i = 0; i < k; i++) {
      q.offer(arr[i]);
    }
    res.add(getAverage(q));

    // Simplify: arr is [1,2,3,4,5], k=2
    // 1. q=head=1, tail=2
    // 2. q=head=2, tail=3
    // so by poll() and offer() we are good
    for (int i = k; i < arr.length; i++) {
      // pop and offer
      q.poll();
      q.offer(arr[i]);
      res.add(getAverage(q));
    }

    return res;
  }

  private static Double getAverage(Queue<Integer> q) {
    return q.stream().collect(Collectors.averagingInt(Integer::intValue));
  }
}