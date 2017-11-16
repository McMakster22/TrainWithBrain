package dk.now.just.trainwithbrain;

import android.provider.BaseColumns;

/**
 * Created by Mir on 11/14/2017.
 */

public class DBContractClass {

    private DBContractClass(){}

    public class RoutinesEntry implements BaseColumns{

    public static final String TABLE_NAME = "training_Routines";
    public static final String  ID = "id";
    public static final String DATE = "date";
    public static final String NAME = "name";
    }


}
