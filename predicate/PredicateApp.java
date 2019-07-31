import java.util.List;
import java.util.function.Predicate;

// import javax.validation.constraints.NotNull;

public class PredicateApp {
    public static void main(final String[] args) {
        final List<String> months = List.of("January", "February", "March");

        months.stream().filter(Predicate.not(m -> m.startsWith("M")))
            .forEach(System.out::println);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~>");

        months
            .stream()
            .filter((final var x) -> x.startsWith("M"))
            .forEach(System.out::println);

    }
}