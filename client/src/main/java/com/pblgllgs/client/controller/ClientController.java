package com.pblgllgs.client.controller;

import com.pblgllgs.client.models.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/*
 *
 * @author pblgl
 * Created on 29-01-2024
 *
 */
@RestController
public class ClientController {

    public static final Logger log = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("/read")
    public List<Message> read(){
        return Collections.singletonList(new Message("READ_OPERATION"));
    }

    @PostMapping("/write")
    public Message write(@RequestBody Message message){
        log.info("The message is: "+message.getText());
        return message;
    }

    @GetMapping("/authorized")
    public Map<String,String> authorized(@RequestParam String code){
        return Collections.singletonMap("code",code);
    }
}
