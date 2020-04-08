package datastructures.mutable;

import datastructures.Month;
import static datastructures.Month.*;

public class SetOfMonths {
  private short bitmask;

  private SetOfMonths(short bitmask) {
    this.bitmask = bitmask;
  }

  // bitwise operators
  // | (or) -> 0101 | 0111 => 0111 
  // & (and) -> 0101 & 0111 => 0101
  // ^ (xor) -> 0101 ^ 0111 => 0010
  // ~ (complement) -> ~ 0101 => 1010
  // a = 10
  // >> (signed right shift) -> a >> 1 = 5
  // a = 5
  // << (signed left shift) -> a << 1 = 10

  public SetOfMonths add(Month month) {
    int position = month.ordinal();
    bitmask |= (1 << position);
    return this;
  }

  public SetOfMonths add(String[] months) {
    for(String month : months) {
      int position = Month.valueOf(month).ordinal();
      bitmask |= (1 << position);
    }

    return this;
  }

  public boolean contains(Month month) {
    return (bitmask >> month.ordinal()) % 2 != 0;
  }

  public SetOfMonths remove(Month month) {
    int position = month.ordinal();
    int oneAtPosition = (1 << position);
    int zeroAtPosition = (-1) ^ oneAtPosition;
    bitmask &= zeroAtPosition;
    return this;
  }

  public static SetOfMonths empty() {
    return new SetOfMonths((short)0);
  }

  public static SetOfMonths of(Month... months) {
    short temp_bitmask = 0;
    for(Month month: months) {
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
    System.out.println(empty().add(January).add(February));
    System.out.println(empty());
    
    SetOfMonths example = SetOfMonths.of(April, September, August);
    System.out.println(example);
    example.remove(April).add(July).add(April);
    System.out.println(example);
    
  }
}