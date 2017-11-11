package dk.now.just.trainwithbrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Calendar;



import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Date currentTime = Calendar.getInstance().getTime();
    MainCustomAdapter customAdapeter;
    ListView listView;
String stuff = "Shit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list_routines);

        final ArrayList<MainArrayListRoutine> arrayList = new ArrayList<MainArrayListRoutine>();
        arrayList.add(new MainArrayListRoutine(stuff,currentTime));
        arrayList.add(new MainArrayListRoutine("Muscle Up Routine",currentTime));

        customAdapeter = new MainCustomAdapter (this, arrayList);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(customAdapeter);

    }
}
