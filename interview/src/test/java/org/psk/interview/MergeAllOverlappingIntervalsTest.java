// File: interview/src/test/java/org/psk/interview/MergeAllOverlappingIntervalsTest.java
package org.psk.interview;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.psk.interview.utils.Interval;

import java.util.Arrays;
import java.util.List;

class MergeAllOverlappingIntervalsTest {

  @Test
  void testMerge() {
    List<Interval> intervals = Arrays.asList(
        new Interval(1, 4),
        new Interval(2, 5),
        new Interval(7, 9));

    List<Interval> expected = Arrays.asList(
        new Interval(1, 5),
        new Interval(7, 9));

    assertEquals(expected, MergeAllOverlappingIntervals.merge(intervals));

    // intervals = Arrays.asList(
    // new Interval(6, 7),
    // new Interval(2, 4),
    // new Interval(5, 9));

    // expected = Arrays.asList(
    // new Interval(2, 4),
    // new Interval(5, 9));

    // assertEquals(expected, MergeAllOverlappingIntervals.merge(intervals));

    // intervals = Arrays.asList(
    // new Interval(1, 4),
    // new Interval(2, 6),
    // new Interval(3, 5));

    // expected = Arrays.asList(
    // new Interval(1, 6));

    // assertEquals(expected, MergeAllOverlappingIntervals.merge(intervals));
  }

  @Test
  void testMergeMore() {
    List<Interval> intervals = Arrays.asList(
        new Interval(1, 3),
        new Interval(2, 6),
        new Interval(8, 10),
        new Interval(15, 18));

    List<Interval> mergedIntervals = MergeAllOverlappingIntervals.merge(intervals);

    List<Interval> expectedMergedIntervals = Arrays.asList(
        new Interval(1, 6),
        new Interval(8, 10),
        new Interval(15, 18));

    assertEquals(expectedMergedIntervals, mergedIntervals);
  }

  ////////////////////////

}
