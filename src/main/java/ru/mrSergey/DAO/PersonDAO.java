package ru.mrSergey.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.mrSergey.models.Person;
import java.util.List;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //Аннотация для методов (только чтение)
    @Transactional(readOnly = true)
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();
        // Язык HQL
        return session.createQuery("select p from Person p", Person.class). getResultList();

    }
    public Person show(int id){
    return null;
    }
    public void save(Person person){

    }
    public void update(int id, Person person) {

    }
    public void delete(int id){

    }

}
