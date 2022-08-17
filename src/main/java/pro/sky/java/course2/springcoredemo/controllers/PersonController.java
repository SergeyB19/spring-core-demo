package pro.sky.java.course2.springcoredemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping("/short-info")
    public String shortPersonInfo(Person person) {
        return personService.makeInfo(person);
    }

    public PersonController() {
        this.personService = PersonServiceImpl.getInstance();
    }
}
