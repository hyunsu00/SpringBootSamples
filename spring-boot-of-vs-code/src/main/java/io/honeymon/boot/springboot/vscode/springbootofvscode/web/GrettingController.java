package io.honeymon.boot.springboot.vscode.springbootofvscode.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * GrettingController
 */
@RestController
public class GrettingController {

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello, world";
    }
    
}
