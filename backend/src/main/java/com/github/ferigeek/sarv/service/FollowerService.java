package com.github.ferigeek.sarv.service;

import com.github.ferigeek.sarv.dto.response.UserSummaryResponse;
import com.github.ferigeek.sarv.entity.Follow;
import com.github.ferigeek.sarv.entity.User;
import com.github.ferigeek.sarv.repository.FollowRepository;
import com.github.ferigeek.sarv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowerService {

    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    @Autowired
    public FollowerService(UserRepository userRepository, FollowRepository followRepository) {
        this.userRepository = userRepository;
        this.followRepository = followRepository;
    }

    public List<UserSummaryResponse> getFollowers(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        List<Follow> follows = followRepository.findByFollowed(user);

        return follows.stream()
                .map(Follow::getFollower)
                .map(UserSummaryResponse::new)
                .toList();
    }

    public List<UserSummaryResponse> getFollowings(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        List<Follow> follows = followRepository.findByFollower(user);

        return follows.stream()
                .map(Follow::getFollowed)
                .map(UserSummaryResponse::new)
                .toList();
    }
}
