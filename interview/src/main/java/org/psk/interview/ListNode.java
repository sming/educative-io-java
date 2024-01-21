package org.psk.interview;

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

public class ListNode {
  public int val = 0;
  public ListNode next;

  public ListNode(int v, ListNode next) {
    this.val = v;
    this.next = next;
  }
}