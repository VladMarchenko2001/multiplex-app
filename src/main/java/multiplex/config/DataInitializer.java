package multiplex.config;

import multiplex.model.Role;
import multiplex.model.User;
import multiplex.service.RoleService;
import multiplex.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setRoleType(Role.RoleType.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setRoleType(Role.RoleType.USER);
        roleService.add(userRole);
        User user = new User();
        user.setEmail("user@gmail.com");
        user.setPassword("u123456789");
        user.setRoles(Set.of(adminRole));
        userService.add(user);
    }
}
