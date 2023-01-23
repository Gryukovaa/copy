package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.dao.PersonDAO;

import web.dao.ContactDAO;
import web.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.entities.Contact;


import java.util.List;

@Service
@Transactional
public class ContactAndPhonesServiceImpl implements ContactAndPhonesService {

    private PersonDAO personDAO;
    private ContactDAO contactDAO;

    @Autowired
    public ContactAndPhonesServiceImpl(PersonDAO personDAO, ContactDAO contactDAO) {
        this.personDAO = personDAO;
        this.contactDAO = contactDAO;
    }



    @Override
    public List<Person> getPersonsList() {
        return personDAO.getAllPersons();
    }

    @Override
    public List<Contact> getContactsList(){
        return contactDAO.getAllContacts();
    }

    @Override
    public List<Contact> getListPhonesOfPersonById(int id) {
        return contactDAO.getListPhonesOfPersonById(id);
    }

    @Override
    public void createСontact(Contact contact) {
       contactDAO.addPhoneNumberByPersonID(contact);
    }

    @Override
    public Contact getContactById(int id) {
        return contactDAO.getContactById(id);
    }

    @Override
    public Person getPersonById(int id) {
        return personDAO.getPersonById(id);
    }

    @Override
    public void updatePerson(Person person) {
        personDAO.updatePerson(person);
    }


    @Override
    public void updateContactById() {

    }

    @Override
    public void deleteContactById(int personId) {
        personDAO.deletePersonById(personId);
    }
}
