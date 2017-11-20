package dk.now.just.trainwithbrain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static dk.now.just.trainwithbrain.R.id.Exercise1;
import static dk.now.just.trainwithbrain.R.id.Exercise2;
import static dk.now.just.trainwithbrain.R.id.Exercise3;
import static dk.now.just.trainwithbrain.R.id.Exercise4;
import static dk.now.just.trainwithbrain.R.id.MuscleGroup1;
import static dk.now.just.trainwithbrain.R.id.MuscleGroup2;
import static dk.now.just.trainwithbrain.R.id.Rep1;
import static dk.now.just.trainwithbrain.R.id.Rep2;
import static dk.now.just.trainwithbrain.R.id.Rep3;
import static dk.now.just.trainwithbrain.R.id.Rep4;
import static dk.now.just.trainwithbrain.R.id.Set1;
import static dk.now.just.trainwithbrain.R.id.Set3;
import static dk.now.just.trainwithbrain.R.id.Set4;
import static dk.now.just.trainwithbrain.R.id.Sets2;
import static dk.now.just.trainwithbrain.R.id.name;
import static dk.now.just.trainwithbrain.R.id.spinner;


public class AddRoutine extends MainActivity implements java.io.Serializable {

    // Date currentTime = Calendar.getInstance().getTime();

    EditText addN;
    Button btn;
    ArrayList<MainArrayListRoutine> arrayList;
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");


    Spinner weekoftheday1;
    Spinner weekoftheday2;
    EditText musclegroup1;
    EditText musclegroup2;
    EditText exercise1;
    EditText exercise2;
    EditText exercise3;
    EditText exercise4;
    EditText set1;
    EditText set2;
    EditText set3;
    EditText set4;
    EditText rep1;
    EditText rep2;
    EditText rep3;
    EditText rep4;



    //DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);

    // Get the date today using Calendar object.
    Date today = Calendar.getInstance().getTime();
    // Using DateFormat format method we can create a string
// representation of a date with the defined format.
    String reportDate = df.format(today);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_routine);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        arrayList = (ArrayList<MainArrayListRoutine>) getIntent().getSerializableExtra("arrayList");

        btn = (Button) findViewById(R.id.button3);
        btn.setOnClickListener(add);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.DaysOfWeek, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);

    }

    View.OnClickListener add = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            addN = (EditText) findViewById(name);
            weekoftheday1 =(Spinner) findViewById(spinner);
            weekoftheday2 = (Spinner) findViewById(spinner);
            musclegroup1 = (EditText) findViewById(MuscleGroup1);
            musclegroup2 = (EditText) findViewById(MuscleGroup2);
            exercise1 = (EditText) findViewById(Exercise1);
            exercise2 = (EditText) findViewById(Exercise2);
            exercise3 = (EditText) findViewById(Exercise3);
            exercise4 = (EditText) findViewById(Exercise4);
            set1 = (EditText) findViewById(Set1);
            set2 = (EditText) findViewById(Sets2);
            set3 = (EditText) findViewById(Set3);
            set4 = (EditText) findViewById(Set4);
            rep1 = (EditText) findViewById(Rep1);
            rep2 = (EditText) findViewById(Rep2);
            rep3 = (EditText) findViewById(Rep3);
            rep4 = (EditText) findViewById(Rep4);


            Ssingl.getInstance().getArray().add(new MainArrayListRoutine(addN.getText().toString(), reportDate, Ssingl.getInstance().getArray().size(),weekoftheday1.getSelectedItem().toString(),
                    weekoftheday2.getSelectedItem().toString(), musclegroup1.getText().toString(), musclegroup2.getText().toString(),exercise1.getText().toString(),
                    exercise2.getText().toString(),exercise3.getText().toString(), exercise4.getText().toString(),Integer.parseInt(set1.getText().toString()),
                    Integer.parseInt(set2.getText().toString()), Integer.parseInt(set3.getText().toString()),Integer.parseInt(set4.getText().toString()),
                    Integer.parseInt(rep1.getText().toString()),Integer.parseInt(rep2.getText().toString()),
                    Integer.parseInt(rep3.getText().toString()),Integer.parseInt(rep4.getText().toString())));
            Intent intent = new Intent(AddRoutine.this, MainActivity.class);
            intent.putExtra("arrayList", arrayList);
            startActivity(intent);
        }

    };


}



