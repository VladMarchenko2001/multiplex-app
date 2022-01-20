package multiplex.dao.impl;

import multiplex.dao.AbstractDao;
import multiplex.dao.RoleDao;
import multiplex.exception.DataProcessingException;
import multiplex.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getByName(String roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> getRoleByName = session
                    .createQuery("FROM Role WHERE roleType = "
                            + "'" + Role.RoleType.valueOf(roleName) + "'", Role.class);
            return getRoleByName.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Role with name " + roleName + " not found", e);
        }
    }
}
