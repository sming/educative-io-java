package org.psk.interview;

import java.util.*;

/**
 * Given a set with distinct elements, find all of its distinct subsets.
 *
 * Example 1:
 *
 * Input: [1, 3]
 * Output: [], [1], [3], [1,3]
 * Example 2:
 *
 * Input: [1, 5, 3]
 * Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]
 *
 * imagine starting at the top of a binary tree
 * you'd have [], then you add 1 to the queue
 * it gets unloaded, but not before adding 5 and 3
 * but how do we get the subsets?
 * let's say you have 1 and 3. you will need:
 * [], [1], [3], [1,3]
 * ah - you treat [] as a valid 'option' AHA. So we just need some combinatorial
 * logic.
 * A
 * B
 * A+B
 * B+A // ignore this
 * C
 * C+A, C+B, C+A+B, C+B+A (ignore),
 * so it's recursive??? no. We just build a big list and then append the latest
 * token to each of the other tokens, right?
 */
class Subsets {

  public static List<List<Integer>> findSubsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();

    var setOfSets = new TreeSet<TreeSet<Integer>>();
    setOfSets.add(new TreeSet<Integer>());

    if (nums == null || nums.length == 0) {
      return res;
    }

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      d("Adding " + num + " to combinations.");
      _addNumToSets(setOfSets, num);
    }

    setOfSets.stream().forEach(x -> {
      res.add(x.stream().toList());
    });

    return res;
  }

  private static void d(String s) {
    System.out.println(s);
  }

  private static void _addNumToSets(TreeSet<TreeSet<Integer>> setOfSets, int num) {
    var dupes = new TreeSet<TreeSet<Integer>>();
    for (TreeSet<Integer> treeSet : setOfSets) {
      var dupe = new TreeSet<Integer>(treeSet);
      d("Adding " + num + " to new copy of: " + dupe);
      dupe.add(num);
      dupes.add(dupe);
      d("#combos: " + dupes.size());
    }
    setOfSets.addAll(dupes);
  }

  public static void main(String[] args) {
    List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });

    System.out.println("Here is the list of subsets: " + result);
    result = Subsets.findSubsets(new int[] { 1, 5, 3 });
    System.out.println("Here is the list of subsets: " + result);
  }
}