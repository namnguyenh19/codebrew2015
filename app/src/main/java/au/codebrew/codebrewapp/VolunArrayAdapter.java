package au.codebrew.codebrewapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jizhizili on 26/09/15.
 */
public class VolunArrayAdapter extends ArrayAdapter<String>{

    private final Context context;
    private final ArrayList<String> causes;
    private Button apply;

    public VolunArrayAdapter(Context context, ArrayList<String> causes) {
        super(context, -1, causes);
        this.context = context;
        this.causes = causes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rawlayout, parent, false);
        apply = (Button)rowView.findViewById(R.id.icon);
        final TextView textView = (TextView) rowView.findViewById(R.id.firstLine);

        textView.setText(causes.get(position));

       // <-----------------BUTTON APPLY---------------------->

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VolunApply.class);
                intent.putExtra("message", textView.getText().toString());
                context.startActivity(intent);
            }
        });
        return rowView;
    }
}
