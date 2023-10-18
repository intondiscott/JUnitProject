import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ContactService {
    List<Contact> contacts = new ArrayList<>();
    String uniqueID(){
        Random rand = new Random();
        int randomID = rand.nextInt(1000000000)+1;
        return String.valueOf(randomID);
    }

    void addContact(){
        Contact contact = new Contact(uniqueID());
        for(Contact id : contacts){
            if(id.getID().equals(uniqueID())){
                throw new IllegalArgumentException("ID Has to be unique to user...");
            }
        }
        contacts.add(contact);
        System.out.println("Contact has been added...\n" + "-".repeat(100));
    }
    void updateFirstName(String ID, String firstName){
        for(Contact contact: contacts){
            if(contact.getID().equals(ID)){
                contact.setFirstName(firstName);
                System.out.printf("First name at ID: %s has been updated...\n%s\n", ID, "-".repeat(100));
                break;
            }
            if(!Objects.equals(ID, contact.getID())){
                throw new IllegalArgumentException("First name cannot be updated because ID: " + ID +" is not in list");
            }
        }
    }
    void updateLastName(String ID, String lastName){
        for(Contact contact: contacts){
            if(contact.getID().equals(ID)){
                contact.setLastName(lastName);
                System.out.printf("Last name at ID: %s has been updated...\n%s\n", ID, "-".repeat(100));
                break;
            }
            if(!Objects.equals(ID, contact.getID())){
                throw new IllegalArgumentException("Last name cannot be updated because ID: " + ID +" is not in list");
            }
        }
    }
    void updatePhoneNumber(String ID, String phoneNumber){
        for(Contact contact: contacts){
            if(contact.getID().equals(ID)){
                contact.setPhoneNumber(phoneNumber);
                System.out.printf("Phone number at ID: %s has been updated...\n%s\n", ID, "-".repeat(100));
                break;
            }
            if(!Objects.equals(ID, contact.getID())){
                throw new IllegalArgumentException("Phone number cannot be updated because ID: " + ID +" is not in list");
            }
        }
    }
    void updateAddress(String ID, String address){
        for(Contact contact: contacts){
            if(contact.getID().equals(ID)){
                contact.setAddress(address);
                System.out.printf("Address at ID: %s has been updated...\n%s\n", ID, "-".repeat(100));
                break;
            }
            if(!Objects.equals(ID, contact.getID())){
                throw new IllegalArgumentException("Address cannot be updated because ID: " + ID +" is not in list");
            }
        }

    }
    void deleteContact(String ID){
        for(Contact contact: contacts){
            if(contact.getID().equals(ID)){
                contacts.remove(contact);
                System.out.printf("Contact at ID: %s has been deleted...\n%s\n", ID, "-".repeat(100));
                break;
            }
            if(!Objects.equals(ID, contact.getID())){
                throw new IllegalArgumentException("Contact at ID: " + ID + " cannot be deleted because it is not in list...\n"  + "-".repeat(100));
            }
        }
    }
    void showAllContacts() {
        for(Contact contact: contacts){
            System.out.println("{ " +
                    "\n\tID: " + contact.getID() +
                    ", \n\tFirst Name: " + contact.getFirstName()+
                    ", \n\tLast Name: " + contact.getLastName() +
                    ", \n\tPhone Number: " + contact.getPhoneNumber() +
                    ", \n\tAddress: " + contact.getAddress() +
                    "\n}" + ((contacts.indexOf(contact) < contacts.size()-1)?",":""));
        }
    }
}
