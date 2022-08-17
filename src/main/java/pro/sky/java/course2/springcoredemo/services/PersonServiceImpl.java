package pro.sky.java.course2.springcoredemo.services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Logger;

@Service
//@Scope(scopeName = "prototype")
public class PersonServiceImpl implements PersonService {
    //    @Autowired
    private PerfectWeightCalculator perfectWeightCalculator;
    Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

    public PersonServiceImpl() {
//        this.perfectWeightCalculator = perfectWeightCalculator;
        log.info("Person Service Impl")
    }

    @PostConstruct
    public void setup() {
        log.info("Person service is created");
        if (perfectWeightCalculator != null) {
            log.info("dependency created");
        }
    }

    @PreDestroy
    public void destroy() {
        log.info("Person service is destroyed");
    }

    @Override
    public PerfectWeight calculatePerfectWeight(Person person) {
        int perfectWeight = perfectWeightCalculator.calculate(person.getHeight());
        PerfectWeight result = new PerfectWeight(person.getHeight(), perfectWeight);
        return result;
    }

    @Override
    public String makeInfo(Person person) {
        return person.getSurname() + " " + person.getAge();

    }

    @Autowired
    public void setPerfectWeightCalculator(PerfectWeightCalculator perfectWeightCalculator) {
        this.perfectWeightCalculator = perfectWeightCalculator;
    }

//    private static PersonServiceImpl instance;

//    public static PersonServiceImpl getInstance() {
//        if (instance == null) {
//            instance = new PersonServiceImpl();
//        }
//        return instance;
//    }
//
//    public PersonServiceImpl() {
////        this.perfectWeightCalculator = new PerfectWeightCalculatorImpl();
//        this.perfectWeightCalculator = perfectWeightCalculatorImpl.getInstance();
//    }
}
