package com.training.lfallon.activitylifecycle1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SearchContactActivity extends BaseActivity {

    public static final String RESULT_CONTACT_NAME = "RESULT_CONTACT_NAME";
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contact);

        input = (EditText)findViewById(R.id.activity_search_contact_input);
        View search = findViewById(R.id.activity_search_contact_searchButton);
        View cancel = findViewById(R.id.activity_search_contact_cancelButton);
        View mainActivity = findViewById(R.id.activity_search_contact_mainActivityButton);
        search.setOnClickListener(new SearchButtonHandler());
        cancel.setOnClickListener(new CancelButtonHandler());
        mainActivity.setOnClickListener(new MainActivityButtonHandler());
    }

    private class SearchButtonHandler implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra(RESULT_CONTACT_NAME, input.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    private class CancelButtonHandler implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            setResult(RESULT_CANCELED);
            finish();
        }
    }

    private class MainActivityButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(SearchContactActivity.this, MainActivity.class));
            finish();
        }
    }
}
