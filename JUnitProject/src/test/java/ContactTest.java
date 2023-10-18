import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//TODO ContactTest ✓
class ContactTest {
    String ID,firstName, lastName, number, address, longID, longFirstName, longLastName, numberLengthNot10, longAddress;

    @BeforeEach
    void init(){
        ID = "1234567890";
        firstName = "Scotty";
        lastName = "Intondi";
        number = "1234567890";
        address = "123 Fake St";
        longID = "12345678910";
        longFirstName = "Scotty12345";
        longLastName = "Intondi1234";
        numberLengthNot10 = "12";
        longAddress = "1234567890 fake st apt123456789";
    }

    @Test
    @DisplayName("Test Contact ID too long")
    void testContactIDTooLong(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(longID, firstName, lastName, number, address);
        });
    }
    @Test
    @DisplayName("Test contact first name too long")
    void testContactFirstNameTooLong(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(ID, longFirstName, lastName, number, address);
        });
    }
    @Test
    @DisplayName("Test Contact last name too long")
    void testContactLastNameTooLong(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(ID, firstName, longLastName, number, address);
        });
    }
    @Test
    @DisplayName("Test contact number not 10 digits")
    void testContactNumberNot10Digits(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(ID, firstName, lastName, numberLengthNot10, address);
        });
    }
    @Test
    @DisplayName("Test Contact address too long")
    void testContactAddressTooLong(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(ID, firstName, lastName, number, longAddress);
        });
    }
}