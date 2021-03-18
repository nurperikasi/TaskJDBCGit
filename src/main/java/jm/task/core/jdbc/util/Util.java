package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.sql.Select;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;

public class Util {
    // реализуйте настройку соеденения с БД
    private  static Util instance;
    private Util() {}

    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USER = "root1";
    private static final String PASSWORD = "root1";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }


    private static SessionFactory sessionFactory;

    public static SessionFactory getSession() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            settings.put(Environment.URL, URL);
            settings.put(Environment.USER, USER);
            settings.put(Environment.PASS, PASSWORD);
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
            configuration.setProperties(settings);

            configuration.addAnnotatedClass(User.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            try {
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Throwable tr) {
                System.out.printf("session isn't opened");
                tr.printStackTrace();
            }
        }
        return sessionFactory;
    }
}