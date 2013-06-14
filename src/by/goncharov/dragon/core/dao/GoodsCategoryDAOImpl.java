package by.goncharov.dragon.core.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import by.goncharov.dragon.core.entity.GoodsCategory;

/**
 * Description of GoodsCategoryDAOImpl class
 *
 * @author Mikita Hancharou
 * @created 24.05.13 10:22
 */
public class GoodsCategoryDAOImpl extends BaseDAO implements GoodsCategoryDAO {

    @Transactional(readOnly = false)
    public int save(GoodsCategory goodsCategory) {
        return (Integer) getCurrentSession().save(goodsCategory);
    }

    @Transactional(readOnly = false)
    public void update(GoodsCategory goodsCategory) {
        getCurrentSession().update(goodsCategory);
    }

    @Transactional(readOnly = false)
    public void delete(GoodsCategory goodsCategory) {
        getCurrentSession().delete(goodsCategory);
    }

    @Transactional(readOnly = true)
    public GoodsCategory findByGoodsCategoryId(int goodsCategoryId) {
        Criteria criteria = getCurrentSession().createCriteria(GoodsCategory.class);
        return (GoodsCategory) criteria.add(Restrictions.eq("goodsCatId", goodsCategoryId)).setMaxResults(1).uniqueResult();
    }
}
