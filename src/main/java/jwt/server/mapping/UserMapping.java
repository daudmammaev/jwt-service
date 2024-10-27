package jwt.server.mapping;

import jwt.server.domain.User;
import jwt.server.dto.UserDto;

public class UserMapping {
    public static User UserDtoToUser(UserDto userDto){
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setRoles(userDto.getRoles());
        user.setName(userDto.getName());
        user.setGroup(userDto.getGroup());
        user.setPatronymic(user.getPatronymic());
        user.setSurname(userDto.getSurname());
        user.setMiddleScore(userDto.getMiddleScore());
        return user;
    }
}
