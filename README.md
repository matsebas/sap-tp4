# Trabajo Práctico Nº4 - Seminario de Actualización en Programación

## Universidad Siglo 21

**Autor:**

- Matías Sebastián, DNI 31070095, VINF011605

**Profesores:**

- Gutierrez J.M.
- Callejas M.

## Resumen

Este proyecto aborda el Trabajo Práctico Nº4 del Seminario de Actualización en Programación. Se parte del patrón de
arquitectura Objeto-Acceso a Datos (DAO) desarrollado previamente y se modifica para integrar una librería ORM (
Object-Relational Mapping) en la plataforma Java. Además, se diseñan e implementan pruebas unitarias y funcionales para
asegurar la calidad y el correcto funcionamiento del sistema.

**Palabras Clave:** ORM, DAO, JUnit, TestFX, JavaFX, Java

## Diseño y Arquitectura

* **Objeto-Acceso a Datos (DAO) con ORM:** Se adapta el patrón DAO existente para integrar una librería ORM (Hibernate),
  lo que permite una interacción más transparente y eficiente con la base de datos, reduciendo la cantidad de código
  repetitivo y facilitando el mantenimiento.

* **Pruebas Unitarias:** Se diseñan e implementan pruebas unitarias utilizando JUnit para verificar el correcto
  funcionamiento de componentes individuales del sistema de forma aislada, como los métodos de los DAOs y la lógica de
  negocio en los controladores.

* **Pruebas Funcionales:** Se diseñan e implementan pruebas funcionales utilizando TestFX para simular la interacción
  del usuario con la interfaz gráfica de JavaFX y validar el comportamiento del sistema en su conjunto, incluyendo la
  navegación entre vistas, la entrada de datos y la visualización de resultados.

## Diagrama Entidad-Relación (DER)

El DER se encuentra en el archivo `diagrams/der.puml` y se ha generado utilizando PlantUML. Este diagrama modela la
estructura de
la base de datos relacional y sus relaciones, reflejando el diseño de clases del modelo.

## Implementación

El proyecto se ha implementado en Java, utilizando las siguientes herramientas y tecnologías:

* **Lenguaje:** Java
* **ORM:** Hibernate
* **Pruebas Unitarias:** JUnit
* **Pruebas Funcionales:** TestFX
* **Interfaz Gráfica:** JavaFX
* **Modelado:** PlantUML

## Instrucciones de Uso

1. **Clonar el Repositorio:**
   ```bash
   git clone https://github.com/matsebas/sap-tp4
   ```

2. **Configuración del Entorno:**

* Asegúrate de tener instalado el JDK 21 de Java.
* Configura la conexión a la base de datos en el archivo `persistence.xml` del proyecto.
* Asegúrate de tener las dependencias de Hibernate y TestFX en tu proyecto.


3. **Compilar el proyecto utilizando Maven:**
    ```sh
    mvn clean install
    ```

4. **Ejecutar la aplicación**

    * Asegúrate de que tu base de datos MySQL esté en funcionamiento y configurada correctamente.

    * Ejecutá la aplicación utilizando Maven:
      ```sh
      mvn javafx:run
      ```
      Esto compilará y ejecutará la aplicación JavaFX.

## Estructura del proyecto

- `src/main/java`: Contiene el código fuente principal de la aplicación (modelos, vistas y controladores).
- `src/main/resources`: Contiene los archivos FXML, `persistence.xml` y otros recursos.
- `src/test/java`: Contiene las pruebas unitarias (JUnit) y funcionales (TestFX).
- `scripts/01_supercharger.sql`: Script SQL que crea la base y llena datos básicos para poder probar.
- `scripts/supercharger_dump_OPCIONAL.sql`: Dump OPCIONAL que permite probar rápidamente varios ejemplos de datos.

## Configuración de la base de datos

```properties
    url= "jdbc:mysql://localhost:3306/supercharger";
    usuario= "root";
    clave= "P4ssw0rd!";
}
```

## Dependencias principales

- JavaFX 21
- Hibernate
- JUnit
- TestFX
- MySQL Connector/J 8.2.0

## Referencias

* **Hibernate:** [https://hibernate.org/](https://hibernate.org/)
* **JUnit:** [https://junit.org/junit5/](https://junit.org/junit5/)
* **TestFX:** [https://github.com/TestFX/TestFX](https://github.com/TestFX/TestFX)
* **PlantUML:** [https://plantuml.com/es/](https://plantuml.com/es/)