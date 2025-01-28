package org.psk.interview;

import org.junit.jupiter.api.Test;
import org.psk.interview.utils.Interval;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class InsertIntervalTest {

  @Test
  void testInsert() {
    List<Interval> intervals = Arrays.asList(
        new Interval(1, 3),
        new Interval(5, 7),
        new Interval(8, 12));

    Interval newInterval = new Interval(4, 6);

    List<Interval> expected = Arrays.asList(
        new Interval(1, 3),
        new Interval(4, 7),
        new Interval(8, 12));

    assertEquals(expected, InsertInterval.insert(intervals, newInterval));
  }

  @Test
  void testFindInsertPosition() {
    List<Interval> intervals = Arrays.asList(
        new Interval(1, 2),
        new Interval(5, 7),
        new Interval(8, 12));

    Interval newInterval = new Interval(3, 4);
    assertEquals(1, InsertInterval.findInsertPosition(intervals, newInterval));

    newInterval = new Interval(9, 11);
    assertEquals(3, InsertInterval.findInsertPosition(intervals, newInterval));

    newInterval = new Interval(13, 15);
    assertEquals(3, InsertInterval.findInsertPosition(intervals, newInterval));

    newInterval = new Interval(0, 12);
    assertEquals(0, InsertInterval.findInsertPosition(intervals, newInterval));

    newInterval = new Interval(6, 12);
    assertEquals(2, InsertInterval.findInsertPosition(intervals, newInterval));
  }
}
