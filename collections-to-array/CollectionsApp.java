import java.util.List;

public class CollectionsApp {
	public static void main(final String[] args) {
		final List<String> names = List.of("Leo", "Brenda", "Karla", "Juan", "Enrice");
		System.out.println(names);

		final String[] namesArray = names.toArray(String[]::new);
		System.out.println(namesArray);

	}
}
