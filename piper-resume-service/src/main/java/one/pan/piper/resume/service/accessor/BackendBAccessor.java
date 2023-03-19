package one.pan.piper.resume.service.accessor;

import one.pan.piper.resume.service.exception.BusinessException;
import org.springframework.stereotype.Component;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.vavr.control.Try;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

//TODO: Rename later
@Component(value = "backendBAccessor")
public class BackendBAccessor implements Accessor {

    private static final String BACKEND_B = "backendB";

    @Override
    public String failure() {
        throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "This is a remote exception");
    }

    @Override
    public String success() {
        return "Hello World from backend B";
    }

    @Override
    public String successException() {
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "This is a remote client exception");
    }

    @Override
    public String ignoreException() {
        throw new BusinessException("This exception is ignored by the CircuitBreaker of backend B");
    }

    @Override
    @Bulkhead(name = "backendB")
    public Flux<String> fluxFailure() {
        return Flux.error(new IOException("BAM!"));
    }

    @Override
    public Flux<String> fluxTimeout() {
        return Flux.just("Hello World from backend B")
                .delayElements(Duration.ofSeconds(10));
    }

    @Override
    public Mono<String> monoSuccess() {
        return Mono.just("Hello World from backend B");
    }

    @Override
    public Mono<String> monoFailure() {
        return Mono.error(new IOException("BAM!"));
    }

    @Override
    public Mono<String> monoTimeout() {
        return Mono.just("Hello World from backend B")
                .delayElement(Duration.ofSeconds(10));
    }

    @Override
    public Flux<String> fluxSuccess() {
        return Flux.just("Hello", "World");
    }

    @Override
    public CompletableFuture<String> futureSuccess() {
        return CompletableFuture.completedFuture("Hello World from backend B");
    }

    @Override
    public CompletableFuture<String> futureFailure() {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.completeExceptionally(new IOException("BAM!"));
        return future;
    }

    @Override
    public CompletableFuture<String> futureTimeout() {
        Try.run(() -> Thread.sleep(5000));
        return CompletableFuture.completedFuture("Hello World from backend A");
    }

    @Override
    public String failureWithFallback() {
        return Try.ofSupplier(this::failure).recover(this::fallback).get();
    }

    private String fallback(Throwable ex) {
        return "Recovered: " + ex.toString();
    }
}
