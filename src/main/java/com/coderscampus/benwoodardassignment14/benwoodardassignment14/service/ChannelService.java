package com.coderscampus.benwoodardassignment14.benwoodardassignment14.service;

import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.Channel;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.User;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelService {

    private final ChannelRepository channelRepo;


    @Autowired
    public ChannelService(ChannelRepository channelRepo) {
        this.channelRepo = channelRepo;
    }

    public Boolean checkForGeneralChannel(User user) {
        if(user.getChannels().contains("General")){
            return true;
        }
        return false;
    }

    public Channel save(Channel channel) {
        return channelRepo.save(channel);
    }

    public Channel findById(Long channelId) {
        return channelRepo.findById(channelId).orElse(null);
    }

//    public User createUserGeneralChannel(User user) {
//        Channel channel = new Channel();
//        channel.setChannelName("General");
//        user.getChannels().add(channel);
//        channel.getUsers().add(user);
//        channelRepo.save(channel);
//    }

    public Channel findByChannelName(String channelName) {
        return channelRepo.findByChannelName(channelName).orElse(null);
    }
}
