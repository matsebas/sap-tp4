package com.msebastiao.sap.controller;

import com.msebastiao.sap.dao.ActividadDAO;
import com.msebastiao.sap.model.Actividad;
import com.msebastiao.sap.model.FichaMecanica;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.ListViewMatchers;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.testfx.api.FxAssert.verifyThat;

@ExtendWith(ApplicationExtension.class)
public class SupervisarTareasControllerTest {

    @InjectMocks
    private SupervisarTareasController controller;

    @Mock
    private ActividadDAO actividadDAO;

    @Start
    public void start(Stage stage) throws Exception {
        // Inicializar los mocks
        MockitoAnnotations.openMocks(this);
        // Cargar el archivo FXML y configurar el controlador
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/msebastiao/sap/view/SupervisarTareasView.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
        controller.actividadDAO = actividadDAO;
        stage.setScene(new javafx.scene.Scene(root));
        stage.show();
    }

    @BeforeEach
    public void setUp() {
        // Preparar mocks y datos de prueba
        List<Actividad> actividades = List.of(
                new Actividad("Actividad 1", 60, "En curso", new FichaMecanica()),
                new Actividad("Actividad 2", 120, "Finalizada", new FichaMecanica()),
                new Actividad("Actividad 3", 90, "Cancelada", new FichaMecanica())
        );
        when(actividadDAO.getAll()).thenReturn(actividades);
        // Llamar al método initialize del controlador para cargar los datos mock
        controller.cargarTareas();
    }

    @Test
    public void should_initialize_lists() {
        // Verificar que las listas se inicializan correctamente
        verifyThat("#tareasEnCursoList", ListViewMatchers.hasItems(1));
        verifyThat("#tareasFinalizadasList", ListViewMatchers.hasItems(1));
        verifyThat("#tareasCanceladasList", ListViewMatchers.hasItems(1));
    }

    @Test
    public void should_update_lists_on_button_click(FxRobot robot) {
        // Mocking data again to ensure fresh data is returned when the button is clicked
        List<Actividad> actividadesActualizadas = List.of(
                new Actividad("Actividad 4", 60, "En curso", new FichaMecanica()),
                new Actividad("Actividad 5", 120, "Finalizada", new FichaMecanica()),
                new Actividad("Actividad 6", 90, "Cancelada", new FichaMecanica())
        );
        when(actividadDAO.getAll()).thenReturn(actividadesActualizadas);

        // Hacer clic en el botón "Actualizar Lista"
        robot.clickOn("#handleActualizarLista");

        // Verificar que las listas se actualizan correctamente
        verifyThat("#tareasEnCursoList", ListViewMatchers.hasItems(1));
        verifyThat("#tareasFinalizadasList", ListViewMatchers.hasItems(1));
        verifyThat("#tareasCanceladasList", ListViewMatchers.hasItems(1));
    }
}
