package is.hi.adal;

import java.util.ArrayList;

/**
 * Created by Alexander on 4/16/2017.
 */
public class FligtsData {
    private ArrayList<String> out = new ArrayList<> ();
    private ArrayList<String> home = new ArrayList<>();

    public ArrayList<String> getOut() {
        return out;
    }

    public void setOut(ArrayList<String> out) {
        this.out = out;
    }

    public ArrayList<String> getHome() {
        return home;
    }

    public void setHome(ArrayList<String> home) {
        this.home = home;
    }
}
