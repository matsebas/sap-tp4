package com.msebastiao.sap.dao;

import com.msebastiao.sap.model.Actividad;
import com.msebastiao.sap.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ActividadDAO implements DAO<Actividad> {

    private final SessionFactory sessionFactory;

    public ActividadDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void insert(Actividad actividad) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(actividad);
            tx.commit();
        }
    }

    @Override
    public Actividad getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Actividad.class, id);
        }
    }

    @Override
    public List<Actividad> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Actividad> query = session.createQuery("FROM Actividad", Actividad.class);
            return query.list();
        }
    }

    @Override
    public void update(Actividad actividad) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(actividad);
            tx.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Actividad actividad = session.get(Actividad.class, id);
            if (actividad != null) {
                session.remove(actividad);
            }
            tx.commit();
        }
    }

    public List<Actividad> getByFichaMecanicaId(int fichaMecanicaId) {
        try (Session session = sessionFactory.openSession()) {
            Query<Actividad> query = session.createQuery("FROM Actividad WHERE fichaMecanicaId = :fichaMecanicaId", Actividad.class);
            query.setParameter("fichaMecanicaId", fichaMecanicaId);
            return query.list();
        }
    }
}