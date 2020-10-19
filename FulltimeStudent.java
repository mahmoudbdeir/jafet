package cmps252.oopreview;

public class FulltimeStudent extends Student {

	public FulltimeStudent(String firstName, String lastName, int minCredits) throws Exception {
		super(firstName, lastName);
		super.minCredits = minCredits;
	}
	
	public FulltimeStudent(String firstName, String lastName) throws Exception {
		this(firstName, lastName, 12);
	}
	

	@Override
	public int getBorrowDays() {
		return 21;
	}

}
