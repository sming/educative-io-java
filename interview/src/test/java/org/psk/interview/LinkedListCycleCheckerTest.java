package org.psk.interview;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListCycleCheckerTest {

  @Test
  void hasCycle_NoCycle_ShouldReturnFalse() {
    ListNode node1 = new ListNode(1, null);
    ListNode node2 = new ListNode(2, node1);
    ListNode node3 = new ListNode(3, node2);
    ListNode node4 = new ListNode(4, node3);
    ListNode node5 = new ListNode(5, node4);
    ListNode node6 = new ListNode(6, node5);

    LinkedListCycleChecker checker = new LinkedListCycleChecker();
    boolean result = checker.hasCycle(node6);

    assertFalse(result);
  }

  @Test
  void hasCycle_2Node_ShouldReturnFalse() {
    ListNode node1 = new ListNode(1, null);
    ListNode node2 = new ListNode(2, node1);

    LinkedListCycleChecker checker = new LinkedListCycleChecker();
    boolean result = checker.hasCycle(node2);

    assertFalse(result);
  }

  @Test
  void hasCycle_3Node() {
    ListNode node1 = new ListNode(1, null);
    ListNode node2 = new ListNode(2, node1);
    ListNode node3 = new ListNode(3, node2);

    LinkedListCycleChecker checker = new LinkedListCycleChecker();
    boolean result = checker.hasCycle(node3);

    assertFalse(result);
  }

  @Test
  void hasCycle_3Node_Cycle() {
    ListNode node1 = new ListNode(1, null);
    ListNode node2 = new ListNode(2, node1);
    ListNode node3 = new ListNode(3, node2);
    node1.next = node3; // this creates the cycle

    LinkedListCycleChecker checker = new LinkedListCycleChecker();
    boolean result = checker.hasCycle(node3);

    assertTrue(result);
  }

  @Test
  void hasCycle_big() {
    ListNode node1 = new ListNode(1, null);
    ListNode node2 = new ListNode(2, node1);
    ListNode node3 = new ListNode(3, node2);
    ListNode node4 = new ListNode(4, node3);
    ListNode node5 = new ListNode(5, node4);
    ListNode node6 = new ListNode(6, node5);
    ListNode node7 = new ListNode(7, node6);

    LinkedListCycleChecker checker = new LinkedListCycleChecker();
    boolean result = checker.hasCycle(node7);

    assertFalse(result);
  }

  @Test
  void hasCycle_big_cycle() {
    ListNode node1 = new ListNode(1, null);
    ListNode node2 = new ListNode(2, node1);
    ListNode node3 = new ListNode(3, node2);
    ListNode node4 = new ListNode(4, node3);
    ListNode node5 = new ListNode(5, node4);
    ListNode node6 = new ListNode(6, node5);
    ListNode node7 = new ListNode(7, node6);
    node3.next = node7; // this creates a cycle

    LinkedListCycleChecker checker = new LinkedListCycleChecker();
    boolean result = checker.hasCycle(node7);

    assertTrue(result);
  }

  @Test
  void hasCycle_NoCycle_ShouldReturnFalse_ForNull() {
    LinkedListCycleChecker checker = new LinkedListCycleChecker();
    boolean result = checker.hasCycle(null);

    assertFalse(result);
  }
}