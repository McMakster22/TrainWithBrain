package dk.now.just.trainwithbrain;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;

import static android.os.Build.VERSION_CODES.M;
import static dk.now.just.trainwithbrain.R.id.addName;


public class AddRoutine extends AppCompatActivity implements java.io.Serializable {

   // Date currentTime = Calendar.getInstance().getTime();

    EditText addN;
    Button btn;
    ArrayList<MainArrayListRoutine> arrayList;
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
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

    }

        View.OnClickListener add = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addN = (EditText) findViewById(addName);
                Ssingl.getInstance().getArray().add(new MainArrayListRoutine(addN.getText().toString(), reportDate, Ssingl.getInstance().getArray().size() ));
                Intent intent = new Intent(AddRoutine.this,MainActivity.class);
                intent.putExtra("arrayList",arrayList);
                startActivity(intent);
            }

        };



    }



