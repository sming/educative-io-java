package org.psk.interview;

// import java.util.*;

/**
 * Problem Statement #
 * Given an array of intervals representing ‘N’ appointments, find out if a
 * person can attend all the appointments.
 *
 * Example 1:
 *
 * Appointments: [[1,4], [2,5], [7,9]]
 * Output: false
 * Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of
 * these appointments.
 * Example 2:
 *
 * Appointments: [[6,7], [2,4], [8,12]]
 * Output: true
 * Explanation: None of the appointments overlap, therefore a person can attend
 * all of them.
 * Example 3:
 *
 * Appointments: [[4,5], [2,3], [3,6]]
 * Output: false
 * Explanation: Since [4,5] and [3,6] overlap, a person cannot attend both of
 * these appointments.
 *
 * PSK
 * - so the central task is to find whether the appts overlap or not. That's it.
 * - but how to represent that in efficient data structures is the question. We
 * need
 * to somehow delineate ranges of numbers as being "off limits" when we
 * encounter a new
 * appt.
 * - we also need to merge (?) existing appts (v2)
 * - first draft could be as simple as filtering all appts that start before new
 * appt and then
 * linearly checking if their end time >= new appt end time...
 */
import java.util.Comparator;

class IntervalC {
  int start;
  int end;

  public IntervalC(int start, int end) {
    this.start = start;
    this.end = end;
  };
}

class IntervalStartComparitor implements Comparator<IntervalC> {

  @Override
  public int compare(IntervalC i1, IntervalC i2) {
    return i1.start > i2.start ? 1 : (i1.start == i2.start ? 0 : -1);
  }
}

class IntervalEndComparitor implements Comparator<IntervalC> {

  @Override
  public int compare(IntervalC i1, IntervalC i2) {
    return i1.end > i2.end ? 1 : (i1.end == i2.end ? 0 : -1);
  }
}

class ConflictingAppointmentsComparators {
  public static boolean canAttendAllAppointments(Interval[] intervals) {
    // @SuppressWarnings({ "rawtypes", "unchecked" })
    // final var apptsStartToEnd = new TreeSet(new IntervalStartComparitor());
    // @SuppressWarnings({ "rawtypes", "unchecked" })
    // final var apptsEndToStart = new TreeMap(new IntervalEndComparitor());

    // for (var interval : intervals) {
    // find all appts that start before (and could potentially interefere)
    // var startBefore = apptsStartToEnd.headSet(interval.start, true);
    // // find all theapts that end after the start time (and could interferee)
    // var endAfterIntervalStarts = apptsEndToStart.headSet(interval.end, true);

    // var sbSet = startBefore.entrySet();

    // if (sbSet.isEmpty())
    // return true;

    // var eaSet = endAfterIntervalStarts.entrySet();

    // if (eaSet.isEmpty())
    // return true;

    // TOzDO: not sure if this op is commutative i.e. will same heppen if we
    // retain
    // // all the other way
    // sbSet.retainAll(eaSet);
    // if (!sbSet.isEmpty()) {
    // return false;
    // }
    // // for (var potClash : sbSet) {
    // // if (potClash.getKey() <= interval.start &&
    // // potClash.getValue() >= interval.end) {
    // // System.out.println("Can't meet cos existing meet: " + potClash.getKey() +
    // ":"
    // // + potClash.getValue() + ", conflicts with " + interval);
    // // return false;
    // // }

    // apptsStartToEnd.put(interval.start, interval.end);
    // apptsEndToStart.put(interval.end, interval.start);
    // }
    return true;
  }

}

// class IntervalStartComparitorRaw implements Comparator {

// @Override
// public int compare(Object o1, Object o2) {
// var i1 = (Interval) o1;
// var i2 = (Interval) o2;

// if (i1 == null || i2 == null) {
// throw new UnsupportedOperationException("prolly not Interval objects");
// }

// return i1.start > i2.start ? 1 : (i1.start == i2.start ? 0 : -1);

// }

// }
// }