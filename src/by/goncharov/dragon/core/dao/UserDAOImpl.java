package by.goncharov.dragon.core.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import by.goncharov.dragon.core.entity.User;


/**
 * Description of UserDAOImpl class
 *
 * @author Mikita Hancharou
 * @created 23.05.13 12:51
 */
public class UserDAOImpl extends BaseDAO implements UserDAO {

    @Transactional(readOnly = false)
    public int save(User user) {
        return (Integer) getCurrentSession().save(user);
    }

    @Transactional(readOnly = false)
    public void update(User user) {
        getCurrentSession().update(user);
    }

    @Transactional(readOnly = false)
    public void delete(User user) {
        getCurrentSession().delete(user);
    }

    @Transactional(readOnly = true)
    public User findByUserId(int userId) {
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        return (User) criteria.add(Restrictions.eq("userId", userId)).setMaxResults(1).uniqueResult();
    }
}
