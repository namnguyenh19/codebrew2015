package au.codebrew.codebrewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by raymond on 9/26/15.
 */
public class MyListAdapter extends ArrayAdapter{

    private final Context context;
    private final ArrayList<String> causes;
    private final ArrayList<String> descriptions;

    public MyListAdapter(Context context, ArrayList<String> causes, ArrayList<String> descriptions) {
        super(context, -1, causes);
        this.context = context;
        this.causes = causes;
        this.descriptions = descriptions;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_view, parent, false);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView textView = (TextView) rowView.findViewById(R.id.firstLine);
        TextView textView2 = (TextView) rowView.findViewById(R.id.secondLine);

        imageView.setImageResource(R.drawable.map_pin);
        textView.setText(causes.get(position));
        textView2.setText(descriptions.get(position));


        return rowView;
    }
}
