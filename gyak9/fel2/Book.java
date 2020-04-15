
public class Book {
  private String author;
  private String title;
  protected int pages;

  public String getAuthor() { return this.author; }

  public Book() {
    this.author = "John Steinbeck";
    this.title = "Of Mice and Man";
    this.pages = 107;
  }

  public Book(String author, String title, int pages) {
    if(author == null || title == null || author.length() < 2 || title.length() < 4) {
      throw new IllegalArgumentException("Author or Title parameter is wrong!");
    }

    this.author = author;
    this.title = title;
    this.pages = pages;
  }

  public String getShortName() {
    // subsring: beginIndex, endIndex - 1
    return this.author.substring(0, 2) + ": " + this.title.substring(0, 4) + "; " + this.pages;
  }

  public String createReference(String article, int from, int to) {
  	return getShortName() + " [" + from + " - " + to + "] refrenced in article: " + article; 
  }

  public String toString() {
  	return this.author + ": " + this.title + "; " + this.pages;
  }
}

enum CoverType {
  Softcover,
  Hardcover
}

class PrintedBook extends Book {
	protected CoverType cover;  

	public PrintedBook() {
		super();
		cover = CoverType.Hardcover;
		pages += 6;
	}

	public PrintedBook(String author, String title, int pages, CoverType cover) {
		super(author, title, pages + 6);
		this.cover = cover;
	}
	
	public int getPrice() {
		if(cover == CoverType.Softcover) {
			return pages * 2;
		} else {
			return pages * 3;
		}
	}

	@Override
	public String createReference(String article, int from, int to) {
		return super.toString() + " [" + from + " - " + to + "] referenced in article: " + article;
	}

	@Override
	public String toString() {
		String coverStr = new String();
		if(cover == CoverType.Softcover) {
			coverStr = "Softcover";
		} else {
			coverStr = "Hardcover";
		}

		return super.toString() + ": " + coverStr;
	}
}


class EBook extends Book {
		protected int PDFSize;

		public EBook(String author, String title, int pages, int PDFSize) {
			super(author, title, pages);
			this.PDFSize = PDFSize;
		}

		public int getPrice() {
			return pages + PDFSize;
		}

		@Override
		public String createReference(String article, int from, int to) {
			return super.toString() + "(" + PDFSize + ") [" + from + " - " + to + "] referenced in article: " + article; 
		}

		public String createReference(String article, String date) {
			return super.toString() + "(" + PDFSize + ") referenced in article: " + article + ", accessing PDF date: " + date;
		}
}

class Main {
  public static boolean isSameAuthor(Book book1, Book book2) {
  	return book1.getAuthor().equals(book2.getAuthor());
  }


  public static void main(String[] args) {
    Book book1 = new Book();
    Book book2 = new Book("Example", "Example2", 100);
	Book book3 = new Book();

	PrintedBook printed = new PrintedBook();
	PrintedBook printed2 = new PrintedBook("Example", "Example2", 100, CoverType.Softcover);
	
	EBook ebook2 = new EBook("Example1" , "Example2", 100, 200);
	System.out.println(isSameAuthor(book1, book2));
	System.out.println(isSameAuthor(printed, printed2));
	System.out.println(isSameAuthor(book1, book3));
	System.out.println(book2.createReference("article", 10, 20));
	System.out.println(ebook2.createReference("ebook article", "2020. 04. 20"));
	System.out.println(book2.toString());
	System.out.println(ebook2.toString());
	System.out.println(printed.toString());
	System.out.println(printed2.toString());
    System.out.println(book1.getShortName());
    System.out.println(book2.getShortName());
  }
}
