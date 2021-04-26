package ru.netology.controllers;

import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.models.Person;
import ru.netology.services.PeopleService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PeopleController {

    private final PeopleService service;

    public PeopleController(PeopleService service) {
        this.service = service;
    }

    @GetMapping("/by-city")
    public ResponseEntity<String> getPersonsByCity(@RequestParam String city) {
        List<Person> personsByCity = service.getPersonsByCity(city);
        val stringBuilder = new StringBuilder("Жители города " + city + ": ");
        personsByCity.forEach((person) -> stringBuilder.append(person.getName())
                .append(", ")
                .append(person.getSurname())
                .append(", ")
                .append(person.getAge())
                .append(", ")
                .append(person.getPhoneNumber())
                .append("; "));
        return new ResponseEntity<>(stringBuilder.toString(), HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
