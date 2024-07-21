package com.msebastiao.sap.dao;

import com.msebastiao.sap.model.FichaMecanica;
import com.msebastiao.sap.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class FichaMecanicaDAO implements DAO<FichaMecanica> {

    private final SessionFactory sessionFactory;

    public FichaMecanicaDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void insert(FichaMecanica ficha) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(ficha);
            tx.commit();
        }
    }

    @Override
    public FichaMecanica getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            FichaMecanica ficha = session.get(FichaMecanica.class, id);
            if (ficha != null) {
                initializeCollections(ficha);
            }
            return ficha;
        }
    }

    @Override
    public List<FichaMecanica> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<FichaMecanica> query = session.createQuery("FROM FichaMecanica", FichaMecanica.class);
            List<FichaMecanica> fichas = query.list();
            fichas.forEach(this::initializeCollections);
            return fichas;
        }
    }

    @Override
    public void update(FichaMecanica ficha) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(ficha);
            tx.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            FichaMecanica ficha = session.get(FichaMecanica.class, id);
            if (ficha != null) {
                session.remove(ficha);
            }
            tx.commit();
        }
    }

    private void initializeCollections(FichaMecanica ficha) {
        ficha.getActividadesRealizadas().size();
        ficha.getRepuestosEmpleados().size();
    }
}