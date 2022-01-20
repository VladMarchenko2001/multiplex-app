package multiplex.service.impl;

import multiplex.dao.RoleDao;
import multiplex.exception.DataProcessingException;
import multiplex.model.Role;
import multiplex.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role getByName(String roleName) {
        return roleDao.getByName(roleName).orElseThrow(
                () -> new DataProcessingException("Role with name " + roleName + " not found"));
    }
}
