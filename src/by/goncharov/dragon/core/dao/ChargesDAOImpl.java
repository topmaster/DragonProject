package by.goncharov.dragon.core.dao;

import org.springframework.transaction.annotation.Transactional;

import by.goncharov.dragon.core.entity.Charges;

/**
 * Description of ChargesDAOImpl class
 *
 * @author Mikita Hancharou
 * @created 24.05.13 10:33
 */
public class ChargesDAOImpl extends BaseDAO implements ChargesDAO {

    @Override
    @Transactional(readOnly = false)
    public void save(Charges charges) {
        super.save(charges);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Charges charges) {
        super.delete(charges);
    }

    @Override
    @Transactional(readOnly = true)
    public Charges find(Long chargesId) {
        return (Charges) super.find(Charges.class, chargesId);
    }
}
