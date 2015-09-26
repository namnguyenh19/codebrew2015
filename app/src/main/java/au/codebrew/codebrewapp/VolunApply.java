package au.codebrew.codebrewapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;


public class VolunApply extends Activity {

    private TextView volunname;
    private String volun_name;
    private EditText firstName;
    private EditText lastName;
    private EditText age;
    private EditText gender;
    private EditText email;
    private EditText contact_num;
    private EditText address;
    private Button submit;
    private Bitmap bitmap;
    private ImageView imageView;
    private String EventID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volun_apply);

        //<------------------MATHING ID----------------->
        volunname = (TextView)findViewById(R.id.volunname);

        firstName = (EditText)findViewById(R.id.editText);
        lastName = (EditText)findViewById(R.id.editText2);
        age = (EditText)findViewById(R.id.editText3);
        gender = (EditText)findViewById(R.id.editText4);
        email = (EditText)findViewById(R.id.editText5);
        contact_num = (EditText)findViewById(R.id.editText6);
        address = (EditText)findViewById(R.id.editText7);

        submit = (Button)findViewById(R.id.submit);
        imageView = (ImageView)findViewById(R.id.imageView);

        VolunteerHP instance = new VolunteerHP();
        EventID = instance.getEventID();

        //<------------BUTTON SUBMIT/PASS TO DATABASE--------------->

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject volunteerApplication = new ParseObject("VolunteerApplication");
                volunteerApplication.put("firstName", firstName.getText().toString());
                volunteerApplication.put("lastName", lastName.getText().toString());
                volunteerApplication.put("age", age.getText().toString());
                volunteerApplication.put("gender", gender.getText().toString());
                volunteerApplication.put("email", email.getText().toString());
                volunteerApplication.put("contact_num", contact_num.getText().toString());
                volunteerApplication.put("address", address.getText().toString());

                volunteerApplication.saveInBackground();

                Intent intent = new Intent(VolunApply.this, VolunResult.class);
                startActivity(intent);
            }
        });

        //<------------SET PICTURE---------------->
        //<-----------------------Fetch data from database------------------------>

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
        query.getInBackground(EventID, new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    // object will be your game score
                    ParseFile EventImage = (ParseFile) object.get("Image");
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
        Bundle bundle = getIntent().getExtras();
        volun_name = bundle.getString("message");
        volunname.setText(volun_name);
    }
}
