import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

public class AdderTest {
  @Test
  public void testAdd() {
    int result = Integer.parseInt(Adder.add("1", "2"));
    assertEquals(result, 1 + 2);

    assertEquals(
      Adder.add("2", "3"),
      Adder.add("2", "3")
    );
  }

  @Test
  public void testHasProperties() {
    // commutative
    assertEquals(
      Adder.add("300", "200"),
      Adder.add("200", "300")
    );

    // associative
    assertEquals(
      Adder.add("500", Adder.add("200", "300")),
      Adder.add(Adder.add("500", "300"), "200")
    );

    String str1 = Adder.add("404", "0");
    String str2 = Adder.add("0", "404");
    String str3 = "404";

    assertTrue(str1.equals(str2) && str2.equals(str3) && str3.equals(str1));
  }

  @Test
  public void testAcceptsDouble() {
    double result = Double.parseDouble(Adder.add("2.5", "3.5"));
    assertTrue(result == 6.0);
  }

  @Test
  public void testAcceptsBinary() {
    int result = Integer.parseInt(Adder.add("0b01", "0b11"));
    assertTrue(result == 5);
  }

  @Test
  public void testAcceptsString() {
    int result = Integer.parseInt(Adder.add("one", "two"));
    assertTrue(result == 3);
  }

  @Test
  public void testWorkaroundZero() {
    assertEquals(
      Integer.parseInt(Adder.add("0", "0")),
      String.valueOf(0)
    );
  }

  @Test
  public void testNullReference() {
    try {
      Adder.add(null, "12");
      fail();
    } catch(IllegalArgumentException ignored) {}
  }

  @Test
  public void testTrimString() {
    assertEquals(
      Adder.add("  12  ", "  13  "),
      String.valueOf(12 + 13)
    );
  }
}