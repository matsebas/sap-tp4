package com.msebastiao.sap.dao;

import com.msebastiao.sap.model.TitularVehiculo;
import com.msebastiao.sap.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TitularVehiculoDAO implements DAO<TitularVehiculo> {

    private final SessionFactory sessionFactory;

    public TitularVehiculoDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void insert(TitularVehiculo titularVehiculo) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(titularVehiculo);
            tx.commit();
        }
    }

    @Override
    public TitularVehiculo getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(TitularVehiculo.class, id);
        }
    }

    @Override
    public List<TitularVehiculo> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM TitularVehiculo", TitularVehiculo.class).list();
        }
    }

    @Override
    public void update(TitularVehiculo titularVehiculo) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(titularVehiculo); // Usar merge para actualizar
            tx.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            TitularVehiculo titularVehiculo = session.get(TitularVehiculo.class, id);
            if (titularVehiculo != null) {
                session.delete(titularVehiculo);
            }
            tx.commit();
        }
    }

    public TitularVehiculo getByDni(String dni) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM TitularVehiculo WHERE dni = :dni", TitularVehiculo.class)
                    .setParameter("dni", dni)
                    .uniqueResult(); // Esperamos un único resultado por DNI
        }
    }
}
