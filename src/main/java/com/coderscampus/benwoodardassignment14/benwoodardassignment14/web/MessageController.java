package com.coderscampus.benwoodardassignment14.benwoodardassignment14.web;

import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.Message;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.service.ChannelService;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MessageController {

    private final MessageService messageService;
    private final ChannelService channelService;

    public MessageController(MessageService messageService, ChannelService channelService) {
        this.messageService = messageService;
        this.channelService = channelService;
    }

    @PostMapping("message/create")
    public ResponseEntity createMessage(@RequestBody Message message) {
        System.out.println(message);
        messageService.save(message);
        if(message != null) {
            return new ResponseEntity(message, HttpStatus.OK);
        } else {
            return new ResponseEntity("Error in saving the message", HttpStatus.BAD_REQUEST);
        }
    }


}
