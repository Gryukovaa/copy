package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.entities.Person;
import web.entities.Contact;
import web.exception_handler.NoSuchPersonException;
import web.service.ContactAndPhonesService;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api")
public class ContactBookController {

    private final ContactAndPhonesService contactAndPhonesService;

    @Autowired
    public ContactBookController(ContactAndPhonesService contactAndPhonesService) {
        this.contactAndPhonesService = contactAndPhonesService;
    }


    // Contact list of persons and their numbers
    @GetMapping("/contacts")
    public List<Contact> showAllContacts(){
        return contactAndPhonesService.getContactsList();
    }



    // Contacts list of the selected person
    @GetMapping("/contacts/{id}")
    public List<Contact> showAllContactsOfPerson(@PathVariable int id){
        if(contactAndPhonesService.getPersonById(id) == null)
            throw new NoSuchPersonException("Where is no person with id= " + id + " in the DB");
        return contactAndPhonesService.getListPhonesOfPersonById(id);
    }



    // Adding new number by person id
    @PostMapping("/contacts")
    public Contact saveNewNumber(@Valid @RequestBody Contact contact){
        if(contactAndPhonesService.getPersonById(contact.getPerson().getPersonId()) == null)
            throw new NoSuchPersonException(
                    "Where is no person with id= " + (contact.getPerson().getPersonId()) + " in the DB");
        contactAndPhonesService.createСontact(contact);
        return contact;
    }


    // Change person
    @PutMapping(value = "/persons")
    public Person updateUser(@Valid @RequestBody Person person) {
        if(contactAndPhonesService.getPersonById(person.getPersonId()) == null)
            throw new NoSuchPersonException("Where is no person with id= " + person.getPersonId() + " in the DB");
        contactAndPhonesService.updatePerson(person);
        return person;
    }


    // Deleting contact
    @DeleteMapping("/contacts/{id}")
    public String deleteAllInfoByPersonId(@PathVariable int id){
        if(contactAndPhonesService.getPersonById(id) == null)
            throw new NoSuchPersonException("Where is no person with id= " + id + " in the DB");
        contactAndPhonesService.deleteContactById(id);
        return "successfully!";
    }


}
