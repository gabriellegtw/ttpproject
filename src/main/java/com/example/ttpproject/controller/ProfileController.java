package com.example.ttpproject.controller;
import com.example.ttpproject.model.ChatResponse;
import com.example.ttpproject.model.Roadmap;
import com.example.ttpproject.model.Task;
import com.example.ttpproject.model.User;
import com.example.ttpproject.repository.UserRepository;
import com.example.ttpproject.service.GenerationService;
import com.example.ttpproject.service.RoadmapService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
// Method (e.g., post, get) is not needed here as it is just a generic request
@RequestMapping("/profile")
public class ProfileController {

    // Dependency injection
    private final GenerationService generationService;
    private final RoadmapService roadmapService;
    private final UserRepository userRepository;

    // There would be an @Autowired here under the hood
    // @Autowired marks a constructor, field, or setter method
    // to indicate Spring should automatically inject a dependency
    // Have to add @Qualifier here if there are more than one class that uses the GenerationService interface
    public ProfileController(GenerationService generationService, RoadmapService roadmapService, UserRepository userRepository) {
        this.generationService = generationService;
        this.roadmapService = roadmapService;
        this.userRepository = userRepository;
    }

    // PostMapping is a less verbose way of writing @RequestMapping(value = "/generate", method = RequestMethod.POST)
    @PostMapping("/generate")
    public ChatResponse generate(@RequestBody String userDetailsJson) {

        // @ RequestBody tells Spring Boot to get the argument from the JSON sent by the client
        LocalDate today = LocalDate.now();

        String fullPrompt = String.format("""
                You are an expert tech career coach.
                
                Today's date is %s.
                
                Given the following user information: %s
                
                Generate a personalized learning plan as a list of tasks. Each task should have the following fields:
                - title: a clear, concise name of the task
                - skill: the primary skill or topic this task focuses on (Keep it to one per task)
                - endDate: the date the user should complete this task (ISO format YYYY-MM-DD)
                - isCompleted: false (this is a boolean that will always be set to false)
                
                For the skill, please ensure that you cap it to a few different skills across all tasks
                so that users can easily track how well they are keeping up with a specific skill.
                
                Space out tasks realistically according to the user's available learning time per week.
                
                Return the entire response only in JSON format as a list of task objects, like below,
                and do not include any additional text:
                
                [
                  {
                    "title": "string",
                    "skill": "string",
                    "endDate": "YYYY-MM-DD",
                    "isCompleted": "false"
                  }
                ]
                """, today, userDetailsJson);
        String rawResponse = this.generationService.generatePath(fullPrompt);

        // This is to clean up the answer that the API returned
        String cleanJson = rawResponse
                .replaceAll("(?s)```json\\s*", "")
                .replaceAll("(?s)```", "")
                .trim();
        System.out.println(cleanJson);
        ObjectMapper mapper = new ObjectMapper();
        List<Task> tasks;
        try {
            tasks = mapper.readValue(cleanJson, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        // TODO: When database is connected, actual details need to be added
        Roadmap generatedRoadmap = new Roadmap(tasks);
        User currentUser = new User(null, null, null, null, null, null);
        currentUser.setRoadmap(generatedRoadmap);

        // Share this roadmap with the rest of the app
        roadmapService.setRoadmap(generatedRoadmap);

        // Wrap in ChatResponse so that it returns in a nice JSON format to the frontend
        return new ChatResponse(cleanJson);
    }
}
