package org.psk.interview;

import java.util.*;
import org.psk.interview.utils.Interval;

/**
 * Given a list of intervals, merge all the overlapping intervals to produce a
 * list that has only mutually exclusive intervals.
 *
 * Example 1:
 * Intervals: [[1,4], [2,5], [7,9]]
 * Output: [[1,5], [7,9]]
 * Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged
 * them into one [1,5].
 *
 * Example 2:
 * Intervals: [[6,7], [2,4], [5,9]]
 * Output: [[2,4], [5,9]]
 * Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into
 * one [5,9].
 *
 * Example 3:
 * Intervals: [[1,4], [2,6], [3,5]]
 * Output: [[1,6]]
 * Explanation: Since all the given intervals overlap, we merged them into one.
 *
 * PSK NOTES
 * -———————
 * It seems to me to be maximal munch ie just merge everything that overlaps.
 * So how do we do maximal munch again? Bugger.
 */

class MergeAllOverlappingIntervals {
  public static List<Interval> merge(List<Interval> intervals) {

    var merged = new HashSet<Interval>();

    // var q = new LinkedList
    var leftOvers = new HashSet<Interval>();
    for (int i = 0; i < intervals.size(); i++) {
      for (int j = 0; j < intervals.size(); j++) {
        if (i == j)
          continue;

        var i1 = intervals.get(i);
        var i2 = intervals.get(j);

        // The problem here is that the first time an interval is encountered, there
        // aren't all the other intervals by
        // which to definitively say that it's un-merge-able.
        var m = i1.merge(i2);
        if (m == Interval.NO_OVERLAP) {
          System.out.println(i1 + " & " + i2 + " are not overlapping");
          leftOvers.add(i1);
          leftOvers.add(i2);
        } else {
          merged.add(m);
          leftOvers.remove(i1);
          leftOvers.remove(i2);
          System.out.println("Merge result: " + m);
          // if (!merged.remove(i1))
          // System.out.println("Did not find " + i1 + " in order to remove it from
          // result");
          // if (!merged.remove(i2))
          // System.out.println("Did not find " + i2 + " in order to remove it from
          // result");
        }
      }
      System.out.println("merged: " + merged);
      System.out.println("left overs: " + leftOvers);

    }
    // find out why this doesn't want to work
    // mergedIntervals.stream().map(x -> x.toString() + ",
    // ").collect(ArrayList::add);
    for (Interval interval : merged) {
      System.out.println("Merged: " + interval + ", ");
    }
    for (Interval interval : leftOvers) {
      System.out.println("Left Over: " + interval + ", ");
    }

    merged.addAll(leftOvers);

    var ints = merged.toArray(new Interval[0]);

    final var arrInts = new ArrayList<>(Arrays.asList(ints));
    arrInts.sort((Interval i1, Interval i2) -> {
      int rez = Integer.valueOf(i1.start).compareTo(Integer.valueOf(i2.start));
      if (rez != 0)
        return rez;

      return Integer.valueOf(i1.end).compareTo(Integer.valueOf(i2.end));
    });

    return arrInts;

  }
}
