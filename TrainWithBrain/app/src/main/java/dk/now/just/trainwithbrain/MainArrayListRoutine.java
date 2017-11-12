package dk.now.just.trainwithbrain;

import java.util.Date;

/**
 * Created by Mir on 11/11/2017.
 */

public class MainArrayListRoutine implements java.io.Serializable {  // allows to serialize

    private String name;
    private Date date;

    public MainArrayListRoutine(String name, Date date) {
        this.date = date;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
}


