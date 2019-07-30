public class StringStripApp {
    public static void main(final String[] args) {
        final String nameFormField = "      Java Duke     ";
        System.out.printf("[%s]\n", nameFormField.strip());
        System.out.printf("[%s]\n", nameFormField.stripLeading());
        System.out.printf("[%s]\n", nameFormField.stripTrailing());
    }
}