package hu.flow.ktomi.BookShare.persistence.model.dto;

import hu.flow.ktomi.BookShare.persistence.model.Role;
import hu.flow.ktomi.BookShare.persistence.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterDTO {

    private Long id;
    private String userName;
    private String password;
    private String email;
    private String userFirstName;
    private String userLastName;
    private LocalDate birthDate;
    private Role role;

    public static UserRegisterDTO fromUser(User user) {
        return new UserRegisterDTO(
                user.getId(), user.getUserFirstName(), user.getUserLastName(), user.getUsername(), user.getPassword(), user.getEmail(), user.getBirthDate(), user.getRole());
    }
}