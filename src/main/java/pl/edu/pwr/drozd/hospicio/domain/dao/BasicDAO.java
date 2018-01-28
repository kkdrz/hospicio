package pl.edu.pwr.drozd.hospicio.domain.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class BasicDAO<T> {

    private Class<T> clazz;

    public BasicDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    SessionFactory sessionFactory = new Configuration()
            .configure()
            .buildSessionFactory();

    public void setClazz(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }

    public T findOne(final long id) {
        Session session = beginTransaction();
        T result = session.get(clazz, id);
        closeTransaction(session);
        return result;
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        Session session = beginTransaction();
        List<T> result = session.createQuery("from " + clazz.getName()).list();
        closeTransaction(session);
        return result;
    }

    public void save(final T entity) {
        Session session = beginTransaction();
        session.persist(entity);
        closeTransaction(session);
    }

    public T update(final T entity) {
        Session session = beginTransaction();
        T object = (T) session.merge(entity);
        closeTransaction(session);
        return object;
    }

    public void delete(final T entity) {
        Session session = beginTransaction();
        session.delete(entity);
        closeTransaction(session);
    }

    public void deleteById(final long id) {
        final T entity = findOne(id);
        delete(entity);
    }

    private Session beginTransaction() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }

    private void closeTransaction(Session session) {
        session.getTransaction().commit();
        session.close();
    }
}
