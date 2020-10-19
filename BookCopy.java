package cmps252.oopreview;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.PI;

public class BookCopy extends Book {

	public BookCopy(String isbn, String title, String author, String barCode, String comment, boolean availableOnShelf)
			throws Exception {
		super(isbn, title, author);

		Helpers.isNotNullEmptyOrWhitespace(barCode, "barCode");
		Helpers.isNotNullEmptyOrWhitespace(comment, "comment");
		
		this.barCode = barCode;
		this.comments = "محمود";// comment;
		this.availableOnShelf = availableOnShelf;

		this.borrowings = new ArrayList<BorrowRecord>();
	}

	public BookCopy(Book book, String barCode, String comment, boolean availableOnShelf) throws Exception {
		this(book.getIsbn(), book.getTitle(), book.getAuthor(), barCode, comment, availableOnShelf);
	}

	private String barCode;

	public String getBarCode() {
		return barCode;
	}

	private String comments;

	public String getComments() {
		return comments;
	}

	private boolean availableOnShelf;

	public boolean isAvailableOnShelf() {
		return availableOnShelf;
	}

	public void returnBookCopy() {
		this.availableOnShelf = true;
	}

	private List<BorrowRecord> borrowings;

	public List<BorrowRecord> getBorrowings() {
		return borrowings;
	}

	@Override
	public String toString() {
		return "BookCopy [barCode=" + barCode + ", comments=" + comments + ", availableOnShelf=" + availableOnShelf
				+ ", borrowings=" + borrowings + "]";
	}

	public BorrowRecord borrowBook(Borrower borrower) throws Exception {
		if (isAvailableOnShelf()) {

			availableOnShelf = false;
			var now = LocalDateTime.now();
			var b = new BorrowRecord(borrower, this, now, now.plusDays(borrower.getBorrowDays()), null);
			this.borrowings.add(b);
			return b;
		}
		return null;
	}

}
