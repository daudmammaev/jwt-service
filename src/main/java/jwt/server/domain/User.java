package jwt.server.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
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
