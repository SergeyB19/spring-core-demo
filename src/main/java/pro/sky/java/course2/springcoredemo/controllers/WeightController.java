package pro.sky.java.course2.springcoredemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeightController {
    private final PersonService personService;

    public WeightController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/perfect-weight")
    public PerfectWeight findPerfectWeight(Person person) {
        return personService.calculatePerfectWeight;
    }

    public WeightController() {
        this.personService = new PersonServiceImpl();
    }
}
