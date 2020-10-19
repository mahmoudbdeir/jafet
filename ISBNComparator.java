package cmps252.oopreview;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class ISBNComparator implements Comparator<Map.Entry<String,Book>> {
	@Override
	public int compare(Entry<String, Book> o1, Entry<String, Book> o2) {
		return o1.getValue().getIsbn().compareTo(o2.getValue().getIsbn());
	}
}