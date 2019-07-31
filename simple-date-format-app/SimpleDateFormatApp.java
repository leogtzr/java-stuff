import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.text.ParseException;;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;

public class SimpleDateFormatApp {

    private static final DateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final ThreadLocal<DateFormat> SIMPLE_DATE_FORMAT_LOCAL = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // public static final ThreadLocal SIMPLE_DATE_FORMAT = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static Date parse(final String target) {
        return Date.from(LocalDate.parse(target, DATE_TIME_FORMATTER).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        // try {
            
        //     // return SIMPLE_DATE_FORMAT.parse(target);
        //     // return SIMPLE_DATE_FORMAT_LOCAL.get().parse(target);
        // } catch (final ParseException ex) {
        //     ex.printStackTrace();
        // }
        // return null;
    }

    public static void main(final String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        final String source = "2019-01-11";
        System.out.println("Parsing date string ...");

        IntStream.rangeClosed(0, 20)
            .forEach(i -> executorService.submit(() -> System.out.println(parse(source))));

            executorService.shutdown();

    }
}