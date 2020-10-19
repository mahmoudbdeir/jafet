package cmps252.oopreview;
import java.time.LocalDateTime;

public class BorrowRecord {
	
	private Borrower borrower;
	public Borrower getBorrower() {
		return borrower;
	}
	
	private BookCopy bookCopy;
	public BookCopy getBookCopy() {
		return bookCopy;
	}
	
	private LocalDateTime dateBorrowed;
	public LocalDateTime getDateBorrowed() {
		return dateBorrowed;
	}
	
	private LocalDateTime dueDate;
	public LocalDateTime getDueDate() {
		return dueDate;
	}
	
	private LocalDateTime returnedDate;
	public void setReturnedDate(LocalDateTime date) {
		this.returnedDate=date;
	}
	public LocalDateTime getReturnedDate() {
		return returnedDate;
	}
	
	public BorrowRecord(Borrower borrower, BookCopy bookCopy, LocalDateTime dateBorrowed, LocalDateTime dueDate, LocalDateTime returnedDate) throws Exception {
		if(borrower==null || bookCopy==null) {
			throw new Exception();
		}
		this.borrower = borrower;
		this.bookCopy = bookCopy;
		this.dateBorrowed = dateBorrowed;
		this.dueDate = dueDate;
		this.returnedDate = returnedDate;
	}
	
	@Override
	public String toString() {
		return "BorrowRecord [borrower=" + borrower + ", bookCopy=" + bookCopy + ", dateBorrowed=" + dateBorrowed
				+ ", dueDate=" + dueDate + ", returnedDate=" + returnedDate + "]";
	}
}