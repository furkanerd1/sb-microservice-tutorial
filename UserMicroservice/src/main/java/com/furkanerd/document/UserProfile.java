package com.furkanerd.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserProfile {

    @Id
     String id;
     Long authId;
     String userName;
     String name;
     String surName;
     String email;
     String phone;
     String avatar;
     String insta;
     String twitter;
     String isActive;
     Long createdAt;
}
