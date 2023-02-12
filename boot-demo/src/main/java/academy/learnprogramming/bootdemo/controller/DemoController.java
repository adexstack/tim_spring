package academy.learnprogramming.bootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    @ResponseBody
    @GetMapping("demo")
    public String demo() {
        log.info("demo method called");
        int mult = 2 * 10;
        return "Hello Spring Boot " + mult;
    }

    @GetMapping("welcome")
    public String welcome(Model model) {
        log.info("welcome method called");
        model.addAttribute("message", "welcome to Spring Boot");
        return "welcome";
    }
}
