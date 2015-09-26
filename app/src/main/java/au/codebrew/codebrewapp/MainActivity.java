package au.codebrew.codebrewapp;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

    private String[] values = new String[8];
    private String[] values2 = new String[8];
    private Bitmap[] eventBitmap = new Bitmap[8];

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



        //<----------------Fetching data from database----------->

//
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
//
//        for(i =0;i<8;i++){
//
//
//            query.getInBackground(EVEID[i], new GetCallback<ParseObject>() {
//                @Override
//                public void done(ParseObject parseObject, ParseException e) {
//
//
//                    if(e==null){
//
//
//
//                        values[i]=parseObject.getString("Name");
//                        values2[i]=parseObject.getString("Description");
//
//                        System.out.println("mmmmmm"+values[0]+values2[0]);
//
////                        causesList.add(values[i]);
////                        descriptionList.add(values2[i]);
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e1) {
//                            e1.printStackTrace();
//                        }
//
//                        for (int i = 0; i < values.length; ++i) {
//                            causesList.add(values[i]);
//                        }
//
//
//                        for (int i = 0; i < values.length; ++i) {
//                            descriptionList.add(values2[i]);
//                        }
//
//System.out.println("arraylist"+causesList+descriptionList);
////                        ParseFile EventImg = (ParseFile)parseObject.get("Image");
////
////                        EventImg.getDataInBackground(new GetDataCallback() {
////                            @Override
////                            public void done(byte[] data, ParseException e) {
////                                if(e==null){
////
////
////                                    Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
////
////                                    //changed size of bitmap
////
////                                    bmp = Bitmap.createScaledBitmap(bmp, 400, 100, false);
////                                    eventBitmap[0]=bmp;
////
////
////                                }else{
//                            }
////
////
////
////                            }
////                        });
//
//
////                        try {
////                            Thread.sleep(1000);
////                        } catch (InterruptedException e1) {
////                            e1.printStackTrace();
////                        }
//
//
//                    }else{
//                    }
//                }
//            });
//
//
//
//
////
////
////
////
////
////
////
////
//       }
//
//
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        //here we retrieve the images from the database
//        Bitmap[] images = new Bitmap[];



//        values[0]="Crisis";
//        values2[0]="description";
//
//        for (int i = 0; i < values.length; ++i) {
//            causesList.add(values[i]);
//        }
//
//        for (int i = 0; i < values.length; ++i) {
//            descriptionList.add(values2[i]);
//        }

//        //uncomment when we will have the images stored in Bitmap[] images
//        final ArrayList<Bitmap> imageList = new ArrayList<Bitmap>();
//        for (int i = 0; i < values.length; ++i) {
//            imageList.add(images[i]);
//        }

        String[] values = new String[]{"Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile"};
        String[] values2 = new String[]{"Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile"};
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

//        uncomment when we will have the images stored in Bitmap[] images
//        final ArrayList<Bitmap> imageList = new ArrayList<Bitmap>();
//        for (int i = 0; i < values.length; ++i) {
//            imageList.add(images[i]);
//        }

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


}
