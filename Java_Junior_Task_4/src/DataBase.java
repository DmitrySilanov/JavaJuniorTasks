import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBase {
    private static final String URL = "jdbc:mysql://localhost:3404";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void add() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Person person = new Person("Dmitrii", "Olegovich", 33);
        session.save(person);
        person = new Person("Petr", "Dmitrievich", 42);
        session.save(person);
        person = new Person("Alla", "Ivanovna", 21);
        session.save(person);
        person = new Person("Andrey", "Natanovich", 31);
        session.save(person);
        person = new Person("Irina", "Petrovna", 25);
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }

    public static void createTable() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE `test`.`person`");
            statement.execute("CREATE TABLE `test`.`person` (\n" +
                    "                                `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "                                `Имя` VARCHAR(45) NULL,\n" +
                    "                                `Отчество` VARCHAR(45) NULL,\n" +
                    "                                `Возраст` INT NULL,\n" +
                    "                                PRIMARY KEY (`id`));");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}