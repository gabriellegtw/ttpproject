package com.example.ttpproject.controller;
import com.example.ttpproject.model.ChatResponse;
import com.example.ttpproject.service.GenerationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Method (e.g., post, get) is not needed here as it is just a generic request
@RequestMapping("/profile")
public class ProfileController {

    // Dependency injection
    private final GenerationService generationService;

    // There would be an @Autowired here under the hood
    // @Autowired marks a constructor, field, or setter method
    // to indicate Spring should automatically inject a dependency
    public ProfileController(GenerationService generationService) {
        this.generationService = generationService;
    }

    // PostMapping is a less verbose way of writing @RequestMapping(value = "/generate", method = RequestMethod.POST)
    // TODO: In future, we need to save the details to DB
    @PostMapping("/generate")
    public ChatResponse generate(@RequestBody String message) {
        // @ RequestBody tells Spring Boot to get the argument from the JSON sent by client
        return new ChatResponse(this.generationService.generatePath(message));
    }
}
