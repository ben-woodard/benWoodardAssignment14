package com.coderscampus.benwoodardassignment14.benwoodardassignment14.web;

import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.Channel;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.service.ChannelService;
import com.coderscampus.benwoodardassignment14.benwoodardassignment14.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ChannelController {

    private final ChannelService channelService;
    private final UserService userService;

    @Autowired
    public ChannelController(ChannelService channelService, UserService userService) {
        this.channelService = channelService;
        this.userService = userService;
    }

    @GetMapping("")
    public String redirectToWelcomePage() {
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String getWelcomePage(ModelMap modelMap)  {
        if(!channelService.findAll().isEmpty()){
            List<Channel> channels = channelService.findAll();
            modelMap.put("channels", channels);
        }
        return "welcome";
    }

    @GetMapping("channels/{channelId}")
    public String getChannel(@PathVariable Long channelId, ModelMap model) {
        if (channelService.findById(channelId) == null) {
            return "redirect:/welcome";
        } else {
            Channel channel = channelService.findById(channelId);
            model.put("channel", channel);
            return "messages";
        }
    }

    @PostMapping("/channels/create")
    @ResponseBody
    public ResponseEntity createNewChannel(@RequestBody Channel channel) {
        Channel newChannel = channelService.save(channel);
        userService.saveChannelToAllUsers(newChannel);
        return new ResponseEntity<>(channel, HttpStatus.OK);
    }

}
