package auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HomeController {

    @GetMapping
    public String home (@RequestParam(name="name", required = false, defaultValue = "Dude") String name,
                        Map<String, Object> model)
    {
        model.put("name", name);
        return "home";
    }
}
