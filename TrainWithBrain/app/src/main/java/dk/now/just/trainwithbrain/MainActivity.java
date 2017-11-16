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

public class MainActivity extends AppCompatActivity  {

    Date currentTime = Calendar.getInstance().getTime();
    MainCustomAdapter customAdapeter;
    ListView listView;
    Button btn;
    Button delete;

    ArrayList <MainArrayListRoutine> arrayList ;


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
                DBContractClass.RoutinesEntry.DATE
        };
        Cursor cursor = db.query(
                DBContractClass.RoutinesEntry.TABLE_NAME,projection,
                null,null,null,null,null
        );
        if(Ssingl.getInstance().getArray().size()== 0) {
            try {
                int idColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.ID);
                int nameColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.NAME);
                int dateColumnIndex = cursor.getColumnIndex(DBContractClass.RoutinesEntry.DATE);

                while (cursor.moveToNext()) {
                    int currentId = cursor.getInt(idColumnIndex);
                    String currentName = cursor.getString(nameColumnIndex);
                    String curentDate = cursor.getString(dateColumnIndex);


                    Ssingl.getInstance().getArray().add(new MainArrayListRoutine( currentName, curentDate, currentId));

                }


            } finally {
                cursor.close();
            }
        }
        insert();




        arrayList = Ssingl.getInstance().getArray();
        customAdapeter = new MainCustomAdapter (this, arrayList);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(customAdapeter);

        Button delete;

        View.OnClickListener addClick = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddRoutine.class);
                intent.putExtra("arrayList",arrayList);
                startActivity(intent);
            }
        };

        View v;
        for(int i = 0;i<listView.getChildCount();i++ ){
            v = listView.getChildAt(i);
            delete = v.findViewById(R.id.delete);
            delete.setOnClickListener(addClick);

        }

        // adapter Implementation
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(final AdapterView<?> adapterView, View view, int i, long l) {
//                Log.d("Tag",  i+ "");
//                adapterView.getItemAtPosition(i);
//
//                delete = (Button) findViewById(R.id.delete);
//                delete.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        Toast.makeText(MainActivity.this, "Item in position clicked", Toast.LENGTH_LONG).show();
//                        //Toast.makeText(getContext(), "Row " + i + " was clicked!", Toast.LENGTH_SHORT).show();
//                    }
//
//
//                });
//            }
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
//        });


        // adapter Implementation // adapter Implementation

       /* arrayList = new ArrayList<MainArrayListRoutine>();
        customAdapeter = new MainCustomAdapter (this, arrayList);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(customAdapeter); // adapter Implementation*/

        /*arrayList = (ArrayList<MainArrayListRoutine>) getIntent().getSerializableExtra("arrayList");*/
       /* arrayList.add(new MainArrayListRoutine(stuff, currentTime));
        arrayList.add(new MainArrayListRoutine("Muscle Up Routine", currentTime));*/





        btn = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(addClick);

        Toolbar myToolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        };


        //Iteration with the Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:

                Intent intent = new Intent(MainActivity.this,AddRoutine.class);
                intent.putExtra("arrayList",arrayList);
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

    public void insert(){

        if(Ssingl.getInstance().getArray().size()!=0){

            DbClass dbclass = new DbClass(this);
            SQLiteDatabase db = dbclass.getWritableDatabase();
            ContentValues values = new ContentValues();
            for(int i=0;i<Ssingl.getInstance().getArray().size();i++) {
                values.put(DBContractClass.RoutinesEntry.ID, Ssingl.getInstance().getArray().get(i).getId());
                values.put(DBContractClass.RoutinesEntry.NAME, Ssingl.getInstance().getArray().get(i).getName());
                values.put(DBContractClass.RoutinesEntry.DATE, Ssingl.getInstance().getArray().get(i).getDate1());
              db.insert(DBContractClass.RoutinesEntry.TABLE_NAME,null,values);
            }


        }
    }





}
