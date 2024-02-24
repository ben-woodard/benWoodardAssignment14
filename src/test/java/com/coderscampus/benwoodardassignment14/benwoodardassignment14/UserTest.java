package com.coderscampus.benwoodardassignment14.benwoodardassignment14;

import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.Channel;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.User;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.repository.UserRepository;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserTest {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserTest(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Test
    public void saveOneUser(){
        User user = new User();
        userService.save(user);
        assert(userRepository.findById(user.getUserId()).isPresent());
    }

    @Test
    public void saveOneUserName() {
        User user = new User();
        user.setName("John");
        assert (user.getName() == "John");
    }

    @Test
    public void addOneChanneltoOneUser() {
        User user = new User();
        Channel channel = new Channel();
        user.getChannels().add(channel);
        userService.save(user);
        channel.getUsers().add(user);
        assert(channel.getUsers().contains(user) && user.getChannels().contains(channel));
    }
}
