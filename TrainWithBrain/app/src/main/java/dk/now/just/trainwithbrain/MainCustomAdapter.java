package dk.now.just.trainwithbrain;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;


/**
 * Created by Mir on 11/11/2017.
 */

public class MainCustomAdapter extends  ArrayAdapter<MainArrayListRoutine> {



    public MainCustomAdapter (Activity context, ArrayList<MainArrayListRoutine> trainingroutines){
        super(context,0,trainingroutines);


    }



    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {

        View listItemView=convertView;







        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.main_list_routines, parent, false);
        }
        MainArrayListRoutine currentMainListView = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
        nameTextView.setText(currentMainListView.getName());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        dateTextView.setText(""+currentMainListView.getDate1());


        Button button = listItemView.findViewById(R.id.delete);
        button.setTag(currentMainListView.getId());



        return listItemView;




    }




}
