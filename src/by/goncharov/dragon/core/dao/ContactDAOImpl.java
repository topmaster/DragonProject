package by.goncharov.dragon.core.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.goncharov.dragon.core.entity.Contact;

/**
 * Description of ContactDAOImpl class
 *
 * @author Mikita Hancharou
 * @created 26.06.13 10:47
 */
@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO {

    @Override
    @Transactional(readOnly = false)
    public void save(Contact contact) {
        super.save(contact);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Contact contact) {
        super.delete(contact);
    }

    @Override
    @Transactional(readOnly = true)
    public Contact find(Long contactId) {
        return (Contact) super.find(Contact.class, contactId);
    }
}
