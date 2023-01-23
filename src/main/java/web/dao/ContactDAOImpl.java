package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.entities.Contact;
import web.entities.Person;


import java.util.List;

@Repository
public class ContactDAOImpl implements ContactDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ContactDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }




    @Override
    public List<Contact> getAllContacts() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Contact", Contact.class)
                .getResultList();
    }

    @Override
    public List<Contact> getListPhonesOfPersonById(int PersonId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Contact> query = session.createQuery("from Contact c left join fetch c.person p where p.personId=:id"
                , Contact.class);
        query.setParameter("id", PersonId);
        return query.getResultList();

    }

    @Override
    public Contact getContactById(int id) {
        return sessionFactory.getCurrentSession()
                .find(Contact.class, id);
    }

    @Override
    public void saveNewContact(Contact contact) {

    }

    @Override
    public void addPhoneNumberByPersonID(Contact contact) {
        Session session = sessionFactory.getCurrentSession();

        Contact contact1 = new Contact();
        contact1.setPhoneNumber(contact.getPhoneNumber());

        // set old Person's data to the new contact
        contact1.setPerson(
                session.get(Person.class, contact.getPerson().getPersonId())
        );

        session.save(contact1);

    }
    /*@Override
    public void saveNewContact(Contact contact) {
         Session session= sessionFactory.getCurrentSession();
         Query<Contact> query = session. ("from Contact c left join fetch c.person p where p.personId=:id"
                , Contact.class);
         query.setParameter("id", PersonId);


         Person person = contact.getPerson();
         person.addContactToList(contact);
    }*/


}
