package cmps252.oopreview.unitTesting;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cmps252.oopreview.Book;
import cmps252.oopreview.BookCopy;
import cmps252.oopreview.Borrower;
import cmps252.oopreview.FulltimeStudent;
import cmps252.oopreview.Library;

class LibraryTests {

	private Library jafet;
	private Book book;
	private BookCopy bookCopy;
	private Borrower borrower;
	
	@BeforeEach
	void testInit() throws Exception {
		jafet = new Library("Jafet", "Everyday 8:00 AM - 11:59 PM");
		book = jafet.addBook("123456789", "Software Construction", "Bdeir");
		bookCopy = book.addCopy("12112111", "has coffee spilled on page 237");
		borrower = new FulltimeStudent("Joe", "Smith");
	}
	
	@Test
	void basicLibrary() {
		assertEquals("Jafet",jafet.getName());
		assertEquals("Everyday 8:00 AM - 11:59 PM",jafet.getHours());
		assertEquals(1, jafet.getBooks().size());
	}
	
	

	@Test
	@DisplayName("The library has one copy of the only book it has")
	void bookCopies() {
		assertEquals(1,jafet.getBooks().get(0).getCopies().size());
	}

	@Test
	void isBookAvailable() {
		assertEquals(true,jafet.isBookAvailable("123456789"));
	}
	
	@Test
	void getNumberOfCopiesByIsbn() {
		assertEquals(1,jafet.getNumberOfCopies("123456789"));
	}
	
//	@Test
//	void borrowBook() {
//		assertEquals(true,bookCopy.isAvailableOnShelf());
//		jafet.borrowBook(borrower, bookCopy);
//		assertEquals(false,bookCopy.isAvailableOnShelf());
//	}
	@Test
	void returnBook() throws Exception {
		assertEquals(true,bookCopy.isAvailableOnShelf());
		jafet.borrowBook(borrower, bookCopy);
		assertEquals(false,bookCopy.isAvailableOnShelf());
		jafet.returnBook(borrower, bookCopy);
		assertEquals(true,bookCopy.isAvailableOnShelf());
	}
}
