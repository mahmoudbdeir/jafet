package cmps252.oopreview;

public interface Borrower {
	public BorrowRecord borrowBook(BookCopy bookCopy) throws Exception;
	public int getBorrowDays();
}
