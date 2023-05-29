package pl.comarch.szkolenia.spring.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.comarch.szkolenia.spring.boot.database.IPersonRepository;
import pl.comarch.szkolenia.spring.boot.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class PersonController {
    @Autowired
    IPersonRepository personRepository;

    @RequestMapping(path = "/add/{name}/{surname}", method = RequestMethod.GET)
    public String add(@PathVariable String name, @PathVariable String surname) {
        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);

        this.personRepository.add(person);

        return "index";
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        Person person = new Person();
        person.setId(id);

        this.personRepository.delete(person);

        return "index";
    }

    @RequestMapping(path = "/update/{name}/{surname}/{id}", method = RequestMethod.GET)
    public String update(@PathVariable String name,
                         @PathVariable String surname,
                         @PathVariable int id) {
        Person person = new Person(id, name, surname);

        this.personRepository.update(person);

        return "index";
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public String getAll() {
        List<Person> personList = this.personRepository.getAll();
        System.out.println(personList);

        return "index";
    }

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
    public String getById(@PathVariable int id) {
        Optional<Person> personBox = this.personRepository.getById(id);
        personBox.ifPresentOrElse(
                p -> System.out.println(p),
                () -> System.out.println("Nie ma takiego goscia !!!"));

        return "index";
    }
}
