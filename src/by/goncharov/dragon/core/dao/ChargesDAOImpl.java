package by.goncharov.dragon.core.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import by.goncharov.dragon.core.entity.Charges;

/**
 * Description of ChargesDAOImpl class
 *
 * @author Mikita Hancharou
 * @created 24.05.13 10:33
 */
public class ChargesDAOImpl extends BaseDAO implements ChargesDAO {

    @Transactional(readOnly = false)
    public int save(Charges charges) {
        return (Integer) getCurrentSession().save(charges);
    }

    @Transactional(readOnly = false)
    public void update(Charges charges) {
        getCurrentSession().update(charges);
    }

    @Transactional(readOnly = false)
    public void delete(Charges charges) {
        getCurrentSession().delete(charges);
    }

    @Transactional(readOnly = true)
    public Charges findByChargesId(int chargesId) {
        Criteria criteria = getCurrentSession().createCriteria(Charges.class);
        return (Charges) criteria.add(Restrictions.eq("chargesId", chargesId)).setMaxResults(1).uniqueResult();
    }
}
