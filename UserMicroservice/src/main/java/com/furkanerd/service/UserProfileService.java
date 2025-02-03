package com.furkanerd.service;

import com.furkanerd.document.UserProfile;
import com.furkanerd.dto.request.CreateUserRequestDto;
import com.furkanerd.repository.UserProfileRepository;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final CacheManager cacheManager;

    public UserProfileService(UserProfileRepository userProfileRepository, CacheManager cacheManager) {
        this.userProfileRepository = userProfileRepository;
        this.cacheManager = cacheManager;
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

    //for redis
    @Cacheable("upper-case")
    public String upperName(String name) {
        String result= name.toUpperCase();
        try{
            Thread.sleep(3000L);
        }catch(Exception e){}
        return result;
    }

    public void clearCache(){
        Objects.requireNonNull(cacheManager.getCache("upper-case")).clear();
    }
}
