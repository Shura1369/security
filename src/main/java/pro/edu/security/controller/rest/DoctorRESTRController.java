package pro.edu.security.controller.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.edu.security.model.Doctor;
import pro.edu.security.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorRESTRController {

    private List<Doctor> doctors = new ArrayList<>(
            Arrays.asList(
                    new Doctor("1","The first",23),
                    new Doctor("2","The second",21)
            )
    );

    @RequestMapping("/get/list")
    public  List<Doctor> showAll()
    {
        return doctors;
    }

    @RequestMapping("/get/{id}")
    Doctor show(@PathVariable("id") String id){
        return doctors.stream().filter(doctor -> doctor.getId().equals(id)).findFirst().orElse(null);
    }

    @RequestMapping("/delete/{id}")
    Doctor delete(@PathVariable("id") String id){
        Doctor doctr = doctors.stream().filter(doctor -> doctor.getId().equals(id)).findFirst().orElse(null);
        doctors.remove(doctr);
        return doctr;
    }
}
