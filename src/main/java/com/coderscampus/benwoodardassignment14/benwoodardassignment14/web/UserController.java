package com.coderscampus.benwoodardassignment14.benwoodardassignment14.web;

import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.User;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.service.ChannelService;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public ModelAndView createUser(@RequestBody User user, RedirectAttributes redirectAttributes) {
        userService.save(user);
        userService.checkUserContainsGeneralChannel(user);
        redirectAttributes.addFlashAttribute("user", user);
        return new ModelAndView("redirect:/welcome");
    }


}
