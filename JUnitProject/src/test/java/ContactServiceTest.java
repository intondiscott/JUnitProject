import org.junit.jupiter.api.*;

//TODO ContactServiceTest ✓
class ContactServiceTest {
    String ID, firstName, lastName, phoneNumber, address;
    ContactService cs;
    Contact contact;

    @BeforeEach
    void init(){
        ID = "123456789";
        firstName = "Scotty";
        lastName = "Intondi";
        phoneNumber = "202-455-9898";
        address = "123 Fake st";
        cs = new ContactService();
        contact = new Contact(ID);
    }

    @Test
    @DisplayName("Testing adding contacts")
    void testAddContact() {
        cs.addContact();
        cs.showAllContacts();
    }

    @Test
    @DisplayName("Testing updating first name")
    void updateFirstName(){
        cs.addContact();
        for(Contact contact: cs.contacts){
           cs.updateFirstName(contact.getID(),"Lisa");
            Assertions.assertThrows(IllegalArgumentException.class, ()->{
                cs.updateFirstName(contact.getID(),"SomeLongNAmeHere");
            });
        }
        cs.showAllContacts();

    }
    @Test
    @DisplayName("Testing updating last name")
    void updateLastName(){
        cs.addContact();
        for(Contact contact: cs.contacts){
            cs.updateLastName(contact.getID(),"Smith");
            Assertions.assertThrows(IllegalArgumentException.class, ()->{
                cs.updateLastName(contact.getID(),"SomeLongNAmeHere");
            });
        }
        cs.showAllContacts();
    }
    @Test
    @DisplayName("Testing updating phone number")
    void updatePhoneNumber(){
        cs.addContact();
        for(Contact contact: cs.contacts){
            cs.updatePhoneNumber(contact.getID(), phoneNumber.replaceAll("-",""));
            Assertions.assertThrows(IllegalArgumentException.class, ()->{
                cs.updatePhoneNumber(contact.getID(),"1-203-123-3433".replaceAll("-",""));
            });
        }
        cs.showAllContacts();
    }
    @Test
    @DisplayName("Testing updating address")
    void updateAddress(){
        cs.addContact();
        for(Contact contact: cs.contacts){
            cs.updateAddress(contact.getID(),"2622623123");
            Assertions.assertThrows(IllegalArgumentException.class, ()->{
                cs.updateAddress(contact.getID(),address + "some more text here to cause an error");
            });
        }
        cs.showAllContacts();
    }
    @Test
    @DisplayName("Testing deleting contact")
    void testDeleteContact(){
        cs.addContact();
        String newID = "0";
        for(Contact contact: cs.contacts){
            newID = contact.getID();
            Assertions.assertThrows(IllegalArgumentException.class, ()->{
                cs.deleteContact(ID);
            });
        }
        cs.addContact();
        cs.deleteContact(newID);
        cs.showAllContacts();
    }
}