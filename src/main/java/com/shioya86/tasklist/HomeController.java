package com.shioya86.tasklist;

import ch.qos.logback.core.util.Loader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDateTime;

@Controller
public class HomeController {
    @RequestMapping("/hello")
    @ResponseBody
    String hello() {
        return """
                <html>
                    <head><title>Hello</title></head>
                    <body>
                        <h1>Hello</h1>
                        It works!<br>
                        現在時刻は%sです。
                    </body>
                </html>
               """.formatted(LocalDateTime.now());
    }
}
