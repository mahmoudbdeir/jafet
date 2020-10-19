package cmps252.oopreview;

public class Professor extends Person implements Worker, Researcher {

	public Professor(String firstName, String lastName) throws Exception {
		super(firstName, lastName);
	}

	@Override
	public String Reserach() {
		return "Leading the research";
	}

	@Override
	public String work() {
		return "Teaching";
	}

}
