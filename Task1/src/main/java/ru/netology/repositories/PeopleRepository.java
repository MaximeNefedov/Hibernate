package ru.netology.repositories;

import org.springframework.stereotype.Repository;
import ru.netology.models.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PeopleRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        TypedQuery<Person> query = entityManager
                .createQuery("select person from persons person where person.cityOfLiving= :city", Person.class);
        query.setParameter("city", city);
        return query.getResultList();
    }
}
