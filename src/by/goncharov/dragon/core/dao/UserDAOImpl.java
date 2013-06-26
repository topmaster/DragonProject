package by.goncharov.dragon.core.dao;

import org.springframework.transaction.annotation.Transactional;

import by.goncharov.dragon.core.entity.User;


/**
 * Description of UserDAOImpl class
 *
 * @author Mikita Hancharou
 * @created 23.05.13 12:51
 */
public class UserDAOImpl extends BaseDAO implements UserDAO {

    @Override
    @Transactional(readOnly = false)
    public Long save(User user) {
        return (Long) super.getCurrentSession().save(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(User user) {
        super.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User find(Long userId) {
        return (User) super.find(User.class, userId);
    }
}
