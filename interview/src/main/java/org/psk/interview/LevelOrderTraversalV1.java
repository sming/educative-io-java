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
class LevelOrderTraversalV1 {
  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    if (root == null)
      return result;

    var q = new LinkedList<TreeNode>();
    q.add(root);

    while (!q.isEmpty()) {
      // result.add(new ArrayList<Integer>());
      var node = q.peek();
      // result.get(result.size() - 1).add(node.val);
      if (node.left != null) {
        q.add(node.left);
      }
      if (node.right != null) {
        q.add(node.right);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> result = LevelOrderTraversalV1.traverse(root);
    System.out.println("Level order traversal: " + result);
  }
}