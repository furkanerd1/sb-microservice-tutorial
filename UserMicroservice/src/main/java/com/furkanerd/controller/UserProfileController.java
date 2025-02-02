package com.furkanerd.controller;

import com.furkanerd.dto.request.CreateUserRequestDto;
import com.furkanerd.service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.furkanerd.config.RestApis.*;

@RestController
@RequestMapping(USERPROFILE)
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping(CREATEUSER)
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto request){
        userProfileService.createUser(request);
        return ResponseEntity.ok(true);
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(userProfileService.getAll());
    }
}
