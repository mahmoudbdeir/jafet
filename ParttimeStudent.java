package cmps252.oopreview;

public class ParttimeStudent extends Student implements Worker {

	public ParttimeStudent(String firstName, String lastName) throws Exception {
		super(firstName, lastName);
	}

	@Override
	public int getBorrowDays() {
		return 14;
	}

	@Override
	public String work() {
		return "Studying on a part-time basis";
	}

}
