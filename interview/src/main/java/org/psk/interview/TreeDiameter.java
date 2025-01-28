package org.psk.interview;

import java.util.ArrayList;

/**
 * Tree Diameter (medium) #
 * Given a binary tree, find the length of its diameter. The diameter of a tree
 * is the number of nodes on the longest path between any two leaf nodes. The
 * diameter of a tree may or may not pass through the root.
 *
 * Note: You can always assume that there are at least two leaf nodes in the
 * given tree.
 *
 * Example 1:
 * -------------1
 * ----------2-----3
 * ---------4-----5-6
 *
 * Output: 5
 * Explaination: The diameter of the tree is: [4, 2, 1, 3, 6]
 *
 * PSK NOTES ——————————————
 * So as you walk the tree, if you assemble a List<List<Integer>> leafPaths
 * variable
 * on v1 you could just do N^2 and test (TBD) every path against each other and
 * just
 * report the longest.
 * I *think* it'd make sense to order the paths by length first, for most cases.
 * OR you could assemble a TreeMap<Integer, Map<Integer, Integer>> ancestorDist
 * where the key is
 * the parent/non-leaf nodes and the members of the Map are those leaf nodes
 * that have
 * that parent and the distance to that parent.
 * Ouch.
 */
class TreeDiameter {

  public static int findDiameter(TreeNode n) {
    return 0;
  }

  private static void d(String s) {
    System.out.println(s);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    root.left.left = null;
    root.right.left.left = new TreeNode(7);
    root.right.left.right = new TreeNode(8);
    root.right.right.left = new TreeNode(9);
    root.right.left.right.left = new TreeNode(10);
    root.right.right.left.left = new TreeNode(11);
    System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
  }
}