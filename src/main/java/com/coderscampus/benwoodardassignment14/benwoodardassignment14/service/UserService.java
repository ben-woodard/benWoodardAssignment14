package com.coderscampus.benwoodardassignment14.benwoodardassignment14.service;

import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.Channel;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.User;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final ChannelService channelService;

    @Autowired
    public UserService(UserRepository userRepo, ChannelService channelService) {
        this.userRepo = userRepo;
        this.channelService = channelService;
    }


    public User save(User user) {
        return userRepo.save(user);
    }

    public User checkUserContainsGeneralChannel(User user) {
      if(channelService.findByChannelName("General") == null){
            Channel channel =  new Channel();
            channel.setChannelName("General");
            channelService.save(channel);
            user.getChannels().add(channel);
            channel.getUsers().add(user);
            userRepo.save(user);
        } else if(!(user.getChannels()).contains(channelService.findByChannelName("General"))) {
            Channel channel = channelService.findByChannelName("General");
            user.getChannels().add(channel);
            channel.getUsers().add(user);
        }
      return user;
    }

    public User findById(Long userId) {
        return userRepo.findById(userId).orElse(null);
    }
}
