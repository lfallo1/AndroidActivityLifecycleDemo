package com.training.lfallon.activitylifecycle1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SelectContactActivity extends BaseActivity implements View.OnClickListener{

    public static final String EXTRA_TITLE = "EXTRA_TITLE";
    public static final String RESULT_CONTACT_NAME = "RESULT_CONTACT_NAME";

    private View contact1;
    private View contact2;
    private View contact3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_contact);

        contact1 = findViewById(R.id.activity_select_contact_contact1);
        contact2 = findViewById(R.id.activity_select_contact_contact2);
        contact3= findViewById(R.id.activity_select_contact_contact3);

        contact1.setOnClickListener(this);
        contact2.setOnClickListener(this);
        contact3.setOnClickListener(this);

        TextView title = (TextView)findViewById(R.id.activity_select_contact_title);
        String titleFromIntent = getIntent().getStringExtra(EXTRA_TITLE);
        title.setText(titleFromIntent);
    }


    @Override
    public void onClick(View v) {
        if(v == contact1){
            selectContact("Contact 1");
        }
        else if(v == contact2){
            selectContact("Contact 2");
        }
        else if(v == contact3){
            selectContact("Contact 3");
        }
    }

    private void selectContact(String contactName){
        Intent data = new Intent();
        data.putExtra(RESULT_CONTACT_NAME, contactName);
        setResult(RESULT_OK, data);
        finish();
    }
}
