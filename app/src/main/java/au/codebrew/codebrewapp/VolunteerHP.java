package au.codebrew.codebrewapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;


public class VolunteerHP extends ActionBarActivity {

    private ImageView imageView;
    private TextView orgname;
private String orgnameST;
    private ListView listview;
    private String[] Volunteer = new String[5];
    private Integer[] Received = new Integer[5];
    private Integer[] Sum = new Integer[5];


final String Event_ID_1="Ng5vXZHZXO";





    ArrayList<String> causesList = new ArrayList<String>();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_hp);
//<-----------------------matching ID------------------------>

imageView = (ImageView)findViewById(R.id.imageView);
        orgname = (TextView)findViewById(R.id.orgname);
        listview = (ListView)findViewById(R.id.listView);


        //<-----------------------Fetch data from database------------------------>




        ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
        query.getInBackground(Event_ID_1, new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    // object will be your game score

                    orgnameST = object.getString("Organization");

                    for(int i =0;i<5;i++) {
                        Volunteer[i] = object.getJSONArray("Volun"+Integer.toString(i+1)).optString(0);

//Received[i]=Integer.parseInt(object.getJSONArray("Volun" + Integer.toString(i+1)).optString(1));
//                        Sum[i] = Integer.parseInt(object.getJSONArray("Volun"+Integer.toString(i+1)).optString(2));

                    }






                    orgname.setText(orgnameST);





//                    final ArrayList<String> causesList = new ArrayList<String>();
                    for (int i = 0; i < Volunteer.length; ++i) {
                        causesList.add(Volunteer[i]);
                    }








                    ParseFile EventImage =(ParseFile)object.get("Image");
                    EventImage.getDataInBackground(new GetDataCallback() {
                        public void done(byte[] data, ParseException e) {
                            if (e == null) {

                                Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
                                bmp = Bitmap.createScaledBitmap(bmp, 400, 100, false);

                                        imageView.setImageBitmap(bmp);


                            } else {
                                // something went wrong
                            }
                        }
                    });




                } else {
                    // something went wrong
                }
            }
        });




















        //set the name of orgname


//
//        orgname.setText(orgnameST);
//
//System.out.println("youshouldseethem"+orgnameST);
//
//
//
//
//        final ArrayList<String> causesList = new ArrayList<String>();
//        for (int i = 0; i < Volunteer.length; ++i) {
//            causesList.add(Volunteer[i]);
//        }
//
//        System.out.println("youshouldseethem"+causesList);

        final VolunArrayAdapter adapter = new VolunArrayAdapter(this,
                causesList);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                causesList.remove(item);
                                adapter.notifyDataSetChanged();
                                view.setAlpha(1);


                            }
                        });
            }

        });
    }



public String getEventID(){

    return Event_ID_1;

}




}
