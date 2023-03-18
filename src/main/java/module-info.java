module com.example.examen_mysql {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;


    opens com.example.examen_mysql to javafx.fxml;
    exports com.example.examen_mysql;
}