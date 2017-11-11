package dk.now.just.trainwithbrain;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Mir on 11/11/2017.
 */

public class MainCustomAdapter extends  ArrayAdapter<MainArrayListRoutine> {

    public MainCustomAdapter (Activity context, ArrayList<MainArrayListRoutine> trainingroutines){
        super(context,0,trainingroutines);
    }



    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View listItemView=convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, parent, false);
        }
        MainArrayListRoutine currentMainListView = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
        nameTextView.setText(currentMainListView.getName());



        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        dateTextView.setText(""+currentMainListView.getDate());

        return listItemView;
    }
}
