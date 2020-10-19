package cmps252.oopreview;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Library {
	private Map<String, Book> map;
	
	@Override
	public String toString() {
		return "Library [name=" + name + ", hours=" + hours + ", books=" + books + "]";
	}
	
	private String name;
	public String getName() {
		return name;
	}
	
	private String hours;
	public String getHours() {
		return hours;
	}
	
	private List<Book> books;
	public List<Book> getBooks() {
		return books;
	}
	public Library(String name, String hours) {
		this.name = name;
		this.hours = hours;
		
		this.books = new ArrayList<Book>();
		this.map = new TreeMap<String,Book>();
		
	}
	
	public void addBook(Book book) {
		this.books.add(book);
		this.map.put(book.getIsbn(), book);
	}
	
	public Book addBook(String isbn, String title, String author) throws Exception {
		Book b = new Book(isbn,title,author);
		addBook(b);//this is better than the line below
		return b;
//		this.books.add(new Book(isbn,title,author));
	}
	
	public boolean isBookAvailable(String isbn) {
//		for(Book b : books) {
//			if(b.getIsbn()==isbn) {
//				return true;
//			}
//		}
//		return false;
		return map.containsKey(isbn);
	}
	
	public int getNumberOfCopies(String isbn) {
//		for(Book b : books) {
//			if(b.getIsbn()==isbn) {
//				return b.getCopies().size();
//			}
//		}
//		return 0;
		if(map.containsKey(isbn)) {
			var book = map.get(isbn);
			return book.getCopies().size();
		}
		return 0;
	}
	
	public BorrowRecord borrowBook(Borrower borrower, BookCopy bookCopy) throws Exception {
		return bookCopy.borrowBook(borrower);
	}
	
	public void returnBook(Borrower borrower, BookCopy bookCopy) {
		for(var b : bookCopy.getBorrowings()) {
			if(b.getReturnedDate()==null) {
				if(b.getBorrower()==borrower) {
					b.setReturnedDate(LocalDateTime.now());
					bookCopy.returnBookCopy();
				}
			}
		}
	}
}
