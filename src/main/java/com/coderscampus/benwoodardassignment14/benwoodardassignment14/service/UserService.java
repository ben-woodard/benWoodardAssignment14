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

    public User checkForUserGeneralChannel(User user) {
        if(user.getChannels().contains("General")){
            return user;
        } else if(channelService.findByChannelName("General") == null){
            Channel channel =  new Channel();
            channel.setChannelName("General");
            user.getChannels().add(channel);
            channel.getUsers().add(user);
            channelService.save(channel);
            return userRepo.save(user);
        } else {
            Channel channel = channelService.findByChannelName("General");
            user.getChannels().add(channel);
            channel.getUsers().add(user);
            return user;
        }
    }

//    public User checkIfNewUser(User user) {
//        if(!userRepo.findById(user.getUserId()).isPresent()){
//            User newUser = new User();
//        }
//    }
}
