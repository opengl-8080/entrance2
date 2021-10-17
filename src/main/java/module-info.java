open module javafx.template.main {
    exports entrance;

    requires javafx.fxml;
    requires javafx.controls;
    requires gl.javafx;
    requires java.sql;
    requires org.apache.logging.log4j;
    requires org.flywaydb.core;
    requires com.h2database;
}