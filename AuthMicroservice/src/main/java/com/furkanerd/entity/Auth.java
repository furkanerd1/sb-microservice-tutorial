package com.furkanerd.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_auth")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String userName;

    String password;

    String email;

    Boolean isActive;

    Long createdAt;

}
