package com.mhalab.eve.controller;

import com.mhalab.eve.model.nlp.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("nlp")
public class NaturalLanguageController {
    @PostMapping("parse")
    public Message parse(@RequestBody Message input) {
        Message output = new Message("Usłyszałam \"" + input.getMessage() + "\"");
        return output;
    }

    @PostMapping("echo")
    public String echo(@RequestBody String input) {
        return input;
    }
}
