package org.psk.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree where each node can only have a digit (0-9) value, each
 * root-to-leaf path will represent a number. Find the total sum of all the
 * numbers represented by all paths.
 *
 * Example 1:
 * Output: 408 Explaination: The sume of all path numbers: 17 + 192 + 199
 * -------------------1
 * --------------7-----------9
 * ----------------------2--------9
 */
class SumOfPathNumbers {

  public static int findSumOfPathNumbers(TreeNode root) {
    var paths = new ArrayList<ArrayList<Integer>>();
    var currPath = new ArrayList<Integer>();
    discoverAllPaths(root, currPath, paths);
    d("Paths: " + paths);
    int grandTotal = 0;
    for (var p : paths) {
      int powerOfTen = 0;
      int subTotal = 0;
      for (var i : p.reversed()) {
        d("Adding " + (i * Math.pow(10, powerOfTen)) + " to the subtotal");
        subTotal += i * Math.pow(10, powerOfTen);
        powerOfTen++;
      }
      d("Subtotal for path " + p + ": " + subTotal);
      grandTotal += subTotal;
    }
    return grandTotal;
  }

  private static void d(String s) {
    System.out.println(s);
  }

  private static void discoverAllPaths(TreeNode root, ArrayList<Integer> currPath,
      ArrayList<ArrayList<Integer>> paths) {
    currPath.add(root.val);
    d("Added " + root.val + " to: " + currPath);
    if (root.left == null && root.right == null) {
      // d(root.val + " is a leaf node so adding " + currPath + " to list of paths and
      // removing " + root.val
      // + " from currPath");
      d(root.val + " is a leaf node so adding " + currPath + " to list of paths");
      paths.add(new ArrayList<Integer>(currPath));
    } else {
      if (root.left != null) {
        discoverAllPaths(root.left, currPath, paths);
      }
      if (root.right != null) {
        discoverAllPaths(root.right, currPath, paths);
      }
    }
    d("Removing since at end of func: " + currPath.getLast());
    currPath.removeLast();
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);
    System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
  }
}