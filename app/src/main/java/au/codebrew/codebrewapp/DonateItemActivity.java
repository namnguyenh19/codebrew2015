package au.codebrew.codebrewapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class DonateItemActivity extends Activity {
    private ImageView imageView = null;
    private Spinner spinner_country = null;
    private Spinner spinner_state = null;
    private ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_item);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        spinner_country = (Spinner) findViewById(R.id.spinner_country);
        spinner_state = (Spinner) findViewById(R.id.spinner_state);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.planets_array, R.layout.support_simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_country.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.planets_array, R.layout.support_simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_state.setAdapter(adapter2);

        listView = (ListView) findViewById(R.id.listView);

        final ArrayList<String> causesList = new ArrayList<String>();
        causesList.add("155 Pelham Street, Carlton");
        causesList.add("23 - 47 Villiers St, North Melbourne");
        causesList.add("2/360 Bourke Street, Melbourne");
        causesList.add("100-154 Batman St, West Melbourne");
        causesList.add("191 Bridge Rd, Richmond");

        final ArrayList<String> descriptionList = new ArrayList<String>();
        descriptionList.add("1300 367 428");
        descriptionList.add("(03) 9345 1800");
        descriptionList.add("(03) 9421 6481");
        descriptionList.add("(03) 9427 8556");
        descriptionList.add("13 14 95");

        final MyListAdapter adapter = new MyListAdapter(this, causesList, descriptionList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @SuppressLint("NewApi")
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
//                                causesList.remove(item);
//                                descriptionList.remove(item);
                                adapter.notifyDataSetChanged();
                                view.setAlpha(1);
                            }
                        });
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_donate_item, menu);
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
