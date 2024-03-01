package com.coderscampus.benwoodardassignment14.benwoodardassignment14.service;

import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.Channel;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.Message;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChannelService {

    private final ChannelRepository channelRepo;
    @Autowired
    public ChannelService(ChannelRepository channelRepo) {
        this.channelRepo = channelRepo;
    }

    public Channel save(Channel channel) {
        return channelRepo.save(channel);
    }

    public Channel findById(Long channelId) {
        return channelRepo.findById(channelId).orElse(null);
    }

    public Channel findByChannelName(String channelName) {
        return channelRepo.findByChannelName(channelName).orElse(null);
    }

    public List<Channel> findAll() {
       return channelRepo.findAll();
    }

    public List<Message> findAllMessages(String channelName) {
        Channel channel = findByChannelName(channelName);
        return channel.getMessages();
    }
}
