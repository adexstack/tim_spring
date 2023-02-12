package academy.learnprogramming.bbbms.controller;

import academy.learnprogramming.bbbms.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class DemoController {
    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("demo")
    public String demo(Model model) {
        log.info("Getting attribute from DemoController Class");
        model.addAttribute("message", demoService.getMessage());
        return "demo/demo";
    }
}
