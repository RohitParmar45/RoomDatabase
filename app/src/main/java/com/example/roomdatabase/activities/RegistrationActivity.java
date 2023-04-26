package com.example.roomdatabase.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdatabase.R;
import com.example.roomdatabase.dao.UserDao;
import com.example.roomdatabase.database.DatabaseProvider;
import com.example.roomdatabase.models.User;

public class RegistrationActivity extends AppCompatActivity {
     private EditText edName, edNum, edPass, edUser;
     private String  edName2, edNum2, edPass2, edUser2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

    }

    public void onSumit(View view) {

        edName = findViewById(R.id.ed_name);
        edNum = findViewById(R.id.ed_mobNum);
        edUser = findViewById(R.id.edUser);
        edPass = findViewById(R.id.edPass);

        edName2 =edName.getText().toString();
        edNum2 =edNum.getText().toString();
        edUser2 =edUser.getText().toString();
        edPass2 =edPass.getText().toString();

        Toast.makeText(this, ""+edUser2, Toast.LENGTH_SHORT).show();
        if (edName2.isEmpty() || edNum2.isEmpty() || edUser2.isEmpty() || edPass2.isEmpty() ){
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }else{

            Toast.makeText(this, edPass2, Toast.LENGTH_LONG).show();
            User user =new User(edName2,null,edPass2,edNum2);
            DatabaseProvider dbp = DatabaseProvider.getDbConnection(this);
            UserDao userDao = dbp.getUserDao();
            userDao.insert(user);
            Toast.makeText(this, edUser2 + " successfully insert...", Toast.LENGTH_SHORT).show();
        }

    }
}