package com.training.lfallon.activitylifecycle1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private View button;
    private TextView textView;
    private EditText input;

    private int counter = 0;
    public static final int REQUEST_SELECT_CONTACT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.activity_main_button);
        textView = (TextView)findViewById(R.id.activity_main_text);
        input = (EditText)findViewById(R.id.activity_main_editText);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.activity_main_button){
            Intent intent = new Intent(this, SelectContactActivity.class);
            intent.putExtra(SelectContactActivity.EXTRA_TITLE, input.getText().toString());
            startActivityForResult(intent, REQUEST_SELECT_CONTACT);
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
