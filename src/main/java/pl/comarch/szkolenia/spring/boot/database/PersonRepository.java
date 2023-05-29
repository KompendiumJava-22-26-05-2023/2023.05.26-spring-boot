package pl.comarch.szkolenia.spring.boot.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.comarch.szkolenia.spring.boot.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonRepository implements IPersonRepository {

    @Autowired
    Connection connection;

    @Override
    public void add(Person person) {
        try {
            String sql = "INSERT INTO tperson (name, surname) VALUES (?, ?);";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, person.getName());
            ps.setString(2, person.getSurname());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("cos nie pyklo !!!");
        }
    }

    @Override
    public void delete(Person person) {
        try {
            String sql = "DELETE FROM tperson WHERE id = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, person.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("cos nie pyklo !!!");
        }
    }

    @Override
    public void update(Person person) {
        try {
            String sql = "UPDATE tperson SET name = ?, surname = ? WHERE id = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, person.getName());
            ps.setString(2, person.getSurname());
            ps.setInt(3, person.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("cos nie pyklo !!!");
        }
    }

    @Override
    public List<Person> getAll() {
        List<Person> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tperson;";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(new Person(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname")));
            }
        } catch (SQLException e) {
            System.out.println("cos nie pyklo !!!");
        }
        return result;
    }

    @Override
    public Optional<Person> getById(int id) {
        try {
            String sql = "SELECT * FROM tperson WHERE id = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return Optional.of(new Person(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname")));
            }
        } catch (SQLException e) {
            System.out.println("cos nie pyklo !!!");
        }
        return Optional.empty();
    }
}
