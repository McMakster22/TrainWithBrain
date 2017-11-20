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

    private String weekday1;
    private String weekday2;
    private String muscLeGroup1;
    private String muscLeGroup2;
    private String exercise1;
    private String exercise2;
    private String exercise3;
    private String exercise4;
    private int set1;
    private int set2;
    private int set3;
    private int set4;
    private int rep1;
    private int rep2;
    private int rep3;
    private int rep4;



    public MainArrayListRoutine(String name, String date, int id,
    String weekday1, String weekday2, String muscLeGroup1, String muscLeGroup2,
    String exercise1, String exercise2, String exercise3, String exercise4,
    int set1, int set2, int set3, int set4, int rep1, int rep2, int rep3, int rep4


    ) {

        this.date = date;
        this.name = name;
        this.id = id;

        this.weekday1= weekday1;
        this.weekday2= weekday2;
        this.muscLeGroup1 = muscLeGroup1;
        this.muscLeGroup2 = muscLeGroup2;
        this.exercise1 = exercise1;
        this.exercise2 = exercise2;
        this.exercise3 = exercise3;
        this.exercise4 = exercise4;
        this.set1 = set1;
        this.set2 = set2;
        this.set3 = set3;
        this.set4 = set4;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.rep3 = rep3;
        this.rep4 = rep4;

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


    public String getWeekday1() {
        return weekday1;
    }

    public String getWeekday2() {
        return weekday2;
    }

    public String getMuscLeGroup1() {
        return muscLeGroup1;
    }

    public String getMuscLeGroup2() {
        return muscLeGroup2;
    }

    public String getExercise1() {
        return exercise1;
    }

    public String getExercise2() {
        return exercise2;
    }

    public String getExercise3() {
        return exercise3;
    }

    public String getExercise4() {
        return exercise4;
    }

    public int getRep2() {
        return rep2;
    }

    public int getRep3() {
        return rep3;
    }

    public int getRep4() {
        return rep4;
    }

    public int getRep1() {
        return rep1;
    }

    public int getSet1() {
        return set1;
    }

    public int getSet2() {
        return set2;
    }

    public int getSet3() {
        return set3;
    }

    public int getSet4() {
        return set4;
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


