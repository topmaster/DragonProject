package by.goncharov.dragon.core.dao;

import by.goncharov.dragon.core.entity.Charges;

/**
 * Description of ChargesDAO class
 *
 * @author Mikita Hancharou
 * @created 24.05.13 10:31
 */
public interface ChargesDAO {

    void save(Charges charges);

    void delete(Charges charges);

    Charges find(Long chargesId);
}
