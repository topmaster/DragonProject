package by.goncharov.dragon.core.dao;

import by.goncharov.dragon.core.entity.Contact;

/**
 * Description of ContactDAO class
 *
 * @author Mikita Hancharou
 * @created 26.06.13 10:45
 */
public interface ContactDAO {

    void save(Contact contact);

    void delete(Contact contact);

    Contact find(Long contactId);
}
