package com.coderscampus.benwoodardassignment14.benwoodardassignment14.service;

import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.Channel;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.Message;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.User;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final ChannelService channelService;
    private final MessageRepository messageRepo;
    private final UserService userService;

    @Autowired
    public MessageService(ChannelService channelService, MessageRepository messageRepo, UserService userService) {
        this.channelService = channelService;
        this.messageRepo = messageRepo;
        this.userService = userService;
    }

    public Message save(Message message) {
        User dbUser = userService.findByName(message.getUser().getName());
        message.setUser(dbUser);
        Channel dbChannel = channelService.findByChannelName(message.getChannel().getChannelName());
        message.setChannel(dbChannel);
        messageRepo.save(message);
        dbUser.getMessages().add(message);
        dbChannel.getMessages().add(message);
        return message;
    }

}
