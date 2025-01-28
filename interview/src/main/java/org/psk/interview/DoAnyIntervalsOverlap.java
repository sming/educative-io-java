package org.psk.interview;

import java.util.*;
import org.psk.interview.utils.Interval;

/**
 * Problem 1: Given a set of intervals, find out if any two intervals overlap.
 *
 * Example:
 *
 * Intervals: [[1,4], [2,5], [7,9]]
 * Output: true
 * Explanation: Intervals [1,4] and [2,5] overlap
 **/

class DoAnyIntervalsOverlap {
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
          System.out.println("Merge result: " + m);
          // if (!merged.remove(i1))
          // System.out.println("Did not find " + i1 + " in order to remove it from
          // result");
          // if (!merged.remove(i2))
          // System.out.println("Did not find " + i2 + " in order to remove it from
          // result");
        }
      }
    }
    // find out why this doesn't want to work
    // mergedIntervals.stream().map(x -> x.toString() + ",
    // ").collect(ArrayList::add);
    for (Interval interval : merged) {
      System.out.println("Interval: " + interval + ", ");
    }

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
