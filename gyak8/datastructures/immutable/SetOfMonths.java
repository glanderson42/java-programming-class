package datastructures.immutable;

import datastructures.Month;
import static datastructures.Month.*;

public class SetOfMonths {
  private final short bitmask;

  private SetOfMonths(short bitmask) {
    this.bitmask = bitmask;
  }

  public SetOfMonths add(Month month) {
    int position = month.ordinal();
    return new SetOfMonths((short)(bitmask | (1 << position)));
  }

  public boolean contains(Month month) {
    return (bitmask >> month.ordinal()) % 2 != 0;
  }

  public SetOfMonths remove(Month month) {
    int position = month.ordinal();
    int oneAtPosition = (1 << position);
    int zeroAtPosition = (-1) ^ oneAtPosition;
    return new SetOfMonths((short)(bitmask & zeroAtPosition));
  }

  public final static SetOfMonths empty = new SetOfMonths((short)0);

  public static SetOfMonths of(Month... months) {
    short temp_bitmask = 0;
    for(Month month : months) {
      int position = month.ordinal();
      temp_bitmask |= (1 << position);
    }

    return new SetOfMonths(temp_bitmask);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("{");
    short s = bitmask;
    for(Month month : Month.values()) {
      if(s % 2 != 0) {
        sb.append(month);
        sb.append(',');
      }

      s /= 2;
    }

    int len = sb.length();
    if(len > 1) {
      sb.setCharAt(len - 1, '}');
    } else {
      sb.append('}');
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(empty.add(January).add(February).add(March).add(April).add(May));
    System.out.println(empty);
  }
}