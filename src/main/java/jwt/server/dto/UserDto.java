package jwt.server.dto;

import jwt.server.domain.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;
@Getter
@Setter
public class UserDto {
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    private String name;
    private String surname;
    private String patronymic;
    private String group;
    private int middleScore;
    private Set<Role> roles;
}
