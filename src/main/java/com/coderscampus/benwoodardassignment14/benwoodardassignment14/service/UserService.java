package com.coderscampus.benwoodardassignment14.benwoodardassignment14.service;

import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.Channel;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.User;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        checkUserContainsGeneralChannel(user);
        return userRepo.save(user);
    }

    public User checkUserContainsGeneralChannel(User user) {
        if (channelService.findByChannelName("General") == null) {
            Channel channel = new Channel("General");
            channelService.save(channel);
            user.getChannels().add(channel);
            channel.getUsers().add(user);
        } else {
            addAllChannelsToNewUser(user);
        }
        return userRepo.save(user);
    }

    public void addAllChannelsToNewUser(User user) {
        channelService.findAll().stream()
                .forEach(channel -> {
                    user.getChannels().add(channel);
                    channel.getUsers().add(user);
                });
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(Long userId) {
        return userRepo.findById(userId).orElse(null);
    }

    public User findByName(String name) {
        return userRepo.findByName(name);
    }

    public void saveChannelToAllUsers(Channel newChannel) {
        findAll().stream()
                .forEach(user -> {
                    user.getChannels().add(newChannel);
                    newChannel.getUsers().add(user);
                    channelService.save(newChannel);
                    userRepo.save(user);
                });
    }
}
