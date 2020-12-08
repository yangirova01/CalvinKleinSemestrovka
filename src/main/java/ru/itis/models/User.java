package ru.itis.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class User {
    private Long id;
    private String phoneNumber;
    private String email;
    private String hashPassword;
    private String session;
}
