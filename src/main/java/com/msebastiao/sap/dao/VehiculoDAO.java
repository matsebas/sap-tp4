package com.msebastiao.sap.dao;

import com.msebastiao.sap.model.Vehiculo;
import com.msebastiao.sap.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class VehiculoDAO implements DAO<Vehiculo> {

    private final SessionFactory sessionFactory;

    public VehiculoDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void insert(Vehiculo vehiculo) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(vehiculo);
            tx.commit();
        }
    }

    @Override
    public Vehiculo getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Vehiculo.class, id);
        }
    }

    @Override
    public List<Vehiculo> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Vehiculo", Vehiculo.class).list();
        }
    }

    @Override
    public void update(Vehiculo vehiculo) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(vehiculo); // Usar merge para actualizar
            tx.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Vehiculo vehiculo = session.get(Vehiculo.class, id);
            if (vehiculo != null) {
                session.remove(vehiculo);
            }
            tx.commit();
        }
    }
}