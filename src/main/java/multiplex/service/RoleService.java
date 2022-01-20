package multiplex.service;

import multiplex.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByName(String roleName);
}
