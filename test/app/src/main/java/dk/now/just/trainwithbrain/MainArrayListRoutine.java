package dk.now.just.trainwithbrain;

import android.content.Intent;

import java.util.ArrayList;
import java.util.Date;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by Mir on 11/11/2017.
 */

public class MainArrayListRoutine implements java.io.Serializable {  // allows to serialize

    private String name;
    private String date;
    private int id;

    public MainArrayListRoutine(String name, String date, int id) {
        this.date = date;
        this.name = name;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public String getDate1() {
        return date;
    }

    public int getId() {
        return id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}


