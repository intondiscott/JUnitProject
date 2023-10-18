public class Contact {
    private String ID = "1234567890";
    private String firstName = "scotty";
    private String lastName = "Intondi";
    private String phoneNumber = "1284567890";
    private String address = "123 Fake St";

    public String getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.length() > 10){
            throw new IllegalArgumentException("Field can't be empty or over 10 characters...");
        }
        this.firstName = firstName;

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.length() > 10){
            throw new IllegalArgumentException("lastName can't be null and can't be greater than 10 characters...");
        }
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber == null || phoneNumber.length() != 10){
            throw new IllegalArgumentException("number must not be null and 10 digits long...");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30){
            throw new IllegalArgumentException("address can't be null and can't be greater than 30 characters...");
        }
        this.address = address;
    }
public Contact(String ID){
    if (ID == null || ID.length() > 10) {
        throw new IllegalArgumentException("ID can't be null and can't be greater than 10 characters...");
    }
    this.ID = ID;
}
    public Contact(String ID, String firstName, String lastName, String phoneNumber, String address) {
        if (ID == null || ID.length() > 10) {
            throw new IllegalArgumentException("ID can't be null and can't be greater than 10 characters...");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("firstName can't be null and can't be greater than 10 characters...");
        }
        if(lastName == null || lastName.length() > 10){
            throw new IllegalArgumentException("lastName can't be null and can't be greater than 10 characters...");
        }
        if(phoneNumber == null || phoneNumber.length() != 10){
            throw new IllegalArgumentException("number must not be null and 10 digits long...");
        }
        if (address == null || address.length() > 30){
            throw new IllegalArgumentException("address can't be null and can't be greater than 30 characters...");
        }
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = this.getPhoneNumber();
        this.address = address;
    }
}

