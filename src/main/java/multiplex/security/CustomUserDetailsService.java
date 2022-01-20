package multiplex.security;

import multiplex.model.User;
import multiplex.service.UserService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findByEmail(username);

        UserBuilder builder;
        if (userOptional.isPresent()) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(userOptional.get().getPassword());
            builder.roles(userOptional.get().getRoles()
                    .stream().map(r -> r.getRoleType().name()).toArray(String[]::new));
            return builder.build();
        }
        throw new UsernameNotFoundException("User not found!");
    }
}
