package pl.comarch.szkolenia.spring.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FromController {

    @RequestMapping(path = "/form", method = RequestMethod.GET)
    public String form() {
        return "form";
    }

    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public String form2(@RequestParam String name,
                        @RequestParam String surname,
                        @RequestParam int age) {
        System.out.println(name);
        System.out.println(surname);
        System.out.println(age);
        return "index";
    }
}
