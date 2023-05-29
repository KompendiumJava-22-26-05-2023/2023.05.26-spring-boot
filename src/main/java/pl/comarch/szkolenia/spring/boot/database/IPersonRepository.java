package pl.comarch.szkolenia.spring.boot.database;

import pl.comarch.szkolenia.spring.boot.model.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonRepository {
    void add(Person person);
    void delete(Person person);
    void update(Person person);
    List<Person> getAll();
    Optional<Person> getById(int id);
}
