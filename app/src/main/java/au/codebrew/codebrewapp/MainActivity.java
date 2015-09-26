package au.codebrew.codebrewapp;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import java.util.*;
import android.app.*;
import android.widget.*;
import android.view.*;
import android.graphics.Bitmap;
import android.content.Intent;
import android.util.Log;

import com.parse.GetCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;


public class MainActivity extends Activity {

    //final String[] EVEID = {"X66VaIcndS","Ng5vXZHZXO","7A93yxSnaH","Kqc5B8FEx4","dI8LwOJRim","M4beADfW90","0XmrQgRy1c","wcMBey5leA"};

    final String[] values = new String[]{"Snowstorm in Canada", "Hurricane Sandy in United States","Flood in India","Earthquake in Nepal","Draught in Africa","Famine in Somalia","War Refugees from Syria","Tsunami in Japan"};

    final String[] values2 = new String[]{"Food   Clothes   Volunteer", "Food   Money   Clothes", "Volunteer   Clothes",
            "Food Volunteer", "Food Money", "Money Volunteer", "Clothes Volunteer", "Food Volunteer"};

Bitmap[] bitmap = new Bitmap[8];



    private ArrayList<String> causesList = new ArrayList<String>();
    private ArrayList<String> descriptionList = new ArrayList<String>();
    private ArrayList<Bitmap> imageList = new ArrayList<Bitmap>();
    //private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("prefs", 0);
        boolean firstRun = prefs.getBoolean("firstRun", false);
        if(firstRun == false) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstRun",true);
            editor.commit();
            Intent intent = new Intent(MainActivity.this,IntroActivity.class);
            startActivity(intent);
            finish();
        }

        setContentView(R.layout.activity_main);
        final ListView listview = (ListView) findViewById(R.id.mainListview);





        //here we retrieve the images from the database
        //Bitmap[] images = new Bitmap[];

        final ArrayList<String> causesList = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            causesList.add(values[i]);
        }

        final ArrayList<String> descriptionList = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            descriptionList.add(values2[i]);
        }





           //     uncomment when we will have the images stored in Bitmap[] images
        final ArrayList<Bitmap> imageList = new ArrayList<Bitmap>();
        for (int i = 0; i < values.length; ++i) {
            imageList.add(bitmap[i]);
        }




















        final MyArrayAdapter adapter = new MyArrayAdapter(this, causesList, descriptionList);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
//                final String item = (String) parent.getItemAtPosition(position);
//                view.animate().setDuration(2000).alpha(0)
//                        .withEndAction(new Runnable() {
//                            @Override
//                            public void run() {
//                                causesList.remove(item);
//                                descriptionList.remove(item);
//                                adapter.notifyDataSetChanged();
//                                view.setAlpha(1);
//                            }
//                        });

                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                //intent.putExtra("key", 1);

                intent.putExtra("index", Integer.toString(position));

                startActivity(intent);
                //finish();

            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public String getCrisis(int i){
return values[i];
    }


    public String getDesc(int i){
        return values2[i];


    }







}
