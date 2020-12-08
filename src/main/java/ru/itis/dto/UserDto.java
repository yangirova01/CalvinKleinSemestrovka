package ru.itis.dto;
import lombok.*;
import ru.itis.models.User;
import java.util.Optional;
@Setter
@Getter
@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@NonNull
public class UserDto {
    private Long id;
    private String email;
    public static UserDto from(User user){
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
    public  static UserDto fromOptional(Optional<UserDto> optionalUserDto){
        return optionalUserDto.orElse(null);
    }
    public static User userFromOptional(Optional<User> optionalUser){
        return optionalUser.orElse(null);
    }
}
