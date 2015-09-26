package au.codebrew.codebrewapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.TaskStackBuilder;

public class EventActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        getActionBar().setDisplayHomeAsUpEnabled(true);


//        int id = this.getIntent().getExtras().getInt("key");
//        Log.e("key: ", "" + id);


        ImageView imageView = (ImageView) findViewById(R.id.mainImageView);
        imageView.setImageResource(R.drawable.google);


        ImageButton imageButton1 = (ImageButton) findViewById(R.id.buttonImageView1);
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.buttonImageView2);
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.buttonImageView3);


        imageButton1.setImageResource(R.drawable.moneybutton);
        imageButton2.setImageResource(R.drawable.itemsbutton);
        imageButton3.setImageResource(R.drawable.volunteerbutton);



        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, VolunteerHP.class);
                startActivity(intent);
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, DonateItemActivity.class);
                startActivity(intent);
            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, PaymentActivity.class);

                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event, menu);
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
