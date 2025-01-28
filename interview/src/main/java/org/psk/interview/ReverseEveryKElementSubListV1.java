package org.psk.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Problem Statement #
 * Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized
 * sub-list starting from the head.
 *
 * If, in the end, you are left with a sub-list with less than ‘k’ elements,
 * reverse it too.
 * Example:
 *
 * Original List:
 * head
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * null
 *
 * Resulting list:
 * head
 * 3
 * 2
 * 1
 * 6
 * 5
 * 4
 * 8
 * 7
 * null
 *
 * PSK NOTES
 * it seems like it's screaming out for stacks, right? FILO
 * and how do we do stacks in Java generally...
 * OK well what is a stack? A dynamically growing data structure with a top
 * you push and pull off the top
 * when you push on the top, the previous items "sink down" 1 spot
 * so this sounds very much like an ArrayList that you use as follows:
 * add 1, add 2, add 3
 * pop = 3
 * pop = 2
 * pop = 1
 * you just go backwards from the end (???)
 */

class ReverseEveryKElements {
  public static ListNode reverse(ListNode head, int k) {
    var stack = new ArrayList<ListNode>();
    var curr = head;
    while (curr != null) {
      stack.add(curr);
      curr = curr.next;
    }
    System.out.println(".forEach:");
    stack.forEach(i -> System.out.print(i + " "));

    System.out.println("String.join:");
    String result = String.join(" ", stack.stream().map(i -> i.toString()).toList());
    System.out.println(result);
    ListNode lnToStitch = null;
    for (int i = 0; i < stack.size(); i++) {
      System.out.print("i:" + i + ",");
      if ((i + 1) % k == 0) {
        System.out.println((i + 1) + " is divisible by " + k + ", so reversing");
        ListNode lnTo = null;
        for (int j = i; j > (i - k + 1); j--) {
          var ln = stack.get(j);
          if (j == i) {
            if (lnToStitch != null) {
              lnToStitch.next = lnTo;
            }
            lnToStitch = lnTo;
          }
          lnTo = stack.get(j - 1);
          ln.next = lnTo;
          System.out.print(ln + ", ");
        }
      }
    }

    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = new ListNode(7);
    head.next.next.next.next.next.next.next = new ListNode(8);
    ListNode result = ReverseEveryKElements.reverse(head, 3);
    System.out.print("Nodes of the reversed Linkedlist are: ");
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }

  }
}
