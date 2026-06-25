package com.github.ferigeek.sarv.controller;

import com.github.ferigeek.sarv.dto.response.UserSummaryResponse;
import com.github.ferigeek.sarv.dto.response.UserResponse;
import com.github.ferigeek.sarv.service.FollowerService;
import com.github.ferigeek.sarv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final FollowerService followerService;

    @Autowired
    public UserController(UserService userService,  FollowerService followerService) {
        this.userService = userService;
        this.followerService = followerService;
    }

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/{userId}/followers")
    public List<UserSummaryResponse> getFollowers(@PathVariable("userId") Long userId) {
        return followerService.getFollowers(userId);
    }

    @GetMapping("/{userId}/followings")
    public List<UserSummaryResponse> getFollowings(@PathVariable("userId") Long userId) {
        return followerService.getFollowings(userId);
    }
}
