package mk.ukim.finki.emt.eshop.model.dto;

import lombok.Data;
import mk.ukim.finki.emt.eshop.model.Role;
import mk.ukim.finki.emt.eshop.model.User;

@Data
public class UserDetailsDto {
    private String username;
    private Role role;

    public static UserDetailsDto of(User user){
        UserDetailsDto details = new UserDetailsDto();
        details.username = user.getUsername();
        details.role = user.getRole();
        return details;
    }
}
