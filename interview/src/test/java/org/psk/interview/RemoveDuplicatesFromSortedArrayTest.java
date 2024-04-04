package org.psk.interview;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class RemoveDuplicatesFromSortedArrayTest {

  @Test
  public void testRemove() {
    int[] arr = { 1, 1, 2, 2, 3, 4, 4, 5 };
    int newLength = RemoveDuplicatesFromSortedArray.remove(arr);

    // DEBUGGING
    var foo = Arrays.toString(arr);
    System.out.println("Foo: " + foo);

    int[] expectedArr = { 1, 2, 3, 4, 5 };
    assertEquals(5, newLength);
    assertArrayEquals(expectedArr, Arrays.copyOf(arr, newLength));
  }

  @Test
  public void testRemoveEmptyArray() {
    int[] arr = {};
    int newLength = RemoveDuplicatesFromSortedArray.remove(arr);
    assertEquals(0, newLength);
  }

  @Test
  public void testRemoveSingleElement() {
    int[] arr = { 1 };
    int newLength = RemoveDuplicatesFromSortedArray.remove(arr);
    int[] expectedArr = { 1 };
    assertEquals(1, newLength);
    assertArrayEquals(expectedArr, Arrays.copyOf(arr, newLength));
  }

  @Test
  public void testRemoveAllDuplicates() {
    int[] arr = { 1, 1, 1, 1, 1 };
    int newLength = RemoveDuplicatesFromSortedArray.remove(arr);
    int[] expectedArr = { 1 };
    assertEquals(1, newLength);
    assertArrayEquals(expectedArr, Arrays.copyOf(arr, newLength));
  }

  @Test
  public void testRemoveNoDuplicates() {
    int[] arr = { 1, 2, 3, 4, 5 };
    int newLength = RemoveDuplicatesFromSortedArray.remove(arr);
    int[] expectedArr = { 1, 2, 3, 4, 5 };
    assertEquals(5, newLength);
    assertArrayEquals(expectedArr, Arrays.copyOf(arr, newLength));
  }
}