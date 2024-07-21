package com.msebastiao.sap.dao;

import com.msebastiao.sap.model.Repuesto;
import com.msebastiao.sap.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RepuestoDAO implements DAO<Repuesto> {

    private final SessionFactory sessionFactory;

    public RepuestoDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void insert(Repuesto repuesto) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(repuesto);
            tx.commit();
        }
    }

    @Override
    public Repuesto getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Repuesto.class, id);
        }
    }

    @Override
    public List<Repuesto> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Repuesto> query = session.createQuery("FROM Repuesto", Repuesto.class);
            return query.list();
        }
    }

    @Override
    public void update(Repuesto repuesto) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(repuesto);
            tx.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Repuesto repuesto = session.get(Repuesto.class, id);
            if (repuesto != null) {
                session.remove(repuesto);
            }
            tx.commit();
        }
    }
}