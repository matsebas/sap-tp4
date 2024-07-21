package com.msebastiao.sap.dao;

import com.msebastiao.sap.model.Turno;
import com.msebastiao.sap.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TurnoDAO implements DAO<Turno> {

    private final SessionFactory sessionFactory;

    public TurnoDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void insert(Turno turno) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(turno); // Usamos persist para guardar el turno
            tx.commit();
        }
    }

    @Override
    public Turno getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Turno.class, id);
        }
    }

    @Override
    public List<Turno> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Turno", Turno.class).list();
        }
    }

    @Override
    public void update(Turno turno) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(turno);
            tx.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Turno turno = session.get(Turno.class, id);
            if (turno != null) {
                session.remove(turno);
            }
            tx.commit();
        }
    }
}
