package by.goncharov.dragon.core.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description of BaseDAO class
 *
 * @author Mikita Hancharou
 * @created 20.05.13 11:05
 */
public abstract class BaseDAO implements Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    protected BaseDAO() {
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    protected void save(Object obj) {
        getCurrentSession().saveOrUpdate(obj);
    }

    public Object merge(Object entity) {
        return getCurrentSession().merge(entity);
    }

    protected void delete(Object obj) {
        getCurrentSession().delete(obj);
    }

    protected Object find(Class<?> clazz, Long id) {
        return sessionFactory.getCurrentSession().get(clazz, id);
    }

    public void saveAll(List<?> entities) {
        Session session = getCurrentSession();
        for (final Object entity : entities) {
            session.saveOrUpdate(entity);
        }
    }
}
