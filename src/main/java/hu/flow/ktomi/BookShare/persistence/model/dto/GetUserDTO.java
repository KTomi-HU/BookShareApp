package hu.flow.ktomi.BookShare.persistence.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class GetUserDTO {

    private String email;
    private String userFirstName;
    private String userLastName;
}