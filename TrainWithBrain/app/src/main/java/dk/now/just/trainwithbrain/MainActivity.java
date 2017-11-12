package dk.now.just.trainwithbrain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.io.Serializable;
import java.util.Calendar;



import java.util.ArrayList;
import java.util.Date;

import static android.support.v7.widget.AppCompatDrawableManager.get;

public class MainActivity extends AppCompatActivity {

    Date currentTime = Calendar.getInstance().getTime();
    MainCustomAdapter customAdapeter;
    ListView listView;
    String stuff = "Shit";
    Button btn;
    ArrayList <MainArrayListRoutine> arrayList;
    /*Intent intent = new Intent(MainActivity.this, AddRoutine.class);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list_routines);

       // adapter Implementation // adapter Implementation
        arrayList = new ArrayList<MainArrayListRoutine>();
        arrayList.add(new MainArrayListRoutine(stuff,currentTime));
        arrayList.add(new MainArrayListRoutine("Muscle Up Routine",currentTime));

        customAdapeter = new MainCustomAdapter (this, arrayList);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(customAdapeter); // adapter Implementation



        btn = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(addClick);

    }
    View.OnClickListener addClick = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,AddRoutine.class);
            intent.putExtra("arrayList",arrayList);
            startActivity(intent);
        }
    };

}
