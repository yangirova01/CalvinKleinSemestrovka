package ru.itis.dto;

import lombok.*;

import java.util.Optional;
@Setter
@Getter
@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@NonNull
public class SessionDto {
    Long userId;
    String sessionId;
    public static SessionDto getFromOptional(Optional<SessionDto> optionalSessionDto)throws Exception{
        return optionalSessionDto.orElse(null);
    }
}
