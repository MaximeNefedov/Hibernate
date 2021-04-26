package ru.netology.services;

import org.springframework.stereotype.Service;
import ru.netology.models.Person;
import ru.netology.repositories.PeopleRepository;

import java.util.List;

@Service
public class PeopleService {
    private final PeopleRepository repository;

    public PeopleService(PeopleRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        List<Person> personsByCity = repository.getPersonsByCity(city);
        if (personsByCity.isEmpty()) {
            throw new IllegalArgumentException("В городе " + city + " не найден ни один житель!");
        }
        return repository.getPersonsByCity(city);
    }
}
