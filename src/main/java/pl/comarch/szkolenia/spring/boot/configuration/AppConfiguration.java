package pl.comarch.szkolenia.spring.boot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.comarch.szkolenia.spring.boot.database.INameRepository;
import pl.comarch.szkolenia.spring.boot.database.NamesRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan("pl.comarch.szkolenia.spring.boot")
public class AppConfiguration {

    @Bean
    public Connection connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test13",
                    "root",
                    "");
        } catch (ClassNotFoundException e) {
            System.out.println("Zepsulo sie, nie ma drajwera !!!");
        } catch (SQLException e) {
            System.out.println("cos nie pyklo laczenie do bazy !!!");
        }
        return null;
    }
}
