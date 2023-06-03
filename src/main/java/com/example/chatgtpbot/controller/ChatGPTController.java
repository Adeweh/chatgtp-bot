package com.example.chatgtpbot.controller;


import com.example.chatgtpbot.dto.request.ChatGPTRequest;
import com.example.chatgtpbot.dto.response.ChatGPTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/chat")
public class ChatGPTController {
    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.key}")
    private String apiURL;

    @Autowired
    private RestTemplate template;

    public ChatGPTResponse chat(@RequestParam("prompt") String prompt){
        ChatGPTRequest request = new ChatGPTRequest(model, prompt);

        ChatGPTResponse response = template.postForObject(apiURL, request, ChatGPTResponse.class);

        return response;

    }
}
