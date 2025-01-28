package org.psk.interview;

import java.util.*;

/**
 * Minimum Meeting Rooms (hard) #
 * Given a list of intervals representing the start and end time of ‘N’
 * meetings, find the minimum number of rooms required to hold all the meetings.
 *
 * Example 1:
 *
 * Meetings: [[1,4], [2,5], [7,9]]
 * Output: 2
 * Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these
 * two meetings. [7,9] can
 * occur in any of the two rooms later.
 * Example 2:
 *
 * Meetings: [[6,7], [2,4], [8,12]]
 * Output: 1
 * Explanation: None of the meetings overlap, therefore we only need one room to
 * hold all meetings.
 * Example 3:
 *
 * Meetings: [[1,4], [2,3], [3,6]]
 * Output:2
 * Explanation: Since [1,4] overlaps with the other two meetings [2,3] and
 * [3,6], we need two rooms to
 * hold all the meetings.
 *
 * Example 4:
 *
 * Meetings: [[4,5], [2,3], [2,4], [3,5]]
 * Output: 2
 * Explanation: We will need one room for [2,3] and [3,5], and another room for
 * [2,4] and [4,5].
 *
 * Here is a visual representation of Example 4:
 *
 * Minimum Meeting Rooms (hard) #
 * Given a list of intervals representing the start and end time of ‘N’
 * meetings, find the minimum number of rooms required to hold all the meetings.
 *
 * Example 1:
 *
 * Meetings: [[1,4], [2,5], [7,9]]
 * Output: 2
 * Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these
 * two meetings. [7,9] can
 * occur in any of the two rooms later.
 * Example 2:
 *
 * Meetings: [[6,7], [2,4], [8,12]]
 * Output: 1
 * Explanation: None of the meetings overlap, therefore we only need one room to
 * hold all meetings.
 * Example 3:
 *
 * Meetings: [[1,4], [2,3], [3,6]]
 * Output:2
 * Explanation: Since [1,4] overlaps with the other two meetings [2,3] and
 * [3,6], we need two rooms to
 * hold all the meetings.
 *
 * Example 4:
 *
 * Meetings: [[4,5], [2,3], [2,4], [3,5]]
 * Output: 2
 * Explanation: We will need one room for [2,3] and [3,5], and another room for
 * [2,4] and [4,5].
 *
 * Here is a visual representation of Example
 * 4:/Users/peter/Library/Containers/at.EternalStorms.Yoink/Data/Documents/YoinkPromisedFiles.noIndex/yoinkFilePromiseCreationFolder020220EC-45D5-4B26-9EF5-712933C45F9D/add020220EC-45D5-4B26-9EF5-712933C45F9D/download.svg
 */

class Meeting {
  int start;
  int end;

  public Meeting(int start, int end) {
    this.start = start;
    this.end = end;

  };
}

class MinimumMeetingRooms {
  /**
   * So this will not return the true minimum number of rooms for fancy
   * requirements like the last example given.
   *
   * @param meetings
   * @return
   */
  public static int findMinimumMeetingRooms(List<Meeting> meetings) {
    BitSet bitSet = new BitSet(13);
    bitSet.set(0, 12, false);
    meetings.sort((m1, m2) -> m1.start - m2.start);
    int minRooms = 1;
    for (var m : meetings) {
      var booked = bitSet.get(m.start, m.end);
      var mRequirements = new BitSet(13);

      mRequirements.set(m.start, m.end);
      if (booked.intersects(mRequirements)) {
        ++minRooms;
      }
      bitSet.set(m.start, m.end);
    }

    return minRooms;
  }

  public static void main(String[] args) {
    List<Meeting> input = new ArrayList<Meeting>() {
      {
        add(new Meeting(1, 4));
        add(new Meeting(2, 5));
        add(new Meeting(7, 9));
      }
    };
    var result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);
    input = new ArrayList<Meeting>() {
      {
        add(new Meeting(6, 7));
        add(new Meeting(2, 4));
        add(new Meeting(8, 12));
      }
    };
    result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input = new ArrayList<Meeting>() {
      {
        add(new Meeting(1, 4));
        add(new Meeting(2, 3));
        add(new Meeting(3, 6));
      }
    };
    result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);
    input = new ArrayList<Meeting>() {
      {
        add(new Meeting(4, 5));
        add(new Meeting(2, 3));
        add(new Meeting(2, 4));
        add(new Meeting(3, 5));
      }
    };
    result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);
  }
}