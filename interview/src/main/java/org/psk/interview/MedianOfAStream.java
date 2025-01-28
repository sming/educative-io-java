package org.psk.interview;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Problem Statement #
 * Design a class to calculate the median of a number stream. The class should
 * have the following two methods:
 *
 * insertNum(int num): stores the number in the class
 * findMedian(): returns the median of all numbers inserted in the class
 * If the count of numbers inserted in the class is even, the median will be the
 * average of the middle two numbers.
 *
 * Example 1:
 *
 * 1. insertNum(3)
 * 2. insertNum(1)
 * 3. findMedian() -> output: 2
 * 4. insertNum(5)
 * 5. findMedian() -> output: 3
 * 6. insertNum(4)
 * 7. findMedian() -> output: 3.5
 *
 * PSK NOTES
 *
 */
class MedianOfAStream {
  class Node {
    static int numNodes;
    Node bigger;
    Integer val;
  }

  private ArrayList<Node> stream = new ArrayList<>();
  // private Node smallest = null;

  public void insertNum(int num) {
    for (int i = 0; i < stream.size(); i++) {
      if (stream.get(i).val > num) {
        Node element = new Node();
        element.val = num;
        stream.add(i, element);
      }
    }
  }

  public double findMedian() {
    if (stream.isEmpty()) {
      return -1;
    }

    // 1, 2, 3, 4
    // isEven == True
    // midIdx = 2.0
    // 3 + 4 / 2
    boolean isEven = stream.size() % 2 == 0;
    // So, how do you pick the two medians... well, just floor and ceiling right?
    double midIdx = stream.size() / 2.0;
    // return stream.get((Math.floorDiv(midIdx, 2)));// + Math.
    if (isEven && midIdx + 1 > stream.size()) {
      // throw new ArithmeticException("Logic error: ")
      return -1;
    }
    if (isEven) {
      d("Lower median idx: " + ((int) (midIdx) - 1));
      d("Upper median idx: " + ((int) (midIdx)));
    }
    return (stream.get(((int) (midIdx)) - 1).val + stream.get((int) (midIdx)).val) / 2.0;
  }

  private static void d(String s) {
    System.out.println(s);
  }

  public static void main(String[] args) {
    MedianOfAStream medianOfAStream = new MedianOfAStream();
    medianOfAStream.insertNum(3);
    medianOfAStream.insertNum(1);
    System.out.println("The median is: " + medianOfAStream.findMedian());
    medianOfAStream.insertNum(5);
    System.out.println("The median is: " + medianOfAStream.findMedian());
    medianOfAStream.insertNum(4);
    System.out.println("The median is: " + medianOfAStream.findMedian());
  }
}