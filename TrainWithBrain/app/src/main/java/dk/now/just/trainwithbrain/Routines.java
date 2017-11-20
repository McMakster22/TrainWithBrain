package dk.now.just.trainwithbrain;

import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class Routines extends MainActivity {
    TextView day;
    TextView day2;

    TextView muscleGroup;
    TextView muscleGroup2;

    TextView exercise1;
    TextView exercise2;
    TextView exercise3;
    TextView exercise4;

    TextView set;
    TextView set2;
    TextView set3;
    TextView set4;

    TextView rep;
    TextView rep2;
    TextView rep3;
    TextView rep4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routines);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        day = (TextView) findViewById(R.id.Nday);
        day.setText(getIntent().getStringExtra("day"));
        day2 = (TextView) findViewById(R.id.Nday2);
        day2.setText(getIntent().getStringExtra("day2"));

        muscleGroup = (TextView) findViewById(R.id.muscleG);
        muscleGroup.setText(getIntent().getStringExtra("muscle"));
        muscleGroup2 = (TextView) findViewById(R.id.muscleG2);
        muscleGroup2.setText(getIntent().getStringExtra("muscle2"));

        exercise1 = (TextView)findViewById(R.id.Ex1);
        exercise1.setText(getIntent().getStringExtra("exercise"));
        exercise2 = (TextView)findViewById(R.id.Ex2);
        exercise2.setText(getIntent().getStringExtra("exercise2"));
        exercise3 = (TextView)findViewById(R.id.Ex3);
        exercise3.setText(getIntent().getStringExtra("exercise3"));
        exercise4 = (TextView)findViewById(R.id.Ex4);
        exercise4.setText(getIntent().getStringExtra("exercise4"));

        set = (TextView) findViewById(R.id.Nset1);
        int syt =  getIntent().getIntExtra("set",0 );
        set.setText(""+syt);
        set2 = (TextView) findViewById(R.id.Nset2);
        int syt2 =getIntent().getIntExtra("set2",0 );
        set2.setText(""+syt2);
        set3 = (TextView) findViewById(R.id.Nset3);
        int syt3 =getIntent().getIntExtra("set3",0 );
        set3.setText(""+syt3);
        set4 = (TextView) findViewById(R.id.Nset4);
        int syt4 =getIntent().getIntExtra("set4",0 );
        set4.setText(""+syt4);

        rep = (TextView) findViewById(R.id.Nrow1);
        int ryt =getIntent().getIntExtra("rep",0 );
        rep.setText(""+ryt);
        rep2 = (TextView) findViewById(R.id.Nrow2);
        int ryt2 =getIntent().getIntExtra("rep2",0 );
        rep2.setText(""+ryt2);
        rep3 = (TextView) findViewById(R.id.Nrow3);
        int ryt3 =getIntent().getIntExtra("rep3",0 );
        rep3.setText(""+ryt3);
        rep4 = (TextView) findViewById(R.id.Nrow4);
        int ryt4 =getIntent().getIntExtra("rep4",0 );
        rep4.setText(""+ryt4);






    }

}
