package org.psk.interview;

import java.util.*;

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

class Interval {
  int start;
  int end;

  protected final static Interval NO_OVERLAP = new Interval(-1, -1);

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null)
      return false;

    if (this == other)
      return true;

    if (Interval.class.isInstance(other)) {
      var otherInterval = Interval.class.cast(other);
      return start == otherInterval.start && end == otherInterval.end;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + start * 17;
    result = prime * result + end * 17;
    return result;
  }

  @Override
  public String toString() {
    return "Interval [" + start + "," + end + "]";
  }

  protected Interval merge(Interval o) {
    int lStart = start;
    int lEnd = end;

    if (start > o.end)
      return NO_OVERLAP;

    if (end < o.start)
      return NO_OVERLAP;

    if (o.start <= start && o.end >= start) {
      // the other spans our start
      lStart = o.start;
    }

    if (o.end >= end && o.start <= end) {
      // other spans our end
      lEnd = o.end;
    }

    if (start <= o.start && end >= o.start) {
      // we span their start
      lStart = Math.min(start, lStart);
    }
    if (end >= o.end && start <= o.end) {
      // we span their end
      lEnd = Math.max(end, lEnd);
    }

    return new Interval(lStart, lEnd);
  }
}

class MergeIntervals {
  public static List<Interval> merge(List<Interval> intervals) {

    var merged = new HashSet<Interval>();

    for (int i = 0; i < intervals.size(); i++) {
      for (int j = 0; j < intervals.size(); j++) {
        if (i == j)
          continue;

        var i1 = intervals.get(i);
        var i2 = intervals.get(j);

        var m = i1.merge(i2);
        if (m == Interval.NO_OVERLAP) {
          merged.add(i1);
          merged.add(i2);
        } else {
          merged.add(m);
          merged.remove(i1);
          merged.remove(i2);
        }
      }
    }
    // TODO: find out why this doesn't want to work
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
