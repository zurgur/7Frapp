package is.hi.adal;

import com.sun.org.apache.xpath.internal.operations.Variable;
import javafx.scene.control.DatePicker;

/**
 * Created by Sjakke on 15/04/2017.
 */
public class Booking {

    private String FirstName;
    private String LastName;
    private DatePicker Birthday;
    private Variable PhoneNumber;
    private Variable PhoneSOS;


    private String emailAddress;

    private String name;

    private Person(FirstName, LastName, Birthday) {

        name = FirstName + " " + LastName;
        Birthday.getConverter();
        emailAddress = getEmailAddress(emailAddress);
    }

    private String getEmailAddress(String emailAddress) {
        getEmailAddress(this.emailAddress);
        return emailAddress;
    }

    private DatePicker getAge() {
        new DatePicker();
        return Birthday;
    }
    public void Person() {
        System.out.println(name + ", " + this.getAge());
    }

    public Variable getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(Variable phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Variable getPhoneSOS() {
        return PhoneSOS;
    }

    public void setPhoneSOS(Variable phoneSOS) {
        PhoneSOS = phoneSOS;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setBirthday(DatePicker birthday) {
        Birthday = birthday;
    }
}