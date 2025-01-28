package org.psk.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree,populate an array to represent its level-by-level
 * traversal.You should populate the values of all nodes of each level from left
 * to right in separate sub-arrays.
 *
 * PSK
 *
 * -------------------6
 * ----------3------------------------10
 * ----2---------------------- 8------------ 12
 * 1
 *
 * =>
 *
 * [
 * [6],
 * [3,10],
 * [2,8,12],
 * [1]
 * ]
 *
 * so how do you know when you've either put or consumed the last number of a
 * level?
 * maybe it'll shake out in the wash
 */
class LevelOrderTraversalV2 {

  private static void visit(TreeNode n, int depth, List<List<Integer>> result) {
    if (n == null)
      return;

    List<Integer> level = null;
    if (depth + 1 > result.size()) {
      level = new ArrayList<Integer>();
      result.add(level);
    } else {
      level = result.get(depth);
    }

    level.add(n.val);

    if (n.left != null) {
      visit(n.left, depth + 1, result);
    }
    if (n.right != null) {
      visit(n.right, depth + 1, result);
    }
  }

  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    visit(root, 0, result);

    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> result = LevelOrderTraversalV2.traverse(root);
    System.out.println("Level order traversal: " + result);
  }
}