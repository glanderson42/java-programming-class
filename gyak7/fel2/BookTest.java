import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class BookTest {
  @Before
  public void setUp() { 
    Book.resetId();
  }

  @After
  public void tearDown() {
    Book.resetId();
  }

  @Test
  public void testBookMake() { 
    Book book = Book.make("abc", "def", "FANTASY", "1000");
    assertEquals(book.getId(), 0);
  }

  @Test
  public void testBooksMake() { 
    Book book1 = Book.make("abc", "def", "FANTASY", "1000");
    Book book2 = Book.make("abc", "def", "FANTASY", "1000");

    assertEquals(book1.getReservePrice(), 1000);
    assertEquals(book2.getReservePrice(), 1000);

    assertEquals(book1.getId(), 0);
    assertEquals(book2.getId(), 1);
  }

  @Test
  public void testParsers() {
    // int parsing
    assertEquals(Book.make("abc", "def", "SCIFI", "onehundred"), null);

    // enum check
    assertEquals(Book.make("abc", "def", "asd", "1000"), null);

    // cover int and enum check success
    assertNotEquals(Book.make("abc", "def", "SCIFI", "1000"), null);
  }

  @Test
  public void testCheckValues() {
    // title null
    assertEquals(Book.make("abc", null, "SCIFI", "1000"), null);

    // title length is smaller than 2
    assertEquals(Book.make("abc", "a", "SCIFI", "1000"), null);

    // covers reserve proce positivity check fail
    assertEquals(Book.make("abc", "asd", "SCIFI", "0"), null);
    assertEquals(Book.make("abc", "asd", "SCIFI", "-20"), null);

    // success make
    assertNotEquals(Book.make("asd", "def", "SCIFI", "1000"), null);
  }

  @Test
  public void testIsSameGenre() {
    Book b1 = Book.make("abc", "def1", "SCIFI", "1000");
    Book b2 = Book.make("abc", "def2", "FANTASY", "421");
    Book b3 = Book.make("abc", "def3", "FANTASY", "56354");

    assertFalse(Book.isSameGenre(b1, b2));
    assertTrue(Book.isSameGenre(b2, b3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNotIsSame() {
    Book b1 = Book.make("abc", "def", "SCIFI", "1000");
    Book b2 = Book.make("abc", "def", "FANTASY", "1000");
    b1.compare(b2);
  }

  @Test
  public void testCompare() {
    Book b1 = Book.make("abc", "def", "SCIFI", "100");
    Book b2 = Book.make("abc", "def", "SCIFI", "1000");

    assertEquals(b1.compare(b2), -1);
    assertEquals(b2.compare(b1), 1);
  }

  @Test
  public void testCompareEqual() {
    Book b1 = Book.make("abc", "def", "SCIFI", "1000");
    Book b2 = Book.make("abc", "def", "SCIFI", "1000");
    assertEquals(b1.compare(b2), 0);
  }
}