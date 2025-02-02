package com.furkanerd.service;

import com.furkanerd.document.UserProfile;
import com.furkanerd.dto.request.CreateUserRequestDto;
import com.furkanerd.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public void createUser(CreateUserRequestDto request) {
        userProfileRepository.save(UserProfile.builder()
                .authId(request.authId())
                .userName(request.userName())
                .email(request.email())
                .build());
    }

    public List<UserProfile> getAll() {
        return userProfileRepository.findAll();
    }
}
