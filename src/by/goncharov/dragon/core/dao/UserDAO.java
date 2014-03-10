package by.goncharov.dragon.core.dao;

import by.goncharov.dragon.core.entity.User;

/**
 * Description of UserDAO class
 *
 * @author Mikita Hancharou
 * @created 23.05.13 12:44
 */
public interface UserDAO {

    void save(User user);

    void delete(User user);

    User find(Long userId);
}
