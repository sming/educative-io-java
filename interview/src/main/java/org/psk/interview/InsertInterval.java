package org.psk.interview;

import java.util.*;
import org.psk.interview.utils.Interval;

/**
 * Given a list of non-overlapping intervals sorted by their start time, insert
 * a given interval at the correct position and merge all necessary intervals to
 * produce a list that has only mutually exclusive intervals.
 *
 * Example 1:
 *
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
 * Output: [[1,3], [4,7], [8,12]]
 * Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them
 * into one [4,7].
 * Example 2:
 *
 * -- PSK --
 * what are the properties of the correct position p?
 * - p.start must be on (i.start OR after i.start) AND before i+1.start / do
 * binary search?
 * - for interval z in list(i...)
 * if z.start <= p.end
 * merge z & p, using max(z.end, p.end) // or add to merge list or whatever
 * else
 * / we have reached an interval "past" p so exit loop
 *
 * - the there's the special case of i-1.end > p.start. If so, merge them.
 */

class InsertInterval {
  public static List<Interval> insert(List<Interval> intervals, Interval francis) {

    return null;
  }

  public static int findInsertPosition(List<Interval> intervals, Interval francis) {

    int end = intervals.size() - 1;
    if (end < 0)
      return -1;

    final int lastStartingIdx = intervals.get(end).start;
    final int firstStartingIdx = intervals.get(0).start;
    if (lastStartingIdx < francis.start)
      return intervals.size();
    if (firstStartingIdx > francis.start)
      return 0;

    int start = 0;
    int mid = 0;
    int iters = 0;
    int new_mid = 0;
    while (start < end && ++iters < 100) {
      //
      // 0,1,2,3,4,5,6
      // start=1, end=6
      // mid = 5/2 + 1 =3
      // start=0,end=5
      // mid = 5/2 + 1 = 3
      // start=0,end=6
      // mid = 6/2 + 1 = 4
      new_mid = start + (end - start) / 2;
      if (new_mid == mid)
        break;

      mid = new_mid;
      var midInterval = intervals.get(mid);

      if (midInterval.start > francis.start) {
        end = mid;
      } else if (midInterval.start < francis.start) {
        start = mid;
      }
    }

    return mid;
  }

}
