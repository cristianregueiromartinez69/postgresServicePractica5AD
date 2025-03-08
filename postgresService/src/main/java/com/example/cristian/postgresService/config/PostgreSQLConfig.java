package com.example.cristian.postgresService.config;

import com.example.cristian.postgresService.excepciones.ConnectionDbException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Clase de configuracion de postgreSQL
 * @author cristian
 * @version 1.0
 */
@Configuration
public class PostgreSQLConfig {

    //url de la base de datos
    @Value("${spring.datasource.url}")
    private String url;

    //usuario de la base de datos
    @Value("${spring.datasource.username}")
    private String user;

    //contraseña de la base de datos
    @Value("${spring.datasource.password}")
    private String password;

    //driver de la base de datos
    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    /**
     * Metodo que devuelve la conexion de la base de datos
     * @return la conexion a la base
     */
    @Bean
    public DataSource dataSource() {
        try {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(password);
            return dataSource;
        }catch (Exception e) {
            throw new ConnectionDbException("Ups, error al conectar con la base de PostgreSQL");
        }
    }
}
