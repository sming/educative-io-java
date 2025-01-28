package org.psk.interview;

/**
 * Given a binary tree and a number sequence, find if the sequence is present as
 * a root-to-leaf path in the given tree.
 *
 * - so we know that the first digit must be root and the final digit must be a
 * leaf i.e. if it's not a leaf, don't
 * consider it
 * - we'll want early exit but that's a nice to have
 * - as always the problem will be a mutable stack being passed around or...
 * - we just keep the idx of the next required number, no?
 */
class PathWithGivenSequence {
  public static boolean findPath(TreeNode root, int[] sequence) {
    return _findPath(root, sequence, 0);
  }

  public static boolean _findPath(TreeNode node, int[] sequence, int idx) {
    if (node == null) {
      return false;
    }

    int required = sequence[idx];
    if (node.val != required) {
      d("Node val " + node.val + " doesn't match required " + required + ", at idx " + idx);
      return false;
    }

    if (idx == sequence.length - 1 && node.left == null && node.right == null) {
      return true;
    }

    if (_findPath(node.left, sequence, idx + 1)) {
      return true;
    }

    if (_findPath(node.right, sequence, idx + 1)) {
      return true;
    }

    return false;
  }

  private static void d(String s) {
    System.out.println(s);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);
    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));

    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
  }
}