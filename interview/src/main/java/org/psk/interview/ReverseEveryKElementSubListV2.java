package org.psk.interview;

import java.io.*;
import java.util.*;
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
 * Original List: key = 3
 * head 1 2 3 4 5 6 7 8 null
 *
 * Resulting list: head 3 2 1 6 5 4 8 7 null
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

class ReverseEveryKElementsV2 {
  static class Stack {
    private ArrayList<ListNode> stack = new ArrayList<>();
    private int subListLength;
    private int insertionIdx = 0;

    ListNode get(int i) {
      return stack.get(i);
    }

    Stack(int subListLength) {
      this.subListLength = subListLength;
    }

    void push(ListNode l) {
      if (stack.size() % this.subListLength == 0) {
        dump("Stack size is " + stack.size() + ", setting insertionIdx to it");
        insertionIdx = stack.size();
      }

      var copy = new ListNode(l);
      stack.add(insertionIdx, copy);
      dump("Pushing " + copy);
      if (insertionIdx + 1 < stack.size()) {
        copy.next = stack.get(insertionIdx + 1);
        dump("Setting .next to " + copy.next);
      }
      dump("Stack is now: " + Arrays.toString(stack.toArray()));
    }

    void hackFix() {
      int i = 0;
      while (true) {
        i += subListLength;
        if (i >= stack.size()) {
          break;
        }
        if (i < stack.size()) {
          stack.get(i - 1).next = stack.get(i);
          dump("Pointed " + stack.get(i - 1) + " at " + stack.get(i));
        }
      }
    }
  }

  public static ListNode reverse(ListNode head, int k) {
    if (head == null || k <= 1)
      return head;

    var linkNode = head;
    var stack = new Stack(k);

    while (linkNode != null) {
      dump("Pushing " + linkNode);
      stack.push(linkNode);
      linkNode = linkNode.next;
    }

    stack.hackFix();

    return stack.get(0);
  }

  static void dump(String s) {
    System.out.println(s);
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
    ListNode result = ReverseEveryKElementsV2.reverse(head, 3);
    System.out.print("Nodes of the reversed Linkedlist are: ");
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }

  }
}
