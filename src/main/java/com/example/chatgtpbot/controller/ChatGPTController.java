package com.example.chatgtpbot.controller;


import com.example.chatgtpbot.dto.request.ChatGPTRequest;
import com.example.chatgtpbot.dto.response.ChatGPTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bot")
public class ChatGPTController {
    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.key}")
    private String apiURL;

    @Autowired
    private RestTemplate template;

    @GetMapping("/chat")

    public ChatGPTResponse chat(@RequestParam("prompt") String prompt){
        ChatGPTRequest request = new ChatGPTRequest(model, prompt);

        return template.postForObject(apiURL, request, ChatGPTResponse.class);

    }

    @GetMapping("/message")
    public String getMessage(@RequestParam("prompt") String prompt){
        ChatGPTRequest request = new ChatGPTRequest(model, prompt);

        ChatGPTResponse chatGPTResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);

        return chatGPTResponse.getChoice().get(0).getMessage().getContent();

    }
}
