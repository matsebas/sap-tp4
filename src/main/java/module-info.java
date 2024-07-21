module com.msebastiao.sap {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires org.slf4j;

    // Abre el paquete com.msebastiao.sap para reflexiones a javafx.fxml
    opens com.msebastiao.sap to javafx.fxml;

    // Abre el paquete com.msebastiao.sap.controller para reflexiones a javafx.fxml
    opens com.msebastiao.sap.controller to javafx.fxml;

    // Abre el paquete com.msebastiao.sap.model para reflexiones a org.hibernate.orm.core
    opens com.msebastiao.sap.model to org.hibernate.orm.core, javafx.base;

    // Exporta los paquetes para que puedan ser utilizados por otros módulos
    exports com.msebastiao.sap;
    exports com.msebastiao.sap.controller;
    exports com.msebastiao.sap.model;
    exports com.msebastiao.sap.dao;
}
