package au.codebrew.codebrewapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // pass to the intro activity for the first time the app is opened
        // return to the main activity
        SharedPreferences prefs = getSharedPreferences("prefs", 0);
        boolean firstRun = prefs.getBoolean("firstRun", false);
        if(firstRun == false) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstRun",true);
            editor.commit();
            Intent intent = new Intent(MainActivity.this,IntroActivity.class);//Activity to be     launched For the First time
            startActivity(intent);
            finish();
        }
//        else {
//            Intent intent = new Intent(MainActivity.this, MainActivity.class);//Default Activity
//            startActivity(intent);
//            finish();
//        }

        setContentView(R.layout.activity_main);
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
