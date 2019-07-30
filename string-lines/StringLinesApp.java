import java.util.List;
import java.util.stream.Collectors;

public class StringLinesApp {
    public static void main(final String[] args) {
        final String str = "Leo\nGutierrez\nRamirez";
        final List<String> lines = str.lines().collect(Collectors.toList());
        lines.forEach(System.out::println);
    }
}