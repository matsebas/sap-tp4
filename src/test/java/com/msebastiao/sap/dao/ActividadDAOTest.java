package com.msebastiao.sap.dao;

import com.msebastiao.sap.model.Actividad;
import com.msebastiao.sap.model.FichaMecanica;
import com.msebastiao.sap.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActividadDAOTest {

    private static SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    private ActividadDAO actividadDAO;
    private FichaMecanicaDAO fichaMecanicaDAO;

    @BeforeAll
    static void init() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @BeforeEach
    void setUp() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        actividadDAO = new ActividadDAO();
        fichaMecanicaDAO = new FichaMecanicaDAO();
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

        Actividad actividad = new Actividad("Reparación de motor", 120, "Completado", ficha);

        actividadDAO.insert(actividad);

        assertNotNull(actividad.getId());
    }

    @Test
    void testGetById() {
        FichaMecanica ficha = new FichaMecanica();
        fichaMecanicaDAO.insert(ficha);

        Actividad actividad = new Actividad("Cambio de aceite", 30, "Pendiente", ficha);

        actividadDAO.insert(actividad);

        Actividad fetchedActividad = actividadDAO.getById(actividad.getId());
        assertNotNull(fetchedActividad);
        assertEquals("Cambio de aceite", fetchedActividad.getDescripcion());
    }

    @Test
    void testGetAll() {
        FichaMecanica ficha = new FichaMecanica();
        fichaMecanicaDAO.insert(ficha);

        Actividad actividad1 = new Actividad("Cambio de aceite", 30, "Pendiente", ficha);
        Actividad actividad2 = new Actividad("Reparación de frenos", 60, "En progreso", ficha);

        actividadDAO.insert(actividad1);
        actividadDAO.insert(actividad2);

        List<Actividad> actividades = actividadDAO.getAll();
        assertNotNull(actividades);
        assertFalse(actividades.isEmpty());
    }

    @Test
    void testUpdate() {
        FichaMecanica ficha = new FichaMecanica();
        fichaMecanicaDAO.insert(ficha);

        Actividad actividad = new Actividad("Cambio de neumáticos", 45, "En progreso", ficha);
        actividadDAO.insert(actividad);

        actividad.setDescripcion("Cambio de frenos");
        actividadDAO.update(actividad);

        Actividad updatedActividad = actividadDAO.getById(actividad.getId());
        assertEquals("Cambio de frenos", updatedActividad.getDescripcion());
    }

    @Test
    void testDelete() {
        FichaMecanica ficha = new FichaMecanica();
        fichaMecanicaDAO.insert(ficha);

        Actividad actividad = new Actividad("Cambio de luces", 20, "Finalizado", ficha);
        actividadDAO.insert(actividad);

        actividadDAO.delete(actividad.getId());
        Actividad deletedActividad = actividadDAO.getById(actividad.getId());
        assertNull(deletedActividad);
    }
}