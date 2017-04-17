package is.hi.adal;

import com.jfoenix.controls.JFXTextField;
import com.sun.org.apache.xpath.internal.operations.Variable;
import javafx.scene.control.DatePicker;

/**
 * Created by Sjakke on 15/04/2017.
 */
public class Booking {

    private JFXTextField FirstName;
    private JFXTextField LastName;
    private DatePicker Birthday;
    private JFXTextField PhoneNumber;
    private JFXTextField PhoneSOS;


    private String emailAddress;

    private String name, PhoneNum, PeSOS;

    private Person() {

        name = FirstName.getText() + " " + LastName.getText();
        Birthday.getConverter();
        emailAddress = getEmailAddress(emailAddress);
        PhoneNum = PhoneNumber.getText();
        PeSOS = PhoneNumber.getText();
        return (name+Birthday+emailAddress+PhoneNum+PeSOS);

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

    public void setFirstName(JFXTextField firstName) {
        FirstName = firstName;
    }

    public void setLastName(JFXTextField lastName) {
        LastName = lastName;
    }

    public void setBirthday(DatePicker birthday) {
        Birthday = birthday;
    }

    public void setPhoneNumber(JFXTextField phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setPhoneSOS(JFXTextField phoneSOS) {
        PhoneSOS = phoneSOS;
    }
}