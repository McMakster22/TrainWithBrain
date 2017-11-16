package dk.now.just.trainwithbrain;

import java.util.ArrayList;

/**
 * Created by Mir on 11/14/2017.
 */

public class Ssingl {
    private static  Ssingl mInstance;
    private ArrayList<MainArrayListRoutine> list = null;

    public static Ssingl getInstance() {
        if(mInstance == null)
            mInstance =new Ssingl();
        return mInstance;
    }

    private Ssingl() {
        list = new ArrayList<MainArrayListRoutine>();
    }
    public ArrayList<MainArrayListRoutine> getArray(){
        return this.list;
    }
    public void addToArray(MainArrayListRoutine value){
        list.add(value);
    }

}
