package com.gelu.painter.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gelu.painter.R;
import com.gelu.painter.database.LocalRoomDatabase;
import com.gelu.painter.database.User;
import com.gelu.painter.utility.TinyDB;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;


public class LoginScreen extends AppCompatActivity implements View.OnClickListener {

    private LoginScreen mContext;
    private Button btnLogin;
    private EditText etUserId;
    private EditText etPassword;
    private LocalRoomDatabase database;
    private ArrayList<User> userArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        mContext = this;
        initUi();

        //add user
        if (userArrayList == null || userArrayList.size() < 5) {
            addUserInDatabase();
        }
    }

    private void addUserInDatabase() {
        for (int i = 1; i < 5; i++) {
            User user = new User();
            user.setId(i);
            user.setUserId("user" + i);
            user.setPassword("user" + i);
            new SetUser().execute(user);
        }
    }

    private void initUi() {
        database = LocalRoomDatabase.getInstance(mContext);
        userArrayList = new ArrayList<>();
        btnLogin = findViewById(R.id.btnLogin);
        etUserId = findViewById(R.id.etUserId);
        etPassword = findViewById(R.id.etPassword);
        btnLogin.setOnClickListener(this);
        //get user data
        new GetUserData().execute();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnLogin:
                if (checkValidation()) {
                    Toast.makeText(mContext, mContext.getResources().getString(R.string.str_login_message), Toast.LENGTH_SHORT).show();
                    new TinyDB(mContext).putBoolean(TinyDB.isLogin, true);
                    startActivity(new Intent(mContext, HomeScreen.class));
                    finish();
                }
                break;
        }
    }

    private boolean checkValidation() {
        boolean isValid = true;
        String userId = etUserId.getText().toString().trim();
        String userPass = etPassword.getText().toString().trim();
        if (etUserId.getText().toString().isEmpty()) {
            Toast.makeText(mContext, mContext.getResources().getString(R.string.val_str_user_id), Toast.LENGTH_SHORT).show();
            etUserId.requestFocus();
            isValid = false;
        } else if (etPassword.getText().toString().isEmpty()) {
            Toast.makeText(mContext, mContext.getResources().getString(R.string.str_val_pass), Toast.LENGTH_SHORT).show();
            etPassword.requestFocus();
            isValid = false;
        } else if (etPassword.getText().length() < 4) {
            Toast.makeText(mContext, mContext.getResources().getString(R.string.str_val_pass_length), Toast.LENGTH_SHORT).show();
            isValid = false;
        } else {

            if (userArrayList.size() > 0) {
                for (int i = 0; i < userArrayList.size(); i++) {

                    if (userId.equals(userArrayList.get(i).getUserId())) {
                        if (userPass.equals(userArrayList.get(i).getPassword())) {
                            isValid = true;
                            break;
                        } else {
                            isValid = false;
                            Toast.makeText(mContext, mContext.getResources().getString(R.string.str_pass_incorrect), Toast.LENGTH_SHORT).show();
                            break;
                        }
                    } else {
                        isValid = false;
                        if (i == userArrayList.size() - 1) {
                            Toast.makeText(mContext, mContext.getResources().getString(R.string.str_val_userid_not_match), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        }
        return isValid;
    }

    private class SetUser extends AsyncTask<User, String, User> {

        @Override
        protected User doInBackground(User... users) {
            List<User> list = database.userDAO().getAllUser();
            String data = new Gson().toJson(list);
            Log.e("User DATA", data);
            if (list == null || list.size() < 5) {
                database.userDAO().addUser(users[0]);
            }
            return null;
        }

        @Override
        protected void onPostExecute(User model) {
            super.onPostExecute(model);
        }
    }


    private class GetUserData extends AsyncTask<User, String, User> {

        @Override
        protected User doInBackground(User... users) {
            List<User> list = database.userDAO().getAllUser();
            String data = new Gson().toJson(list);
            Log.e("User DATA", data);
            userArrayList.clear();
            userArrayList.addAll(list);
            return null;
        }

        @Override
        protected void onPostExecute(User model) {
            super.onPostExecute(model);
        }
    }
}
