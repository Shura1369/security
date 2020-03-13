package pro.edu.security.controller.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.edu.security.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonRESTRController {

    private List<Person> persons = new ArrayList<>(
            Arrays.asList(
                    new Person("1","The first",23),
                    new Person("2","The second",21)
            )
    );

    @RequestMapping("/get/list")
    public  List<Person> showAll()
    {
        return persons;
    }

    @RequestMapping("/get/{id}")
    Person show(@PathVariable("id") String id){
        return persons.stream().filter(person -> person.getId().equals(id)).findFirst().orElse(null);
    }

    @RequestMapping("/delete/{id}")
    Person delete(@PathVariable("id") String id){
        Person pers = persons.stream().filter(person -> person.getId().equals(id)).findFirst().orElse(null);
        persons.remove(pers);
        return pers;
    }
}
