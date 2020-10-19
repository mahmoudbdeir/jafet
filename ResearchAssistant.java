package cmps252.oopreview;

public class ResearchAssistant extends FulltimeStudent implements Researcher {

	public ResearchAssistant(String firstName, String lastName) throws Exception {
		super(firstName, lastName);
	}

	@Override
	public String Reserach() {
		return "Participating in research";
	}

}
