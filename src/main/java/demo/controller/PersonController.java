package demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@CrossOrigin
@RestController
public class PersonController {
	
	@Value("${value: Default Client Value}")
	private String value;

    
    
	@GetMapping("/client")
    public String client()
    {
        return "this is the client";
    }
}

