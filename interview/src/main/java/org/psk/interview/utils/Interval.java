package org.psk.interview.utils;

public class Interval {
  public int start;
  public int end;

  public final static Interval NO_OVERLAP = new Interval(-1, -1);

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null)
      return false;

    if (this == other)
      return true;

    if (Interval.class.isInstance(other)) {
      var otherInterval = Interval.class.cast(other);
      return start == otherInterval.start && end == otherInterval.end;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + start * 17;
    result = prime * result + end * 17;
    return result;
  }

  @Override
  public String toString() {
    return "Interval [" + start + "," + end + "]";
  }

  public Interval merge(Interval o) {
    int lStart = start;
    int lEnd = end;

    if (start > o.end)
      return NO_OVERLAP;

    if (end < o.start)
      return NO_OVERLAP;

    if (o.start <= start && o.end >= start) {
      // the other spans our start
      lStart = o.start;
    }

    if (o.end >= end && o.start <= end) {
      // other spans our end
      lEnd = o.end;
    }

    if (start <= o.start && end >= o.start) {
      // we span their start
      lStart = Math.min(start, lStart);
    }

    if (end >= o.end && start <= o.end) {
      // we span their end
      lEnd = Math.max(end, lEnd);
    }

    return new Interval(lStart, lEnd);
  }
}
