package com.msebastiao.sap.dao;

import com.msebastiao.sap.model.FichaMecanica;
import com.msebastiao.sap.model.Repuesto;
import com.msebastiao.sap.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepuestoDAOTest {

    private static SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    private RepuestoDAO repuestoDAO;
    private FichaMecanicaDAO fichaMecanicaDAO;

    @BeforeAll
    static void init() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @BeforeEach
    void setUp() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        repuestoDAO = new RepuestoDAO();
        fichaMecanicaDAO = new FichaMecanicaDAO();

        // Limpiar la base de datos antes de cada prueba
        limpiarBaseDeDatos();
    }

    private void limpiarBaseDeDatos() {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.createQuery("DELETE FROM Repuesto").executeUpdate();
            tx.commit();
        }
    }

    @AfterEach
    void tearDown() {
        if (transaction != null) {
            transaction.rollback();
        }
        if (session != null) {
            session.close();
        }
    }

    @AfterAll
    static void destroy() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    void testInsert() {
        FichaMecanica ficha = new FichaMecanica();
        fichaMecanicaDAO.insert(ficha);

        Repuesto repuesto = new Repuesto("Filtro de aire", 2, ficha);
        repuestoDAO.insert(repuesto);

        assertNotNull(repuesto.getId()); // Verifica que el ID se haya generado
    }

    @Test
    void testGetById() {
        FichaMecanica ficha = new FichaMecanica();
        fichaMecanicaDAO.insert(ficha);

        Repuesto repuesto = new Repuesto("Bujías", 4, ficha);
        repuestoDAO.insert(repuesto);

        Repuesto repuestoObtenido = repuestoDAO.getById(repuesto.getId());
        assertNotNull(repuestoObtenido);
        assertEquals("Bujías", repuestoObtenido.getNombre());
        assertEquals(4, repuestoObtenido.getCantidad());
    }

    @Test
    void testGetAll() {
        FichaMecanica ficha = new FichaMecanica();
        fichaMecanicaDAO.insert(ficha);

        Repuesto repuesto1 = new Repuesto("Pastillas de freno", 2, ficha);
        Repuesto repuesto2 = new Repuesto("Aceite de motor", 1, ficha);
        repuestoDAO.insert(repuesto1);
        repuestoDAO.insert(repuesto2);

        List<Repuesto> repuestos = repuestoDAO.getAll();
        assertNotNull(repuestos);
        assertFalse(repuestos.isEmpty());
        assertEquals(2, repuestos.size());
    }

    @Test
    void testUpdate() {
        FichaMecanica ficha = new FichaMecanica();
        fichaMecanicaDAO.insert(ficha);

        Repuesto repuesto = new Repuesto("Correa de distribución", 1, ficha);
        repuestoDAO.insert(repuesto);

        repuesto.setCantidad(2); // Modificar la cantidad
        repuestoDAO.update(repuesto);

        Repuesto repuestoActualizado = repuestoDAO.getById(repuesto.getId());
        assertEquals(2, repuestoActualizado.getCantidad());
    }

    @Test
    void testDelete() {
        FichaMecanica ficha = new FichaMecanica();
        fichaMecanicaDAO.insert(ficha);

        Repuesto repuesto = new Repuesto("Amortiguadores", 2, ficha);
        repuestoDAO.insert(repuesto);

        repuestoDAO.delete(repuesto.getId());
        Repuesto repuestoEliminado = repuestoDAO.getById(repuesto.getId());
        assertNull(repuestoEliminado);
    }
}
