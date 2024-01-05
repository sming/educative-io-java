import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given an array of positive numbers and a positive number ‘k’, find the
 * maximum sum of any contiguous subarray of size ‘k’.
 *
 * Example 1:
 *
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 * Example 2:
 *
 * Input: [2, 3, 4, 1, 5], k=2
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4]. * ...
 */

public class CalculateMaxSumContiguousSubarray {

  public static void main(String[] args) {
    int[] arr = { 2, 1, 5, 1, 3, 2 };
    int k = 3;
    var res = calcBiggestSubArray(arr, k);
    System.out.println("Res: " + res);
    int[] arr2 = { 2, 3, 4, 1, 5 };
    int k2 = 2;
    var res2 = calcBiggestSubArray(arr2, k2);
    System.out.println("Res: " + res2);

  }

  /**
   *
   *
   * @param arr
   * @param k
   * @return
   */
  private static int calcBiggestSubArray(int[] arr, int k) {
    final Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < k; i++) {
      q.offer(arr[i]);
    }
    int max = getAverage(q);

    for (int i = k; i < arr.length; i++) {
      // pop and offer
      q.poll();
      q.offer(arr[i]);
      max = Math.max(max, getAverage(q));
    }

    return max;
  }

  private static Integer getAverage(Queue<Integer> q) {
    return q.stream().collect(Collectors.summingInt(Integer::intValue));
  }
}