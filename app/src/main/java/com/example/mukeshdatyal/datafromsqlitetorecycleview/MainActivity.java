package com.example.mukeshdatyal.datafromsqlitetorecycleview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Mukesh Datyal on 6/9/2017.
 */

public class MainActivity extends AppCompatActivity {
    EditText Name_main,Rollno_main,Address_main,Branch_main,Email_main;
    Button Submit,Result;
    DBHelper helper;
    List<DBModel> dbList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbList= new ArrayList<DBModel>();
        Name_main = (EditText)findViewById(R.id.name_main);
        Rollno_main = (EditText)findViewById(R.id.rollno_main);
        Address_main =(EditText)findViewById(R.id.address_main);
        Branch_main = (EditText)findViewById(R.id.branch_main);
        Email_main = (EditText)findViewById(R.id.email_main);
        Submit  =(Button)findViewById(R.id.submit);
        Result =(Button)findViewById(R.id.result);
        Result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ResultActivity.class));

                // startActivity(new Intent(MainActivity.this, Details.class));

            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=Name_main.getText().toString();
                String email=Email_main.getText().toString();
                String roll=Rollno_main.getText().toString();
                String address=Address_main.getText().toString();
                String branch=Branch_main.getText().toString();

                if(name.equals("") || email.equals("") || roll.equals("") ||address.equals("")||branch.equals("")){
                    Toast.makeText(MainActivity.this,"Please fill all the fields",Toast.LENGTH_LONG).show();
                }else {
                    helper = new DBHelper(MainActivity.this);
                    helper.insertIntoDB(name, email, roll, address, branch);
                }
                Name_main.setText("");
                Rollno_main.setText("");
                Address_main.setText("");
                Branch_main.setText("");
                Email_main.setText("");

                Toast.makeText(MainActivity.this, "insert value", Toast.LENGTH_LONG);

            }
        });

    }



}

