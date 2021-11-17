package reactor.context;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import reactor.core.publisher.Mono;

@Controller
public class TestController {

    @Get
    Mono<String> test() {
        return Mono.deferContextual(ctx -> {
            System.out.println(ctx.get("from-filter").toString());
            return Mono.just("hi");
        });
    }
}
