package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicioSeguroController {

    private static final String template = "El servicio está asegurado %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/servicioSeguro")
    public ServicioSeguro servicioSeguro(@RequestParam(value="nombre", defaultValue="!!") String name) {
        return new ServicioSeguro(counter.incrementAndGet(),
                            String.format(template, name));
    }
}