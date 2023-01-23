package web.dao;

import web.entities.Contact;
import web.entities.Person;

import java.util.List;


public interface PersonDAO {

    List<Person> getAllPersons();
    void updatePerson(Person person);
    Person getPersonById(int id);
    void savePerson(Person person);

    void deletePersonById(int personId);
}
