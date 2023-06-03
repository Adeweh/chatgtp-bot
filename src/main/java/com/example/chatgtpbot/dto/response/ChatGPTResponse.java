package com.example.chatgtpbot.dto.response;


import com.example.chatgtpbot.model.Choice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatGPTResponse {
    private List<Choice> choice;
}
