package org.psk.interview;

import java.util.ArrayDeque;
import java.util.Queue;

class TreeNodeLevel {
  int val;
  TreeNodeLevel left;
  TreeNodeLevel right;
  TreeNodeLevel next;

  TreeNodeLevel(int x) {
    val = x;
    left = right = next = null;
  }
}

/**
 * Connect All Level Order Siblings (medium) #
 * Given a binary tree, connect each node with its level order successor. The
 * last node of each level should point to the first node of the next level.
 * /Users/peter/Documents/Screenshots/Screenshot 2024-12-01 at 3.42.40 AM.png
 ******* 1
 ****** 2 3
 **** 4 5 6 7 null
 * would become 1234567
 *************
 * PSK Notes
 * ----------
 * so we have in order, out of order and ...middle order? We want the one
 * where...we try all the children at a level
 * before descending to the next level, so that'd be:
 * 1. add left & right to queue at level N+1
 * 2. process this node as level N
 *
 * so clearly we need a queue and to keep track of the level. The level needs to
 * be in order so we can't use say a map
 *
 * I think we can rely on the queue's content and ordering to know when to
 * connect the
 * last of the N layer, to the first of the N+1 layer right?
 */
class ConnectSameLevelSiblings {
  public static void connect(TreeNodeLevel root) {
    queue.add(root);
    connectImpl();
  }

  static void connectImpl() {
    if (queue.isEmpty()) {
      return;
    }

    var node = queue.poll();
    if (node.left != null) {
      queue.add(node.left);
    }
    if (node.right != null) {
      queue.add(node.right);
    }

    if (prev != null) {
      prev.next = node;
    }

    prev = node;
    connectImpl();

  }

  private static Queue<TreeNodeLevel> queue = new ArrayDeque<TreeNodeLevel>();
  private static TreeNodeLevel prev = null;

  public static void main(String[] args) {
    TreeNodeLevel root = new TreeNodeLevel(12);
    root.left = new TreeNodeLevel(7);
    root.right = new TreeNodeLevel(1);
    root.left.left = new TreeNodeLevel(9);
    root.right.left = new TreeNodeLevel(10);
    root.right.right = new TreeNodeLevel(5);
    ConnectSameLevelSiblings.connect(root);
    // level order traversal using 'next' pointer
    TreeNodeLevel current = root;
    System.out.println("Traversal using 'next' pointer: ");
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }
}