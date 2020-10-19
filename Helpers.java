package cmps252.oopreview;

public class Helpers {
	public static void isNotNullEmptyOrWhitespace(String s, String varName) throws Exception {
		if(s.isBlank() || s.isEmpty())
			throw new Exception(varName + " cannot be null!");
	}
	public static int Counter = 0;
}
