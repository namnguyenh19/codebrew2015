package au.codebrew.codebrewapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class VolunResult extends ActionBarActivity {


    private TextView result;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volun_result);


        result = (TextView)findViewById(R.id.result);

        result.setText("Thank you.\n for your details.\n \n We will keep you updated by email. \n \n ------------------\n The world is a better place with your help.");

button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VolunResult.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }


}
