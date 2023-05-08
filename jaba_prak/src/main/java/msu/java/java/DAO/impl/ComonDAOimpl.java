package msu.java.java.DAO.impl;

import msu.java.java.DAO.ComonDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import msu.java.java.model.CommonEntity;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

import java.io.Serializable;
import java.util.Collection;

@Repository
public abstract class ComonDAOimpl<T extends CommonEntity<ID>, ID extends Serializable> implements ComonDAO<T, ID> {
    protected Class<T> entityClass;
    protected SessionFactory sessionFactory;

    protected Class<T> persistentClass;

    public ComonDAOimpl(Class<T> entityClass){
        this.persistentClass = entityClass;
    }

    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory.getObject();
    }

    @Override
    public T getById(ID id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(persistentClass, id);
        }
    }

    @Override
    public Collection<T> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = builder.createQuery(entityClass);
            criteriaQuery.from(entityClass);
            return session.createQuery(criteriaQuery).getResultList();
        }
    }
    @Override
    public void save(T entity) {
        try (Session session = sessionFactory.openSession()) {
            if (entity.getId() != null) {
                entity.setId(null);
            }
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveCollection(Collection<T> entities) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            for (T entity : entities) {
                this.save(entity);
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(T entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(T entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(ID id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            T entity = getById(id);
            session.delete(entity);
            session.getTransaction().commit();
        }
    }
}