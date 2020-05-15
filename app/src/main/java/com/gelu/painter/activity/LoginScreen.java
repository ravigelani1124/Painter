package com.gelu.painter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gelu.painter.R;

import androidx.appcompat.app.AppCompatActivity;

public class LoginScreen extends AppCompatActivity implements View.OnClickListener {

    private LoginScreen mContext;
    private Button btnLogin;
    private EditText etUserId;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        mContext = this;
        initUi();

    }

    private void initUi() {
        btnLogin = findViewById(R.id.btnLogin);
        etUserId = findViewById(R.id.etUserId);
        etPassword = findViewById(R.id.etPassword);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnLogin:
                if (checkValidation()) {
                    startActivity(new Intent(mContext, HomeScreen.class));
                    finish();
                }
                break;
        }
    }

    private boolean checkValidation() {
        boolean isValid = true;
        if (etUserId.getText().toString().isEmpty()) {
            Toast.makeText(mContext, mContext.getResources().getString(R.string.val_str_user_id), Toast.LENGTH_SHORT).show();
            etUserId.requestFocus();
            isValid = false;
        } else if (etPassword.getText().toString().isEmpty()) {
            Toast.makeText(mContext, mContext.getResources().getString(R.string.str_val_pass), Toast.LENGTH_SHORT).show();
            etPassword.requestFocus();
            isValid = false;
        } else if (etPassword.getText().length() < 6) {
            Toast.makeText(mContext, mContext.getResources().getString(R.string.str_val_pass_length), Toast.LENGTH_SHORT).show();
            isValid = false;
        }
        return isValid;
    }
}
