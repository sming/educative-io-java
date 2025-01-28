package org.psk.interview;

import java.util.*;

/**
 * Given a binary tree and a number ‘S’, find all paths in the tree such that
 * the sum of all the node values of each path equals ‘S’. Please note that the
 * paths can start or end at any node but all paths must follow direction from
 * parent to child (top to bottom).
 *
 * Sheeeeit
 * - will have to keep running totals for every node until it exceeds S
 * - need global counter to increment
 * - need to avoid double counting
 * - how do we keep the set of totals current/fresh? e.g. the totals for the LHS
 * child don't apply to children of the RHS child
 * - can't use the val cos it isn't unique
 * -
 */
class CountAllPathSum {
  public static int countPaths(TreeNode root, int s) {
    return _countPaths(root, s, new int[0]);
  }

  // every parent node of the current node has an integer in here, which
  // represents
  // the total from that node to this
  // private static LinkedList<Integer> runningTotalsStack = new
  // LinkedList<Integer>();

  private static int _countPaths(TreeNode node, int s, int runningTotals[]) {
    if (node == null) {
      return 0;
    }

    updateRunningTotals(runningTotals, node.val);
    updateTotalCount(runningTotals, s);
    runningTotals = Arrays.copyOf(runningTotals, runningTotals.length + 1);
    runningTotals[runningTotals.length - 1] = node.val;

    if (node.left != null) {
      _countPaths(node.left, s, runningTotals);
    }
    if (node.right != null) {
      _countPaths(node.right, s, runningTotals);
    }

    return totalCount;
  }

  private static void d(String s) {
    System.out.println(s);
  }

  private static void updateTotalCount(int[] runningTotals, int s) {
    d("Updating totals array " + runningTotals + " (len: " + runningTotals.length + ")");
    for (int i : runningTotals) {
      if (i == s) {
        totalCount++;
        d("Found s, count is now " + totalCount);
      }
    }
  }

  private static int totalCount = 0;

  private static void updateRunningTotals(int[] runningTotals, int val) {
    for (int i = 0; i < runningTotals.length; i++) {
      runningTotals[i] += val;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
  }
}