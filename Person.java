package cmps252.oopreview;
public abstract class Person {
	private final int MONDAY = 1;
	
	private String firstName;
	public String getFirstName() {
		return firstName;
	}

	private String lastName;
	public String getLastName() {
		return lastName;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}

	@Override
	public String toString() {
		return getFullName();
	}

	public Person(String firstName, String lastName) throws Exception {
		Helpers.isNotNullEmptyOrWhitespace(lastName,"lastName");
		Helpers.isNotNullEmptyOrWhitespace(firstName,"firstName");
		this.firstName = firstName;
		this.lastName = lastName;
	}
}