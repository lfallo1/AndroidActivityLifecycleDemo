package com.training.lfallon.activitylifecycle1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private View button;
    private TextView textView;
    private int counter = 0;
    private static final String BUNDLE_COUNTER = "BUNDLE_COUNTER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(savedInstanceState != null){
            counter = savedInstanceState.getInt(BUNDLE_COUNTER);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.activity_main_button);
        textView = (TextView)findViewById(R.id.activity_main_text);

        button.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_COUNTER, counter);
    }

    @Override
    public void onClick(View v) {
        counter++;
        textView.setText(Integer.toString(counter));
    }
}
