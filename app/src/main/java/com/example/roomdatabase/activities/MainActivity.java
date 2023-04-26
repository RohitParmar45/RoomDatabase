package com.example.roomdatabase.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdatabase.R;
import com.example.roomdatabase.dao.UserDao;
import com.example.roomdatabase.database.DatabaseProvider;
import com.example.roomdatabase.models.User;

import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText name , pass;
    String name2 , pass2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onLogin(View view) {

        name = findViewById(R.id.edUser);
        pass = findViewById(R.id.edPass);

       name2 = name.getText().toString();
       pass2 = pass.getText().toString();

        DatabaseProvider dbp = DatabaseProvider.getDbConnection(this);
       UserDao userDao =  dbp.getUserDao();
        List<User> list = userDao.getData();

        for (User uT : list) {
            String name = uT.getName();
            String pass = uT.getName();
            if (this.name2.equals(name) && this.pass2.equals(pass)) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
    }

    public void onRegister(View view) {
        Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }
}