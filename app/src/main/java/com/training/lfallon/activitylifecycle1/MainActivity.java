package com.training.lfallon.activitylifecycle1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private View button;
    private TextView textView;
    private EditText input;
    private TextView welcomeText;
    private View logout;

    private int counter = 0;
    public static final int REQUEST_SELECT_CONTACT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.activity_main_button);
        logout = findViewById(R.id.activity_main_logoutButton);
        textView = (TextView)findViewById(R.id.activity_main_text);
        input = (EditText)findViewById(R.id.activity_main_editText);
        welcomeText = (TextView)findViewById(R.id.activity_main_welcomeText);
        welcomeText.setText("Welcome, " + getIntent().getStringExtra(LoginActivity.EXTRA_USERNAME));

        button.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.activity_main_button){
            Intent intent = new Intent(this, SelectContactActivity.class);
            intent.putExtra(SelectContactActivity.EXTRA_TITLE, input.getText().toString());
            startActivityForResult(intent, REQUEST_SELECT_CONTACT);
        }
        else if(v.getId() == R.id.activity_main_logoutButton){

            //perform logic to logout
            BaseActivity.isLoggedIn = false;

            //launch the login activity
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); //clear entire back stack
            startActivity(intent);
        }
    }

    /**
     * One of few over-rideable methods that will not throw error if super not called
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_SELECT_CONTACT){
            if(resultCode == RESULT_OK){
                String contact = data.getStringExtra(SelectContactActivity.RESULT_CONTACT_NAME).toString();
                textView.setText("You selected " + contact);
            }
            else{
                textView.setText("Error...");
            }
        }
        else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
