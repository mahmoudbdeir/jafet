package cmps252.oopreview;
import java.util.ArrayList;
import java.util.List;

public abstract class Student extends Person implements Borrower {

	private List<Course> courses;
	public List<Course> getCourses() {
		return courses;
	}
	public List<Course> getNumberOfCourses() {
		return courses;
	}

	protected int minCredits;
	public int getNumberOfCredits() {
		return minCredits;
	}

	public Student(String firstName, String lastName) throws Exception {
		super(firstName, lastName);
		courses = new ArrayList<Course>();
	}

	public void registerCourse(Course course) {
		courses.add(course);
	}

	@Override
	public String toString() {
		return String.format("%s\n\tMinimum Credits: %d\n\t%s", super.toString(), minCredits, courses);
	}

	public BorrowRecord borrowBook(BookCopy bookCopy) throws Exception { //convenience method
		return bookCopy.borrowBook(this);
	}
}