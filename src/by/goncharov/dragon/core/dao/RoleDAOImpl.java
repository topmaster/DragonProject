package by.goncharov.dragon.core.dao;

import org.springframework.transaction.annotation.Transactional;

import by.goncharov.dragon.core.entity.Role;

/**
 * Description of RoleDAOImpl class
 *
 * @author Mikita Hancharou
 * @created 18.05.13 15:48
 */
@Transactional
public class RoleDAOImpl extends BaseDAO implements RoleDAO {

    @Override
    @Transactional(readOnly = false)
    public void save(Role role) {
        super.save(role);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Role role) {
        super.delete(role);
    }

    @Override
    @Transactional(readOnly = true)
    public Role find(Long roleId) {
        return (Role) super.find(Role.class, roleId);
    }
}
