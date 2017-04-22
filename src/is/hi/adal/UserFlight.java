package is.hi.adal;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

/**
 * Created by Alexander on 21.4.2017.
 */
public class UserFlight extends RecursiveTreeObject<UserFlight> {
    private String from;
    private String to;
    private String date;
    private String fname;
    private String lname;
    UserFlight(String f, String t, String d, String fn, String ln){
        this.from = f;
        this.to = t;
        this.date = d;
        this.fname = fn;
        this.lname = ln;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
