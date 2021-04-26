package ru.netology.products_dao.repositories;

import org.springframework.stereotype.Repository;
import ru.netology.products_dao.models.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductsRepositoryHibernate implements ProductsRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public ProductsRepositoryHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public List<Order> getOrdersByName(String name) {
        TypedQuery<Order> query = entityManager
                .createQuery("select ord from customers customer " +
                                "join orders ord on ord.customer.id = customer.id " +
                                "where upper(customer.name) = upper(:name)", Order.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}

