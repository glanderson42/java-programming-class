import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MathUtilsTest {
  @Test
  public void testPositive() {
    int result = MathUtils.Increment(4);
    assertEquals(5, result);
  }

  @Test
  public void testNegative() {
    int result = MathUtils.Increment(-4);
    assertEquals(-3, result);
  }

  @Test
  public void testZero() {
    int result = MathUtils.Increment(0);
    assertEquals(1, result);
  }

  @Test
  public void testMaxValue() {
    int res = MathUtils.Increment(Integer.MAX_VALUE);
    assertEquals(Integer.MAX_VALUE, res);
  }

  @Test
  public void testMaxValueMinusOne() {
    int res = MathUtils.Increment(Integer.MAX_VALUE - 1);
    assertEquals(Integer.MAX_VALUE, res);
  }
}