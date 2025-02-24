package Java_Contact_List;

import java.util.Collections;
import java.util.LinkedList;

public class Agenda {
    LinkedList<Contact> agenda = new LinkedList<>();
    
    public LinkedList<Contact> getAgenda() {
        return agenda;
    }

    public boolean addContact(Contact c){
        return agenda.add(c);
    }
    
    public boolean removeContact(String name){
        if (agenda.contains(new Contact(name))){
            return agenda.remove(new Contact(name));
        }
        return false;
    }
    
    public void listContacts(){
        for (Contact contact : agenda) {
            System.out.println(contact);
        }
    }
    
    public LinkedList<Contact> searchContact(String name){
        LinkedList<Contact> contacts = new LinkedList<>();
        
        for (Contact contact : agenda) {
            if (contact.getName().contains(name)){
                contacts.add(contact);
            }
        }
        return contacts;
    }
    
    public void orderContacts(){
        Collections.sort(agenda);
    }

}
