import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class ReadFileApp {
    public static void main(final String[] args) {
        try {
            final URI txtFileUri = ReadFileApp.class.getClassLoader().getResource("hello.txt").toURI();
            final String content = Files.readString(Path.of(txtFileUri), Charset.defaultCharset());
            System.out.println(content);
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }
}