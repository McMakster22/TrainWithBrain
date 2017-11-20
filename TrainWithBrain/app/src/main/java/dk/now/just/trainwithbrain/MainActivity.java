package dk.now.just.trainwithbrain;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.os.Build.VERSION_CODES.M;
import static android.support.v7.widget.AppCompatDrawableManager.get;
import static android.webkit.ConsoleMessage.MessageLevel.LOG;
import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    Date currentTime = Calendar.getInstance().getTime();
    MainCustomAdapter customAdapeter;
    ListView listView;
    Button btn;
    Button delete;

    ArrayList<MainArrayListRoutine> arrayList;


    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    //DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);

    // Get the date today using Calendar object.
    Date today = Calendar.getInstance().getTime();
    // Using DateFormat format method we can create a string
// representation of a date with the defined format.
    String reportDate = df.format(today);

    /*Intent intent = new Intent(MainActivity.this, AddRoutine.class);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // receiving values from database and uploading to adapter
        DbClass dbclass = new DbClass(this);
        SQLiteDatabase db = dbclass.getWritableDatabase();


        String[] projection = {
                DBContractClass.RoutinesEntry.ID,
                DBContractClass.RoutinesEntry.NAME,
                DBContractClass.RoutinesEntry.DATE,
                DBContractClass.RoutinesEntry.WEEKDAY1,
                DBContractClass.RoutinesEntry.WEEKDAY2,
                DBContractClass.RoutinesEntry.MuscleGroup1,
                DBContractClass.RoutinesEntry.MuscleGroup2,
                DBContractClass.RoutinesEntry.Exercise1,
                DBContractClass.RoutinesEntry.Exercise2,
                DBContractClass.RoutinesEntry.Exercise3,
                DBContractClass.RoutinesEntry.Exercise4,
                DBContractClass.RoutinesEntry.Set1,
                DBContractClass.RoutinesEntry.Set2,
                DBContractClass.RoutinesEntry.Set3,
                DBContractClass.RoutinesEntry.Set4,
                DBContractClass.RoutinesEntry.Rep1,
                DBContractClass.RoutinesEntry.Rep2,
                DBContractClass.RoutinesEntry.Rep3,
                DBContractClass.RoutinesEntry.Rep4

        };
        Cursor cursor = db.query(
                DBContractClass.RoutinesEntry.TABLE_NAME, projection,
                null, null, null, null, null
        );
        if (Ssingl.getInstance().getArray().size() == 0) {
            try {
                int idColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.ID);
                int nameColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.NAME);
                int dateColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.DATE);
                int weekColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.WEEKDAY1);
                int week2ColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.WEEKDAY2);
                int muscle1ColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.MuscleGroup1);
                int muscle2ColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.MuscleGroup2);
                int ex1ColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.Exercise1);
                int ex2ColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.Exercise2);
                int ex3ColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.Exercise3);
                int ex4ColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.Exercise4);
                int set1ColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.Set1);
                int set2ColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.Set2);
                int set3ColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.Set3);
                int set4ColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.Set4);
                int rep1ColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.Rep1);
                int rep2ColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.Rep2);
                int rep3ColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.Rep3);
                int rep4ColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.Rep4);
                while (cursor.moveToNext()) {
                    int currentId = cursor.getInt(idColumnIndex);
                    String currentName = cursor.getString(nameColumnIndex);
                    String curentDate = cursor.getString(dateColumnIndex);
                    String curentWorkDay = cursor.getString(weekColumnIndex);
                    String curentWorkDay2 = cursor.getString(week2ColumnIndex);
                    String curentMuscle1 = cursor.getString(muscle1ColumnIndex);
                    String curentMuscle2 = cursor.getString(muscle2ColumnIndex);
                    String curentEx1 = cursor.getString(ex1ColumnIndex);
                    String curentEx2 = cursor.getString(ex2ColumnIndex);
                    String curentEx3 = cursor.getString(ex3ColumnIndex);
                    String curentEx4 = cursor.getString(ex4ColumnIndex);
                    int curentSet1 = cursor.getInt(set1ColumnIndex);
                    int curentSet2 = cursor.getInt(set2ColumnIndex);
                    int curentSet3 = cursor.getInt(set3ColumnIndex);
                    int curentSet4 = cursor.getInt(set4ColumnIndex);
                    int curentRep1 = cursor.getInt(rep1ColumnIndex);
                    int curentRep2 = cursor.getInt(rep2ColumnIndex);
                    int curentRep3 = cursor.getInt(rep3ColumnIndex);
                    int curentRep4 = cursor.getInt(rep4ColumnIndex);
                    Ssingl.getInstance().getArray().add(new MainArrayListRoutine( currentName, curentDate, currentId,curentWorkDay,curentWorkDay2,curentMuscle1,curentMuscle2,curentEx1,curentEx2,curentEx3,curentEx4,curentSet1
                    ,curentSet2,curentSet3,curentSet4,curentRep1,curentRep2,curentRep3,curentRep4));

                }


            } finally {
                cursor.close();
            }
        }
        insert();


        arrayList = Ssingl.getInstance().getArray();
        customAdapeter = new MainCustomAdapter(this, arrayList);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(customAdapeter);

        Button delete;

        View.OnClickListener addClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddRoutine.class);
                intent.putExtra("arrayList", arrayList);
                startActivity(intent);
            }
        };


        //DETAILED ITEM LOOK WHEN CLICKING ON ROUTINE
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, View view, int i, long l) {

                TextView nameTextView = (TextView) findViewById(R.id.Ex1);
                //view.getTag();
                // int j =(int)view.getTag();


                for (int z = 0; z <= arrayList.size(); z++) {

                    if (arrayList.get(z).getId() == i) {
                        String day = arrayList.get(z).getWeekday1();
                        String day2 = arrayList.get(z).getWeekday2();

                        String muscle = arrayList.get(z).getMuscLeGroup1();
                        String muscle2 = arrayList.get(z).getMuscLeGroup2();

                        String ex = arrayList.get(z).getExercise1();
                        String ex2 = arrayList.get(z).getExercise2();
                        String ex3 = arrayList.get(z).getExercise3();
                        String ex4 = arrayList.get(z).getExercise4();

                        int set = arrayList.get(z).getSet1();
                        int set2 = arrayList.get(z).getSet2();
                        int set3 = arrayList.get(z).getSet3();
                        int set4 = arrayList.get(z).getSet4();

                        int rep = arrayList.get(z).getRep1();
                        int rep2 = arrayList.get(z).getRep2();
                        int rep3 = arrayList.get(z).getRep3();
                        int rep4 = arrayList.get(z).getRep4();

                        Intent intent = new Intent(MainActivity.this, Routines.class);

                        intent.putExtra("day", day);
                        intent.putExtra("day2", day2);

                        intent.putExtra("muscle", muscle);
                        intent.putExtra("muscle2", muscle2);

                        intent.putExtra("set", set);
                        intent.putExtra("set2", set2);
                        intent.putExtra("set3", set3);
                        intent.putExtra("set4", set4);

                        intent.putExtra("rep", rep);
                        intent.putExtra("rep2", rep2);
                        intent.putExtra("rep3", rep3);
                        intent.putExtra("rep4", rep4);


                        intent.putExtra("exercise", ex);
                        intent.putExtra("exercise2", ex2);
                        intent.putExtra("exercise3", ex3);
                        intent.putExtra("exercise4", ex4);

                        startActivity(intent);

                    }
                }




//                Log.d("Tag", i + "");
//                adapterView.getItemAtPosition(i);

//                Button delete = (Button) view.findViewById(R.id.delete);
//                delete.getTag();
            }

        });
//
//
////                long viewId = view.getId();
////                if(viewId == R.id.delete){
////                    Toast.makeText(MainActivity.this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
////                }
//
//
//
////                if (== Ssingl.getInstance().getArray().get(i).getId()){
////
////
////                }
//
//
//
//
////                Toast.makeText(MainActivity.this,
////                        "Item in position " + i + " clicked", Toast.LENGTH_LONG).show();
//
//
//
//
//


        // adapter Implementation // adapter Implementation

       /* arrayList = new ArrayList<MainArrayListRoutine>();
        customAdapeter = new MainCustomAdapter (this, arrayList);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(customAdapeter); // adapter Implementation*/

        /*arrayList = (ArrayList<MainArrayListRoutine>) getIntent().getSerializableExtra("arrayList");*/
       /* arrayList.add(new MainArrayListRoutine(stuff, currentTime));
        arrayList.add(new MainArrayListRoutine("Muscle Up Routine", currentTime));*/


        btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(addClick);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

    }

    ;


    //Iteration with the Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:


            case R.id.action_add:

                Intent intent = new Intent(MainActivity.this, AddRoutine.class);
                intent.putExtra("arrayList", arrayList);
                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
//        bul = true;
//        SharedPreferences pref = getSharedPreferences("Mypref", MODE_PRIVATE);
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putBoolean("tru",bul);
//        editor.apply();


    }


    @Override
    protected void onResume() {
        super.onResume();


    }

//    View.OnClickListener addClick = new View.OnClickListener(){
//        @Override
//        public void onClick(View view) {
//            Intent intent = new Intent(MainActivity.this,AddRoutine.class);
//            intent.putExtra("arrayList",arrayList);
//            startActivity(intent);
//        }
//    };

    public void insert() {

        if (Ssingl.getInstance().getArray().size() != 0) {

            DbClass dbclass = new DbClass(this);
            SQLiteDatabase db = dbclass.getWritableDatabase();
            ContentValues values = new ContentValues();
            for (int i = 0; i < Ssingl.getInstance().getArray().size(); i++) {
                values.put(DBContractClass.RoutinesEntry.ID, Ssingl.getInstance().getArray().get(i).getId());
                values.put(DBContractClass.RoutinesEntry.NAME, Ssingl.getInstance().getArray().get(i).getName());
                values.put(DBContractClass.RoutinesEntry.DATE, Ssingl.getInstance().getArray().get(i).getDate1());
                values.put(DBContractClass.RoutinesEntry.WEEKDAY1, Ssingl.getInstance().getArray().get(i).getWeekday1());
                values.put(DBContractClass.RoutinesEntry.WEEKDAY2, Ssingl.getInstance().getArray().get(i).getWeekday2());
                values.put(DBContractClass.RoutinesEntry.MuscleGroup1, Ssingl.getInstance().getArray().get(i).getMuscLeGroup1());
                values.put(DBContractClass.RoutinesEntry.MuscleGroup2, Ssingl.getInstance().getArray().get(i).getMuscLeGroup2());
                values.put(DBContractClass.RoutinesEntry.Exercise1, Ssingl.getInstance().getArray().get(i).getExercise1());
                values.put(DBContractClass.RoutinesEntry.Exercise2, Ssingl.getInstance().getArray().get(i).getExercise2());
                values.put(DBContractClass.RoutinesEntry.Exercise3, Ssingl.getInstance().getArray().get(i).getExercise3());
                values.put(DBContractClass.RoutinesEntry.Exercise4, Ssingl.getInstance().getArray().get(i).getExercise4());
                values.put(DBContractClass.RoutinesEntry.Set1, Ssingl.getInstance().getArray().get(i).getSet1());
                values.put(DBContractClass.RoutinesEntry.Set2, Ssingl.getInstance().getArray().get(i).getSet2());
                values.put(DBContractClass.RoutinesEntry.Set3, Ssingl.getInstance().getArray().get(i).getSet3());
                values.put(DBContractClass.RoutinesEntry.Set4, Ssingl.getInstance().getArray().get(i).getSet4());
                values.put(DBContractClass.RoutinesEntry.Rep1, Ssingl.getInstance().getArray().get(i).getRep1());
                values.put(DBContractClass.RoutinesEntry.Rep2, Ssingl.getInstance().getArray().get(i).getRep2());
                values.put(DBContractClass.RoutinesEntry.Rep3, Ssingl.getInstance().getArray().get(i).getRep3());
                values.put(DBContractClass.RoutinesEntry.Rep4, Ssingl.getInstance().getArray().get(i).getRep4());
                db.insert(DBContractClass.RoutinesEntry.TABLE_NAME, null, values);
            }


        }
    }

    public void onClick(View view) {
        //deleting from database and the array
        view.getTag();
        int j = (int) view.getTag();
        int i = Ssingl.getInstance().getArray().size() - 1;
        //

        DbClass dbclass = new DbClass(this);
        SQLiteDatabase db = dbclass.getWritableDatabase();
        String selection = DBContractClass.RoutinesEntry.ID + " = ?";
        String[] selectionArgs = {j + ""};
        db.delete(DBContractClass.RoutinesEntry.TABLE_NAME, selection, selectionArgs);
//        for (int x=0; x <= Ssingl.getInstance().getArray().size(); x++){
//            if (x==j){
//            Ssingl.getInstance().getArray().remove(i).getId();
//            }
//
//        }


        if (j == i) {
            Ssingl.getInstance().getArray().remove(j).getId();

        } else if (j < i) {

            Ssingl.getInstance().getArray().remove(j).getId();
        } else if (j > i) {
            Ssingl.getInstance().getArray().remove(i).getId();

        }

        finish();
        startActivity(getIntent());


    }


}
