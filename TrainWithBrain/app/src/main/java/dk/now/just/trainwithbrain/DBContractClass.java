package dk.now.just.trainwithbrain;

import android.provider.BaseColumns;

/**
 * Created by Mir on 11/14/2017.
 */

public class DBContractClass {

    private DBContractClass() {
    }

    public class RoutinesEntry implements BaseColumns {

        public static final String TABLE_NAME = "training_Routines";
        public static final String ID = "id";
        public static final String DATE = "date";
        public static final String NAME = "name";

        public static final String WEEKDAY1 = "weekday1";
        public static final String WEEKDAY2 = "weekday2";
        public static final String MuscleGroup1 = "musclegroup1";
        public static final String MuscleGroup2 = "musclegroup2";
        public static final String Exercise1 = "exercise1";
        public static final String Exercise2 = "exercise2";
        public static final String Exercise3 = "exercise3";
        public static final String Exercise4 = "exercise4";
        public static final String Set1 = "set1";
        public static final String Set2 = "set2";
        public static final String  Set3 = "set3";
        public static final String Set4 = "set4";
        public static final String Rep1 = "rep1";
        public static final String Rep2 = "rep2";
        public static final String Rep3 = "rep3";
        public static final String Rep4 = "rep4";


    }


}
