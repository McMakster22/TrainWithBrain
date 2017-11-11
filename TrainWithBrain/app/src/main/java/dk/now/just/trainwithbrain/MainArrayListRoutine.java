package dk.now.just.trainwithbrain;

import java.util.Date;

/**
 * Created by Mir on 11/11/2017.
 */

public class MainArrayListRoutine {

    private String name;
    private Date date;

    public MainArrayListRoutine(String s, Date date) {
        this.date = date;
    }

    public MainArrayListRoutine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
}


