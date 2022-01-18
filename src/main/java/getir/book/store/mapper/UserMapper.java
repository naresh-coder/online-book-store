package getir.book.store.mapper;

import getir.book.store.dto.UserPrincipal;
import getir.book.store.entities.Customer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class UserMapper {
    public static UserPrincipal userToPrincipal(Customer user) {
        UserPrincipal userp = new UserPrincipal();

        userp.setUsername(user.getUsername());
        userp.setPassword(user.getPassword());
        userp.setEnabled(user.getIsAction() !=null ? true:false);
        userp.setAuthorities(Collections.emptyList());
        return userp;
    }
}