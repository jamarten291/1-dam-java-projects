package Java_Contact_List;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Menu {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        int opt;

        do {
            String name = "";
            String phone = "";
            String address = "";
            System.out.printf("""
                               ============ MENU ===========
                               
                               1.- Add new contact.
                               2.- Delete a contact.
                               3.- Search for a contact.
                               4.- List of contacts.
                               5.- Sort contacts alphabetically by name.
                               6.- Exit.
                               %-4s""", "->");
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1:
                    System.out.println("Enter the name of the new contact");
                    name = sc.nextLine();

                    System.out.println("Enter their phone number");
                    phone = sc.nextLine();

                    System.out.println("Enter their address");
                    address = sc.nextLine();

                    agenda.addContact(new Contact(name, phone, address));
                    break;
                case 2:
                    System.out.println("Enter the name of the contact you want to delete");
                    name = sc.nextLine();

                    System.out.printf("The contact %s %n",
                            (agenda.removeContact(name) ? "has been successfully deleted"
                                    : "could not be deleted or does not exist"));
                    break;
                case 3:
                    System.out.println("Enter the name of the contact you want to search for");
                    name = sc.nextLine();

                    LinkedList<Contact> searched = agenda.searchContact(name);

                    if (searched.isEmpty()) {
                        System.out.println("No contacts found");
                    } else {
                        ListIterator<Contact> itCon = searched.listIterator();

                        while (itCon.hasNext()) {
                            System.out.print((Contact) itCon.next());
                        }
                    }
                    break;
                case 4:
                    agenda.listContacts();
                    break;
                case 5:
                    agenda.orderContacts();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("That character is not valid");
            }

        } while (opt != 6);
    }
}

