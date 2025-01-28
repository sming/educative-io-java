package org.psk.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Find the minimum depth of a binary tree. The minimum depth is the number of
 * nodes along the
 * shortest path from the root node to the nearest leaf node.
 *
 * Example 1:
 * ----------------------- 1
 * ---------2--------------------------3
 * 4---------------5
 *
 * == 2 (1 -> 3)
 */
class MinimumBinaryTreeDepth {

  public static int findDepth(TreeNode n) {
    if (n == null)
      return 0;
    try {
      return findMinDepth(n, 1, Integer.MAX_VALUE);
    } catch (Exception e) {
      e.printStackTrace();
      return 0;

    }
  }

  private static int findMinDepth(TreeNode n, int currDepth, int minDepth) throws Exception {
    if (n.left == null && n.right == null) {
      return Math.min(currDepth, minDepth);
    }

    if (n.left != null) {
      return Math.min(minDepth, findMinDepth(n.left, currDepth + 1, minDepth));
    }
    if (n.right != null) {
      return Math.min(minDepth, findMinDepth(n.right, currDepth + 1, minDepth));
    }

    throw new Exception("Application logic error");
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    root.left.left = new TreeNode(9);
    root.right.left.left = new TreeNode(11);
    System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
  }
}