package org.psk.interview;

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

class IntervalConflicting {
  int start;
  int end;

  public IntervalConflicting(int start, int end) {
    this.start = start;
    this.end = end;
  };
}

class ConflictingAppointments {
  public static boolean canAttendAllAppointments(IntervalConflicting[] intervals) {

    // for (var IntervalConflicting : intervals) {
    // find all appts that start before (and could potentially interefere)
    // }
    return true;
  }
}
