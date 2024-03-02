package com.coderscampus.benwoodardassignment14.benwoodardassignment14.web;

import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.Message;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.service.ChannelService;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;
    private final ChannelService channelService;

    public MessageController(MessageService messageService, ChannelService channelService) {
        this.messageService = messageService;
        this.channelService = channelService;
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity createMessage(@RequestBody Message message) {
        messageService.save(message);
        if(message != null) {
            return new ResponseEntity(message, HttpStatus.OK);
        } else {
            return new ResponseEntity("Error in saving the message", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{channelName}")
    @ResponseBody
    public ResponseEntity getUpdatedMessages(@PathVariable String channelName) {
        if(channelService.findByChannelName(channelName) == null){
            return new ResponseEntity<>("MessageList is null", HttpStatus.BAD_REQUEST);
        } else {
            List<Message> messageList = channelService.findAllMessages(channelName);
            return new ResponseEntity(messageList, HttpStatus.OK);
        }




    }

}
