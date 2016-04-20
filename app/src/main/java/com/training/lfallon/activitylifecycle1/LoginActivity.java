package com.training.lfallon.activitylifecycle1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends BaseActivity {

    public static final String EXTRA_USERNAME = "EXTRA_USERNAME";
    private EditText usernameTextBox;
    private View loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameTextBox = (EditText)findViewById(R.id.activity_login_username);
        loginButton = findViewById(R.id.activity_login_loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameTextBox.getText().toString();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra(EXTRA_USERNAME, username);
                BaseActivity.isLoggedIn = true;
                startActivity(intent);
                finish(); //remove login activity from back stack
            }
        });
    }
}
