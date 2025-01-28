package org.psk.interview;

import java.util.*;

/**
 * Maximum CPU Load (hard) #
 * We are given a list of Jobs. Each job has a Start time, an End time, and a
 * CPU load when it is running. Our goal is to find the maximum CPU load at any
 * time if all the jobs are running on the same machine.
 *
 * Example 1:
 *
 * Jobs: [[1,4,3], [2,5,4], [7,9,6]]
 * Output: 7
 * Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load
 * (3+4=7) will be when both the
 * jobs are running at the same time i.e., during the time interval (2,4).
 * Example 2:
 *
 * Jobs: [[6,7,10], [2,4,11], [8,12,15]]
 * Output: 15
 * Explanation: None of the jobs overlap, therefore we will take the maximum
 * load of any job which is 15.
 * Example 3:
 *
 * Jobs: [[1,4,2], [2,4,1], [3,6,5]]
 * Output: 8
 * Explanation: Maximum CPU load will be 8 as all jobs overlap during the time
 * interval [3,4].
 */
public class MaximumCpuLoad {
  private static final int numBits = 100;

  public static int findMaxCPULoad(List<org.psk.interview.Job> jobs) {
    int maxLoadSeen = -1;
    var overallLoad = new ArrayList<Integer>(numBits);
    for (int i = 0; i < numBits; i++) {
      overallLoad.add(0);
    }
    for (var job : jobs) {
      for (int i = job.start; i < job.end; i++) {
        overallLoad.set(i, overallLoad.get(i) + job.cpuLoad);
        maxLoadSeen = Math.max(maxLoadSeen, overallLoad.get(i));
      }
    }
    return maxLoadSeen;
  }

  public static void main(String[] args) {
    var input = Arrays.asList(
        new org.psk.interview.Job(1, 4, 3),
        new org.psk.interview.Job(2, 5, 4),
        new org.psk.interview.Job(7, 9, 6));
    System.out.println("Maximum CPU load at any time: " + MaximumCpuLoad.findMaxCPULoad(input));

    input = new ArrayList<Job>(Arrays.asList(
        new org.psk.interview.Job(6, 7, 10),
        new org.psk.interview.Job(2, 4, 11),
        new org.psk.interview.Job(8, 12, 15)));
    System.out.println("Maximum CPU load at any time: " + MaximumCpuLoad.findMaxCPULoad(input));

    input = new ArrayList<Job>(Arrays.asList(
        new org.psk.interview.Job(1, 4, 2),
        new org.psk.interview.Job(2, 4, 1),
        new org.psk.interview.Job(3, 6, 5)));
    System.out.println("Maximum CPU load at any time: " + MaximumCpuLoad.findMaxCPULoad(input));

  }
}