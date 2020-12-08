package ru.itis.dto;
import lombok.*;
@Setter
@Getter
@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@NonNull
public class UserForm {
    private String phoneNumber;
    private String email;
    private String password;
}