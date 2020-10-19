package cmps252.oopreview;
import java.util.ArrayList;
import java.util.List;

public class Course {
	private String subject;
	public String getSubject() {
		return subject;
	}

	private String number;
	public String getNumber() {
		return number;
	}

	private int credits;
	public int getCredits() {
		return credits;
	}

	private List<Student> registeredStudents;
	public List<Student> getRegisteredStudents() {
		return registeredStudents;
	}
	
	public int getNumberOfRegisteredStudents() {
		return registeredStudents.size();
	}
	
	public Course(String subject, String number, int credits) throws Exception {
		Helpers.isNotNullEmptyOrWhitespace(subject, "subject");
		Helpers.isNotNullEmptyOrWhitespace(number, "number");
		
		this.subject = subject;
		this.number = number;
		this.credits = credits;
		
		this.registeredStudents = new ArrayList<Student>();
	}
	
	@Override
	public String toString() {
		return "Course [subject=" + subject + ", number=" + number + ", credits=" + credits + ", registeredStudents="
				+ registeredStudents + "]";
	}
}