package com.shioya86.tasklist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
public class HomeRestController {
    @RequestMapping("/resthello")
    String hello() {
        return """
                Hello.
                It worked!
                現在時刻は%sです。
                """.formatted(LocalDateTime.now());
    }

}
