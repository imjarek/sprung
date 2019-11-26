package auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class StatusController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/status")
    public Status status(@RequestParam(value="name", defaultValue="World") String name) {
        return new Status(counter.incrementAndGet(),
                String.format(template, name));
    }
}