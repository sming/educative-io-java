package org.psk.interview;

/**
 * Problem Statement #
 * Given a sorted array of numbers, find if a given number ‘key’ is present in
 * the array. Though we know that the array is sorted, we don’t know if it’s
 * sorted in ascending or descending order. You should assume that the array can
 * have duplicates.
 *
 * Write a function to return the index of the ‘key’ if it is present in the
 * array, otherwise return -1.
 */
public class BinarySearch {
  public static int search(int[] arr, int key) {
    if (arr == null || arr.length == 0) {
      return -1;
    }

    return _search(arr, key);
  }

  private static boolean isAscending(int arr[]) {
    boolean ascending = true;
    if (arr[0] > arr[arr.length - 1]) {
      ascending = false;
    }
    return ascending;
  }

  private static boolean keepGoing(int[] arr, int idx1, int idx2) {
    if (isAscending(arr)) {
      return idx2 > idx1;
    } else {
      return idx1 > idx2;
    }
  }

  private static boolean matches(int[] arr, int idx, int key) {
    return arr[idx] == key ? true : false;
  }

  private static int getKeyIdx(int[] arr, int idx1, int idx2, int key) {
    if (matches(arr, idx1, key)) {
      return idx1;
    } else if (matches(arr, idx2, key)) {
      return idx2;
    }

    return -1;
  }

  private static int _search(int[] arr, int key) {
    int idx1 = 0;
    int idx2 = arr.length - 1;
    while (keepGoing(arr, idx1, idx2)) {
      int res = getKeyIdx(arr, idx1, idx2, key);
      if (res != -1) {
        return res;
      }

      int halfwayIdx = (idx1 + idx2) / 2;
      int halfway = arr[halfwayIdx];
      if (isAscending(arr)) {
        if (key > halfway) {
          idx1 = halfwayIdx;
        } else {
          idx2 = halfwayIdx;
        }
      } else {
        if (key > halfway) {
          idx2 = halfwayIdx;
        } else {
          idx1 = halfwayIdx;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
    System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
    System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
    System.out.println((BinarySearch.search(new int[] { 10, 6, 4 }, 4)));
  }
}
