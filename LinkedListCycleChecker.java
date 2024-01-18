import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Problem Statement #
 * Given the head of a Singly LinkedList, write a function to determine if the
 * LinkedList has a cycle in it or not.
 *
 * Example:
 * Following LinkedList has a cycle:
 * head
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 3
 * Following LinkedList doesn't have a cycle:
 * head
 * 2
 * 4
 * 6
 * 8
 * 10
 * null
 */

class ListNode {
  public int val = 0;
  public ListNode next;

  public ListNode(int v, ListNode next) {
    this.val = v;
    this.next = next;
  }
}

public class LinkedListCycleChecker {

  public static void main(String[] args) {

  }

  private static boolean hasCycle(ListNode n) {
    if (n == null || n.next == null)
      return false;

    if (n.next.next == null)
      return n.val == n.next.val;

    ListNode slow = n, fast = n.next.next;
    while (true) {
      if (slow.val == fast.val)
        return true;
      if (fast.next != null && fast.next.val == slow.val)
        return true;

      if (fast.next != null)
        if (fast.next.next != null)
          fast = fast.next.next;
        else
          fast = fast.next;
      else
        return false;

      slow = slow.next;
    }
  }
}