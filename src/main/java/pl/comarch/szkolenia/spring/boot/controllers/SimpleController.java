package pl.comarch.szkolenia.spring.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.comarch.szkolenia.spring.boot.database.INameRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SimpleController {

    @Autowired
    INameRepository nameRepository;

    @RequestMapping(path = "/test1/{name}/{surname}", method = RequestMethod.GET)
    public String test1(
            @PathVariable String name,
            @PathVariable String surname,
            @RequestParam int age,
            @RequestParam long pesel) {
        System.out.println("Dziala !!!");
        System.out.println(name);
        System.out.println(surname);
        System.out.println(age);
        System.out.println(pesel);
        return "index";
    }

    @RequestMapping(path = "/test2", method = RequestMethod.GET)
    public String test2(Model model) {
        System.out.println("Teraz sie dzieje cos innego !!!");
        String name = "Wiesiek";
        model.addAttribute("imie", name);
        model.addAttribute("imiona", this.nameRepository.getNames());
        return "cos";
    }
}
