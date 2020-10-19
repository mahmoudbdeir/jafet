package cmps252.oopreview.unitTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cmps252.oopreview.*;

class StudentTester {

	private FulltimeStudent fts;
	private Book book;
	private BookCopy bookCopy;
	
	@BeforeEach
	void testInit() throws Exception {
		fts = new FulltimeStudent("Joe", "Smith");
		book = new Book("123456789", "Software Construction", "Bdeir");
		bookCopy = new BookCopy(book, "121212111", "has coffee spilled on page 237", true);
	}
	

	
	@Test
	void fullTimeStudentName() throws Exception {
		assertEquals("Joe Smith", fts.getFullName());
	}
	
	@Test
	void fullTimeStudentCredits() throws Exception {
		assertEquals(12, fts.getNumberOfCredits());
	}
	
	@Test
	void book() throws Exception {
		assertEquals("123456789", book.getIsbn());
		assertEquals("Software Construction", book.getTitle());
		assertEquals("Bdeir", book.getAuthor());
		assertEquals(0, book.getCopies().size());
	}
	
	@Test
	void bookCopy() throws Exception {
		assertEquals("123456789", bookCopy.getIsbn());
		assertEquals("Software Construction", bookCopy.getTitle());
		assertEquals("Bdeir", bookCopy.getAuthor());
		assertEquals("121212111", bookCopy.getBarCode());
		assertEquals("has coffee spilled on page 237", bookCopy.getComments());
		assertEquals(true, bookCopy.isAvailableOnShelf());
	}
	
	
	@Test
	@DisplayName("Does borrowing a book make the copy unavailable on shelves?")
	void borrowingABook_AvailableOnShelf() throws Exception {
		assertEquals(true, bookCopy.isAvailableOnShelf());
		fts.borrowBook(bookCopy);
		assertEquals(false, bookCopy.isAvailableOnShelf());
	}
	
	@Test
	@DisplayName("Does borrowing a book create a correct BorrowRecord?")
	void borrowingABook_borrowRecord() throws Exception {
		fts.borrowBook(bookCopy);
		assertEquals(1, bookCopy.getBorrowings().size());
		
		var record = bookCopy.getBorrowings().get(0);
		
//		private Borrower borrower;
//		private BookCopy bookCopy;
//		private LocalDateTime dateBorrowed;
//		private LocalDateTime dueDate;
//		private LocalDateTime returnedDate;
		
		assertEquals(LocalDateTime.now().getYear(), record.getDateBorrowed().getYear());
		assertEquals(LocalDateTime.now().getDayOfYear(), record.getDateBorrowed().getDayOfYear());
		
		assertEquals(LocalDateTime.now().plusDays(21).getDayOfYear(), record.getDueDate().getDayOfYear());
		assertNull(record.getReturnedDate());
	}
}