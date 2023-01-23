package web.dao;

import org.hibernate.Session;
import web.entities.Contact;
import web.entities.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Person> getAllPersons() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Person", Person.class)
                .getResultList();
    }

    @Override
    public void updatePerson(Person person) {
        sessionFactory.getCurrentSession().update(person);
    }


    @Override
    public Person getPersonById(int id) {
        return sessionFactory.getCurrentSession()
                .get(Person.class, id);
    }

    @Override
    public void savePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    @Override
    public void deletePersonById(int personId) {
        Session session = sessionFactory.getCurrentSession();
        Person owner = session.get(Person.class, personId);
        session.delete(owner);
    }


}

