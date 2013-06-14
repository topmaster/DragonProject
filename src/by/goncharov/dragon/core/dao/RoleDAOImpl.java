package by.goncharov.dragon.core.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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

    @Transactional(readOnly = false)
    public int save(Role role) {
        return (Integer) getCurrentSession().save(role);
    }

    @Transactional(readOnly = false)
    public void update(Role role) {
        getCurrentSession().update(role);
    }

    @Transactional(readOnly = false)
    public void delete(Role role) {
        getCurrentSession().delete(role);
    }

    @Transactional(readOnly = true)
    public Role findByRoleId(int roleId) {
        Criteria criteria = getCurrentSession().createCriteria(Role.class);
        return (Role) criteria.add(Restrictions.eq("roleId", roleId)).setMaxResults(1).uniqueResult();
    }
}
