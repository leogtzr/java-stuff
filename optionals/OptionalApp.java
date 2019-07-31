import java.util.Optional;

public class OptionalApp {
    public static void main(final String[] args) {
        final String text = "Leo";
        Optional.ofNullable(text).ifPresentOrElse(val -> {
            System.out.println("This value is ... " + val);
        }, () -> {
            System.out.println(":(");
        });
    }
}