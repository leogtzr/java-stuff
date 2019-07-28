import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class AsynGetCall {
    public static void main(final String[] args) {

        final List<URI> uris = Stream.of(
            "https://www.google.com/",
            "https://www.github.com/",
            "https://www.ebay.com/"
            ).map(URI::create).collect(toList());

        final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .followRedirects(HttpClient.Redirect.ALWAYS)
            .build();

        final CompletableFuture[] futures = uris.stream()
            .map(uri -> verifyUri(httpClient, uri))
            .toArray(CompletableFuture[]::new)
            ;

        CompletableFuture.allOf(futures).join();

    }

    private static CompletableFuture<Void> verifyUri(final HttpClient httpClient, final URI uri) {
        final HttpRequest request = HttpRequest.newBuilder()
            .timeout(Duration.ofSeconds(5))
            .uri(uri)
            .build()
            ;

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::statusCode)
            .thenApply(statusCOde -> statusCOde == 200)
            .exceptionally(__ -> false)
            .thenAccept(valid -> {
                if (valid) {
                    System.out.println("[SUCCESS] Verified " + uri);
                } else {
                    System.out.println("[FAILURE] Could not verify " + uri);
                }
            });
    }

}