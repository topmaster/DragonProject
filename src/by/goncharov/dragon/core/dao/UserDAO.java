package by.goncharov.dragon.core.dao;

import by.goncharov.dragon.core.entity.User;

/**
 * Description of UserDAO class
 *
 * @author Mikita Hancharou
 * @created 23.05.13 12:44
 */
public interface UserDAO {

    int save(User user);

    void update(User user);

    void delete(User user);

    User findByUserId(int userId);
}
