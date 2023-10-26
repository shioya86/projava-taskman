package com.shioya86.tasklist;

import ch.qos.logback.core.util.Loader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDateTime;

@Controller
public class HomeController {
    @RequestMapping("/hello")
    String hello(Model model) {
        model.addAttribute("time", LocalDateTime.now());
        return "hello";
    }
}
