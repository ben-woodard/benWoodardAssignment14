package com.coderscampus.benwoodardassignment14.benwoodardassignment14.web;

import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.User;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.service.ChannelService;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    private final UserService userService;
    private final ChannelService channelService;
    @Autowired
    public UserController(UserService userService, ChannelService channelService) {
        this.userService = userService;
        this.channelService = channelService;
    }

    @PostMapping("/user/create")
    @ResponseBody
    public ResponseEntity createUser(@RequestBody User user)  {
        userService.save(user);
        userService.checkUserContainsGeneralChannel(user);
        if(userService.findById(user.getUserId()).equals(user)) {
            return new ResponseEntity(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error in saving the user", HttpStatus.BAD_REQUEST);
        }

    }

}
