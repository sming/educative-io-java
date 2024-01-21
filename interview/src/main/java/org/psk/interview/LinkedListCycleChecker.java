package org.psk.interview;

public class LinkedListCycleChecker {

  public boolean hasCycle(ListNode n) {
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