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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;

import static android.os.Build.VERSION_CODES.M;
import static dk.now.just.trainwithbrain.R.id.addName;


public class AddRoutine extends AppCompatActivity implements java.io.Serializable {

    Date currentTime = Calendar.getInstance().getTime();

    EditText addN;
    Button btn;
    ArrayList<MainArrayListRoutine> arrayList;

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
                arrayList.add(new MainArrayListRoutine(addN.getText().toString(), currentTime));
                Intent intent = new Intent(AddRoutine.this,MainActivity.class);
                intent.putExtra("arrayList",arrayList);
                startActivity(intent);
            }

        };



    }



