package web.service;

import web.entities.Person;
import web.entities.Contact;


import java.util.List;


public interface ContactAndPhonesService {

    void createСontact(Contact contact);


    List<Person> getPersonsList();
    List<Contact> getContactsList();
    List<Contact> getListPhonesOfPersonById(int id);


    Contact getContactById(int id);
    Person getPersonById(int id);

    void updatePerson(Person person);

    void updateContactById();
    void deleteContactById(int personId);

}
