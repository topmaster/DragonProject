package by.goncharov.dragon.core.dao;

import by.goncharov.dragon.core.entity.Role;

/**
 * Description of RoleDAO class
 *
 * @author Mikita Hancharou
 * @created 18.05.13 15:46
 */
public interface RoleDAO {

    void save(Role role);

    void delete(Role role);

    Role find(Long roleId);
}
